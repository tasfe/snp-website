/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.snp.site.model.SiteSpmp4;
import com.snp.site.model.SiteSpmp4Sub;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/**
 * 首先取得所有产品ID组成字符串，保存好，跳转到
 */
public class UpdateProductLink implements IbusinessAction {
	private static Log log = LogFactory.getLog(UpdateProductLink.class);

	// private IOperationContext operationContext;

	public void excute(IOperationContext context) throws OperationException {
		String[] value = (String[]) ActionContext.getContext().getParameters()
				.get("productlink");
		String strValue = "";
		if (value == null) {
			strValue = "";
		} else {
			for (int j = 0; j < value.length; j++) {
				strValue = strValue + value[j] + ",";
			}
		}
		AdvanceDAO advanceDao = (AdvanceDAO) context.getApplicationContext()
				.getBean("advanceDAO");
		if (WebAppContextUtils.getpara("flag").equals("sub")) {
			String id = WebAppContextUtils.getpara("spmp4subid");

			SiteSpmp4Sub siteSpmp4sub = (SiteSpmp4Sub) advanceDao.loadById(
					"SiteSpmp4Sub", new Long(id));
			siteSpmp4sub.setProductlinkstring(strValue);
			advanceDao.updateObject(siteSpmp4sub);
		}
		if (WebAppContextUtils.getpara("flag").equals("home")) {
			String id = WebAppContextUtils.getpara("DM.Instance.SiteUser.id");

			SiteUser siteUser = (SiteUser) advanceDao.loadById("SiteUser",
					new Long(id));
			siteUser.setProductlinkstring(strValue);
			advanceDao.updateObject(siteUser);
		}

		if (WebAppContextUtils.getpara("flag").equals("spmp4")) {
			String id = WebAppContextUtils.getpara("spmp4id");

			SiteSpmp4 siteSpmp4 = (SiteSpmp4) advanceDao.loadById("SiteSpmp4",
					new Long(id));
			siteSpmp4.setProductlinkstring(strValue);
			advanceDao.updateObject(siteSpmp4);
		}

	}
}