/*
 * Universial Enterprise Authenticate And Authority Center
 * 
 * Copyright(c) 2005 SunRise Inc. Ricsson Group All rights reserved.
 * 
 * @created: 2005-06-21 @author: Andy
 */

package com.snp.site.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.interceptor.FileUploadInterceptor;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteUser;

public class FileInterceptor extends FileUploadInterceptor implements
		Interceptor {
	private final static Log log = LogFactory.getLog(FileInterceptor.class);

	public final static String UNAUTHENTICATED_USER_CODE = "unauthenticated.user";

	public void destroy() {
	}

	public void init() {
	}

	private SiteUser getSiteUser() {
		Map sessionMap = ActionContext.getContext().getSession();
		try {
			SiteUser siteUser = (SiteUser) sessionMap
					.get(SystemInit.clientloginflag);
			return siteUser;
		} catch (Exception e) {
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony
	 * .xwork.ActionInvocation)
	 */
	public String intercept(ActionInvocation ai) throws Exception {
		log.debug("intercepting!");
		super.intercept(ai);
		if (getSiteUser() != null) {
			String s = ai.invoke();
			return s;
		} else {
			// throw new Exception(); 还是最后一个运行
			return "no";
		}

		/*
		 * if (getUser() != null) { String s = ai.invoke(); return s; } else {
		 * return UNAUTHENTICATED_USER_CODE; }
		 */
	}

}