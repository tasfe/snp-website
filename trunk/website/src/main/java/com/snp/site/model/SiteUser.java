package com.snp.site.model;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;

/**
 * @hibernate.class table="site_user"
 * 
 */
public class SiteUser implements Serializable {
	private static Log log = LogFactory.getLog(SiteUser.class);

	private Long id;

	static final long serialVersionUID = 8630443880286631821L;

	private String usernotify;

	private String paymoney;

	private String price;

	private String state = "T";

	private Integer ordernum;

	private String comment;

	private String password;

	private String username;

	private String title;

	private String title2;

	private String title3;

	private String contentright;
	private String contentleft;

	private String language;

	private String language2 = "";

	private String language3 = "";

	private String local = "";

	private String local2 = "";

	private String local3 = "";

	private Date enddate;

	private Date begindate;

	private String envelopStyle;

	private String shopcartflag;

	private String indexStyle;

	private String cssStyle = "0";
	private String dirStyle = "0";

	private String indexContentStyle;

	private String spmp4ItemDetailStyle;

	private String linkDetailStyle;

	private String indexProductRownum;

	private String indexProductColnum;

	private String indexLanmu;

	private String indexLimit;

	private String indexLanmu2;

	private String indexLanmu3;

	private String indexDesc;
	private String indexDesc2;
	private String indexDesc3;

	private String marquee;
	private String marquee2;
	private String marquee3;

	private String searchTitle;

	private String searchKeys;

	private String searchDesc;

	private String addressLanmu = "";

	private String addressLanmu2 = "";

	private String addressLanmu3 = "";

	private String addressLimit;

	private String indexht;
	private String addressht;
	private String jobht;
	private String aboutht;
	// 双层目录不适合加横条

	private String s1ht = "";
	private String s2ht = "";

	private String addressDesc;
	private String urlkey;
	private Set siteAddresss;

	private String jobLanmu = "";

	private String jobLanmu2 = "";

	private String jobLanmu3 = "";

	private String jobLimit;

	private String jobDesc;

	private String guestLanmu = "";

	private String guestLanmu2 = "";

	private String guestLanmu3 = "";

	private String guestLimit;

	private String guestDesc;

	private String linkLanmu = "";

	private String linkLanmu2 = "";

	private String linkLanmu3 = "";

	private String linkLimit;

	private String linkDesc;

	private String checkLanmu = "";

	private String bottom;

	private String checkLanmu2 = "";

	private String checkLanmu3 = "";

	private String checkLimit;
	private String otherusername;
	private String checkDesc;
	private String checkdesignLanmu = "";

	private String checkdesignDesc;
	private String productlinkstring = "";
	private String s1Lanmu = "";
	private String s1Lanmu2 = "";
	private String s1Lanmu3 = "";
	private String s2Lanmu = "";
	private String s2Lanmu2 = "";

	private String spmp4common = "";
	private String spmp4common2 = "";
	private String spmp4common3 = "";
	private String s2Lanmu3;
	private String spmp1Lanmu = "";

	private String spmp1Lanmu2 = "";

	private String spmp1Lanmu3 = "";

	private String spmp1Limit = "";

	private String spmp1Desc = "";

	private String spmp2Lanmu = "";

	private String spmp2Lanmu2 = "";

	private String spmp2Lanmu3 = "";

	private String spmp2Limit = "";

	private String spmp2Desc = "";

	private String spmp4Desc = "";

	private String spmp4Lanmu = "";

	private String spmp4Lanmu2 = "";

	private String spmp4Lanmu3 = "";
	private String spmp4Limit = "";

	private String spmp5Desc = "";

	private String spmp5Lanmu = "";

	private String spmp5Lanmu2 = "";

	private String spmp5Lanmu3 = "";

	private String spmp5Limit = "";

	private String guestEmail = ""; // 客户联系邮箱

	private String checkEmail = ""; // 邮箱转发都用这个，1.为安全考虑,不让别人拿到用户邮箱，2.也为AJAX考虑，进入进入AJAX直接取用户SESSION
	private String fileEmail = "";
	private String spmp3Lanmu = "";

	private String spmp3Lanmu2 = "";

	private String spmp3Lanmu3 = "";

	private String spmp3Limit = "";

	private String spmp3Desc = "";

	private String spmp6Lanmu = "";

	private String spmp6Lanmu2 = "";

	private String spmp6Lanmu3 = "";

	private String spmp6Limit = "";

	private String spmp6Desc = "";

	private String clientList = "";

	private Set siteOrderRadios;
	private String cssdefineself;
	private Set siteLinks;

	private Set siteJobs;

	private Set siteSpmp3s;

	private Set siteSpmp4s;

	private Set siteSpmp5s;

	private Set siteSpmp6s;

	private Set siteOrderChecks;

	private Set siteOrderInputs;

	private Set siteAbouts;
	private Set siteS1s;
	private Set siteS2s;

	public String getAddressht() {
		return addressht;
	}

	public void setAddressht(String addressht) {
		this.addressht = addressht;
	}

	public String getIndexht() {
		return indexht;
	}

	public void setIndexht(String indexht) {
		this.indexht = indexht;
	}

	public String getAboutht() {
		return aboutht;
	}

	public void setAboutht(String aboutht) {
		this.aboutht = aboutht;
	}

	public String getJobht() {
		return jobht;
	}

	public void setJobht(String jobht) {
		this.jobht = jobht;
	}

	public String getS1ht() {
		return s1ht;
	}

	public void setS1ht(String s1ht) {
		this.s1ht = s1ht;
	}

	public String getS2ht() {
		return s2ht;
	}

	public void setS2ht(String s2ht) {
		this.s2ht = s2ht;
	}

	public String getS1Lanmu() {
		return s1Lanmu;
	}

	public String getProductlinkstring() {
		return productlinkstring;
	}

	public void setProductlinkstring(String productlinkstring) {
		this.productlinkstring = productlinkstring;
	}

	public void setS1Lanmu(String lanmu) {
		s1Lanmu = lanmu;
	}

	public String getS1Lanmu2() {
		return s1Lanmu2;
	}

	public void setS1Lanmu2(String lanmu2) {
		s1Lanmu2 = lanmu2;
	}

	public String getS1Lanmu3() {
		return s1Lanmu3;
	}

	public void setS1Lanmu3(String lanmu3) {
		s1Lanmu3 = lanmu3;
	}

	public String getS2Lanmu() {
		return s2Lanmu;
	}

	public void setS2Lanmu(String lanmu) {
		s2Lanmu = lanmu;
	}

	public String getS2Lanmu2() {
		return s2Lanmu2;
	}

	public void setS2Lanmu2(String lanmu2) {
		s2Lanmu2 = lanmu2;
	}

	public String getS2Lanmu3() {
		return s2Lanmu3;
	}

	public void setS2Lanmu3(String lanmu3) {
		s2Lanmu3 = lanmu3;
	}

	public String getSpmp4common() {
		return spmp4common;
	}

	public void setSpmp4common(String spmp4common) {
		this.spmp4common = spmp4common;
	}

	public String getSpmp4common2() {
		return spmp4common2;
	}

	public void setSpmp4common2(String spmp4common2) {
		this.spmp4common2 = spmp4common2;
	}

	public String getSpmp4common3() {
		return spmp4common3;
	}

	public void setSpmp4common3(String spmp4common3) {
		this.spmp4common3 = spmp4common3;
	}

	public String getFileEmail() {
		return fileEmail;
	}

	public void setFileEmail(String fileEmail) {
		this.fileEmail = fileEmail;
	}

	public Set getSiteS2s() {
		return siteS2s;
	}

	public void setSiteS2s(Set siteS2s) {
		this.siteS2s = siteS2s;
	}

	private Set sitePresources;

	private Set siteEmailconfs;

	private Set siteSpmp1s;

	private Set siteOrders;

	private Set siteEnvelopabouts;

	private Set siteGuests;

	private Set siteSpmp2s;

	private Set siteSpmp7s;

	private String spmp7Lanmu;

	private String spmp7Lanmu2;

	private String spmp7Lanmu3;

	private String spmp7Limit;

	private String spmp7Desc;

	private Set siteSusers;

	private Set siteSworkers;

	private Set siteSpmp8s;
	private String spmp8Lanmu = "";

	private String spmp8Lanmu2 = "";

	private String spmp8Lanmu3 = "";

	private String spmp8Limit;

	private Set siteSpmp9s;

	/** default constructor */
	public SiteUser() {
	}

	public String getUserDataPath() {
		return SystemInit.getUserDatapath();
	}

	public String get_img_support_format() {
		return SystemInit.img_support_format;
	}

	public String get_video_support_format() {
		return SystemInit.video_support_format;
	}

	public String get_video_init_width() {
		return SystemInit.video_init_width;
	}

	public String get_video_init_height() {
		return SystemInit.video_init_height;
	}

	public String getWebPath(String absolutepath) {
		String ftppath = StringUtils.replace(absolutepath, "\\", "/");
		if (SystemInit.domainname.equals(""))
			return StringUtils.substringAfter(ftppath, "snp/webroot");
		// return "http://"+
		// SystemInit.domainname+StringUtils.substringAfter(SystemInit.getWebroot(),absolutepath
		// );
		return "http://" + SystemInit.domainname
				+ StringUtils.substringAfter(ftppath, "snp/webroot");
	}

	// 根据属性名得到字符串属性
	public String getValueByName(String propertiesName) {
		try {

			// log.debug("得到的属性="+BeanUtils.describe(this).get(propertiesName));

			return (String) BeanUtils.describe(this).get(propertiesName);

		} catch (Exception e) {
			log.info("取用户的字符串属性错误siteuser.getValueByName!", e);
			return "";
		}

	}

	// 根据属性名得到字符串属性,这样就算变成LSIT，可能对象也不能用
	public List getListBySetName(String propertiesName)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		ArrayList resultList = new ArrayList();
		return resultList;
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
	 * @hibernate.property column="usernotify" length="65535"
	 * 
	 */
	public String getUsernotify() {
		return this.usernotify;
	}

	public String getDomainname() {
		return SystemInit.domainname;
	}

	public void setUsernotify(String usernotify) {
		this.usernotify = usernotify;
	}

	/**
	 * @hibernate.property column="paymoney" length="30"
	 * 
	 */
	public String getPaymoney() {
		return this.paymoney;
	}

	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}

	/**
	 * @hibernate.property column="price" length="30"
	 * 
	 */
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @hibernate.property column="state" length="30"
	 * 
	 */
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @hibernate.property column="ordernum" length="11"
	 * 
	 */
	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	/**
	 * @hibernate.property column="comment" length="65535"
	 * 
	 */
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @hibernate.property column="password" length="50"
	 * 
	 */
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @hibernate.property column="username" length="50"
	 * 
	 */
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	 * @hibernate.property column="language" length="20"
	 * 
	 */
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @hibernate.property column="language2" length="20"
	 * 
	 */
	public String getLanguage2() {
		return this.language2;
	}

	public void setLanguage2(String language2) {
		this.language2 = language2;
	}

	/**
	 * @hibernate.property column="language3" length="20"
	 * 
	 */
	public String getLanguage3() {
		return this.language3;
	}

	public void setLanguage3(String language3) {
		this.language3 = language3;
	}

	/**
	 * @hibernate.property column="local" length="20"
	 * 
	 */
	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * @hibernate.property column="local2" length="20"
	 * 
	 */
	public String getLocal2() {
		return this.local2;
	}

	public void setLocal2(String local2) {
		this.local2 = local2;
	}

	/**
	 * @hibernate.property column="local3" length="20"
	 * 
	 */
	public String getLocal3() {
		return this.local3;
	}

	public void setLocal3(String local3) {
		this.local3 = local3;
	}

	/**
	 * @hibernate.property column="icpnumber" length="50"
	 * 
	 */

	/**
	 * @hibernate.property column="enddate" length="10"
	 * 
	 */
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	/**
	 * @hibernate.property column="begindate" length="10"
	 * 
	 */
	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	/**
	 * @hibernate.property column="envelop_style" length="20"
	 * 
	 */
	public String getEnvelopStyle() {
		return this.envelopStyle;
	}

	public void setEnvelopStyle(String envelopStyle) {
		this.envelopStyle = envelopStyle;
	}

	/**
	 * @hibernate.property column="index_style" length="20"
	 * 
	 */
	public String getIndexStyle() {
		return this.indexStyle;
	}

	public void setIndexStyle(String indexStyle) {
		this.indexStyle = indexStyle;
	}

	/**
	 * @hibernate.property column="index_product_rownum" length="20"
	 * 
	 */
	public String getIndexProductRownum() {
		return this.indexProductRownum;
	}

	public void setIndexProductRownum(String indexProductRownum) {
		this.indexProductRownum = indexProductRownum;
	}

	/**
	 * @hibernate.property column="index_product_colnum" length="20"
	 * 
	 */
	public String getIndexProductColnum() {
		return this.indexProductColnum;
	}

	public void setIndexProductColnum(String indexProductColnum) {
		this.indexProductColnum = indexProductColnum;
	}

	/**
	 * @hibernate.property column="index_lanmu" length="50"
	 * 
	 */
	public String getIndexLanmu() {
		return this.indexLanmu;
	}

	public void setIndexLanmu(String indexLanmu) {
		this.indexLanmu = indexLanmu;
	}

	/**
	 * @hibernate.property column="index_lanmu2" length="50"
	 * 
	 */
	public String getIndexLanmu2() {
		return this.indexLanmu2;
	}

	public void setIndexLanmu2(String indexLanmu2) {
		this.indexLanmu2 = indexLanmu2;
	}

	/**
	 * @hibernate.property column="index_lanmu3" length="50"
	 * 
	 */
	public String getIndexLanmu3() {
		return this.indexLanmu3;
	}

	public void setIndexLanmu3(String indexLanmu3) {
		this.indexLanmu3 = indexLanmu3;
	}

	/**
	 * @hibernate.property column="index_desc" length="50"
	 * 
	 */
	public String getIndexDesc() {
		return this.indexDesc;
	}

	public void setIndexDesc(String indexDesc) {
		this.indexDesc = indexDesc;
	}

	/**
	 * @hibernate.property column="ipsum_fun" length="20"
	 * 
	 */

	/**
	 * @hibernate.property column="job_lanmu" length="50"
	 * 
	 */
	public String getJobLanmu() {
		return this.jobLanmu;
	}

	public void setJobLanmu(String jobLanmu) {
		this.jobLanmu = jobLanmu;
	}

	/**
	 * @hibernate.property column="job_lanmu2" length="50"
	 * 
	 */
	public String getJobLanmu2() {
		return this.jobLanmu2;
	}

	public void setJobLanmu2(String jobLanmu2) {
		this.jobLanmu2 = jobLanmu2;
	}

	/**
	 * @hibernate.property column="job_lanmu3" length="50"
	 * 
	 */
	public String getJobLanmu3() {
		return this.jobLanmu3;
	}

	public void setJobLanmu3(String jobLanmu3) {
		this.jobLanmu3 = jobLanmu3;
	}

	/**
	 * @hibernate.property column="job_limit" length="50"
	 * 
	 */
	public String getJobLimit() {
		return this.jobLimit;
	}

	public void setJobLimit(String jobLimit) {
		this.jobLimit = jobLimit;
	}

	/**
	 * @hibernate.property column="job_desc" length="65535"
	 * 
	 */
	public String getJobDesc() {
		return this.jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	/**
	 * @hibernate.property column="guest_lanmu" length="50"
	 * 
	 */
	public String getGuestLanmu() {
		return this.guestLanmu;
	}

	public void setGuestLanmu(String guestLanmu) {
		this.guestLanmu = guestLanmu;
	}

	/**
	 * @hibernate.property column="guest_lanmu2" length="50"
	 * 
	 */
	public String getGuestLanmu2() {
		return this.guestLanmu2;
	}

	public void setGuestLanmu2(String guestLanmu2) {
		this.guestLanmu2 = guestLanmu2;
	}

	/**
	 * @hibernate.property column="guest_limit" length="50"
	 * 
	 */
	public String getGuestLimit() {
		return this.guestLimit;
	}

	public void setGuestLimit(String guestLimit) {
		this.guestLimit = guestLimit;
	}

	/**
	 * @hibernate.property column="guest_desc" length="65535"
	 * 
	 */
	public String getGuestDesc() {
		return this.guestDesc;
	}

	public void setGuestDesc(String guestDesc) {
		this.guestDesc = guestDesc;
	}

	/**
	 * @hibernate.property column="link_lanmu" length="50"
	 * 
	 */
	public String getLinkLanmu() {
		return this.linkLanmu;
	}

	public void setLinkLanmu(String linkLanmu) {
		this.linkLanmu = linkLanmu;
	}

	/**
	 * @hibernate.property column="link_lanmu2" length="50"
	 * 
	 */
	public String getLinkLanmu2() {
		return this.linkLanmu2;
	}

	public void setLinkLanmu2(String linkLanmu2) {
		this.linkLanmu2 = linkLanmu2;
	}

	/**
	 * @hibernate.property column="link_lanmu3" length="50"
	 * 
	 */
	public String getLinkLanmu3() {
		return this.linkLanmu3;
	}

	public void setLinkLanmu3(String linkLanmu3) {
		this.linkLanmu3 = linkLanmu3;
	}

	/**
	 * @hibernate.property column="link_limit" length="50"
	 * 
	 */
	public String getLinkLimit() {
		return this.linkLimit;
	}

	public void setLinkLimit(String linkLimit) {
		this.linkLimit = linkLimit;
	}

	/**
	 * @hibernate.property column="link_desc" length="65535"
	 * 
	 */
	public String getLinkDesc() {
		return this.linkDesc;
	}

	public void setLinkDesc(String linkDesc) {
		this.linkDesc = linkDesc;
	}

	/**
	 * @hibernate.property column="check_lanmu" length="50"
	 * 
	 */
	public String getCheckLanmu() {
		return this.checkLanmu;
	}

	public void setCheckLanmu(String checkLanmu) {
		this.checkLanmu = checkLanmu;
	}

	/**
	 * @hibernate.property column="check_lanmu2" length="50"
	 * 
	 */
	public String getCheckLanmu2() {
		return this.checkLanmu2;
	}

	public void setCheckLanmu2(String checkLanmu2) {
		this.checkLanmu2 = checkLanmu2;
	}

	/**
	 * @hibernate.property column="check_lanmu3" length="50"
	 * 
	 */
	public String getCheckLanmu3() {
		return this.checkLanmu3;
	}

	public void setCheckLanmu3(String checkLanmu3) {
		this.checkLanmu3 = checkLanmu3;
	}

	/**
	 * @hibernate.property column="checkLimit" length="50"
	 * 
	 */
	public String getCheckLimit() {
		return this.checkLimit;
	}

	public void setCheckLimit(String checkLimit) {
		this.checkLimit = checkLimit;
	}

	/**
	 * @hibernate.property column="check_desc" length="50"
	 * 
	 */
	public String getCheckDesc() {
		return this.checkDesc;
	}

	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}

	/**
	 * @hibernate.property column="checkdesign_lanmu" length="50"
	 * 
	 */
	public String getCheckdesignLanmu() {
		return this.checkdesignLanmu;
	}

	public void setCheckdesignLanmu(String checkdesignLanmu) {
		this.checkdesignLanmu = checkdesignLanmu;
	}

	/**
	 * @hibernate.property column="checkdesign_desc" length="50"
	 * 
	 */
	public String getCheckdesignDesc() {
		return this.checkdesignDesc;
	}

	public void setCheckdesignDesc(String checkdesignDesc) {
		this.checkdesignDesc = checkdesignDesc;
	}

	/**
	 * @hibernate.property column="spmp1_lanmu" length="50"
	 * 
	 */
	public String getSpmp1Lanmu() {
		return this.spmp1Lanmu;
	}

	public void setSpmp1Lanmu(String spmp1Lanmu) {
		this.spmp1Lanmu = spmp1Lanmu;
	}

	/**
	 * @hibernate.property column="spmp1_lanmu2" length="50"
	 * 
	 */
	public String getSpmp1Lanmu2() {
		return this.spmp1Lanmu2;
	}

	public void setSpmp1Lanmu2(String spmp1Lanmu2) {
		this.spmp1Lanmu2 = spmp1Lanmu2;
	}

	/**
	 * @hibernate.property column="spmp1_lanmu3" length="50"
	 * 
	 */
	public String getSpmp1Lanmu3() {
		return this.spmp1Lanmu3;
	}

	public void setSpmp1Lanmu3(String spmp1Lanmu3) {
		this.spmp1Lanmu3 = spmp1Lanmu3;
	}

	/**
	 * @hibernate.property column="spmp1_limit" length="50"
	 * 
	 */
	public String getSpmp1Limit() {
		return this.spmp1Limit;
	}

	public void setSpmp1Limit(String spmp1Limit) {
		this.spmp1Limit = spmp1Limit;
	}

	/**
	 * @hibernate.property column="spmp1_desc" length="65535"
	 * 
	 */
	public String getSpmp1Desc() {
		return this.spmp1Desc;
	}

	public void setSpmp1Desc(String spmp1Desc) {
		this.spmp1Desc = spmp1Desc;
	}

	/**
	 * @hibernate.property column="spmp2_lanmu" length="50"
	 * 
	 */
	public String getSpmp2Lanmu() {
		return this.spmp2Lanmu;
	}

	public void setSpmp2Lanmu(String spmp2Lanmu) {
		this.spmp2Lanmu = spmp2Lanmu;
	}

	/**
	 * @hibernate.property column="spmp2_lanmu2" length="50"
	 * 
	 */
	public String getSpmp2Lanmu2() {
		return this.spmp2Lanmu2;
	}

	public void setSpmp2Lanmu2(String spmp2Lanmu2) {
		this.spmp2Lanmu2 = spmp2Lanmu2;
	}

	/**
	 * @hibernate.property column="spmp2_lanmu3" length="50"
	 * 
	 */
	public String getSpmp2Lanmu3() {
		return this.spmp2Lanmu3;
	}

	public void setSpmp2Lanmu3(String spmp2Lanmu3) {
		this.spmp2Lanmu3 = spmp2Lanmu3;
	}

	/**
	 * @hibernate.property column="spmp2_limit" length="50"
	 * 
	 */
	public String getSpmp2Limit() {
		return this.spmp2Limit;
	}

	public void setSpmp2Limit(String spmp2Limit) {
		this.spmp2Limit = spmp2Limit;
	}

	/**
	 * @hibernate.property column="spmp2_desc" length="65535"
	 * 
	 */
	public String getSpmp2Desc() {
		return this.spmp2Desc;
	}

	public void setSpmp2Desc(String spmp2Desc) {
		this.spmp2Desc = spmp2Desc;
	}

	/**
	 * @hibernate.property column="spmp3_lanmu" length="50"
	 * 
	 */
	public String getSpmp3Lanmu() {
		return this.spmp3Lanmu;
	}

	public void setSpmp3Lanmu(String spmp3Lanmu) {
		this.spmp3Lanmu = spmp3Lanmu;
	}

	/**
	 * @hibernate.property column="spmp3_lanmu2" length="50"
	 * 
	 */
	public String getSpmp3Lanmu2() {
		return this.spmp3Lanmu2;
	}

	public void setSpmp3Lanmu2(String spmp3Lanmu2) {
		this.spmp3Lanmu2 = spmp3Lanmu2;
	}

	/**
	 * @hibernate.property column="spmp3_lanmu3" length="50"
	 * 
	 */
	public String getSpmp3Lanmu3() {
		return this.spmp3Lanmu3;
	}

	public void setSpmp3Lanmu3(String spmp3Lanmu3) {
		this.spmp3Lanmu3 = spmp3Lanmu3;
	}

	/**
	 * @hibernate.property column="spmp3_limit" length="50"
	 * 
	 */
	public String getSpmp3Limit() {
		return this.spmp3Limit;
	}

	public void setSpmp3Limit(String spmp3Limit) {
		this.spmp3Limit = spmp3Limit;
	}

	/**
	 * @hibernate.property column="spmp3_desc" length="65535"
	 * 
	 */
	public String getSpmp3Desc() {
		return this.spmp3Desc;
	}

	public void setSpmp3Desc(String spmp3Desc) {
		this.spmp3Desc = spmp3Desc;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteOrderRadio"
	 * 
	 */
	public Set getSiteOrderRadios() {
		return this.siteOrderRadios;
	}

	public void setSiteOrderRadios(Set siteOrderRadios) {
		this.siteOrderRadios = siteOrderRadios;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteLink"
	 * 
	 */
	public Set getSiteLinks() {
		return this.siteLinks;
	}

	public void setSiteLinks(Set siteLinks) {
		this.siteLinks = siteLinks;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteJob"
	 * 
	 */
	public Set getSiteJobs() {
		return this.siteJobs;
	}

	public void setSiteJobs(Set siteJobs) {
		this.siteJobs = siteJobs;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteSpmp3"
	 * 
	 */
	public Set getSiteSpmp3s() {
		return this.siteSpmp3s;
	}

	public void setSiteSpmp3s(Set siteSpmp3s) {
		this.siteSpmp3s = siteSpmp3s;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteOrderCheck"
	 * 
	 */
	public Set getSiteOrderChecks() {
		return this.siteOrderChecks;
	}

	public void setSiteOrderChecks(Set siteOrderChecks) {
		this.siteOrderChecks = siteOrderChecks;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteOrderInput"
	 * 
	 */
	public Set getSiteOrderInputs() {
		return this.siteOrderInputs;
	}

	public void setSiteOrderInputs(Set siteOrderInputs) {
		this.siteOrderInputs = siteOrderInputs;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteAbout"
	 * 
	 */
	public Set getSiteAbouts() {
		return this.siteAbouts;
	}

	public void setSiteAbouts(Set siteAbouts) {
		this.siteAbouts = siteAbouts;
	}

	public Set getSiteS1s() {
		return siteS1s;
	}

	public void setSiteS1s(Set siteS1s) {
		this.siteS1s = siteS1s;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteSpmp1"
	 * 
	 */
	public Set getSiteSpmp1s() {
		return this.siteSpmp1s;
	}

	// 根据属性名得到字符串属性
	public Set getListByName(String lanmu) {
		try {
			if (lanmu.equals("spmp1"))
				return getSiteSpmp1s();
			if (lanmu.equals("spmp2"))
				return getSiteSpmp2s();
			if (lanmu.equals("spmp3"))
				return getSiteSpmp3s();
			if (lanmu.equals("spmp4"))
				return getSiteSpmp4s();
			if (lanmu.equals("spmp5"))
				return getSiteSpmp5s();
			if (lanmu.equals("spmp6"))
				return getSiteSpmp6s();

			return null;
		} catch (Exception e) {
			log.info("栏目子集错误", e);
			return null;
		}

	}

	public void setSiteSpmp1s(Set siteSpmp1s) {
		this.siteSpmp1s = siteSpmp1s;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteOrder"
	 * 
	 */
	public Set getSiteOrders() {
		return this.siteOrders;
	}

	public void setSiteOrders(Set siteOrders) {
		this.siteOrders = siteOrders;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteEnvelopabout"
	 * 
	 */
	public Set getSiteEnvelopabouts() {
		return this.siteEnvelopabouts;
	}

	public void setSiteEnvelopabouts(Set siteEnvelopabouts) {
		this.siteEnvelopabouts = siteEnvelopabouts;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteGuest"
	 * 
	 */
	public Set getSiteGuests() {
		return this.siteGuests;
	}

	public void setSiteGuests(Set siteGuests) {
		this.siteGuests = siteGuests;
	}

	/**
	 * @hibernate.set lazy="true" inverse="true" cascade="none"
	 * @hibernate.collection-key column="userid"
	 * @hibernate.collection-one-to-many class="com.site.model.SiteSpmp2"
	 * 
	 */
	public Set getSiteSpmp2s() {
		return this.siteSpmp2s;
	}

	public void setSiteSpmp2s(Set siteSpmp2s) {
		this.siteSpmp2s = siteSpmp2s;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String getGuestLanmu3() {
		return guestLanmu3;
	}

	public void setGuestLanmu3(String guestLanmu3) {
		this.guestLanmu3 = guestLanmu3;
	}

	public String getTitle3() {
		return title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

	public String getSpmp4Desc() {
		return spmp4Desc;
	}

	public void setSpmp4Desc(String spmp4Desc) {
		this.spmp4Desc = spmp4Desc;
	}

	public String getSpmp4Lanmu() {
		return spmp4Lanmu;
	}

	public void setSpmp4Lanmu(String spmp4Lanmu) {
		this.spmp4Lanmu = spmp4Lanmu;
	}

	public String getSpmp4Lanmu2() {
		return spmp4Lanmu2;
	}

	public void setSpmp4Lanmu2(String spmp4Lanmu2) {
		this.spmp4Lanmu2 = spmp4Lanmu2;
	}

	public String getSpmp4Lanmu3() {
		return spmp4Lanmu3;
	}

	public void setSpmp4Lanmu3(String spmp4Lanmu3) {
		this.spmp4Lanmu3 = spmp4Lanmu3;
	}

	public String getSpmp4Limit() {
		return spmp4Limit;
	}

	public void setSpmp4Limit(String spmp4Limit) {
		this.spmp4Limit = spmp4Limit;
	}

	public Set getSiteSpmp4s() {
		return siteSpmp4s;
	}

	public void setSiteSpmp4s(Set siteSpmp4s) {
		this.siteSpmp4s = siteSpmp4s;
	}

	public String getCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(String checkEmail) {
		this.checkEmail = checkEmail;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public Set getSiteSpmp5s() {
		return siteSpmp5s;
	}

	public void setSiteSpmp5s(Set siteSpmp5s) {
		this.siteSpmp5s = siteSpmp5s;
	}

	public String getSpmp5Desc() {
		return spmp5Desc;
	}

	public void setSpmp5Desc(String spmp5Desc) {
		this.spmp5Desc = spmp5Desc;
	}

	public String getSpmp5Lanmu() {
		return spmp5Lanmu;
	}

	public void setSpmp5Lanmu(String spmp5Lanmu) {
		this.spmp5Lanmu = spmp5Lanmu;
	}

	public String getSpmp5Lanmu2() {
		return spmp5Lanmu2;
	}

	public void setSpmp5Lanmu2(String spmp5Lanmu2) {
		this.spmp5Lanmu2 = spmp5Lanmu2;
	}

	public String getSpmp5Lanmu3() {
		return spmp5Lanmu3;
	}

	public void setSpmp5Lanmu3(String spmp5Lanmu3) {
		this.spmp5Lanmu3 = spmp5Lanmu3;
	}

	public String getSpmp5Limit() {
		return spmp5Limit;
	}

	public void setSpmp5Limit(String spmp5Limit) {
		this.spmp5Limit = spmp5Limit;
	}

	public Set getSiteAddresss() {
		return siteAddresss;
	}

	public void setSiteAddresss(Set siteAddresss) {
		this.siteAddresss = siteAddresss;
	}

	public String getAddressLanmu() {
		return addressLanmu;
	}

	public void setAddressLanmu(String addressLanmu) {
		this.addressLanmu = addressLanmu;
	}

	public String getAddressLanmu2() {
		return addressLanmu2;
	}

	public void setAddressLanmu2(String addressLanmu2) {
		this.addressLanmu2 = addressLanmu2;
	}

	public String getAddressLanmu3() {
		return addressLanmu3;
	}

	public void setAddressLanmu3(String addressLanmu3) {
		this.addressLanmu3 = addressLanmu3;
	}

	public String getAddressLimit() {
		return addressLimit;
	}

	public void setAddressLimit(String addressLimit) {
		this.addressLimit = addressLimit;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getIndexLimit() {
		return indexLimit;
	}

	public void setIndexLimit(String indexLimit) {
		this.indexLimit = indexLimit;
	}

	public String getSearchDesc() {
		return searchDesc;
	}

	public void setSearchDesc(String searchDesc) {
		this.searchDesc = searchDesc;
	}

	public String getSearchKeys() {
		return searchKeys;
	}

	public void setSearchKeys(String searchKeys) {
		this.searchKeys = searchKeys;
	}

	public String getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public String getIndexContentStyle() {
		return indexContentStyle;
	}

	public void setIndexContentStyle(String indexContentStyle) {
		this.indexContentStyle = indexContentStyle;
	}

	public String getLinkDetailStyle() {
		return linkDetailStyle;
	}

	public void setLinkDetailStyle(String linkDetailStyle) {
		this.linkDetailStyle = linkDetailStyle;
	}

	public String getSpmp4ItemDetailStyle() {
		return spmp4ItemDetailStyle;
	}

	public void setSpmp4ItemDetailStyle(String spmp4ItemDetailStyle) {
		this.spmp4ItemDetailStyle = spmp4ItemDetailStyle;
	}

	public Set getSiteSpmp6s() {
		return siteSpmp6s;
	}

	public void setSiteSpmp6s(Set siteSpmp6s) {
		this.siteSpmp6s = siteSpmp6s;
	}

	public String getSpmp6Desc() {
		return spmp6Desc;
	}

	public void setSpmp6Desc(String spmp6Desc) {
		this.spmp6Desc = spmp6Desc;
	}

	public String getSpmp6Lanmu() {
		return spmp6Lanmu;
	}

	public void setSpmp6Lanmu(String spmp6Lanmu) {
		this.spmp6Lanmu = spmp6Lanmu;
	}

	public String getSpmp6Lanmu2() {
		return spmp6Lanmu2;
	}

	public void setSpmp6Lanmu2(String spmp6Lanmu2) {
		this.spmp6Lanmu2 = spmp6Lanmu2;
	}

	public String getSpmp6Lanmu3() {
		return spmp6Lanmu3;
	}

	public void setSpmp6Lanmu3(String spmp6Lanmu3) {
		this.spmp6Lanmu3 = spmp6Lanmu3;
	}

	public String getSpmp6Limit() {
		return spmp6Limit;
	}

	public void setSpmp6Limit(String spmp6Limit) {
		this.spmp6Limit = spmp6Limit;
	}

	public String getClientList() {
		return clientList;
	}

	public void setClientList(String clientList) {
		this.clientList = clientList;
	}

	public Set getSiteSusers() {
		return siteSusers;
	}

	public void setSiteSusers(Set siteSusers) {
		this.siteSusers = siteSusers;
	}

	public Set getSiteSpmp7s() {
		return siteSpmp7s;
	}

	public void setSiteSpmp7s(Set siteSpmp7s) {
		this.siteSpmp7s = siteSpmp7s;
	}

	public String getSpmp7Desc() {
		return spmp7Desc;
	}

	public void setSpmp7Desc(String spmp7Desc) {
		this.spmp7Desc = spmp7Desc;
	}

	public String getSpmp7Lanmu() {
		return spmp7Lanmu;
	}

	public void setSpmp7Lanmu(String spmp7Lanmu) {
		this.spmp7Lanmu = spmp7Lanmu;
	}

	public String getSpmp7Lanmu2() {
		return spmp7Lanmu2;
	}

	public void setSpmp7Lanmu2(String spmp7Lanmu2) {
		this.spmp7Lanmu2 = spmp7Lanmu2;
	}

	public String getSpmp7Lanmu3() {
		return spmp7Lanmu3;
	}

	public void setSpmp7Lanmu3(String spmp7Lanmu3) {
		this.spmp7Lanmu3 = spmp7Lanmu3;
	}

	public String getSpmp7Limit() {
		return spmp7Limit;
	}

	public void setSpmp7Limit(String spmp7Limit) {
		this.spmp7Limit = spmp7Limit;
	}

	public Set getSitePresources() {
		return sitePresources;
	}

	public void setSitePresources(Set sitePresources) {
		this.sitePresources = sitePresources;
	}

	public Set getSiteSworkers() {
		return siteSworkers;
	}

	public void setSiteSworkers(Set siteSworkers) {
		this.siteSworkers = siteSworkers;
	}

	public Set getSiteEmailconfs() {
		return siteEmailconfs;
	}

	public void setSiteEmailconfs(Set siteEmailconfs) {
		this.siteEmailconfs = siteEmailconfs;
	}

	public String getShopcartflag() {
		return shopcartflag;
	}

	public void setShopcartflag(String shopcartflag) {
		this.shopcartflag = shopcartflag;
	}

	public String getBottom() {
		return bottom;
	}

	public void setBottom(String bottom) {
		this.bottom = bottom;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public Set getSiteSpmp8s() {
		return siteSpmp8s;
	}

	public ArrayList getVideoList() {
		ArrayList videolist = new ArrayList();
		for (Iterator iter = getSiteSpmp8s().iterator(); iter.hasNext();) {
			SiteSpmp8 spmp8 = (SiteSpmp8) iter.next();
			if (spmp8.checkexists())
				videolist.add(spmp8);
		}

		/**
		 * for (Iterator iter = getSiteSpmp8s().iterator(); iter.hasNext();) {
		 * SiteSpmp8 spmp8 = (SiteSpmp8) iter.next(); for (Iterator iterator =
		 * spmp8.getSiteSpmp8Items().iterator(); iterator .hasNext();) {
		 * SiteSpmp8Item siteSpmp8Item = (SiteSpmp8Item) iterator.next();
		 * if(siteSpmp8Item.checkexists())videolist.add(siteSpmp8Item);
		 * //FLV文件存在才可以，不然耗尽IE } }
		 */
		return videolist;
	}

	public ArrayList getImgList() {
		ArrayList imglist = new ArrayList();

		for (Iterator iter = getSiteSpmp4s().iterator(); iter.hasNext();) {
			SiteSpmp4 spmp4 = (SiteSpmp4) iter.next();
			for (Iterator iterator = spmp4.getSiteSpmp4Items().iterator(); iterator
					.hasNext();) {
				SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) iterator.next();
				imglist.add(siteSpmp4Item);
			}
		}

		return imglist;
	}

	public boolean checkVideofile(String Filepath) {
		return new File(SystemInit.getSiteHome() + Filepath + ".flv").exists();
	}

	public static String getImg_spmp4_sm_width() {
		return SystemInit.img_spmp4_sm_width;
	}

	public static String getImg_spmp4_sm_height() {
		return SystemInit.img_spmp4_sm_height;
	}

	/*
	 * public static String getImg_spmp4_width() { return
	 * SystemInit.img_spmp4_width; }
	 * 
	 * public static String getImg_spmp4_height() { return
	 * SystemInit.img_spmp4_height; } public static String
	 * getImg_spmp4_sm_width() { return SystemInit.img_spmp4_sm_width; } public
	 * static String getImg_spmp4_sm_height() { return
	 * SystemInit.img_spmp4_sm_height; } public static String
	 * getImg_spmp8_width() { return SystemInit.img_spmp8_width; } public static
	 * String getImg_spmp8_height() { return SystemInit.img_spmp8_height; }
	 */

	public ArrayList getOtherUserlist() {
		ArrayList otheruserlist = new ArrayList();
		if ((otherusername != null) && (!otherusername.equalsIgnoreCase(""))) {
			String strUserList = otherusername;
			String[] usernamearray = strUserList.split(",");
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			if (usernamearray.length > 0) {
				for (int i = 0; i < usernamearray.length; i++) {
					if (!username.equals(usernamearray[i])) {
						String sql = "select o from com.snp.site.model.SiteUser o where o.username='"
								+ usernamearray[i] + "'";
						List ls = adao.find(sql);
						for (Iterator iter = ls.iterator(); iter.hasNext();) {
							SiteUser element = (SiteUser) iter.next();
							otheruserlist.add(element);
						}

					}
				}
			}

		}
		return otheruserlist;
	}

	public String getSpmpFirstIDByLanmuName(String lanmu) {
		try {
			if (lanmu.equals("spmp1"))
				for (Iterator iterator = getSiteSpmp1s().iterator(); iterator
						.hasNext();) {
					SiteSpmp1 siteSpmp = (SiteSpmp1) iterator.next();
					return "_" + siteSpmp.getId().toString();
				}
			if (lanmu.equals("spmp2"))
				for (Iterator iterator = getSiteSpmp2s().iterator(); iterator
						.hasNext();) {
					SiteSpmp2 siteSpmp = (SiteSpmp2) iterator.next();
					return "_" + siteSpmp.getId().toString();
				}
			if (lanmu.equals("spmp3"))
				for (Iterator iterator = getSiteSpmp3s().iterator(); iterator
						.hasNext();) {
					SiteSpmp3 siteSpmp = (SiteSpmp3) iterator.next();
					return "_" + siteSpmp.getId().toString();
				}
			if (lanmu.equals("spmp4"))
				for (Iterator iterator = getSiteSpmp4s().iterator(); iterator
						.hasNext();) {
					SiteSpmp4 siteSpmp = (SiteSpmp4) iterator.next();
					return "_" + siteSpmp.getId().toString();
				}
			if (lanmu.equals("spmp6"))
				for (Iterator iterator = getSiteSpmp6s().iterator(); iterator
						.hasNext();) {
					SiteSpmp6 siteSpmp = (SiteSpmp6) iterator.next();
					return "_" + siteSpmp.getId().toString();
				}
			if (lanmu.equals("spmp9"))
				for (Iterator iterator = getSiteSpmp9s().iterator(); iterator
						.hasNext();) {
					SiteSpmp9 siteSpmp = (SiteSpmp9) iterator.next();
					return "_" + siteSpmp.getId().toString();
				}
			return "";
		} catch (Exception e) {
			log.info("取第一个数错误", e);
			return null;
		}

	}

	public ArrayList getMoveList() {
		ArrayList productLinklist = new ArrayList();

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

	public void setSiteSpmp8s(Set siteSpmp8s) {
		this.siteSpmp8s = siteSpmp8s;
	}

	public String getSpmp8Lanmu() {
		return spmp8Lanmu;
	}

	public void setSpmp8Lanmu(String spmp8Lanmu) {
		this.spmp8Lanmu = spmp8Lanmu;
	}

	public String getSpmp8Lanmu2() {
		return spmp8Lanmu2;
	}

	public void setSpmp8Lanmu2(String spmp8Lanmu2) {
		this.spmp8Lanmu2 = spmp8Lanmu2;
	}

	public String getSpmp8Lanmu3() {
		return spmp8Lanmu3;
	}

	public void setSpmp8Lanmu3(String spmp8Lanmu3) {
		this.spmp8Lanmu3 = spmp8Lanmu3;
	}

	public String getSpmp8Limit() {
		return spmp8Limit;
	}

	public void setSpmp8Limit(String spmp8Limit) {
		this.spmp8Limit = spmp8Limit;
	}

	public String getIndexDesc2() {
		return indexDesc2;
	}

	public void setIndexDesc2(String indexDesc2) {
		this.indexDesc2 = indexDesc2;
	}

	public String getIndexDesc3() {
		return indexDesc3;
	}

	public void setIndexDesc3(String indexDesc3) {
		this.indexDesc3 = indexDesc3;
	}

	public String getDirStyle() {
		return dirStyle;
	}

	public void setDirStyle(String dirStyle) {
		this.dirStyle = dirStyle;
	}

	public String getMarquee() {
		return marquee;
	}

	public void setMarquee(String marquee) {
		this.marquee = marquee;
	}

	public String getMarquee2() {
		return marquee2;
	}

	public void setMarquee2(String marquee2) {
		this.marquee2 = marquee2;
	}

	public String getMarquee3() {
		return marquee3;
	}

	public void setMarquee3(String marquee3) {
		this.marquee3 = marquee3;
	}

	public String getUrlkey() {
		return urlkey;
	}

	public void setUrlkey(String urlkey) {
		this.urlkey = urlkey;
	}

	public Set getSiteSpmp9s() {
		return siteSpmp9s;
	}

	public void setSiteSpmp9s(Set siteSpmp9s) {
		this.siteSpmp9s = siteSpmp9s;
	}

	public String getOtherusername() {
		return otherusername;
	}

	public void setOtherusername(String otherusername) {
		this.otherusername = otherusername;
	}

	public String getCssdefineself() {
		return cssdefineself;
	}

	public void setCssdefineself(String cssdefineself) {
		this.cssdefineself = cssdefineself;
	}

	public void bat_update_img() {

	}

	public String getContentleft() {
		return contentleft;
	}

	public void setContentleft(String contentleft) {
		this.contentleft = contentleft;
	}

	public String getContentright() {
		return contentright;
	}

	public void setContentright(String contentright) {
		this.contentright = contentright;
	}

}
