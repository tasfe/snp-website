package com.snp.site.model;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_suser"
 * 
 */
public class SiteSuser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5139691270067559639L;

	/** identifier field */
	private Long id;

	private String username;

	private String password;

	private String detail;

	private String filename;

	private String filepath;

	private String name2;

	private String detail2;

	private String name3;

	private String detail3;

	private String name;

	private String imagealign;

	private String sortstr;
	private String confirm;
	private String width;

	private String height;

	private com.snp.site.model.SiteUser siteUser;

	/** persistent field */
	private Set siteSuserItems;

	/** full constructor */
	public SiteSuser(String name2, String detail2, String name3, String detai3,
			String name, String detail, String filename, String filepath,
			String imagealign, String sortstr, String width, String height,
			com.snp.site.model.SiteUser siteUser, Set siteSuserItems) {
		this.name2 = name2;
		this.detail2 = detail2;
		this.name3 = name3;
		this.detail3 = detai3;
		this.name = name;
		this.detail = detail;
		this.filename = filename;
		this.filepath = filepath;
		this.imagealign = imagealign;
		this.sortstr = sortstr;
		this.width = width;
		this.height = height;
		this.siteUser = siteUser;
		this.siteSuserItems = siteSuserItems;
	}

	/** default constructor */
	public SiteSuser() {
	}

	/** minimal constructor */
	public SiteSuser(com.snp.site.model.SiteUser siteUser, Set siteSuserItems) {
		this.siteUser = siteUser;
		this.siteSuserItems = siteSuserItems;
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
	 * @hibernate.property column="name2" length="50"
	 * 
	 */
	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
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
	 * @hibernate.property column="name3" length="50"
	 * 
	 */
	public String getName3() {
		return this.name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	/**
	 * @hibernate.property column="detai3" length="65535"
	 * 
	 */
	public String getDetail3() {
		return this.detail3;
	}

	public void setDetail3(String detai3) {
		this.detail3 = detai3;
	}

	/**
	 * @hibernate.property column="name" length="50"
	 * 
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="parentid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteSuserItem"
	 * 
	 */
	public Set getSiteSuserItems() {
		return this.siteSuserItems;
	}

	public void setSiteSuserItems(Set siteSuserItems) {
		this.siteSuserItems = siteSuserItems;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

}
