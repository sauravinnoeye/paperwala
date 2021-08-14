package com.paperwala.service;

import org.springframework.http.ResponseEntity;

import com.paperwala.wrapper.UserCredentialsWrapper;

public interface UserCredentialsService {
	ResponseEntity<String> createUser(UserCredentialsWrapper request);
	
	Boolean login(String username,String password);
	
	String userSignUp(UserCredentialsWrapper request);
}
