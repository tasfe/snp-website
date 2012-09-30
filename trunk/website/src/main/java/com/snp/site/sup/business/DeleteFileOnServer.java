/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.io.File;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class DeleteFileOnServer implements IbusinessAction {
	private static Log log = LogFactory.getLog(DeleteFileOnServer.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			String savaFilePoName = WebAppContextUtils.getpara("fileponame");
			String id = WebAppContextUtils.getpara("fileid");
			String filepath = "";
			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			Object obj = context.getApplicationContext()
					.getBean(savaFilePoName);
			advanceDao.removeObject(obj.getClass(), new Long(id));
			try {
				filepath = SystemInit.getSiteHome()
						+ (String) BeanUtils.describe(obj).get("filepath");
				log.debug("delete file path=" + filepath);
				File temp = new File(filepath);
				temp.delete();
			} catch (Exception e) {
				log.error("删除数据对象错误", e);
			}
			context.addResults("info", "success!");
		} catch (Exception e) {
			OperationException opEx = new OperationException("删除服务器上记录错误", e);
			throw opEx;
		}

	}

}
