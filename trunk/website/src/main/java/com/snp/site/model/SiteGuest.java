package com.snp.site.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="site_guest"
 * 
 */
public class SiteGuest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1762842225533967433L;

	/** identifier field */
	private Long id;

	/** nullable persistent field */
	private String name;

	/** nullable persistent field */
	private String phone;

	/** nullable persistent field */
	private String contact;

	/** nullable persistent field */
	private String email;

	/** nullable persistent field */
	private String qq;

	/** nullable persistent field */
	private String url;

	/** nullable persistent field */
	private String ip;

	/** nullable persistent field */
	private String wordtime;

	/** nullable persistent field */
	private String leaveword;

	/** nullable persistent field */
	private String reply;

	/** nullable persistent field */
	private String publicize;

	/** nullable persistent field */
	private String sortstr;

	/** nullable persistent field */
	private String filepath;

	/** nullable persistent field */
	private String filename;

	/** persistent field */
	private com.snp.site.model.SiteUser siteUser;

	/** full constructor */
	public SiteGuest(String name, String phone, String contact, String email,
			String qq, String url, String ip, String wordtime,
			String leaveword, String reply, String publicize, String sortstr,
			String filepath, String filename,
			com.snp.site.model.SiteUser siteUser) {
		this.name = name;
		this.phone = phone;
		this.contact = contact;
		this.email = email;
		this.qq = qq;
		this.url = url;
		this.ip = ip;
		this.wordtime = wordtime;
		this.leaveword = leaveword;
		this.reply = reply;
		this.publicize = publicize;
		this.sortstr = sortstr;
		this.filepath = filepath;
		this.filename = filename;
		this.siteUser = siteUser;
	}

	/** default constructor */
	public SiteGuest() {
	}

	/** minimal constructor */
	public SiteGuest(com.snp.site.model.SiteUser siteUser) {
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
	 * @hibernate.property column="name" length="40"
	 * 
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @hibernate.property column="phone" length="40"
	 * 
	 */
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @hibernate.property column="contact" length="80"
	 * 
	 */
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @hibernate.property column="email" length="40"
	 * 
	 */
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @hibernate.property column="qq" length="40"
	 * 
	 */
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @hibernate.property column="url" length="40"
	 * 
	 */
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @hibernate.property column="ip" length="40"
	 * 
	 */
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @hibernate.property column="wordtime" length="50"
	 * 
	 */
	public String getWordtime() {
		return this.wordtime;
	}

	public void setWordtime(String wordtime) {
		this.wordtime = wordtime;
	}

	/**
	 * @hibernate.property column="leaveword" length="65535"
	 * 
	 */
	public String getLeaveword() {
		return this.leaveword;
	}

	public void setLeaveword(String leaveword) {
		this.leaveword = leaveword;
	}

	/**
	 * @hibernate.property column="reply" length="200"
	 * 
	 */
	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	/**
	 * @hibernate.property column="publicize" length="20"
	 * 
	 */
	public String getPublicize() {
		return this.publicize;
	}

	public void setPublicize(String publicize) {
		this.publicize = publicize;
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
