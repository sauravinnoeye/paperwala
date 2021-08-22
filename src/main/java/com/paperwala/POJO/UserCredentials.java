package com.paperwala.POJO;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@NamedQuery(name = "UserCredentials.getUser", query = "select u from UserCredentials u where u.userName=:username and u.userPassword=:password and userRole=:role")

@NamedQuery(name = "UserCredentials.validUser", query = "select u.userName,u.userPassword,u.userRole from UserCredentials u where u.userName=:username")

@Data
@Entity
@Table(name = "usercredentials")
public class UserCredentials implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "usercredentials_pk")
	private Integer id;

	@Basic
	@Column(name = "username")
	private String userName;

	@Basic
	@Column(name = "userpass")
	private String userPassword;

	@Basic
	@Column(name = "userrole")
	private String userRole;

	@Basic
	@Column(name = "contact")
	private String contact;

	@Basic
	@Column(name = "address")
	private String address;

}
