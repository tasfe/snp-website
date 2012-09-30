/**
 * Universial Enterprise Authenticate And Authority Center
 * 
 * Copyright(c) 2005 SunRise Inc. Ricsson Group All rights reserved.
 * 
 * @created: 2005-4-28
 * @author: Andy
 */

package com.snp.site.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.snp.common.WebworkCookie;
import com.snp.site.config.LanmuConfig;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteUser;
import com.snp.site.sup.dm.UploadSiteData;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.core.common.util.WebAppContextUtils;

public class LoginAction extends ActionSupport {
	private final static Log log = LogFactory.getLog(LoginAction.class);

	private Map results = new HashMap();

	private List systemErrors = new ArrayList(3);

	private String account;

	private String passwd;

	private LanmuConfig lanmuObject;

	public String sso() {

		String username = WebAppContextUtils.getpara("account");
		String password = WebAppContextUtils.getpara("passwd");
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		List user_list = adao.find("from SiteUser user where user.username='"
				+ username + "'" + "and user.password='" + password + "'");
		log.debug("用户个数：" + user_list.size());

		if (user_list.size() == 1) {
			results.put("sso", "true");
		} else {
			results.put("sso", "false");
		}
		return "sso";

	}

	public String execute() {
		// 1.先验证图形码
		String username = WebAppContextUtils.getpara("account");
		String password = WebAppContextUtils.getpara("passwd");
		String filename = "conf/newuser/test.zip";

		results.put("username", username);

		Map sessionMap = ActionContext.getContext().getSession();

		try {
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			List user_list = adao.find("from SiteUser ");
			if (user_list.size() == 0) {
				SiteUser siteuser = new SiteUser();
				siteuser.setUsername("admin");
				siteuser.setPassword("123");
				adao.saveObject(siteuser);
				File fileOut = new File(filename);
				UploadSiteData.ImportData(adao, fileOut, siteuser, "createnew");
				results.put("info", "请用admin,123登陆");
				return "error";
			}
			String sql = "select o from com.snp.site.model.SiteUser o where o.username='"
					+ username + "'";
			List ls = adao.find(sql);
			if (ls.size() == 0) {
				results.put("info", "此用户不存在");
				return "error";
			}
			SiteUser siteuser = (SiteUser) ls.get(0);
			WebworkCookie.invalidCookie(SystemInit.cookieuserid);
			WebworkCookie.addCookie(SystemInit.cookieuserid, siteuser.getId()
					.toString(), "/editor/dialog");
			// 2.验证密码
			if (password.equals(siteuser.getPassword())) {
				sessionMap.put(SystemInit.clientloginflag, siteuser);
				try {
					FileUtils.forceMkdir(new File(SystemInit.getSiteHome()));
					FileUtils.forceMkdir(new File(SystemInit.getSiteHome()
							+ username));
					String userLunmuXmlPath = SystemInit.getSiteHome()
							+ username + "/" + SystemInit.LanmuConfFileName;
					try {
						lanmuObject = SystemInit
								.getLanmuObjectFromXml(userLunmuXmlPath);
					} catch (Exception e) {
						File fileOut = new File(filename);
						UploadSiteData.ImportData(adao, fileOut, siteuser,
								"createnew");
						lanmuObject = SystemInit
								.getLanmuObjectFromXml(userLunmuXmlPath);
						log.debug(e);
					}
					sessionMap.put("lanmuobject", lanmuObject);
				} catch (Exception e) {
					log.error(e);
					return "systemerror";
				}
				log.info(SystemInit.get_info_title() + "管理员"
						+ siteuser.getUsername() + ":成功登录管理后台");
				return SUCCESS;
			} else { // 密码不对
				results.put("info", "密码输入错误");
				log.info(SystemInit.get_info_title() + "管理员"
						+ siteuser.getUsername() + ":密码输入错误" + password);
				return "error";
			}
		} catch (Exception e) {
			log.error("login error!", e);
			results.put("info", "system_error");
			return "error";
		}
	}

	/**
	 * @return Returns the account.
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            The account to set.
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return Returns the passwd.
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            The passwd to set.
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Map getResults() {
		return results;
	}

	public void setResults(Map results) {
		this.results = results;
	}

	public List getSystemErrors() {
		return systemErrors;
	}

	public void setSystemErrors(List systemErrors) {
		this.systemErrors = systemErrors;
	}
}