/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteSpmp1;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class DeleteUserData implements IbusinessAction {
	private static Log log = LogFactory.getLog(DeleteUserData.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			SiteUser currentuser = (SiteUser) ActionContext.getContext()
					.getSession().get(SystemInit.clientloginflag);
			String id = WebAppContextUtils.getpara("fileid");

			AdvanceDAO adao = (AdvanceDAO) context.getApplicationContext()
					.getBean("advanceDAO");
			Set spmp1 = currentuser.getSiteSpmp1s();
			log.debug("个数 " + spmp1.size());
			for (Iterator iter = spmp1.iterator(); iter.hasNext();) {

				SiteSpmp1 objectparent = (SiteSpmp1) iter.next();
				/*
				 * Set spmpitemset= objectparent.getSiteSpmp1Items(); for
				 * (Iterator iter2 =spmpitemset.iterator(); iter2.hasNext();) {
				 * SiteSpmp1Item siteSpmp1Item = (SiteSpmp1Item) iter2.next();
				 * spmpitemset.remove(siteSpmp1Item);
				 * adao.removeObject(siteSpmp1Item); }
				 */
				spmp1.remove(objectparent);
				adao.removeObject(objectparent);
			}

		} catch (Exception e) {
			OperationException opEx = new OperationException(
					"delete spmp error!", e);
			throw opEx;
		}

	}

}
