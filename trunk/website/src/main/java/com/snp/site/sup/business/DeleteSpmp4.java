/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteSpmp4;
import com.snp.site.model.SiteSpmp4Item;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/**
 * ������ɾ���ļ�
 */
public class DeleteSpmp4 implements IbusinessAction {
	private static Log log = LogFactory.getLog(DeleteSpmp4.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			// 1.
			String id = WebAppContextUtils.getpara("fileid");

			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			SiteSpmp4 siteSpmp4 = (SiteSpmp4) advanceDao.loadById("SiteSpmp4",
					new Long(id));
			for (Iterator iter2 = siteSpmp4.getSiteSpmp4Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) iter2.next();
				try {
					File temp = new File(SystemInit.getSiteHome()
							+ siteSpmp4Item.getFilepath());
					temp.delete();

					temp = new File(SystemInit.getSiteHome()
							+ StringUtils.replace(siteSpmp4Item.getFilepath(),
									".", "_sm."));
					temp.delete();
					advanceDao.removeObject(siteSpmp4Item);
				} catch (Exception e) {
					log.error(siteSpmp4Item.getFilepath() + ":delete fail!", e);
				}
			}
			advanceDao.removeObject(siteSpmp4);

			context.addResults("info", "success!");
		} catch (Exception e) {
			OperationException opEx = new OperationException(
					"delete spmp4 error!", e);
			throw opEx;
		}

	}

}
