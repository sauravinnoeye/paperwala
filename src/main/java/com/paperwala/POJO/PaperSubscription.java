package com.paperwala.POJO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@NamedQuery(name = "PaperSubscription.getDetailForVendorByVendorId", query = "select new com.paperwala.wrapper.SubscribtionWrapper(p.user.userName,p.user.contact,p.user.address,p.newspaper.newspaperName,p.newspaper.newspaperRate,p.totalAmount) from PaperSubscription p where p.vendor.id=:id")

@NamedQuery(name = "PaperSubscription.validSubscription", query = "select p.user.userName from PaperSubscription p where p.user.id=:uId and p.vendor.id=:vId and p.newspaper.id=:nId and p.active='Yes'")

@Data
@Entity
@Table(name = "papersubscription")
public class PaperSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "subscribe_pk")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usercredentials_pk", nullable = false)
	private UserCredentials user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_fk", nullable = false)
	private Vendor vendor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "newspaper_fk", nullable = false)
	private Newspaper newspaper;

	@Basic
	@Column(name = "subscribe_date")
	private Date subscribeDate;

	@Basic
	@Column(name = "expire_date")
	private Date expireDate;

	@Basic
	@Column(name = "duration")
	private String duration;

	@Basic
	@Column(name = "active")
	private String active;

	@Basic
	@Column(name = "totalamount")
	private String totalAmount;

}
