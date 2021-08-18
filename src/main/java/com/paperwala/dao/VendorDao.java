package com.paperwala.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paperwala.POJO.Vendor;

public interface VendorDao  extends JpaRepository<Vendor, Integer>  {

	//List<Vendor> findAll();
	
}
