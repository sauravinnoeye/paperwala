package com.paperwala.service;

import org.springframework.http.ResponseEntity;

import com.paperwala.wrapper.PaperSubscriptionWrapper;

public interface PaperSubscriptionService {

	ResponseEntity<String> subscribe(PaperSubscriptionWrapper subscribeWrapper);
	
}
