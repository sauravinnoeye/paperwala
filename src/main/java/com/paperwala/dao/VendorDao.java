package com.paperwala.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.paperwala.POJO.Vendor;

public interface VendorDao  extends JpaRepository<Vendor, Integer>  {

	//List<Vendor> findAll();

	Vendor getVendor(@Param("username") String username, @Param("password") String password);
	
}
