package com.paperwala.serviceImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			if (validateUser(request)) {
				if (validateUsername(request.getUserName())) {
					if (request.getUserRole().equalsIgnoreCase("Admin")) {
						return adminSignUp(request);
					} else if (request.getUserRole().equalsIgnoreCase("User")) {
						return userSignUp(request);
					}
				} else {
					return new ResponseEntity<>("{\"message\":\"" + "Username already Exists" + "\"}",
							HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<>("{\"message\":\"" + "Not sufficient data to create account" + "\"}",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean validateUser(UserCredentialsWrapper request) {
		logger.info("-----------------srv-------------{}", request.getUserName().toString());
		if (!Strings.isNullOrEmpty(request.getUserName()) && !Strings.isNullOrEmpty(request.getUserPassword())
				&& !Strings.isNullOrEmpty(request.getUserRole())) {
			if (request.getUserRole().equalsIgnoreCase("Admin")) {
				return true;
			} else if (!Strings.isNullOrEmpty(request.getAddress()) && !Strings.isNullOrEmpty(request.getContact())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean validateUsername(String username) {
		List<String> list = userDao.validUser(username);
		if (list.isEmpty()) {
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

//	@Override
//	public Boolean login(String username, String password) {
//		if (username != "" && password != "") {
//			List<String> list = userDao.getUser(username, password);
//			logger.info("----------------------------srv----------------------------{}}", list);
//			if (list.size() != 0) {
//				String test = list.get(0);
//				String[] abc = test.split(",");
//				if (abc.length != 0 && (abc[0].equalsIgnoreCase(username) && abc[1].equals(password))) {
//					return true;
//				} else {
//					return false;
//				}
//			} else {
//				return false;
//			}
//		}
//		return false;
//	}

//	@Override
//	public Map<String, String> login(UserCredentialsWrapper userWrapper) {
//		try {
//			logger.info("Inside login {}", userWrapper);
//			String username = userWrapper.getUserName();
//			String password = userWrapper.getUserPassword();
//			if (username != "" && password != "") {
//				Map<String, String> map = new HashMap<>();
//				List<String> list = userDao.getUser(username, password);
//				logger.info("----------------------------srv----------------------------{}}", list);
//				if (list.size() != 0) {
//					String test = list.get(0);
//					String[] abc = test.split(",");
//					logger.info("----------------------------srv array----------------------------{}}", abc);
//					if (abc.length != 0 && (abc[0].equalsIgnoreCase(username) && abc[1].equals(password))) {
//						//map.put("id", list.get(3));
//						map.put("userName", list.get(0));
//						map.put("role", list.get(1));
//						return map;
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new HashMap<>();
//	}

	@Override
	public Map<String, String> login(UserCredentialsWrapper userWrapper) {
		try {
			logger.info("Inside login {}", userWrapper);
			String username = userWrapper.getUserName();
			String password = userWrapper.getUserPassword();
			if (username != "" && password != "") {
				Map<String, String> map = new HashMap<>();
				UserCredentials user = userDao.getUser(username, password);
				logger.info("----------------------------srv----------------------------{}}", user);
				if (!Strings.isNullOrEmpty(user.getUserName()) && !Strings.isNullOrEmpty(user.getUserPassword())) {
					map.put("id", Integer.toString(user.getId()));
					map.put("userName", user.getUserName());
					map.put("role", user.getUserRole());
					return map;
				}

			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}

	private ResponseEntity<String> adminSignUp(UserCredentialsWrapper request) {
		try {
			UserCredentials uc = new UserCredentials();
			uc.setUserName(request.getUserName());
			// uc.setUserPassword(getMd5(request.getUserPassword()));
			uc.setUserPassword(request.getUserPassword());
			uc.setUserRole(request.getUserRole());
			userDao.save(uc);
			return new ResponseEntity<>("{\"message\":\"" + "Sign Up Successfull" + "\"}", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("{\"message\":\"" + "Something went wrong" + "\"}", HttpStatus.OK);
		}
	}

	private ResponseEntity<String> userSignUp(UserCredentialsWrapper request) {
		try {
			if (validateUser(request) && request.getUserRole().equalsIgnoreCase("user")) {
				UserCredentials uc = new UserCredentials();
				uc.setUserName(request.getUserName());
				uc.setUserPassword(request.getUserPassword());
				uc.setUserRole(request.getUserRole());
				uc.setContact(request.getContact());
				uc.setAddress(request.getAddress());
				userDao.save(uc);
				return new ResponseEntity<>("{\"message\":\"" + "Sign Up Successfull" + "\"}", HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("{\"message\":\"" + "Something Went Wrong" + "\"}", HttpStatus.OK);
		}
		return null;
	}

}
