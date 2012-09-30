package com.snp.site.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.snp.site.init.SystemInit;

/**
 * @hibernate.class table="site_spmp4"
 * 
 */
public class SiteSpmp4 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -847498829463197673L;
	/** identifier field */
	private Long id;
	private String ordermyself;

	public String getOrdermyself() {
		return ordermyself;
	}

	public void setOrdermyself(String ordermyself) {
		this.ordermyself = ordermyself;
	}

	/** nullable persistent field */
	private String name2;

	/** nullable persistent field */
	private String detail2;

	/** nullable persistent field */
	private String name3;

	/** nullable persistent field */
	private String detail3;

	/** nullable persistent field */
	private String name;

	/** nullable persistent field */
	private String detail;
	private String common;
	private String common2;

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getCommon2() {
		return common2;
	}

	public void setCommon2(String common2) {
		this.common2 = common2;
	}

	public String getCommon3() {
		return common3;
	}

	public void setCommon3(String common3) {
		this.common3 = common3;
	}

	private String common3;
	/** nullable persistent field */
	private String filename;

	/** nullable persistent field */
	private String filepath;

	private String productlinkstring;

	public String getProductlinkstring() {
		return productlinkstring;
	}

	public void setProductlinkstring(String productlinkstring) {
		this.productlinkstring = productlinkstring;
	}

	/** nullable persistent field */
	private String imagealign;

	/** nullable persistent field */
	private String sortstr;

	/** nullable persistent field */
	private String width;

	/** nullable persistent field */
	private String height;

	/** persistent field */
	private com.snp.site.model.SiteUser siteUser;

	/** persistent field */
	private Set siteSpmp4Items;
	private Set siteSpmp4Subs;

	public Set getSiteSpmp4Subs() {
		return siteSpmp4Subs;
	}

	public void setSiteSpmp4Subs(Set siteSpmp4Subs) {

		this.siteSpmp4Subs = siteSpmp4Subs;
	}

	/** full constructor */
	public SiteSpmp4(String name2, String detail2, String name3, String detai3,
			String name, String detail, String filename, String filepath,
			String imagealign, String sortstr, String width, String height,
			com.snp.site.model.SiteUser siteUser, Set siteSpmp4Items,
			Set siteSpmp4Subs) {
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
		this.siteSpmp4Items = siteSpmp4Items;
		this.siteSpmp4Subs = siteSpmp4Subs;
	}

	/** default constructor */
	public SiteSpmp4() {
	}

	/** minimal constructor */
	public SiteSpmp4(com.snp.site.model.SiteUser siteUser, Set siteSpmp4Items) {
		this.siteUser = siteUser;
		this.siteSpmp4Items = siteSpmp4Items;
	}

	public ArrayList getPoductLinklist() {
		ArrayList productLinklist = new ArrayList();
		productLinklist.addAll(siteSpmp4Items);
		if (productlinkstring != null) {
			String[] producId = productlinkstring.split(",");
			if (producId.length > 0) {
				for (int i = 0; i < producId.length; i++) {
					// SiteSpmp4Item
					// product=(SiteSpmp4Item)adao.loadById("SiteSpmp4Item",Long.getLong(producId[i]));
					SiteSpmp4Item product = (SiteSpmp4Item) SystemInit
							.getObjectById("SiteSpmp4Item", // adao.getObject没有问题
									producId[i]);
					if (product != null)
						productLinklist.add(product);
				}
			}
		}
		return productLinklist;
	}

	public ArrayList getSubPoductLinklist(String subid) {
		ArrayList productLinklist = new ArrayList();
		for (Iterator iterator = getSiteSpmp4Subs().iterator(); iterator
				.hasNext();) {
			SiteSpmp4Sub siteSpmp4Sub = (SiteSpmp4Sub) iterator.next();
			if (siteSpmp4Sub.getId().toString().equals(subid)) {
				if (siteSpmp4Sub.getProductlinkstring() != null) {
					String[] producId = siteSpmp4Sub.getProductlinkstring()
							.split(",");
					if (producId.length > 0) {
						for (int i = 0; i < producId.length; i++) {
							// SiteSpmp4Item
							// product=(SiteSpmp4Item)adao.loadById("SiteSpmp4Item",Long.getLong(producId[i]));
							try {
								SiteSpmp4Item product = (SiteSpmp4Item) SystemInit
										.getObjectById("SiteSpmp4Item", // adao.getObject没有问题
												producId[i]);
								if (product != null)
									productLinklist.add(product);
							} catch (Exception e) {
								// 有时候，连接的图片已经别清理掉了，这时不要报错退出，否则返回不了对象

								// log.error(e.printStackTrace());
								e.printStackTrace();
							}

						}
					}
				}
			}
		}
		return productLinklist;
	}

	/*
	 * public String getSubPoductLinkNum(String subid) {
	 * 
	 * for (Iterator iterator = getSiteSpmp4Subs().iterator(); iterator
	 * .hasNext();) { SiteSpmp4Sub siteSpmp4Sub = (SiteSpmp4Sub)
	 * iterator.next(); if (siteSpmp4Sub.getId().toString().equals(subid)) { if
	 * (siteSpmp4Sub.getProductlinkstring() != null) { String[] producId =
	 * siteSpmp4Sub.getProductlinkstring() .split(","); if (producId.length > 0)
	 * { for (int i = 0; i < producId.length; i++) { // SiteSpmp4Item //
	 * product=
	 * (SiteSpmp4Item)adao.loadById("SiteSpmp4Item",Long.getLong(producId[i]));
	 * try { SiteSpmp4Item product = (SiteSpmp4Item) SystemInit
	 * .getObjectById("SiteSpmp4Item", // adao.getObject没有问题 producId[i]);
	 * productLinklist.add(product); } catch (Exception e) {
	 * //有时候，连接的图片已经别清理掉了，这时不要报错退出，否则返回不了对象
	 * 
	 * e.printStackTrace(); }
	 * 
	 * } } } } } return productLinklist; }
	 */
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
	 * @hibernate.collection-one-to-many class="com.site.model.SiteSpmp4Item"
	 * 
	 */
	public Set getSiteSpmp4Items() {
		return this.siteSpmp4Items;
	}

	public Set getSubItems() {
		return siteSpmp4Subs;// ; 显示目录类别
	}

	public SiteSpmp4Item getFirst() {
		for (Iterator iterator = this.siteSpmp4Items.iterator(); iterator
				.hasNext();) {
			SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) iterator.next();
			return siteSpmp4Item;
		}
		return null;
	}

	public void setSiteSpmp4Items(Set siteSpmp4Items) {
		this.siteSpmp4Items = siteSpmp4Items;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String getActionString() {
		return "siteSpmp4Detail";
	}

	public String getTitle() {
		return this.siteUser.getSpmp4Lanmu();
	}

	public String getTitle1() {
		return this.siteUser.getSpmp4Lanmu2();
	}

	public String getTitle2() {
		return this.siteUser.getSpmp4Lanmu3();
	}

	public Set getAllItems() {
		return this.siteUser.getSiteSpmp4s();
	}
}
