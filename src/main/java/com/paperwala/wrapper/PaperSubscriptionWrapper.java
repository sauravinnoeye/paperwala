package com.paperwala.wrapper;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class PaperSubscriptionWrapper {

	private Integer user;
	
	private Integer vendor;

	private Integer newspaper;

	//private Date subscribeDate;

	//private Date expireDate;
	
	private String duration;

	private String active;

	//private String totalAmount;
	
	private String amount;
	
}
