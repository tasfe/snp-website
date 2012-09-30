/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.model.SiteAbout;
import com.snp.site.model.SiteAddress;
import com.snp.site.model.SiteGuest;
import com.snp.site.model.SiteJob;
import com.snp.site.model.SiteLink;
import com.snp.site.model.SitePresource;
import com.snp.site.model.SiteProduct;
import com.snp.site.model.SiteS1;
import com.snp.site.model.SiteS2;
import com.snp.site.model.SiteSpmp1;
import com.snp.site.model.SiteSpmp1Item;
import com.snp.site.model.SiteSpmp2;
import com.snp.site.model.SiteSpmp2Item;
import com.snp.site.model.SiteSpmp3;
import com.snp.site.model.SiteSpmp3Item;
import com.snp.site.model.SiteSpmp4;
import com.snp.site.model.SiteSpmp4Item;
import com.snp.site.model.SiteSpmp4Sub;
import com.snp.site.model.SiteSpmp5;
import com.snp.site.model.SiteSpmp5Item;
import com.snp.site.model.SiteSpmp6;
import com.snp.site.model.SiteSpmp6Item;
import com.snp.site.model.SiteSpmp7;
import com.snp.site.model.SiteSpmp7Item;
import com.snp.site.model.SiteSpmp8;
import com.snp.site.model.SiteSpmp8Item;
import com.snp.site.model.SiteSpmp9;
import com.snp.site.model.SiteSpmp9Item;
import com.snp.site.model.SiteUser;
import com.snp.site.sup.dm.UploadSiteData;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

public class CreateNewUser implements IbusinessAction {
	private static Log log = LogFactory.getLog(CreateNewUser.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			// 先判断是导入还是导出
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			SiteUser siteuser = new SiteUser();
			siteuser.setUsername(WebAppContextUtils.getpara("username"));
			siteuser.setPassword(WebAppContextUtils.getpara("password"));
			adao.saveObject(siteuser);
			String filename = "conf/newuser/test.zip";
			File fileOut = new File(filename);
			UploadSiteData.ImportData(adao, fileOut, siteuser, "createnew");

		} catch (Exception e) {
			OperationException opEx = new OperationException("用户session临时放入错误",
					e);
			log.error(e);
			throw opEx;
		}
	}

	public void listSiteUser(SiteUser siteUser) {
		Set about = siteUser.getSiteAbouts();
		for (Iterator iter = about.iterator(); iter.hasNext();) {
			SiteAbout siteAbout = (SiteAbout) iter.next();

		}
		Set guest = siteUser.getSiteGuests();
		for (Iterator iter = guest.iterator(); iter.hasNext();) {
			SiteGuest siteGuest = (SiteGuest) iter.next();

		}

		Set job = siteUser.getSiteJobs();
		for (Iterator iter = job.iterator(); iter.hasNext();) {
			SiteJob siteJob = (SiteJob) iter.next();

		}
		Set s1 = siteUser.getSiteS1s();
		for (Iterator iter = s1.iterator(); iter.hasNext();) {
			SiteS1 sites1 = (SiteS1) iter.next();

		}
		Set s2 = siteUser.getSiteS2s();
		for (Iterator iter = s2.iterator(); iter.hasNext();) {
			SiteS2 sites2 = (SiteS2) iter.next();

		}

		Set link = siteUser.getSiteLinks();
		for (Iterator iter = link.iterator(); iter.hasNext();) {
			SiteLink siteLink = (SiteLink) iter.next();

		}

		Set address = siteUser.getSiteAddresss();
		for (Iterator iter = address.iterator(); iter.hasNext();) {
			SiteAddress siteAddress = (SiteAddress) iter.next();

		}

		Set presource = siteUser.getSitePresources();
		for (Iterator iter = presource.iterator(); iter.hasNext();) {
			SitePresource sitePresource = (SitePresource) iter.next();

		}

		Set spmp1 = siteUser.getSiteSpmp1s();
		for (Iterator iter = spmp1.iterator(); iter.hasNext();) {
			SiteSpmp1 siteSpmp1 = (SiteSpmp1) iter.next();

			for (Iterator iter2 = siteSpmp1.getSiteSpmp1Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp1Item siteSpmp1Item = (SiteSpmp1Item) iter2.next();

			}
		}
		Set spmp2 = siteUser.getSiteSpmp2s();
		for (Iterator iter = spmp2.iterator(); iter.hasNext();) {
			SiteSpmp2 siteSpmp2 = (SiteSpmp2) iter.next();

			for (Iterator iter2 = siteSpmp2.getSiteSpmp2Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp2Item siteSpmp2Item = (SiteSpmp2Item) iter2.next();
				;
			}
		}
		Set spmp3 = siteUser.getSiteSpmp3s();
		for (Iterator iter = spmp3.iterator(); iter.hasNext();) {
			SiteSpmp3 siteSpmp3 = (SiteSpmp3) iter.next();
			for (Iterator iter2 = siteSpmp3.getSiteSpmp3Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp3Item siteSpmp3Item = (SiteSpmp3Item) iter2.next();

			}
		}
		Set spmp4 = siteUser.getSiteSpmp4s();
		for (Iterator iter = spmp4.iterator(); iter.hasNext();) {
			SiteSpmp4 siteSpmp4 = (SiteSpmp4) iter.next();
			for (Iterator iter2 = siteSpmp4.getSiteSpmp4Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) iter2.next();
				for (Iterator iter3 = siteSpmp4Item.getSiteProducts()
						.iterator(); iter3.hasNext();) {
					SiteProduct siteProduct = (SiteProduct) iter3.next();
				}

			}

			for (Iterator iter2 = siteSpmp4.getSiteSpmp4Subs().iterator(); iter2
					.hasNext();) {
				SiteSpmp4Sub siteSpmp4Sub = (SiteSpmp4Sub) iter2.next();
			}
		}
		Set spmp5 = siteUser.getSiteSpmp5s();
		for (Iterator iter = spmp5.iterator(); iter.hasNext();) {
			SiteSpmp5 siteSpmp5 = (SiteSpmp5) iter.next();
			for (Iterator iter2 = siteSpmp5.getSiteSpmp5Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp5Item siteSpmp5Item = (SiteSpmp5Item) iter2.next();
			}
		}
		Set spmp6 = siteUser.getSiteSpmp6s();
		for (Iterator iter = spmp6.iterator(); iter.hasNext();) {
			SiteSpmp6 siteSpmp6 = (SiteSpmp6) iter.next();
			for (Iterator iter2 = siteSpmp6.getSiteSpmp6Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp6Item siteSpmp6Item = (SiteSpmp6Item) iter2.next();
			}
		}
		Set spmp7 = siteUser.getSiteSpmp7s();
		for (Iterator iter = spmp7.iterator(); iter.hasNext();) {
			SiteSpmp7 siteSpmp7 = (SiteSpmp7) iter.next();
			for (Iterator iter2 = siteSpmp7.getSiteSpmp7Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp7Item siteSpmp7Item = (SiteSpmp7Item) iter2.next();
			}
		}

		Set spmp8 = siteUser.getSiteSpmp8s();
		for (Iterator iter = spmp8.iterator(); iter.hasNext();) {
			SiteSpmp8 siteSpmp8 = (SiteSpmp8) iter.next();
			for (Iterator iter2 = siteSpmp8.getSiteSpmp8Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp8Item siteSpmp8Item = (SiteSpmp8Item) iter2.next();
			}
		}

		Set spmp9 = siteUser.getSiteSpmp9s();
		for (Iterator iter = spmp9.iterator(); iter.hasNext();) {
			SiteSpmp9 siteSpmp9 = (SiteSpmp9) iter.next();
			for (Iterator iter2 = siteSpmp9.getSiteSpmp9Items().iterator(); iter2
					.hasNext();) {
				SiteSpmp9Item siteSpmp9Item = (SiteSpmp9Item) iter2.next();

			}
		}

	}
}
