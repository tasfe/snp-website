package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_order_check_item"
 * 
 */
public class SiteOrderCheckItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1152149797759277637L;

	/** identifier field */
	private Long id;

	/** nullable persistent field */
	private String title;

	/** nullable persistent field */
	private String title2;

	/** nullable persistent field */
	private String title3;

	/** nullable persistent field */
	private String sortstr;

	/** persistent field */
	private com.snp.site.model.SiteOrderCheck siteOrderCheck;

	/** full constructor */
	public SiteOrderCheckItem(String title, String title2, String title3,
			String sortstr, com.snp.site.model.SiteOrderCheck siteOrderCheck) {
		this.title = title;
		this.title2 = title2;
		this.title3 = title3;
		this.sortstr = sortstr;
		this.siteOrderCheck = siteOrderCheck;
	}

	/** default constructor */
	public SiteOrderCheckItem() {
	}

	/** minimal constructor */
	public SiteOrderCheckItem(com.snp.site.model.SiteOrderCheck siteOrderCheck) {
		this.siteOrderCheck = siteOrderCheck;
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
	 * @hibernate.property column="title" length="200"
	 * 
	 */
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @hibernate.property column="title2" length="200"
	 * 
	 */
	public String getTitle2() {
		return this.title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	/**
	 * @hibernate.property column="title3" length="200"
	 * 
	 */
	public String getTitle3() {
		return this.title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

	/**
	 * @hibernate.property column="sortstr" length="30"
	 * 
	 */
	public String getSortstr() {
		return this.sortstr;
	}

	public void setSortstr(String sortstr) {
		this.sortstr = sortstr;
	}

	/**
	 * @hibernate.many-to-one not-null="true"
	 * @hibernate.column name="parentid"
	 * 
	 */
	public com.snp.site.model.SiteOrderCheck getSiteOrderCheck() {
		return this.siteOrderCheck;
	}

	public void setSiteOrderCheck(
			com.snp.site.model.SiteOrderCheck siteOrderCheck) {
		this.siteOrderCheck = siteOrderCheck;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
