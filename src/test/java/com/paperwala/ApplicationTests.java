package com.paperwala;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paperwala.dao.UserCredentialsDao;

@SpringBootTest
class ApplicationTests {

	@Autowired
	public UserCredentialsDao user;
	
	@Test
	void contextLoads() {
		
		System.out.println("-----------------srv----------------"+user.getUser("saurav", "pass"));
	}

}
