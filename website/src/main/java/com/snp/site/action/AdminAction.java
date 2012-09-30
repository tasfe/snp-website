package com.snp.site.action;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.snp.common.Dateprocess;
import com.snp.common.I18n;
import com.snp.common.regex.StringbyPerlFreemark;
import com.snp.site.config.LanmuConfig;
import com.snp.site.exception.SnpException;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteAbout;
import com.snp.site.model.SiteAddress;
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
import com.snp.site.model.SiteSpmp5;
import com.snp.site.model.SiteSpmp5Item;
import com.snp.site.model.SiteSpmp6;
import com.snp.site.model.SiteSpmp6Item;
import com.snp.site.model.SiteSpmp8;
import com.snp.site.model.SiteSpmp9;
import com.snp.site.model.SiteSpmp9Item;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.core.common.util.WebAppContextUtils;

import freemarker.template.SimpleHash;

/**
 * 
 * 
 */
public class AdminAction extends ActionSupport {
	private static Log log = LogFactory.getLog(AdminAction.class);

	public String execute() throws Exception {
		return Action.SUCCESS;
	}

	private Map results = new HashMap();

	private List systemErrors = new ArrayList(3);

	public List getSystemErrors() {
		return systemErrors;
	}

	public void setSystemErrors(List systemErrors) {
		this.systemErrors = systemErrors;
	}

	public void setResults(Map results) {
		this.results = results;
	}

	public Map getResults() {
		return results;
	}

	public void gethtmlbyfreemaker(String templetename, String page_id,
			String lanmuname, String userhomepath, String templetepathWebpage,
			SiteUser siteuser, SimpleHash root) throws Exception {
		root.put("local", siteuser.getLocal());
		root.put("language", "1");
		root.put("lanmuname", lanmuname);
		StringbyPerlFreemark.getfilebyFreemark(userhomepath + "/" + lanmuname
				+ "_1" + page_id + ".html", templetepathWebpage,
				"website/sitetemplateweb/1/" + templetename + ".ftl", root);
		if (!siteuser.getLanguage2().equals("")) {
			root.put("local", siteuser.getLocal2());
			root.put("language", "2");
			StringbyPerlFreemark.getfilebyFreemark(userhomepath + "/"
					+ lanmuname + "_2" + page_id + ".html",
					templetepathWebpage, "website/sitetemplateweb/1/"
							+ templetename + ".ftl", root);
		}
		if (!siteuser.getLanguage3().equals("")) {
			root.put("local", siteuser.getLocal2());
			root.put("language", "3");
			StringbyPerlFreemark.getfilebyFreemark(userhomepath + "/"
					+ lanmuname + "_3" + page_id + ".html",
					templetepathWebpage, "website/sitetemplateweb/1/"
							+ templetename + ".ftl", root);
		}
	}

	/** 根据配置文件生成栏目数据 */
	public void genLanmuHtml(String lanmuname, String userhomepath,
			String templetepathWebpage, SiteUser siteuser, SimpleHash root)
			throws Exception {
		try {
			String templetename = lanmuname;
			String page_id = "";
			if (lanmuname != null && !(lanmuname.equals(""))) { // 目录栏目
				if (lanmuname.indexOf("spmp") == 0) {
					templetename = "spmp";
					root.put("lanmuname", lanmuname);
					if (lanmuname.equals("spmp1")) {
						for (Iterator iterator = siteuser.getSiteSpmp1s()
								.iterator(); iterator.hasNext();) {
							SiteSpmp1 SiteSpmp = (SiteSpmp1) iterator.next();
							root.put("SiteSpmp", SiteSpmp);
							page_id = "_" + SiteSpmp.getId().toString();
							gethtmlbyfreemaker(templetename, page_id,
									lanmuname, userhomepath,
									templetepathWebpage, siteuser, root);
						}
					}
					if (lanmuname.equals("spmp2")) {
						for (Iterator iterator = siteuser.getSiteSpmp2s()
								.iterator(); iterator.hasNext();) {
							SiteSpmp2 SiteSpmp = (SiteSpmp2) iterator.next();
							root.put("SiteSpmp", SiteSpmp);
							page_id = "_" + SiteSpmp.getId().toString();
							gethtmlbyfreemaker(templetename, page_id,
									lanmuname, userhomepath,
									templetepathWebpage, siteuser, root);
						}
					}
					if (lanmuname.equals("spmp3")) {
						for (Iterator iterator = siteuser.getSiteSpmp3s()
								.iterator(); iterator.hasNext();) {
							SiteSpmp3 SiteSpmp = (SiteSpmp3) iterator.next();
							root.put("SiteSpmp", SiteSpmp);
							page_id = "_" + SiteSpmp.getId().toString();
							gethtmlbyfreemaker(templetename, page_id,
									lanmuname, userhomepath,
									templetepathWebpage, siteuser, root);
						}
					}
					if (lanmuname.equals("spmp6")) {
						for (Iterator iterator = siteuser.getSiteSpmp6s()
								.iterator(); iterator.hasNext();) {
							SiteSpmp6 SiteSpmp = (SiteSpmp6) iterator.next();
							root.put("SiteSpmp", SiteSpmp);
							page_id = "_" + SiteSpmp.getId().toString();
							gethtmlbyfreemaker(templetename, page_id,
									lanmuname, userhomepath,
									templetepathWebpage, siteuser, root);
						}
					}
					if (lanmuname.equals("spmp9")) {
						for (Iterator iterator = siteuser.getSiteSpmp9s()
								.iterator(); iterator.hasNext();) {
							SiteSpmp9 SiteSpmp = (SiteSpmp9) iterator.next();
							root.put("SiteSpmp", SiteSpmp);
							page_id = "_" + SiteSpmp.getId().toString();
							gethtmlbyfreemaker(templetename, page_id,
									lanmuname, userhomepath,
									templetepathWebpage, siteuser, root);
						}
					}

					if (lanmuname.equals("spmp4")) {
						templetename = "spmp4";
						root.put("subid", "");
						for (Iterator iterator = siteuser.getSiteSpmp4s()
								.iterator(); iterator.hasNext();) {
							SiteSpmp4 SiteSpmp = (SiteSpmp4) iterator.next();
							root.put("SiteSpmp", SiteSpmp);
							page_id = "_" + SiteSpmp.getId().toString();
							gethtmlbyfreemaker(templetename, page_id,
									lanmuname, userhomepath,
									templetepathWebpage, siteuser, root);
						}
					}
					if (lanmuname.equals("spmp5")) {
						templetename = "spmp5";
						gethtmlbyfreemaker(templetename, "", lanmuname,
								userhomepath, templetepathWebpage, siteuser,
								root);
					}
					if (lanmuname.equals("spmp8")) {
						templetename = "spmp8";
						gethtmlbyfreemaker(templetename, "", lanmuname,
								userhomepath, templetepathWebpage, siteuser,
								root);
					}
				} else {// 单页栏目
					gethtmlbyfreemaker(templetename, "", lanmuname,
							userhomepath, templetepathWebpage, siteuser, root);
				}
			}
		} catch (Exception e) {
			log.error(lanmuname + "生成错误");
			throw e;
		}
	}

	public String genhtml() {
		String username = "";
		Map sessionMap = ActionContext.getContext().getSession();
		try {
			java.lang.Object obj = ApplicationContextFactory.getWebAppContext()
					.getBean("SiteUser");
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteUser siteuser = (SiteUser) adao.getObject(obj.getClass(),
					new Long(WebAppContextUtils.getpara("siteuserid")));
			LanmuConfig lanmuObject = (LanmuConfig) ActionContext.getContext()
					.getSession().get("lanmuobject");
			try {
				SimpleHash root = new SimpleHash();
				ArrayList<String> lanmuname_aready_gen = new ArrayList();
				root.put("SiteUser", siteuser);
				root.put("LanmuObject", lanmuObject);
				String userhomepath = SystemInit.getSiteHome()
						+ siteuser.getUsername();
				String templetepathWebpage = SystemInit.getWebroot();
				FileUtils.forceMkdir(new File(userhomepath));
				root.put("infomap", new I18n());
				root.put("otheruserlist", SystemInit.otheruserlist(siteuser));
				HttpServletRequest requestServelt = ServletActionContext
						.getRequest();
				root.put("urlpath", requestServelt.getHeader("host"));
				root.put("updatetime",
						Dateprocess.getTimeStr("yyyy-mm-dd hh:mm:ss"));
				genLanmuHtml("index", userhomepath, templetepathWebpage,
						siteuser, root);
				genLanmuHtml("spmp9", userhomepath, templetepathWebpage,
						siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu1(), userhomepath,
						templetepathWebpage, siteuser, root);

				genLanmuHtml(lanmuObject.getLanmu2(), userhomepath,
						templetepathWebpage, siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu3(), userhomepath,
						templetepathWebpage, siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu4(), userhomepath,
						templetepathWebpage, siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu5(), userhomepath,
						templetepathWebpage, siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu6(), userhomepath,
						templetepathWebpage, siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu7(), userhomepath,
						templetepathWebpage, siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu8(), userhomepath,
						templetepathWebpage, siteuser, root);
				genLanmuHtml(lanmuObject.getLanmu9(), userhomepath,
						templetepathWebpage, siteuser, root);
				lanmuname_aready_gen.add(lanmuObject.getLanmu1());
				lanmuname_aready_gen.add(lanmuObject.getLanmu2());
				lanmuname_aready_gen.add(lanmuObject.getLanmu3());
				lanmuname_aready_gen.add(lanmuObject.getLanmu4());
				lanmuname_aready_gen.add(lanmuObject.getLanmu5());
				lanmuname_aready_gen.add(lanmuObject.getLanmu6());
				lanmuname_aready_gen.add(lanmuObject.getLanmu7());
				lanmuname_aready_gen.add(lanmuObject.getLanmu8());
				lanmuname_aready_gen.add(lanmuObject.getLanmu9());

				if (!lanmuname_aready_gen.contains(lanmuObject.getLanmudir1())) {
					genLanmuHtml(lanmuObject.getLanmudir1(), userhomepath,
							templetepathWebpage, siteuser, root);
				}
				if (!lanmuname_aready_gen.contains(lanmuObject.getLanmudir2())) {
					genLanmuHtml(lanmuObject.getLanmudir2(), userhomepath,
							templetepathWebpage, siteuser, root);
				}
				if (!lanmuname_aready_gen.contains(lanmuObject.getLanmudir3())) {
					genLanmuHtml(lanmuObject.getLanmudir3(), userhomepath,
							templetepathWebpage, siteuser, root);
				}
				if (!lanmuname_aready_gen.contains(lanmuObject.getLanmudir4())) {
					genLanmuHtml(lanmuObject.getLanmudir4(), userhomepath,
							templetepathWebpage, siteuser, root);
				}

			} catch (Exception e) {
				log.error("gen page error:", e);
			}

			results.put("username", siteuser.getUsername());
			HttpServletRequest request = ServletActionContext.getRequest();

			return "genclientpagesucess";
		} catch (Exception e) {
			log.error("gen page error:", e);
			String errortitle = "<b>UserName:" + username
					+ "--Operation: page </b>" + SystemInit.getHttpString();
			systemErrors.add(new SnpException(errortitle, e));
			return "operr_admin";
		}
	}

	/** 全局替换文字 */
	public String genReplace() {
		try {
			java.lang.Object obj = ApplicationContextFactory.getWebAppContext()
					.getBean("SiteUser");
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteUser currentuser = (SiteUser) adao.getObject(obj.getClass(),
					new Long(WebAppContextUtils.getpara("siteuserid")));
			String str_find = WebAppContextUtils.getpara("str_find");
			String str_replace = WebAppContextUtils.getpara("str_replace");
			if (currentuser.getTitle() != null)
				currentuser.setTitle(currentuser.getTitle().replaceAll(
						str_find, str_replace));
			if (currentuser.getBottom() != null)
				currentuser.setBottom(currentuser.getBottom().replaceAll(
						str_find, str_replace));

			if (currentuser.getSpmp4common() != null)
				currentuser.setSpmp4common(currentuser.getSpmp4common()
						.replaceAll(str_find, str_replace));

			adao.updateObject(currentuser);

			Set setObjects = currentuser.getSiteAbouts();
			for (Iterator iter = setObjects.iterator(); iter.hasNext();) {
				SiteAbout ojbect = (SiteAbout) iter.next();
				ojbect.setDetail(ojbect.getDetail().replaceAll(str_find,
						str_replace));
				adao.updateObject(ojbect);
			}

			setObjects = currentuser.getSiteJobs();
			for (Iterator iter = setObjects.iterator(); iter.hasNext();) {
				SiteJob ojbect = (SiteJob) iter.next();
				ojbect.setDetail(ojbect.getDetail().replaceAll(str_find,
						str_replace));
				adao.updateObject(ojbect);
			}

			setObjects = currentuser.getSiteS1s();
			for (Iterator iter = setObjects.iterator(); iter.hasNext();) {
				SiteS1 ojbect = (SiteS1) iter.next();
				ojbect.setDetail(ojbect.getDetail().replaceAll(str_find,
						str_replace));
				adao.updateObject(ojbect);
			}

			setObjects = currentuser.getSiteS2s();
			for (Iterator iter = setObjects.iterator(); iter.hasNext();) {
				SiteS2 ojbect = (SiteS2) iter.next();
				ojbect.setDetail(ojbect.getDetail().replaceAll(str_find,
						str_replace));
				adao.updateObject(ojbect);
			}
			setObjects = currentuser.getSiteLinks();
			for (Iterator iter = setObjects.iterator(); iter.hasNext();) {
				SiteLink ojbect = (SiteLink) iter.next();
				ojbect.setDetail(ojbect.getDetail().replaceAll(str_find,
						str_replace));
				adao.updateObject(ojbect);
			}
			setObjects = currentuser.getSiteAddresss();
			for (Iterator iter = setObjects.iterator(); iter.hasNext();) {
				SiteAddress ojbect = (SiteAddress) iter.next();
				ojbect.setDetail(ojbect.getDetail().replaceAll(str_find,
						str_replace));
				adao.updateObject(ojbect);
			}

			Set spmp1 = currentuser.getSiteSpmp1s();
			for (Iterator iter = spmp1.iterator(); iter.hasNext();) {
				SiteSpmp1 objectparent = (SiteSpmp1) iter.next();
				if (objectparent.getName() != null)
					objectparent.setName(objectparent.getName().replaceAll(
							str_find, str_replace));
				if (objectparent.getDetail() != null)
					objectparent.setDetail(objectparent.getDetail().replaceAll(
							str_find, str_replace));
				adao.updateObject(objectparent);
				for (Iterator iter2 = objectparent.getSiteSpmp1Items()
						.iterator(); iter2.hasNext();) {
					SiteSpmp1Item objectchild = (SiteSpmp1Item) iter2.next();
					if (objectchild.getTitle() != null)
						objectchild.setTitle(objectchild.getTitle().replaceAll(
								str_find, str_replace));
					if (objectchild.getDetail() != null)
						objectchild.setDetail(objectchild.getDetail()
								.replaceAll(str_find, str_replace));

				}
			}
			Set spmp2 = currentuser.getSiteSpmp2s();
			for (Iterator iter = spmp2.iterator(); iter.hasNext();) {
				SiteSpmp2 objectparent = (SiteSpmp2) iter.next();
				if (objectparent.getName() != null)
					objectparent.setName(objectparent.getName().replaceAll(
							str_find, str_replace));
				if (objectparent.getDetail() != null)
					objectparent.setDetail(objectparent.getDetail().replaceAll(
							str_find, str_replace));
				adao.updateObject(objectparent);
				for (Iterator iter2 = objectparent.getSiteSpmp2Items()
						.iterator(); iter2.hasNext();) {
					SiteSpmp2Item objectchild = (SiteSpmp2Item) iter2.next();
					if (objectchild.getTitle() != null)
						objectchild.setTitle(objectchild.getTitle().replaceAll(
								str_find, str_replace));
					if (objectchild.getDetail() != null)
						objectchild.setDetail(objectchild.getDetail()
								.replaceAll(str_find, str_replace));

				}
			}
			Set spmp3 = currentuser.getSiteSpmp3s();
			for (Iterator iter = spmp3.iterator(); iter.hasNext();) {
				SiteSpmp3 objectparent = (SiteSpmp3) iter.next();
				if (objectparent.getName() != null)
					objectparent.setName(objectparent.getName().replaceAll(
							str_find, str_replace));
				if (objectparent.getDetail() != null)
					objectparent.setDetail(objectparent.getDetail().replaceAll(
							str_find, str_replace));
				adao.updateObject(objectparent);
				for (Iterator iter2 = objectparent.getSiteSpmp3Items()
						.iterator(); iter2.hasNext();) {
					SiteSpmp3Item objectchild = (SiteSpmp3Item) iter2.next();
					if (objectchild.getTitle() != null)
						objectchild.setTitle(objectchild.getTitle().replaceAll(
								str_find, str_replace));
					if (objectchild.getDetail() != null)
						objectchild.setDetail(objectchild.getDetail()
								.replaceAll(str_find, str_replace));

				}
			}
			Set spmp6 = currentuser.getSiteSpmp6s();
			for (Iterator iter = spmp6.iterator(); iter.hasNext();) {
				SiteSpmp6 objectparent = (SiteSpmp6) iter.next();
				if (objectparent.getName() != null)
					objectparent.setName(objectparent.getName().replaceAll(
							str_find, str_replace));
				if (objectparent.getDetail() != null)
					objectparent.setDetail(objectparent.getDetail().replaceAll(
							str_find, str_replace));
				adao.updateObject(objectparent);
				for (Iterator iter2 = objectparent.getSiteSpmp6Items()
						.iterator(); iter2.hasNext();) {
					SiteSpmp6Item objectchild = (SiteSpmp6Item) iter2.next();
					if (objectchild.getTitle() != null)
						objectchild.setTitle(objectchild.getTitle().replaceAll(
								str_find, str_replace));
					if (objectchild.getDetail() != null)
						objectchild.setDetail(objectchild.getDetail()
								.replaceAll(str_find, str_replace));

				}
			}

			Set spmp9 = currentuser.getSiteSpmp9s();
			for (Iterator iter = spmp9.iterator(); iter.hasNext();) {
				SiteSpmp9 objectparent = (SiteSpmp9) iter.next();
				if (objectparent.getName() != null)
					objectparent.setName(objectparent.getName().replaceAll(
							str_find, str_replace));
				if (objectparent.getDetail() != null)
					objectparent.setDetail(objectparent.getDetail().replaceAll(
							str_find, str_replace));
				adao.updateObject(objectparent);
				for (Iterator iter2 = objectparent.getSiteSpmp9Items()
						.iterator(); iter2.hasNext();) {
					SiteSpmp9Item objectchild = (SiteSpmp9Item) iter2.next();
					if (objectchild.getTitle() != null)
						objectchild.setTitle(objectchild.getTitle().replaceAll(
								str_find, str_replace));
					if (objectchild.getDetail() != null)
						objectchild.setDetail(objectchild.getDetail()
								.replaceAll(str_find, str_replace));

				}
			}
			Set spmp4 = currentuser.getSiteSpmp4s();
			for (Iterator iter = spmp4.iterator(); iter.hasNext();) {
				SiteSpmp4 objectparent = (SiteSpmp4) iter.next();
				if (objectparent.getName() != null)
					objectparent.setName(objectparent.getName().replaceAll(
							str_find, str_replace));
				if (objectparent.getDetail() != null)
					objectparent.setDetail(objectparent.getDetail().replaceAll(
							str_find, str_replace));
				if (objectparent.getCommon() != null)
					objectparent.setCommon(objectparent.getCommon().replaceAll(
							str_find, str_replace));
				adao.updateObject(objectparent);
				for (Iterator iter2 = objectparent.getSiteSpmp4Items()
						.iterator(); iter2.hasNext();) {
					SiteSpmp4Item objectchild = (SiteSpmp4Item) iter2.next();
					if (objectchild.getTitle() != null)
						objectchild.setTitle(objectchild.getTitle().replaceAll(
								str_find, str_replace));
					if (objectchild.getDetail() != null)
						objectchild.setDetail(objectchild.getDetail()
								.replaceAll(str_find, str_replace));

				}
			}
			genhtml();
			return "genreplace";
		} catch (Exception e) {
			log.error("replace page error:", e);
			return "operr_admin";
		}
	}

	public String cleanSite() {
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		SiteUser currentuser = (SiteUser) adao.loadById("SiteUser", new Long(
				WebAppContextUtils.getpara("siteuserid")));

		currentuser.setTitle("");
		currentuser.setSpmp4common("");
		currentuser.setSpmp4common2("");
		currentuser.setSpmp4common3("");
		currentuser.setAboutht("");
		currentuser.setAddressht("");
		currentuser.setMarquee("");
		currentuser.setMarquee2("");
		currentuser.setMarquee3("");
		currentuser.setBottom("");
		adao.updateObject(currentuser);

		while (currentuser.getSiteAbouts().size() > 0) {
			Iterator iter = currentuser.getSiteAbouts().iterator();
			SiteAbout ojbect = (SiteAbout) iter.next();
			File temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/" + ojbect.getFilepath());
			temp.delete();
			temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/"
					+ ojbect.getFilepathvideo());
			temp.delete();
			currentuser.getSiteAbouts().remove(ojbect);
			adao.removeObject(ojbect);
		}

		while (currentuser.getSiteJobs().size() > 0) {
			Iterator iter = currentuser.getSiteJobs().iterator();
			SiteJob ojbect = (SiteJob) iter.next();
			File temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/" + ojbect.getFilepath());
			temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/"
					+ ojbect.getFilepathvideo());
			temp.delete();
			temp.delete();
			currentuser.getSiteJobs().remove(ojbect);
			adao.removeObject(ojbect);
		}

		while (currentuser.getSiteS1s().size() > 0) {
			Iterator iter = currentuser.getSiteS1s().iterator();
			SiteS1 ojbect = (SiteS1) iter.next();
			File temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/" + ojbect.getFilepath());
			temp.delete();
			temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/"
					+ ojbect.getFilepathvideo());
			temp.delete();
			currentuser.getSiteS1s().remove(ojbect);
			adao.removeObject(ojbect);
		}

		for (Iterator iterator = currentuser.getSiteS2s().iterator(); iterator
				.hasNext();) {
			SiteS2 ojbect = (SiteS2) iterator.next();
			File temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/" + ojbect.getFilepath());
			temp.delete();
			temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/"
					+ ojbect.getFilepathvideo());
			temp.delete();
			currentuser.getSiteS2s().remove(ojbect);
			adao.removeObject(ojbect);
		}

		while (currentuser.getSiteLinks().size() > 0) {
			Iterator iter = currentuser.getSiteLinks().iterator();
			SiteLink ojbect = (SiteLink) iter.next();
			File temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/" + ojbect.getFilepath());
			temp.delete();
			temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/"
					+ ojbect.getFilepathvideo());
			temp.delete();
			currentuser.getSiteLinks().remove(ojbect);
			adao.removeObject(ojbect);
		}

		while (currentuser.getSiteAddresss().size() > 0) {
			Iterator iter = currentuser.getSiteAddresss().iterator();
			SiteAddress ojbect = (SiteAddress) iter.next();
			File temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/" + ojbect.getFilepath());
			temp.delete();
			temp = new File(SystemInit.getSiteHome()
					+ currentuser.getUsername() + "/"
					+ ojbect.getFilepathvideo());
			temp.delete();
			currentuser.getSiteAddresss().remove(ojbect);
			adao.removeObject(ojbect);
		}

		// 奇怪：为什么这么处理 就 可以
		while (currentuser.getSiteSpmp1s().size() > 0) {
			Iterator iter = currentuser.getSiteSpmp1s().iterator();
			SiteSpmp1 siteSpmp1 = (SiteSpmp1) iter.next();
			while (siteSpmp1.getSiteSpmp1Items().size() > 0) {
				Iterator iterator2 = siteSpmp1.getSiteSpmp1Items().iterator();
				SiteSpmp1Item siteSpmp1Item = (SiteSpmp1Item) iterator2.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp1Item.getFilepath());
				temp.delete();
				temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp1Item.getFilepathvideo());
				temp.delete();
				siteSpmp1.getSiteSpmp1Items().remove(siteSpmp1Item);
				adao.removeObject(siteSpmp1Item);
			}
			currentuser.getSiteSpmp1s().remove(siteSpmp1);
			adao.removeObject(siteSpmp1);
		}
		while (currentuser.getSiteSpmp2s().size() > 0) {
			Iterator iter = currentuser.getSiteSpmp2s().iterator();
			SiteSpmp2 siteSpmp2 = (SiteSpmp2) iter.next();
			while (siteSpmp2.getSiteSpmp2Items().size() > 0) {
				Iterator iterator2 = siteSpmp2.getSiteSpmp2Items().iterator();
				SiteSpmp2Item siteSpmp2Item = (SiteSpmp2Item) iterator2.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp2Item.getFilepath());
				temp.delete();
				temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp2Item.getFilepathvideo());
				temp.delete();
				siteSpmp2.getSiteSpmp2Items().remove(siteSpmp2Item);
				adao.removeObject(siteSpmp2Item);
			}
			currentuser.getSiteSpmp2s().remove(siteSpmp2);
			adao.removeObject(siteSpmp2);
		}
		while (currentuser.getSiteSpmp3s().size() > 0) {
			Iterator iter = currentuser.getSiteSpmp3s().iterator();
			SiteSpmp3 siteSpmp3 = (SiteSpmp3) iter.next();
			while (siteSpmp3.getSiteSpmp3Items().size() > 0) {
				Iterator iterator3 = siteSpmp3.getSiteSpmp3Items().iterator();
				SiteSpmp3Item siteSpmp3Item = (SiteSpmp3Item) iterator3.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp3Item.getFilepath());
				temp.delete();
				temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp3Item.getFilepathvideo());
				temp.delete();
				siteSpmp3.getSiteSpmp3Items().remove(siteSpmp3Item);
				adao.removeObject(siteSpmp3Item);
			}
			currentuser.getSiteSpmp3s().remove(siteSpmp3);
			adao.removeObject(siteSpmp3);
		}
		while (currentuser.getSiteSpmp6s().size() > 0) {
			Iterator iter = currentuser.getSiteSpmp6s().iterator();
			SiteSpmp6 siteSpmp6 = (SiteSpmp6) iter.next();
			while (siteSpmp6.getSiteSpmp6Items().size() > 0) {
				Iterator iterator6 = siteSpmp6.getSiteSpmp6Items().iterator();
				SiteSpmp6Item siteSpmp6Item = (SiteSpmp6Item) iterator6.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp6Item.getFilepath());
				temp.delete();
				temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp6Item.getFilepathvideo());
				temp.delete();
				siteSpmp6.getSiteSpmp6Items().remove(siteSpmp6Item);
				adao.removeObject(siteSpmp6Item);
			}
			currentuser.getSiteSpmp6s().remove(siteSpmp6);
			adao.removeObject(siteSpmp6);
		}
		while (currentuser.getSiteSpmp9s().size() > 0) {
			Iterator iter = currentuser.getSiteSpmp9s().iterator();
			SiteSpmp9 siteSpmp9 = (SiteSpmp9) iter.next();
			while (siteSpmp9.getSiteSpmp9Items().size() > 0) {
				Iterator iterator9 = siteSpmp9.getSiteSpmp9Items().iterator();
				SiteSpmp9Item siteSpmp9Item = (SiteSpmp9Item) iterator9.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp9Item.getFilepath());
				temp.delete();
				temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp9Item.getFilepathvideo());
				temp.delete();
				siteSpmp9.getSiteSpmp9Items().remove(siteSpmp9Item);
				adao.removeObject(siteSpmp9Item);
			}
			currentuser.getSiteSpmp9s().remove(siteSpmp9);
			adao.removeObject(siteSpmp9);
		}
		try {
			while (currentuser.getSiteSpmp8s().size() > 0) {
				Iterator iter = currentuser.getSiteSpmp8s().iterator();
				SiteSpmp8 SiteSpmp8 = (SiteSpmp8) iter.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ SiteSpmp8.getFilepath() + ".flv");
				temp.delete();
				currentuser.getSiteSpmp8s().remove(SiteSpmp8);
				adao.removeObject(SiteSpmp8);
			}
		} catch (Exception e) {
			log.error("清除视频栏目错误：");
			e.printStackTrace();
		}
		try {
			while (currentuser.getSitePresources().size() > 0) {
				Iterator iter = currentuser.getSiteSpmp8s().iterator();
				SitePresource sitePresource = (SitePresource) iter.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ sitePresource.getFilepath());
				temp.delete();
				currentuser.getSitePresources().remove(sitePresource);
				adao.removeObject(sitePresource);
			}
		} catch (Exception e) {
			log.error("清除视频栏目错误：");
			e.printStackTrace();
		}
		while (currentuser.getSiteSpmp5s().size() > 0) {
			Iterator iter = currentuser.getSiteSpmp5s().iterator();
			SiteSpmp5 siteSpmp5 = (SiteSpmp5) iter.next();
			while (siteSpmp5.getSiteSpmp5Items().size() > 0) {
				Iterator iterator9 = siteSpmp5.getSiteSpmp5Items().iterator();
				SiteSpmp5Item siteSpmp5Item = (SiteSpmp5Item) iterator9.next();
				File temp = new File(SystemInit.getSiteHome()
						+ currentuser.getUsername() + "/"
						+ siteSpmp5Item.getFilepath());
				temp.delete();
				siteSpmp5.getSiteSpmp5Items().remove(siteSpmp5Item);
				adao.removeObject(siteSpmp5Item);
			}
			currentuser.getSiteSpmp5s().remove(siteSpmp5);
			adao.removeObject(siteSpmp5);
		}
		try {
			while (currentuser.getSiteSpmp4s().size() > 0) {
				Iterator iterator = currentuser.getSiteSpmp4s().iterator();
				SiteSpmp4 siteSpmp4 = (SiteSpmp4) iterator.next();
				while (siteSpmp4.getSiteSpmp4Items().size() > 0) {
					Iterator iterator2 = siteSpmp4.getSiteSpmp4Items()
							.iterator();
					SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) iterator2
							.next();
					File temp = new File(SystemInit.getSiteHome()
							+ currentuser.getUsername() + "/"
							+ siteSpmp4Item.getFilepath());
					temp.delete();
					while (siteSpmp4Item.getSiteProducts().size() > 0) {
						Iterator iterator3 = siteSpmp4Item.getSiteProducts()
								.iterator();
						SiteProduct siteProduct = (SiteProduct) iterator3
								.next();
						temp = new File(SystemInit.getSiteHome()
								+ currentuser.getUsername() + "/"
								+ siteProduct.getFilepath());
						temp.delete();
						siteSpmp4Item.getSiteProducts().remove(siteProduct);
						adao.removeObject(siteProduct);
					}
					siteSpmp4.getSiteSpmp4Items().remove(siteSpmp4Item);
					adao.removeObject(siteSpmp4Item);
				}
				currentuser.getSiteSpmp4s().remove(siteSpmp4);
				adao.removeObject(siteSpmp4);
			}

		} catch (Exception e) {
			log.error("清除图片栏目错误：");
			e.printStackTrace();
		}

		genhtml();
		return "genclientpagesucess";

	}

	public String ajax_user() {
		try {
			Map sessionMap = ActionContext.getContext().getSession();
			String property = WebAppContextUtils.getpara("paraname");
			String value = WebAppContextUtils.getpara("value");
			SiteUser currentuser = (SiteUser) sessionMap
					.get(SystemInit.clientloginflag);
			BeanUtils.copyProperty(currentuser, property, value);
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			adao.updateObject(currentuser);
			return "ajax_result";
		} catch (Exception e) {
			log.error("ajax_user!", e);
			return "operr_admin";
		}

	}

	public String ajax_language() {
		try {
			String searchTitle = WebAppContextUtils.getpara("searchTitle");

			String searchKeys = WebAppContextUtils.getpara("searchKeys");
			String searchDesc = WebAppContextUtils.getpara("searchDesc");

			// String newrepeatpassword =
			// WebAppContextUtils.getpara("newrepeatpassword");
			Map sessionMap = ActionContext.getContext().getSession();
			SiteUser currentuser = (SiteUser) sessionMap
					.get(SystemInit.clientloginflag);
			currentuser.setSearchDesc(searchDesc);
			currentuser.setSearchKeys(searchKeys);
			currentuser.setSearchTitle(searchTitle);
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			adao.updateObject(currentuser);

			results.put("ajax_info", "修改成功 ");

			return "ajax_result";
		} catch (Exception e) {
			log.error("Adminaction.changepassword()error!", e);
			return "operr_admin";
		}

	}

	public String ajax_search() {
		try {
			String searchTitle = WebAppContextUtils.getpara("searchTitle");
			String searchKeys = WebAppContextUtils.getpara("searchKeys");
			String searchDesc = WebAppContextUtils.getpara("searchDesc");

			// String newrepeatpassword =
			// WebAppContextUtils.getpara("newrepeatpassword");
			Map sessionMap = ActionContext.getContext().getSession();
			SiteUser currentuser = (SiteUser) sessionMap
					.get(SystemInit.clientloginflag);
			currentuser.setSearchDesc(searchDesc);
			currentuser.setSearchKeys(searchKeys);
			currentuser.setSearchTitle(searchTitle);
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			adao.updateObject(currentuser);

			results.put("ajax_info", "设置成功 ");

			return "ajax_result";
		} catch (Exception e) {
			log.error("Adminaction.changepassword()error!", e);
			return "operr_admin";
		}

	}

	// ajax更新栏目对象
	public String ajax_lanmusetting() {
		try {

			SiteUser siteuser = (SiteUser) ActionContext.getContext()
					.getSession().get(SystemInit.clientloginflag);
			String userLunmuXmlPath = SystemInit.getSiteHome()
					+ siteuser.getUsername() + "/"
					+ SystemInit.LanmuConfFileName;

			LanmuConfig lanmuObject = SystemInit
					.getLanmuObjectFromXml(userLunmuXmlPath);

			String property = WebAppContextUtils.getpara("paraname");
			String value = WebAppContextUtils.getpara("value");

			BeanUtils.copyProperty(lanmuObject, property, value);

			ActionContext.getContext().getSession()
					.put("lanmuobject", lanmuObject);
			XMLEncoder e;
			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(
					userLunmuXmlPath)));
			e.writeObject(lanmuObject);
			e.close();
			results.put("ajax_info", "修改成功 ");
			return "ajax_result";
		} catch (Exception e) {
			log.error("Adminaction.changepassword()error!", e);
			return "operr_admin";
		}

	}

	// 修改session的用户值
	public String ajax_email() {
		try {

			String mailaddress = WebAppContextUtils.getpara("mailaddress");

			// String newrepeatpassword =
			// WebAppContextUtils.getpara("newrepeatpassword");
			Map sessionMap = ActionContext.getContext().getSession();
			SiteUser currentuser = (SiteUser) sessionMap
					.get(SystemInit.clientloginflag);
			currentuser.setCheckEmail(mailaddress);

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			adao.updateObject(currentuser);

			results.put("ajax_info", "修改成功 ");

			return "ajax_result";
		} catch (Exception e) {
			log.error("Adminaction.changepassword()error!", e);
			return "operr_admin";
		}

	}

	/***************************************************************************
	 * 修改密码操作
	 */

	public String ajax_password() {
		// 取得旧密码，比较是否正取，比较新密码， password_repeat, password_error,password_change
		try {
			String oldpassword = WebAppContextUtils.getpara("oldpassword");
			String newpassword = WebAppContextUtils.getpara("newpassword");
			Map sessionMap = ActionContext.getContext().getSession();
			SiteUser currentuser = (SiteUser) sessionMap
					.get(SystemInit.clientloginflag);
			String currentpassword = currentuser.getPassword();
			if (!oldpassword.equals(currentpassword)) {
				String errorinfo = "密码输入错误！请正确输入当前密码";
				results.put("ajax_info", errorinfo);
				return "ajax_result";
			}
			/*
			 * if (!newpassword.equals(newrepeatpassword)) { String errorinfo =
			 * "新密码两次输入不一致，请重新输入！"; results.put("change_info", errorinfo);
			 * return "password_change_result"; }
			 */
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			currentuser.setPassword(newpassword);
			adao.updateObject(currentuser);
			results.put("ajax_info", "OK,修改成功");
			return "ajax_result";
		} catch (Exception e) {
			log.error("Adminaction.changepassword()error!", e);
			return "operr_admin";
		}

	}

	public String get_username() {
		return get_user().getUsername();
	}

	public SiteUser get_user() {
		Map sessionMap = ActionContext.getContext().getSession();
		SiteUser currentuser = (SiteUser) sessionMap
				.get(SystemInit.clientloginflag);
		return currentuser;
	}

	public String getspmp() {
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		Map sessionMap = ActionContext.getContext().getSession();
		SiteUser currentuser = (SiteUser) sessionMap
				.get(SystemInit.clientloginflag);
		SiteUser siteuser = (SiteUser) adao.loadById("SiteUser",
				currentuser.getId());
		results.put("SiteUser", siteuser);
		return "get_spmp";

	}

	public String del() {
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		Map sessionMap = ActionContext.getContext().getSession();
		SiteUser currentuser = (SiteUser) sessionMap
				.get(SystemInit.clientloginflag);
		SiteUser siteuser = (SiteUser) adao.loadById("SiteUser",
				currentuser.getId());

		// adao.removeObject(clazz, id)
		String beanname = WebAppContextUtils.getpara("beanname");

		Object obj = ApplicationContextFactory.getWebAppContext().getBean(
				beanname);
		adao.removeObject(obj.getClass(),
				new Long(Long.parseLong(WebAppContextUtils.getpara("id"))));

		results.put("SiteUser", siteuser);
		return "get_spmp";

	}

	public String common_getpara(String key) {
		try {
			Map props = ActionContext.getContext().getParameters();
			String[] para = (String[]) props.get(key);
			return para[0];
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * 用户数据更新后，刷新SESSION里面的数据
	 */
	public String refreshUser() {
		try {
			Map sessionMap = ActionContext.getContext().getSession();
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			adao.refreshObject(sessionMap.get(SystemInit.clientloginflag));
			results.put("showsetting", common_getpara("showsetting"));
			// ActionContext.getContext().getSession().put("clientlogined",currentuser);
			return "refreshUser";
		} catch (Exception e) {
			return "unauthenticated.user";
		}
	}

}
