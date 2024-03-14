package com.mongodb.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.model.User;
import com.mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User addUser(User user) {
		user.setUserid(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(user);
	}

	public List<User> findAllUser() {
		return repository.findAll();
	}

	public User getUserByUserId(String userId) {
		return repository.findById(userId).get();

	}
	
	public User updateUser(User userRequest) {
		User user = repository.findById(userRequest.getUserid()).get();
		user.setAddress(userRequest.getAddress());
		user.setFirst_name(userRequest.getFirst_name());
		user.setLast_name(userRequest.getLast_name());
		user.setPassword(userRequest.getPassword());
		return repository.save(user);
		
	}
	
	public String deleteUser(String userid) {
		
		 repository.deleteById(userid);;
		return "user delete";
		
	}

}
