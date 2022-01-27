package com.dhana.paymentservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhana.paymentservice.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Payment findByOrderId(int orderId);
	
	}
