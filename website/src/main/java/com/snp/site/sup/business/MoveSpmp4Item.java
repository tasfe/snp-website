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
import com.snp.site.model.SiteSpmp4Item;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class MoveSpmp4Item implements IbusinessAction {
	private static Log log = LogFactory.getLog(MoveSpmp4Item.class);

	// private IOperationContext operationContext;

	public void excute(IOperationContext context) throws OperationException {
		AdvanceDAO advanceDao = (AdvanceDAO) context.getApplicationContext()
				.getBean("advanceDAO");
		String[] moveid = (String[]) ActionContext.getContext().getParameters()
				.get("moveid");
		String spmp4id = WebAppContextUtils.getpara("spmp4id");
		SiteSpmp4 steSpmp4 = (SiteSpmp4) advanceDao.loadById("SiteSpmp4",
				new Long(spmp4id));
		if (moveid != null) {
			for (int j = 0; j < moveid.length; j++) {
				SiteSpmp4Item siteSpmp4item = (SiteSpmp4Item) advanceDao
						.loadById("SiteSpmp4Item", new Long(moveid[j]));
				siteSpmp4item.setSiteSpmp4(steSpmp4);
				advanceDao.updateObject(siteSpmp4item);

			}
		}

		/*
		 * AdvanceDAO advanceDao = (AdvanceDAO) context
		 * .getApplicationContext().getBean("advanceDAO"); if
		 * (WebAppContextUtils.getpara("flag").equals("sub")) { String id =
		 * WebAppContextUtils.getpara("spmp4subid");
		 * 
		 * SiteSpmp4Sub siteSpmp4sub = (SiteSpmp4Sub) advanceDao.loadById(
		 * "SiteSpmp4Sub", new Long(id));
		 * siteSpmp4sub.setProductlinkstring(strValue);
		 * advanceDao.updateObject(siteSpmp4sub); } else { String id =
		 * WebAppContextUtils.getpara("spmp4id");
		 * 
		 * SiteSpmp4 siteSpmp4 = (SiteSpmp4) advanceDao.loadById("SiteSpmp4",
		 * new Long(id)); siteSpmp4.setProductlinkstring(strValue);
		 * advanceDao.updateObject(siteSpmp4); }
		 */
	}
}