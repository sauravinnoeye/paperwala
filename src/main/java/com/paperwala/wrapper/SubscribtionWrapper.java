package com.paperwala.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class SubscribtionWrapper {

	private String newspaperName;

	private String newspaperRate;

	private String userName;

	private String contact;

	private String address;

	private String totalAmount;

	public SubscribtionWrapper() {
		super();
	}

	public SubscribtionWrapper(String userName, String contact, String address, String newspaperName,
			String newspaperRate, String totalAmount) {
		this.userName = userName;
		this.contact = contact;
		this.address = address;
		this.newspaperName = newspaperName;
		this.newspaperRate = newspaperRate;
		this.totalAmount = totalAmount;
	}
}
