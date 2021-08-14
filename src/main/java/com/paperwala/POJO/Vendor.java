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
@Table(name = "vendor")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "vendor_pk")
	private int id;

	@Basic
	@Column(name = "vendorname")
	private String vendorName;

	@Basic
	@Column(name = "type")
	private String type;

	@Basic
	@Column(name = "agency")
	private String agency;

	@Basic
	@Column(name = "contact")
	private String contact;

	@Basic
	@Column(name = "uniqueid")
	private String uniqueId;

	@Basic
	@Column(name = "vendoraddress")
	private String vendorAddress;

	@Basic
	@Column(name = "username")
	private String userName;

	@Basic
	@Column(name = "password")
	private String password;

}
