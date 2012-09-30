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
import com.snp.site.model.SiteSpmp8Item;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/**
 * ������ɾ���ļ�
 */
public class DeleteSpmp8Item implements IbusinessAction {
	private static Log log = LogFactory.getLog(DeleteSpmp8Item.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			String id = WebAppContextUtils.getpara("fileid");
			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			SiteSpmp8Item siteSpmp8Item = (SiteSpmp8Item) advanceDao.loadById(
					"SiteSpmp8Item", new Long(id));
			try {
				File temp = new File(SystemInit.getSiteHome()
						+ siteSpmp8Item.getFilepath() + ".flv");
				temp.delete();
				temp = new File(SystemInit.getSiteHome()
						+ siteSpmp8Item.getFilepath() + ".gif");
				temp.delete();
				advanceDao.removeObject(siteSpmp8Item);
			} catch (Exception e) {
				log.error(siteSpmp8Item.getFilepath() + ":delete fail!", e);
			}

			context.addResults("info", "success!");
		} catch (Exception e) {
			OperationException opEx = new OperationException(
					"delete spmp8 error!", e);
			throw opEx;
		}

	}

}
