package com.paperwala.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paperwala.POJO.PaperSubscription;

public interface PaperSubscriptionDao extends JpaRepository<PaperSubscription, Integer> {

}
