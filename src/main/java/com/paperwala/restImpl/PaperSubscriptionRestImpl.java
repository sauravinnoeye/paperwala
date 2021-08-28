package com.paperwala.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paperwala.service.PaperSubscriptionService;
import com.paperwala.wrapper.PaperSubscriptionWrapper;
import com.paperwala.wrapper.SubscribtionWrapper;

@RestController
@RequestMapping(path = "/papersubscription")
@CrossOrigin(origins = "*")
public class PaperSubscriptionRestImpl {

	@Autowired
	private PaperSubscriptionService service;

	@PostMapping("/subscribe")
	public ResponseEntity<String> subscribe(@RequestBody(required = true) PaperSubscriptionWrapper wrapper) {
		try {
			return service.subscribe(wrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/getDetailForVendorByVendorId/{id}")
	public List<SubscribtionWrapper> getDetailForVendorByVendorId(
			@PathVariable(required = true, name = "id") Integer id) {
		try {
			return service.getDetailForVendorByVendorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/unsubscribe")
	public ResponseEntity<String> unsubscribe(@RequestBody(required = true) PaperSubscriptionWrapper unSubscribeWrapper) {
		try {
			return service.unsubscribe(unSubscribeWrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/getDetailForUserByUserId/{id}")
	public List<SubscribtionWrapper> getDetailForUserByUserId(
			@PathVariable(required = true, name = "id") Integer id) {
		try {
			return service.getDetailForUserByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/getExpiredDetailForVendorByVendorId/{id}")
	public List<SubscribtionWrapper> getExpiredDetailForVendorByVendorId(
			@PathVariable(required = true, name = "id") Integer id) {
		try {
			return service.getExpiredDetailForVendorByVendorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/getExpiredDetailForUserByUserId/{id}")
	public List<SubscribtionWrapper> getExpiredDetailForUserByUserId(
			@PathVariable(required = true, name = "id") Integer id) {
		try {
			return service.getExpiredDetailForUserByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
