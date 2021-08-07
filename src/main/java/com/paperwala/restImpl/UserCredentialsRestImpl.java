package com.paperwala.restImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paperwala.service.UserCredentialsService;
import com.paperwala.wrapper.UserCredentialsWrapper;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins="*")
public class UserCredentialsRestImpl {

	@Autowired
	private UserCredentialsService uservice;

	@PostMapping("/signUp")
	public String addProduct(@RequestBody(required = true) UserCredentialsWrapper request) {
		// uservice.saveProduct(request);
		try {
			return uservice.createUser(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
