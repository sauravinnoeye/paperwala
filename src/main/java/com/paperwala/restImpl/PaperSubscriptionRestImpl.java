package com.paperwala.restImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paperwala.service.PaperSubscriptionService;
import com.paperwala.wrapper.PaperSubscriptionWrapper;

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

}
