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

	private String contact;

	private String address;

	private String uemail;

	private String firstName;

	private String lastName;
}
