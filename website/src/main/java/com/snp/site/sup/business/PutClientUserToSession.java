/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class PutClientUserToSession implements IbusinessAction {
	private static Log log = LogFactory.getLog(PutClientUserToSession.class);

	public void excute(IOperationContext context) throws OperationException {
		try {

			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			String userid = WebAppContextUtils.getpara("userid");
			SiteUser siteUser = (SiteUser) advanceDao.loadById("SiteUser",
					Long.parseLong(userid));
			Map sessionMap = ActionContext.getContext().getSession();
			sessionMap.put(SystemInit.clientloginflag, siteUser);
		} catch (Exception e) {
			log.error("put user to session", e);
			OperationException opEx = new OperationException("用户session临时放入错误",
					e);
			throw opEx;
		}
	}
}
