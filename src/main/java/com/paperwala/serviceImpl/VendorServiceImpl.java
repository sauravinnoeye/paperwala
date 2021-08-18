package com.paperwala.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.paperwala.POJO.Vendor;
import com.paperwala.dao.VendorDao;
import com.paperwala.service.VendorService;
import com.paperwala.wrapper.VendorWrapper;

@Service
public class VendorServiceImpl implements VendorService {

	private Logger logger = LogManager.getLogger(VendorServiceImpl.class);

	@Autowired
	private VendorDao vendorDao;

	@Override
	public ResponseEntity<String> addVendor(VendorWrapper vendor) {
		logger.info("-----------vendor serviceImpl-----------------------srv-----------------------------{}", vendor);
		try {
			if (validateVendor(vendor)) {
				Vendor vendorObj = new Vendor();
				vendorObj.setVendorName(vendor.getVendorName());
				vendorObj.setType(vendor.getType());
				vendorObj.setAgency(vendor.getAgency());
				vendorObj.setContact(vendor.getContact());
				vendorObj.setUniqueId(vendor.getUniqueId());
				vendorObj.setVendorAddress(vendor.getVendorAddress());
				vendorObj.setUserName(vendor.getUserName());
				vendorObj.setPassword(vendor.getPassword());
				vendorDao.save(vendorObj);
				// return "Vendor Added Successfully";
				return new ResponseEntity<>("{\"message\":\"" + "Vendor Added Successfully" + "\"}",
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("{\"message\":\"" + "Not sufficient data." + "\"}", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean validateVendor(VendorWrapper vendor) {
		try {
			if (!Strings.isNullOrEmpty(vendor.getVendorName()) && !Strings.isNullOrEmpty(vendor.getType())
					&& !Strings.isNullOrEmpty(vendor.getAgency()) && !Strings.isNullOrEmpty(vendor.getContact())
					&& !Strings.isNullOrEmpty(vendor.getUniqueId()) && !Strings.isNullOrEmpty(vendor.getVendorAddress())
					&& !Strings.isNullOrEmpty(vendor.getUserName()) && !Strings.isNullOrEmpty(vendor.getPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResponseEntity<String> getVendorDetails() {
		
		return null;
	}

}
