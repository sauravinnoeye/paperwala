package com.paperwala.service;

import org.springframework.http.ResponseEntity;

import com.paperwala.wrapper.NewspaperWrapper;

public interface NewspaperService {

	ResponseEntity<String> addNewsPaper(NewspaperWrapper request);
	
	
	
	
}
