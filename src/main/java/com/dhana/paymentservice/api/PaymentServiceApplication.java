package com.dhana.paymentservice.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableEurekaClient
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
		
	    return new WebMvcConfigurer() {
	        @Override
			public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("*");
	        }
	    };
	}

}
