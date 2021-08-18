package com.paperwala.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class VendorWrapper {

	private String vendorName;

	private String type;

	private String agency;

	private String contact;

	private String uniqueId;

	private String vendorAddress;

	private String userName;

	private String password;

	public VendorWrapper() {
	}

	public VendorWrapper(String vendorName, String type) {
		this.vendorName = vendorName;
		this.type = type;
	}

}
