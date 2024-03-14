package com.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findById(String userId);

}
