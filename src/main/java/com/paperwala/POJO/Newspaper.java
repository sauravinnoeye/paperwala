package com.paperwala.POJO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@NamedQuery(name = "Vendor.getNewspaper", query = "select new com.paperwala.wrapper.NewspaperWrapper(v.vendor.vendorName,v.vendor.type,v.newspaperName) from newspaper v")

@Data
@Entity
@Table(name = "newspaper")
public class Newspaper  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "newspaper_pk")
	private int id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_fk", nullable = false)
	private List<Vendor> vendor;
	
	@Basic
	@Column(name = "newspapername")
	private String newspaperName;

	@Basic
	@Column(name = "newspaperrate")
	private String newspaperRate;
}
