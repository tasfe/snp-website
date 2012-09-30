package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_order"
 * 
 */
public class SiteOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832662885858061834L;

	/** identifier field */
	private Long id;

	/** nullable persistent field */
	private String username;

	/** nullable persistent field */
	private String ordertime;

	/** nullable persistent field */
	private String ip;
	private String detail;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	/** nullable persistent field */
	private String filepath;

	/** nullable persistent field */
	private String filename;

	/** persistent field */
	private com.snp.site.model.SiteUser siteUser;

	/** full constructor */
	public SiteOrder(String username, String ordertime, String ip,
			String filepath, String filename,
			com.snp.site.model.SiteUser siteUser) {
		this.username = username;
		this.ordertime = ordertime;
		this.ip = ip;
		this.filepath = filepath;
		this.filename = filename;
		this.siteUser = siteUser;
	}

	/** default constructor */
	public SiteOrder() {
	}

	/** minimal constructor */
	public SiteOrder(com.snp.site.model.SiteUser siteUser) {
		this.siteUser = siteUser;
	}

	/**
	 * @hibernate.id generator-class="native" type="java.lang.Long" column="id"
	 * 
	 */
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @hibernate.property column="username" length="80"
	 * 
	 */
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @hibernate.property column="ordertime" length="80"
	 * 
	 */
	public String getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	/**
	 * @hibernate.property column="ip" length="30"
	 * 
	 */
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @hibernate.property column="filepath" length="200"
	 * 
	 */
	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @hibernate.property column="filename" length="50"
	 * 
	 */
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @hibernate.many-to-one not-null="true"
	 * @hibernate.column name="userid"
	 * 
	 */
	public com.snp.site.model.SiteUser getSiteUser() {
		return this.siteUser;
	}

	public void setSiteUser(com.snp.site.model.SiteUser siteUser) {
		this.siteUser = siteUser;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
