package com.snp.site.model;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.snp.site.init.SystemInit;

/**
 * @hibernate.class table="site_spmp4_item"
 * 
 */
public class SiteSpmp4Item extends Model implements Serializable {
	static final long serialVersionUID = -2306502411297650499L;
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

	private String shop1 = "";
	private String shop2 = "";
	private String shop3 = "";
	private String shop4 = "";
	public String clicknumber = "1";

	private Set siteProducts;

	public Set getSiteProducts() {
		return siteProducts;
	}

	public void setSiteProducts(Set siteProducts) {
		this.siteProducts = siteProducts;
	}

	public String getClicknumber() {
		return clicknumber;
	}

	public void setClicknumber(String clicknumber) {
		this.clicknumber = clicknumber;
	}

	public String getShop1() {
		return shop1;
	}

	public void setShop1(String shop1) {
		this.shop1 = shop1;
	}

	public String getShop2() {
		return shop2;
	}

	public void setShop2(String shop2) {
		this.shop2 = shop2;
	}

	public String getShop3() {
		return shop3;
	}

	public void setShop3(String shop3) {
		this.shop3 = shop3;
	}

	public String getShop4() {
		return shop4;
	}

	public void setShop4(String shop4) {
		this.shop4 = shop4;
	}

	/** nullable persistent field */
	private String filename;

	/** nullable persistent field */
	private String filepath;
	private String filepathvideo = "";

	public String getFilepathvideo() {
		return filepathvideo;
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
	private String member = "";
	/** persistent field */
	private com.snp.site.model.SiteSpmp4 siteSpmp4;

	/** full constructor */
	public SiteSpmp4Item(String sortstr, String detail, String detail2,
			String detail3, String filename, String filepath,
			String imagealign, String width, String height,
			com.snp.site.model.SiteSpmp4 siteSpmp4) {
		this.sortstr = sortstr;
		this.detail = detail;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.filename = filename;
		this.filepath = filepath;
		this.imagealign = imagealign;
		this.width = width;
		this.height = height;
		this.siteSpmp4 = siteSpmp4;
	}

	/** default constructor */
	public SiteSpmp4Item() {
	}

	/** minimal constructor */
	public SiteSpmp4Item(com.snp.site.model.SiteSpmp4 siteSpmp4) {
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

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getImg_spmp4_sm_height() {
		return SystemInit.img_spmp4_sm_height;
	}

	public String getImg_spmp4_sm_width() {
		return SystemInit.img_spmp4_sm_width;
	}
}
