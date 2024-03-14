package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.model.User;
import com.mongodb.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService services;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return services.addUser(user);
		
	}
	@GetMapping
	public List<User> getUser() {
		return services.findAllUser();
	}
	
	@GetMapping("/{userid}")
	public User gerUser(@PathVariable String  userid) {
		return services.getUserByUserId(userid);
		
	}
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return services.updateUser(user);
		
	}
	@DeleteMapping("/{userid}")
	public String deleteUser(@PathVariable String user) {
		return services.deleteUser(user);

}
	}
