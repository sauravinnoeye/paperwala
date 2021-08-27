package com.paperwala.wrapper;

import java.util.Date;

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

	private Date subscribeDate;

	private Date expireDate;

	private String duration;

	private String vendorName;

	private String type;

	private String agency;

	private String vendorAddress;

	public SubscribtionWrapper() {
		super();
	}

	public SubscribtionWrapper(String userName, String contact, String address, String newspaperName,
			String newspaperRate, String totalAmount, Date subscribeDate, Date expireDate, String duration) {
		this.userName = userName;
		this.contact = contact;
		this.address = address;
		this.newspaperName = newspaperName;
		this.newspaperRate = newspaperRate;
		this.totalAmount = totalAmount;
		this.subscribeDate = subscribeDate;
		this.expireDate = expireDate;
		this.duration = duration;
	}

	public SubscribtionWrapper(String vendorName, String type, String agency, String contact, String vendorAddress,
			String newspaperName, String newspaperRate, String totalAmount, Date subscribeDate, Date expireDate,
			String duration) {
		this.vendorName = vendorName;
		this.type = type;
		this.agency = agency;
		this.contact = contact;
		this.vendorAddress = vendorAddress;
		this.newspaperName = newspaperName;
		this.newspaperRate = newspaperRate;
		this.totalAmount = totalAmount;
		this.subscribeDate = subscribeDate;
		this.expireDate = expireDate;
		this.duration = duration;
	}
}
