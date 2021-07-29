package com.paperwala.POJO;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usercredentials")
public class UserCredentials implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "usercredentials_pk")
	private int id;
	
	@Basic
	@Column(name = "username")
	private String userName;
	
	@Basic
	@Column(name = "userpass")
	private String userPassword;
	
	@Basic
	@Column(name = "userrole")
	private String userRole;

}
