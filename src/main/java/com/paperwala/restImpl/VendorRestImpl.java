package com.paperwala.restImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paperwala.service.VendorService;
import com.paperwala.wrapper.VendorWrapper;

@RestController
@RequestMapping(path = "/vendor")
@CrossOrigin(origins="*")
public class VendorRestImpl {

	private Logger logger = LogManager.getLogger(VendorRestImpl.class);
	
	@Autowired
	private VendorService vservice;

	@PostMapping("/addVendor")
	public ResponseEntity<String> addVendor(@RequestBody(required = true) VendorWrapper wrap) {
		// uservice.saveProduct(request);
		try {
			return vservice.addVendor(wrap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}