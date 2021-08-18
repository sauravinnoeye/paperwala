package com.paperwala.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paperwala.POJO.Vendor;
import com.paperwala.wrapper.VendorWrapper;

public interface VendorService {

	ResponseEntity<String> addVendor(VendorWrapper vendor);
	
	List<Vendor> getAllVendor();
	
}
