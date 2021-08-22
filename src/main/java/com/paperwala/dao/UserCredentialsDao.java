package com.paperwala.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.paperwala.POJO.UserCredentials;

public interface UserCredentialsDao extends JpaRepository<UserCredentials, Integer> {

	UserCredentials getUser(@Param("username") String username, @Param("password") String password,
			@Param("role") String role);

	List<String> validUser(@Param("username") String username);

}
