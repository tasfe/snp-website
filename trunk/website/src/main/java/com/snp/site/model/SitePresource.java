package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_presource"
 * 
 */
public class SitePresource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5934406567435478986L;

	/** identifier field */
	private Long id;

	private String filename;

	private String filepath;

	private String filetype;

	private String title;

	private String detail;

	private String title2;

	private String detail2;

	private String title3;

	private String detail3;

	private String sortstr;

	private String imagealign;

	private String width;

	private String height;

	/** persistent field */
	private com.snp.site.model.SiteUser siteUser;

	/** full constructor */
	public SitePresource(String title, String detail, String title2,
			String detail2, String title3, String detail3, String sortstr,
			String imagealign, String filename, String filepath, String width,
			String height, com.snp.site.model.SiteUser siteUser) {
		this.title = title;
		this.detail = detail;
		this.title2 = title2;
		this.detail2 = detail2;
		this.title3 = title3;
		this.detail3 = detail3;
		this.sortstr = sortstr;
		this.imagealign = imagealign;
		this.filename = filename;
		this.filepath = filepath;
		this.width = width;
		this.height = height;
		this.siteUser = siteUser;
	}

	/** default constructor */
	public SitePresource() {
	}

	/** minimal constructor */
	public SitePresource(com.snp.site.model.SiteUser siteUser) {
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
	 * @hibernate.property column="title" length="50"
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
	 * @hibernate.property column="title2" length="50"
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
	 * @hibernate.property column="title3" length="50"
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
	 * @hibernate.property column="imagealign" length="20"
	 * 
	 */
	public String getImagealign() {
		return this.imagealign;
	}

	public void setImagealign(String imagealign) {
		this.imagealign = imagealign;
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
	 * @hibernate.property column="width" length="20"
	 * 
	 */
	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @hibernate.property column="height" length="20"
	 * 
	 */
	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
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

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

}
