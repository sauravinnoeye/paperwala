package com.paperwala.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.paperwala.POJO.PaperSubscription;
import com.paperwala.wrapper.SubscribtionWrapper;

public interface PaperSubscriptionDao extends JpaRepository<PaperSubscription, Integer> {

	List<SubscribtionWrapper> getDetailForVendorByVendorId(@Param("id") Integer id);

	List<String> validSubscription(@Param("uId") Integer uId, @Param("vId") Integer vId, @Param("nId") Integer nId);
}
