package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_link"
 * 
 */
public class SiteLink extends Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5607402587366480878L;

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
	private String url;

	/** nullable persistent field */
	private String sortstr;

	/** nullable persistent field */
	private String imagealign;

	/** nullable persistent field */
	private String filepath;

	/** nullable persistent field */
	private String filename;

	private String filepathdown;

	/** nullable persistent field */
	private String filenamedown;

	public String getFilepathdown() {
		return filepathdown;
	}

	public void setFilepathdown(String filepathdown) {
		this.filepathdown = filepathdown;
	}

	public String getFilenamedown() {
		return filenamedown;
	}

	public void setFilenamedown(String filenamedown) {
		this.filenamedown = filenamedown;
	}

	/** nullable persistent field */
	private String width;

	/** nullable persistent field */
	private String height;
	private String filepathvideo;
	private String widthvideo;
	private String heightvideo;

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

	/** persistent field */
	private com.snp.site.model.SiteUser siteUser;

	/** full constructor */
	public SiteLink(String title, String detail, String title2, String detail2,
			String title3, String detail3, String url, String sortstr,
			String imagealign, String filepath, String filename, String width,
			String height, com.snp.site.model.SiteUser siteUser) {
		this.title = title;
		this.detail = detail;
		this.title2 = title2;
		this.detail2 = detail2;
		this.title3 = title3;
		this.detail3 = detail3;
		this.url = url;
		this.sortstr = sortstr;
		this.imagealign = imagealign;
		this.filepath = filepath;
		this.filename = filename;
		this.width = width;
		this.height = height;
		this.siteUser = siteUser;
	}

	/** default constructor */
	public SiteLink() {
	}

	/** minimal constructor */
	public SiteLink(com.snp.site.model.SiteUser siteUser) {
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
	 * @hibernate.property column="detail" length="200"
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
	 * @hibernate.property column="detail2" length="200"
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
	 * @hibernate.property column="detail3" length="200"
	 * 
	 */
	public String getDetail3() {
		return this.detail3;
	}

	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}

	/**
	 * @hibernate.property column="url" length="50"
	 * 
	 */
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

}
