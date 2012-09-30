package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_order_radio_item"
 * 
 */
public class SiteOrderRadioItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6092852046778744906L;

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
	private com.snp.site.model.SiteOrderRadio siteOrderRadio;

	/** full constructor */
	public SiteOrderRadioItem(String title, String title2, String title3,
			String sortstr, com.snp.site.model.SiteOrderRadio siteOrderRadio) {
		this.title = title;
		this.title2 = title2;
		this.title3 = title3;
		this.sortstr = sortstr;
		this.siteOrderRadio = siteOrderRadio;
	}

	/** default constructor */
	public SiteOrderRadioItem() {
	}

	/** minimal constructor */
	public SiteOrderRadioItem(com.snp.site.model.SiteOrderRadio siteOrderRadio) {
		this.siteOrderRadio = siteOrderRadio;
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
	public com.snp.site.model.SiteOrderRadio getSiteOrderRadio() {
		return this.siteOrderRadio;
	}

	public void setSiteOrderRadio(
			com.snp.site.model.SiteOrderRadio siteOrderRadio) {
		this.siteOrderRadio = siteOrderRadio;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
