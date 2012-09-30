package com.snp.site.model;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_order_check"
 * 
 */
public class SiteOrderCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3634190130250953016L;

	/** identifier field */
	private Long id;

	/** nullable persistent field */
	private String title;

	/** nullable persistent field */
	private String detail;

	/** nullable persistent field */
	private String title2;

	/** nullable persistent field */
	private String detail2;

	/** nullable persistent field */
	private String title3;

	/** nullable persistent field */
	private String detail3;

	/** nullable persistent field */
	private String sortstr;

	/** persistent field */
	private com.snp.site.model.SiteUser siteUser;

	/** persistent field */
	private Set siteOrderCheckItems;

	/** full constructor */
	public SiteOrderCheck(String title, String detail, String title2,
			String detail2, String title3, String detail3, String sortstr,
			com.snp.site.model.SiteUser siteUser, Set siteOrderCheckItems) {
		this.title = title;
		this.detail = detail;
		this.title2 = title2;
		this.detail2 = detail2;
		this.title3 = title3;
		this.detail3 = detail3;
		this.sortstr = sortstr;
		this.siteUser = siteUser;
		this.siteOrderCheckItems = siteOrderCheckItems;
	}

	/** default constructor */
	public SiteOrderCheck() {
	}

	/** minimal constructor */
	public SiteOrderCheck(com.snp.site.model.SiteUser siteUser,
			Set siteOrderCheckItems) {
		this.siteUser = siteUser;
		this.siteOrderCheckItems = siteOrderCheckItems;
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
	 * @hibernate.property column="detail" length="65535"
	 * 
	 */
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
	 * @hibernate.property column="detail2" length="65535"
	 * 
	 */
	public String getDetail2() {
		return this.detail2;
	}

	public void setDetail2(String detail2) {
		this.detail2 = detail2;
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
	 * @hibernate.property column="detail3" length="65535"
	 * 
	 */
	public String getDetail3() {
		return this.detail3;
	}

	public void setDetail3(String detail3) {
		this.detail3 = detail3;
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
	 * @hibernate.column name="userid"
	 * 
	 */
	public com.snp.site.model.SiteUser getSiteUser() {
		return this.siteUser;
	}

	public void setSiteUser(com.snp.site.model.SiteUser siteUser) {
		this.siteUser = siteUser;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="parentid"
	 * @hibernate.collection-one-to-many 
	 *                                   class="com.site.model.SiteOrderCheckItem"
	 * 
	 */
	public Set getSiteOrderCheckItems() {
		return this.siteOrderCheckItems;
	}

	public void setSiteOrderCheckItems(Set siteOrderCheckItems) {
		this.siteOrderCheckItems = siteOrderCheckItems;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
