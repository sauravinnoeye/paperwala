package com.paperwala.POJO;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

//@NamedQuery(name = "Vendor.getNewspaper", query = "select new com.paperwala.wrapper.NewspaperWrapper(v.newspaperName) from newspaper v")
//@NamedQuery(name = "Vendor.getNewspaper", query = "select n from newspaper v")

@Data
@Entity
@Table(name = "newspaper")
public class Newspaper  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "newspaper_pk")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_fk", nullable = false)
	private Vendor vendor;
	
	@Basic
	@Column(name = "newspapername")
	private String newspaperName;

	@Basic
	@Column(name = "newspaperrate")
	private String newspaperRate;
}
