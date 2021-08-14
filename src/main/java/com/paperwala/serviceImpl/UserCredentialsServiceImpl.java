package com.paperwala.serviceImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.paperwala.POJO.UserCredentials;
import com.paperwala.dao.UserCredentialsDao;
import com.paperwala.service.UserCredentialsService;
import com.paperwala.wrapper.UserCredentialsWrapper;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

	private Logger logger = LogManager.getLogger(UserCredentialsServiceImpl.class);

	@Autowired
	private UserCredentialsDao userDao;

	@Override
	public ResponseEntity<String> createUser(UserCredentialsWrapper request) {
		try {
			if (!Strings.isNullOrEmpty(request.getUserName()) && !Strings.isNullOrEmpty(request.getUserPassword())
					&& !Strings.isNullOrEmpty(request.getUserRole())) {
				UserCredentials uc = new UserCredentials();
				uc.setUserName(request.getUserName());
				// uc.setUserPassword(getMd5(request.getUserPassword()));
				uc.setUserPassword(request.getUserPassword());
				uc.setUserRole(request.getUserRole());
				userDao.save(uc);
				// return "Sign Up Successfull";
				return new ResponseEntity<>("{\"message\":\"" + "Sign Up Successfull" + "\"}", HttpStatus.CREATED);
			} else {
				// return "Not sufficient data to create account";
				return new ResponseEntity<>("{\"message\":\"" + "Not sufficient data to create account" + "\"}",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean validateUser(UserCredentialsWrapper user) {
		logger.info("-----------------srv-------------{}", user.getUserName().toString());
		// String name = user.getUserName().toString();
		if (!Strings.isNullOrEmpty(user.getUserName()) && !Strings.isNullOrEmpty(user.getUserPassword())
				&& !user.getUserRole().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private String getMd5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boolean login(String username, String password) {
		if (username != "" && password != "") {
			List<String> list = userDao.getUser(username, password);
			logger.info("----------------------------srv----------------------------{}}", list);
			if (list.size() != 0) {
				String test = list.get(0);
				String[] abc = test.split(",");
				if (abc.length != 0 && (abc[0].equalsIgnoreCase(username) && abc[1].equals(password))) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String userSignUp(UserCredentialsWrapper request) {
		if (validateUser(request) && request.getUserRole().equalsIgnoreCase("user")) {
			UserCredentials uc = new UserCredentials();
			uc.setUserName(request.getUserName());
			uc.setUserPassword(request.getUserPassword());
			uc.setUserRole(request.getUserRole());
			uc.setContact(request.getContact());
			uc.setAddress(request.getAddress());
			userDao.save(uc);
			return "User Sign Up Successfull";
		} else {
			return "Something went wrong in User Sign Up";
		}
	}

}
