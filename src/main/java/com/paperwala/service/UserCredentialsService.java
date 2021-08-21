package com.paperwala.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.paperwala.wrapper.UserCredentialsWrapper;

public interface UserCredentialsService {
	ResponseEntity<String> createUser(UserCredentialsWrapper request);

	Map<String, String> login(UserCredentialsWrapper userWrapper);

	// ResponseEntity<String> userSignUp(UserCredentialsWrapper request);
}
