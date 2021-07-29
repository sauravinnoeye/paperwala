package com.paperwala.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paperwala.POJO.UserCredentials;

public interface UserCredentialsDao extends JpaRepository<UserCredentials, Integer> {

}
