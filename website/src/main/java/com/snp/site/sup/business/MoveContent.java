/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteAbout;
import com.snp.site.model.SiteAddress;
import com.snp.site.model.SiteJob;
import com.snp.site.model.SiteS1;
import com.snp.site.model.SiteS2;
import com.snp.site.model.SiteSpmp1;
import com.snp.site.model.SiteSpmp1Item;
import com.snp.site.model.SiteSpmp2;
import com.snp.site.model.SiteSpmp2Item;
import com.snp.site.model.SiteSpmp3;
import com.snp.site.model.SiteSpmp3Item;
import com.snp.site.model.SiteSpmp6;
import com.snp.site.model.SiteSpmp6Item;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class MoveContent implements IbusinessAction {
	private static Log log = LogFactory.getLog(MoveContent.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			AdvanceDAO advanceDao = (AdvanceDAO) context
					.getApplicationContext().getBean("advanceDAO");
			String to_beanname = WebAppContextUtils.getpara("to_beanname");
			String from_beanname = WebAppContextUtils.getpara("from_beanname");
			// 单页栏目的迁移
			if (to_beanname.equals("SiteAbout")
					|| to_beanname.equals("SiteAddress")
					|| to_beanname.equals("SiteJob")
					|| to_beanname.equals("SiteS1")
					|| to_beanname.equals("SiteS2")) {
				Object object_from = advanceDao.loadById(
						WebAppContextUtils.getpara("from_beanname"),
						Long.parseLong(WebAppContextUtils.getpara("id_bean")));
				Object object_to = new Object();

				if (to_beanname.equals("SiteAbout"))
					object_to = new SiteAbout();
				if (to_beanname.equals("SiteAddress"))
					object_to = new SiteAddress();
				if (to_beanname.equals("SiteJob"))
					object_to = new SiteJob();
				if (to_beanname.equals("SiteS1"))
					object_to = new SiteS1();
				if (to_beanname.equals("SiteS2"))
					object_to = new SiteS2();

				BeanUtils.copyProperties(object_to, object_from);
				BeanUtils.setProperty(object_to, "id", null);
				Map sessionMap = ActionContext.getContext().getSession();
				SiteUser siteUser = (SiteUser) sessionMap
						.get(SystemInit.clientloginflag);
				BeanUtils.setProperty(object_to, "siteUser",
						(SiteUser) sessionMap.get(SystemInit.clientloginflag));
				advanceDao.saveObject(object_to);
				com.opensymphony.util.BeanUtils.setValue(
						object_to,
						"sortstr",
						com.opensymphony.util.BeanUtils.getValue(object_to,
								"id").toString());
				advanceDao.updateObject(object_to);
				advanceDao.removeObject(object_from);

			} else {
				Object object_from = advanceDao.loadById(
						WebAppContextUtils.getpara("from_beanname"),
						Long.parseLong(WebAppContextUtils.getpara("id_bean")));
				if (to_beanname.equals("SiteSpmp1")) {
					SiteSpmp1 object_to = new SiteSpmp1();
					// 制作了父节点
					BeanUtils.copyProperties(object_to, object_from);
					BeanUtils.setProperty(object_to, "id", null);
					Map sessionMap = ActionContext.getContext().getSession();
					SiteUser siteUser = (SiteUser) sessionMap
							.get(SystemInit.clientloginflag);
					BeanUtils.setProperty(object_to, "siteUser",
							(SiteUser) sessionMap
									.get(SystemInit.clientloginflag));
					advanceDao.saveObject(object_to);
					com.opensymphony.util.BeanUtils.setValue(object_to,
							"sortstr", com.opensymphony.util.BeanUtils
									.getValue(object_to, "id").toString());
					advanceDao.updateObject(object_to);
					advanceDao.removeObject(object_from);
					// 插入子节点
					for (Iterator iterator = get_subitems(from_beanname,
							advanceDao).iterator(); iterator.hasNext();) {
						SiteSpmp1Item siteSpmp1Item = new SiteSpmp1Item();

						BeanUtils
								.copyProperties(siteSpmp1Item, iterator.next());
						// SiteSpmp1Item siteSpmp1Item = (SiteSpmp1Item)
						// iterator.next();
						siteSpmp1Item.setSiteSpmp1(object_to);
						advanceDao.updateObject(siteSpmp1Item);
						advanceDao.removeObject(iterator.next());
					}
				}// end-if StieSpmp1

				if (to_beanname.equals("SiteSpmp2")) {
					SiteSpmp2 object_to = new SiteSpmp2();
					// 制作了父节点
					BeanUtils.copyProperties(object_to, object_from);
					BeanUtils.setProperty(object_to, "id", null);
					Map sessionMap = ActionContext.getContext().getSession();
					SiteUser siteUser = (SiteUser) sessionMap
							.get(SystemInit.clientloginflag);
					BeanUtils.setProperty(object_to, "siteUser",
							(SiteUser) sessionMap
									.get(SystemInit.clientloginflag));
					advanceDao.saveObject(object_to);
					com.opensymphony.util.BeanUtils.setValue(object_to,
							"sortstr", com.opensymphony.util.BeanUtils
									.getValue(object_to, "id").toString());
					advanceDao.updateObject(object_to);

					// 插入子节点
					Set subitems = get_subitems(from_beanname, advanceDao);
					if (subitems != null) {
						for (Iterator iterator = subitems.iterator(); iterator
								.hasNext();) {
							SiteSpmp2Item siteSpmp2Item = new SiteSpmp2Item();

							BeanUtils.copyProperties(siteSpmp2Item,
									iterator.next());
							// SiteSpmp2Item siteSpmp2Item = (SiteSpmp2Item)
							// iterator.next();
							siteSpmp2Item.setSiteSpmp2(object_to);
							advanceDao.saveObject(siteSpmp2Item);
							// advanceDao.removeObject(iterator.next());
						}
					}
					advanceDao.removeObject(object_from);
				}// end-if StieSpmp2

				if (to_beanname.equals("SiteSpmp3")) {
					SiteSpmp3 object_to = new SiteSpmp3();
					// 制作了父节点
					BeanUtils.copyProperties(object_to, object_from);
					BeanUtils.setProperty(object_to, "id", null);
					Map sessionMap = ActionContext.getContext().getSession();
					SiteUser siteUser = (SiteUser) sessionMap
							.get(SystemInit.clientloginflag);
					BeanUtils.setProperty(object_to, "siteUser",
							(SiteUser) sessionMap
									.get(SystemInit.clientloginflag));
					advanceDao.saveObject(object_to);
					com.opensymphony.util.BeanUtils.setValue(object_to,
							"sortstr", com.opensymphony.util.BeanUtils
									.getValue(object_to, "id").toString());
					advanceDao.updateObject(object_to);

					// 插入子节点
					Set subitems = get_subitems(from_beanname, advanceDao);
					if (subitems != null) {
						for (Iterator iterator = subitems.iterator(); iterator
								.hasNext();) {
							SiteSpmp3Item siteSpmp3Item = new SiteSpmp3Item();

							BeanUtils.copyProperties(siteSpmp3Item,
									iterator.next());
							// SiteSpmp3Item siteSpmp3Item = (SiteSpmp3Item)
							// iterator.next();
							siteSpmp3Item.setSiteSpmp3(object_to);
							advanceDao.saveObject(siteSpmp3Item);
							// advanceDao.removeObject(iterator.next());
						}
					}
					advanceDao.removeObject(object_from);
				}// end-if StieSpmp3

				if (to_beanname.equals("SiteSpmp6")) {
					SiteSpmp6 object_to = new SiteSpmp6();
					// 制作了父节点
					BeanUtils.copyProperties(object_to, object_from);
					BeanUtils.setProperty(object_to, "id", null);
					Map sessionMap = ActionContext.getContext().getSession();
					SiteUser siteUser = (SiteUser) sessionMap
							.get(SystemInit.clientloginflag);
					BeanUtils.setProperty(object_to, "siteUser",
							(SiteUser) sessionMap
									.get(SystemInit.clientloginflag));
					advanceDao.saveObject(object_to);
					com.opensymphony.util.BeanUtils.setValue(object_to,
							"sortstr", com.opensymphony.util.BeanUtils
									.getValue(object_to, "id").toString());
					advanceDao.updateObject(object_to);

					// 插入子节点
					Set subitems = get_subitems(from_beanname, advanceDao);
					if (subitems != null) {
						for (Iterator iterator = subitems.iterator(); iterator
								.hasNext();) {
							SiteSpmp6Item siteSpmp6Item = new SiteSpmp6Item();

							BeanUtils.copyProperties(siteSpmp6Item,
									iterator.next());
							// SiteSpmp6Item siteSpmp6Item = (SiteSpmp6Item)
							// iterator.next();
							siteSpmp6Item.setSiteSpmp6(object_to);
							advanceDao.saveObject(siteSpmp6Item);
							// advanceDao.removeObject(iterator.next());
						}
					}
					advanceDao.removeObject(object_from);
				}// end-if StieSpmp6

			}// end-if 多页

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Set get_subitems(String frombeanname, AdvanceDAO advanceDao) {
		if (frombeanname.equals("SiteSpmp1")) {
			SiteSpmp1 siteSpmp1 = (SiteSpmp1) advanceDao.loadById(
					WebAppContextUtils.getpara("from_beanname"),
					Long.parseLong(WebAppContextUtils.getpara("id_bean")));
			return siteSpmp1.getSiteSpmp1Items();
		}
		if (frombeanname.equals("SiteSpmp2")) {
			SiteSpmp2 siteSpmp2 = (SiteSpmp2) advanceDao.loadById(
					WebAppContextUtils.getpara("from_beanname"),
					Long.parseLong(WebAppContextUtils.getpara("id_bean")));
			return siteSpmp2.getSiteSpmp2Items();
		}

		return null;
	}
}