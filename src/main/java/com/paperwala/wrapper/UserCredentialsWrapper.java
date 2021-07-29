package com.paperwala.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class UserCredentialsWrapper {

	private String userName;
	
	private String userPassword;
	
	private String userRole;
}
