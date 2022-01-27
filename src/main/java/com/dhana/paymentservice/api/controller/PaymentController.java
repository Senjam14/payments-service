package com.dhana.paymentservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhana.paymentservice.api.entity.Payment;
import com.dhana.paymentservice.api.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment){
		payment.setPaymentStatus(service.getPaymentProcessing());
		return service.doPayment(payment);
	}
	
	@GetMapping("/{orderId}")
	public Payment getOrderID(@PathVariable int orderId) {
		return service.getOrderId(orderId);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/orders")
	public List<Payment> getAll() {
		
		return service.getOrders();
	}
	

}
