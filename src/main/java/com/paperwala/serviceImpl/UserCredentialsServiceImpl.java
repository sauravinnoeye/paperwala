package com.paperwala.serviceImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paperwala.POJO.UserCredentials;
import com.paperwala.dao.UserCredentialsDao;
import com.paperwala.service.UserCredentialsService;
import com.paperwala.wrapper.UserCredentialsWrapper;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

	@Autowired
	private UserCredentialsDao userDao;
	
	@Override
	public String createUser(UserCredentialsWrapper request) {
		if (validateUser(request)) {
			UserCredentials uc = new UserCredentials();
			uc.setUserName(request.getUserName());
			//uc.setUserPassword(getMd5(request.getUserPassword()));
			uc.setUserPassword(request.getUserPassword());
			uc.setUserRole(request.getUserRole());
			userDao.save(uc);
			return "Sign Up Successfull";
		} else {
			return "Not sufficient data to create account";
		}
	}

	private Boolean validateUser(UserCredentialsWrapper user) {
		if (!user.getUserName().isEmpty() && !user.getUserPassword().isEmpty() && !user.getUserRole().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
