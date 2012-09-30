package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_spmp4_item"
 * 
 */
public class SiteSpmp4Sub implements Serializable {
	static final long serialVersionUID = -2306322411233650499L;
	/** identifier field */
	private Long id;
	/** nullable persistent field */
	private String sortstr;
	private String title;
	private String title2;
	private String title3;
	private String productlinkstring;

	public String getProductlinkstring() {
		return productlinkstring;
	}

	public void setProductlinkstring(String productlinkstring) {
		this.productlinkstring = productlinkstring;
	}

	/** persistent field */
	private com.snp.site.model.SiteSpmp4 siteSpmp4;

	/** default constructor */
	public SiteSpmp4Sub() {
	}

	/** minimal constructor */
	public SiteSpmp4Sub(com.snp.site.model.SiteSpmp4 siteSpmp4) {
		this.siteSpmp4 = siteSpmp4;
	}

	public SiteSpmp4Sub(String sortstr, String title, String title2,
			String title3, com.snp.site.model.SiteSpmp4 siteSpmp4) {
		this.sortstr = sortstr;
		this.title = title;
		this.title2 = title2;
		this.title3 = title3;

		this.siteSpmp4 = siteSpmp4;
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
	 * @hibernate.property column="detail" length="65535"
	 * 
	 */

	/**
	 * @hibernate.many-to-one not-null="true"
	 * @hibernate.column name="parentid"
	 * 
	 */
	public com.snp.site.model.SiteSpmp4 getSiteSpmp4() {
		return this.siteSpmp4;
	}

	public void setSiteSpmp4(com.snp.site.model.SiteSpmp4 siteSpmp4) {
		this.siteSpmp4 = siteSpmp4;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getTitle3() {
		return title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

}
