package com.dhana.paymentservice.api.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhana.paymentservice.api.entity.Payment;
import com.dhana.paymentservice.api.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	//private Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(PaymentService.class);
	
	public Payment doPayment(Payment payment){
		
		payment.setTransactionId(UUID.randomUUID().toString());
		
		//log.info("Payment Requst--------", new ObjectMapper().writeValueAsString(payment));
		return repository.save(payment);
	}
	
	//Method to get the status of payment processing

	public String getPaymentProcessing() {
		//should be api call to payment gatweay like paypal
		return new Random().nextBoolean() ? "success" :"false";
	}

	public Payment getOrderId(int orderId) {
		// TODO Auto-generated method stub
		return repository.findByOrderId(orderId);
	}
	
	public List<Payment> getOrders() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
}
