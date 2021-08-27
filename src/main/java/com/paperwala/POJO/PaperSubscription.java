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

@NamedQuery(name = "PaperSubscription.getDetailForVendorByVendorId", query = "select new com.paperwala.wrapper.SubscribtionWrapper(p.user.userName,p.user.contact,p.user.address,p.newspaper.newspaperName,p.newspaper.newspaperRate,p.totalAmount,p.subscribeDate,p.expireDate,p.duration) from PaperSubscription p where p.vendor.id=:id and p.active='Yes'")

@NamedQuery(name = "PaperSubscription.validSubscription", query = "select p.user.userName from PaperSubscription p where p.user.id=:uId and p.vendor.id=:vId and p.newspaper.id=:nId and p.active='Yes'")

@NamedQuery(name = "PaperSubscription.unsubscribe", query = "update PaperSubscription p set p.active='No' where p.user.id=:uId and p.vendor.id=:vId and p.newspaper.id=:nId and p.active='Yes'")

@NamedQuery(name = "PaperSubscription.statusUpdateScheduler", query = "update PaperSubscription set active='No' WHERE expireDate <= now()")

@NamedQuery(name = "PaperSubscription.getDetailForUserByUserId", query = "select new com.paperwala.wrapper.SubscribtionWrapper(u.vendor.vendorName,u.vendor.type,u.vendor.agency,u.vendor.contact,u.vendor.vendorAddress,u.newspaper.newspaperName,u.newspaper.newspaperRate,u.totalAmount,u.subscribeDate,u.expireDate,u.duration) from PaperSubscription u where u.user.id=:uId and u.active='Yes'")

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
