package com.paperwala.service;

import org.springframework.http.ResponseEntity;

import com.paperwala.wrapper.VendorWrapper;

public interface VendorService {

	ResponseEntity<String> addVendor(VendorWrapper vendor);
	
}
