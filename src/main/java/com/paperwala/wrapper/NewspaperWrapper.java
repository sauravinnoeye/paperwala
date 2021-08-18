package com.paperwala.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.paperwala.POJO.Vendor;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class NewspaperWrapper {

	private String newspaperName;
	
	private int vendor;

	private String newspaperRate;

}
