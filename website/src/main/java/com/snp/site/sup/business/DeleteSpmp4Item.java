/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteSpmp4Item;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class DeleteSpmp4Item implements IbusinessAction {
	private static Log log = LogFactory.getLog(DeleteSpmp4Item.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			String id = WebAppContextUtils.getpara("fileid");
			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) advanceDao.loadById(
					"SiteSpmp4Item", new Long(id));
			try {
				File temp = new File(SystemInit.getSiteHome()
						+ siteSpmp4Item.getFilepath());
				temp.delete();
				temp = new File(SystemInit.getSiteHome()
						+ StringUtils.replace(siteSpmp4Item.getFilepath(), ".",
								"_sm."));
				temp.delete();
				advanceDao.removeObject(siteSpmp4Item);
			} catch (Exception e) {
				log.error(siteSpmp4Item.getFilepath() + ":delete fail!", e);
			}

			context.addResults("info", "success!");
		} catch (Exception e) {
			OperationException opEx = new OperationException(
					"delete spmp4 error!", e);
			throw opEx;
		}

	}

}
