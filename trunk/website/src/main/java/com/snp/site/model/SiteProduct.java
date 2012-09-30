package com.snp.site.model;

import java.io.File;
import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.snp.site.init.SystemInit;

/**
 * @hibernate.class table="site_spmp4_item"
 * 
 */
public class SiteProduct extends Model implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6990116539878078213L;
	private Long id;
	/** nullable persistent field */
	private String sortstr;

	/** nullable persistent field */
	private String detail;

	/** nullable persistent field */
	private String detail2;

	/** nullable persistent field */
	private String detail3;

	/** nullable persistent field */
	private String filename;

	private String filenamevideo;

	public String getFilenamevideo() {
		return filenamevideo;
	}

	public void setFilenamevideo(String filenamevideo) {
		this.filenamevideo = filenamevideo;
	}

	/** nullable persistent field */
	private String filepath;
	private String filepathvideo;
	private String widthvideo;
	private String heightvideo;

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

	public String getFilepathvideo() {
		return filepathvideo;
	}

	public boolean checkexists() {
		return new File(SystemInit.getSiteHome() + getFilepathvideo() + ".flv")
				.exists();
	}

	public void setFilepathvideo(String filepathvideo) {
		this.filepathvideo = filepathvideo;
	}

	/** nullable persistent field */
	private String imagealign;

	/** nullable persistent field */
	private String width;

	/** nullable persistent field */
	private String height;
	/** persistent field */
	private com.snp.site.model.SiteSpmp4Item siteSpmp4Item;

	/** full constructor */
	public SiteProduct(String sortstr, String detail, String detail2,
			String detail3, String filename, String filepath,
			String imagealign, String width, String height,
			com.snp.site.model.SiteSpmp4Item siteSpmp4) {
		this.sortstr = sortstr;
		this.detail = detail;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.filename = filename;
		this.filepath = filepath;
		this.imagealign = imagealign;
		this.width = width;
		this.height = height;
		this.siteSpmp4Item = siteSpmp4;
	}

	/** default constructor */
	public SiteProduct() {
	}

	/** minimal constructor */
	public SiteProduct(com.snp.site.model.SiteSpmp4Item siteSpmp4Item) {
		this.siteSpmp4Item = siteSpmp4Item;
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
	public com.snp.site.model.SiteSpmp4Item getSiteSpmp4Item() {
		return this.siteSpmp4Item;
	}

	public void setSiteSpmp4Item(com.snp.site.model.SiteSpmp4Item siteSpmp4Item) {
		this.siteSpmp4Item = siteSpmp4Item;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
