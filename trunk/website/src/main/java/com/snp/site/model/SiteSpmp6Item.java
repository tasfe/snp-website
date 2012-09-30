package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_spmp6_item"
 * 
 */
public class SiteSpmp6Item extends Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7329375568007633910L;

	/** identifier field */
	private Long id;

	/** nullable persistent field */
	private String sortstr;

	/** nullable persistent field */
	private String detail;

	/** nullable persistent field */
	private String detail2;

	/** nullable persistent field */
	private String detail3;

	private String title;

	private String title2;

	private String title3;

	/** nullable persistent field */
	private String filename;

	/** nullable persistent field */
	private String filepath;

	/** nullable persistent field */
	private String imagealign;

	/** nullable persistent field */
	private String width;

	/** nullable persistent field */
	private String height;
	private String module;
	private String filepathvideo;
	private String widthvideo;
	private String heightvideo;
	private String widthmodule;
	private String heightmodule;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getFilepathvideo() {
		return filepathvideo;
	}

	public void setFilepathvideo(String filepathvideo) {
		this.filepathvideo = filepathvideo;
	}

	public String getWidthvideo() {
		return widthvideo;
	}

	public void setWidthvideo(String widthvideo) {
		this.widthvideo = widthvideo;
	}

	public String getHeightvideo() {
		return heightvideo;
	}

	public void setHeightvideo(String heightvideo) {
		this.heightvideo = heightvideo;
	}

	public String getWidthmodule() {
		return widthmodule;
	}

	public void setWidthmodule(String widthmodule) {
		this.widthmodule = widthmodule;
	}

	public String getHeightmodule() {
		return heightmodule;
	}

	public void setHeightmodule(String heightmodule) {
		this.heightmodule = heightmodule;
	}

	/** persistent field */
	private com.snp.site.model.SiteSpmp6 siteSpmp6;

	/** full constructor */
	public SiteSpmp6Item(String sortstr, String detail, String detail2,
			String detail3, String filename, String filepath,
			String imagealign, String width, String height,
			com.snp.site.model.SiteSpmp6 siteSpmp6) {
		this.sortstr = sortstr;
		this.detail = detail;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.filename = filename;
		this.filepath = filepath;
		this.imagealign = imagealign;
		this.width = width;
		this.height = height;
		this.siteSpmp6 = siteSpmp6;
	}

	/** default constructor */
	public SiteSpmp6Item() {
	}

	/** minimal constructor */
	public SiteSpmp6Item(com.snp.site.model.SiteSpmp6 siteSpmp6) {
		this.siteSpmp6 = siteSpmp6;
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
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
	 * @hibernate.column name="parentid"
	 * 
	 */
	public com.snp.site.model.SiteSpmp6 getSiteSpmp6() {
		return this.siteSpmp6;
	}

	public void setSiteSpmp6(com.snp.site.model.SiteSpmp6 siteSpmp6) {
		this.siteSpmp6 = siteSpmp6;
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
