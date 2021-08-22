package com.paperwala.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class NewspaperWrapper {

	private String newspaperName;

	private Integer vendor;

	private String newspaperRate;

	private Integer newspaperId;

	public NewspaperWrapper() {
		super();
	}

	public NewspaperWrapper(String newspaperName, String newspaperRate, Integer vendor, Integer newspaperId) {
		this.newspaperName = newspaperName;
		this.newspaperRate = newspaperRate;
		this.vendor = vendor;
		this.newspaperId = newspaperId;
	}

}
