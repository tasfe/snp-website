/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteSpmp8;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class DeleteSpmp8 implements IbusinessAction {
	private static Log log = LogFactory.getLog(DeleteSpmp8.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			// 1.
			String id = WebAppContextUtils.getpara("fileid");

			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			SiteSpmp8 siteSpmp8 = (SiteSpmp8) advanceDao.loadById("SiteSpmp8",
					new Long(id));
			File temp = new File(SystemInit.getSiteHome()
					+ siteSpmp8.getFilepath() + ".flv");
			temp.delete();
			temp = new File(SystemInit.getSiteHome() + siteSpmp8.getFilepath()
					+ ".gif");
			temp.delete();
			advanceDao.removeObject(siteSpmp8);

			context.addResults("info", "success!");
		} catch (Exception e) {
			OperationException opEx = new OperationException(
					"delete spmp8 error!", e);
			throw opEx;
		}

	}

}
