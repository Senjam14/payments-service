package com.dhana.paymentservice.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhana.paymentservice.api.entity.User;
import com.dhana.paymentservice.api.repository.UserRepository;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@PostConstruct
	public void initUsers() {
		
		List<User> users = Stream.of(
				new User(101, "test","test123", "test@gmail.com", 8, "IT"),
				new User(101, "test2","test123", "test2@gmail.com", 8, "IT")
				).collect(Collectors.toList());
		this.repository.saveAll(users);
	}

	@PostMapping("/register")
	public String register(@RequestBody User user) {
			repository.save(user);
			return "The user is register successfully";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		
		return repository.findAll();
	}
	
	@GetMapping("/findUser/{email}")
	public List<User> findUser(@PathVariable String email){
		return repository.findByEmail(email);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<User> deleteUser(@PathVariable int id) {
		
		repository.deleteById(id);
        return repository.findAll();
	}
}
