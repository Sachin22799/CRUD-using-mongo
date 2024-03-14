package com.mongodb.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collation = "user")
public class User {
	
	@Id
	private String userid;
	private String first_name;
	private String last_name;
	private String password;
	private String address;
	
	

}
