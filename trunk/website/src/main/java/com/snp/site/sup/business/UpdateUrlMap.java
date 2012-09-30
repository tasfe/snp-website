/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.config.UrlConfig;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/*求得所有的用户列表，然后放入SYSTEMINIT，然后重新生成配置文件*/
public class UpdateUrlMap implements IbusinessAction {
	private static Log log = LogFactory.getLog(UpdateUrlMap.class);

	// private IOperationContext operationContext;

	public void excute(IOperationContext context) throws OperationException {
		try {
			// this.operationContext = context;
			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			List siteUserList = advanceDao.findByNamedQuery("findalluser");
			for (Iterator iter = siteUserList.iterator(); iter.hasNext();) {
				SiteUser siteUser = (SiteUser) iter.next();
				if (siteUser.getUrlkey() != null) {
					if (siteUser.getUrlkey().length() != 0) {
						SystemInit.urlmap.put(siteUser.getUsername(),
								siteUser.getUrlkey());
					}
				}

			}
			// 重新生成URL文件
			XMLEncoder e;
			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(
					SystemInit.getUrlmapConfigpath())));
			UrlConfig urlConfig = new UrlConfig();
			urlConfig.setUrlmap(SystemInit.urlmap);
			e.writeObject(urlConfig);
			e.close();
			// SystemInit.urlmap.put(advanceDao, siteUserList)
		} catch (Exception e) {
			log.error("更新URLMAP对象错误", e);
			OperationException opEx = new OperationException("更新URLMAP对象错误", e);
			throw opEx;
		}
	}
}
