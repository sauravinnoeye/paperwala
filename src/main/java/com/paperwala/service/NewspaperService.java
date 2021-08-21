package com.paperwala.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paperwala.wrapper.NewspaperWrapper;

public interface NewspaperService {

	ResponseEntity<String> addNewsPaper(NewspaperWrapper request);
	
	//List<Newspaper> getAllNewspaper();
	
	ResponseEntity<String> deleteNewspaper(Integer id);
	
	List<NewspaperWrapper> getNewspaperByVendor(Integer id);

}
