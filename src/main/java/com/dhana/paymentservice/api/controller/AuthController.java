package com.dhana.paymentservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhana.paymentservice.api.config.JwtUtil;
import com.dhana.paymentservice.api.entity.AuthRequest;

@RestController
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String login() {

		return "You are authenticated";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

		} catch (Exception exception) {
			throw new Exception("Invalid username or password");
		}

		return jwtUtil.generateToken(request.getUserName());

	}

}
