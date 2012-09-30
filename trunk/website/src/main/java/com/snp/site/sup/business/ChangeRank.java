/*
ChangeRank.java * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.util.BeanUtils;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/*求得所有的用户列表，然后放入SYSTEMINIT，然后重新生成配置文件*/
public class ChangeRank implements IbusinessAction {
	private static Log log = LogFactory.getLog(DownSitedata.class);

	public void excute(IOperationContext context) throws OperationException {
		try {

			AdvanceDAO adao = (AdvanceDAO) context.getApplicationContext()
					.getBean("advanceDAO");
			String id_from = WebAppContextUtils.getpara("id_from");
			String id_to = WebAppContextUtils.getpara("id_to");
			String beanname = WebAppContextUtils.getpara("beanname");
			Object object_from = adao.loadById(beanname,
					Long.parseLong(id_from));
			Object object_to = adao.loadById(beanname, Long.parseLong(id_to));
			String oderid_from = "";
			String oderid_to = "";
			try {
				// 如果是旧版本的话，导入的数据sortstr是空的，就不能toString()
				oderid_from = BeanUtils.getValue(object_from, "sortstr")
						.toString();
			} catch (Exception e) {
				oderid_from = BeanUtils.getValue(object_from, "id").toString();
			}

			try {
				oderid_to = BeanUtils.getValue(object_to, "sortstr").toString();
			} catch (Exception e) {
				oderid_to = BeanUtils.getValue(object_to, "id").toString();
			}

			BeanUtils.setValue(object_from, "sortstr", oderid_to);
			BeanUtils.setValue(object_to, "sortstr", oderid_from);
			adao.updateObject(object_from);
			adao.updateObject(object_to);

			/*
			 * String[] names=BeanUtils.getPropertyNames(adao.loadById(beanname,
			 * Long.parseLong(id_from))); for (int i = 0; i < names.length; i++)
			 * { log.debug(names[i]);
			 * 
			 * }
			 */
		} catch (Exception e) {

			OperationException opEx = new OperationException("用户session临时放入错误",
					e);
			log.error(e);
			throw opEx;
		}
	}
}
