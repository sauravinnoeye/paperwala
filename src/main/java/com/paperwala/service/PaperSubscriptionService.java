package com.paperwala.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paperwala.wrapper.PaperSubscriptionWrapper;
import com.paperwala.wrapper.SubscribtionWrapper;

public interface PaperSubscriptionService {

	ResponseEntity<String> subscribe(PaperSubscriptionWrapper subscribeWrapper);

	ResponseEntity<String> unsubscribe(PaperSubscriptionWrapper unSubscribeWrapper);

	List<SubscribtionWrapper> getDetailForVendorByVendorId(Integer id);

	List<SubscribtionWrapper> getDetailForUserByUserId(Integer id);

}
