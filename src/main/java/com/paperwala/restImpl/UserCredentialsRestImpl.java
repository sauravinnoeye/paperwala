package com.paperwala.restImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paperwala.service.UserCredentialsService;
import com.paperwala.wrapper.UserCredentialsWrapper;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserCredentialsRestImpl {

	@Autowired
	private UserCredentialsService uservice;

	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@RequestBody(required = true) UserCredentialsWrapper request) {
		// uservice.saveProduct(request);
		try {
			return uservice.createUser(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	@PostMapping("/userSignUp")
//	public ResponseEntity<String> userSignUp(@RequestBody(required = true) UserCredentialsWrapper request) {
//		// uservice.saveProduct(request);
//		try {
//			return uservice.userSignUp(request);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody(required = true) UserCredentialsWrapper userWrapper) {
		try {
			return uservice.login(userWrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}

}
