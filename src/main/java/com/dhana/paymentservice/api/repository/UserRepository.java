package com.dhana.paymentservice.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhana.paymentservice.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 
	List<User> findByEmail(String email);

	List<User> deleteById(String id);

	User findByUserName(String username);
}
