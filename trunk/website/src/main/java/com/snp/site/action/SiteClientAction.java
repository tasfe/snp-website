package com.snp.site.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.snp.common.Dateprocess;
import com.snp.common.I18n;
import com.snp.common.mail.SendMailThead;
import com.snp.site.config.LanmuConfig;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteGuest;
import com.snp.site.model.SitePresource;
import com.snp.site.model.SiteSpmp1;
import com.snp.site.model.SiteSpmp2;
import com.snp.site.model.SiteSpmp3;
import com.snp.site.model.SiteSpmp4;
import com.snp.site.model.SiteSpmp4Item;
import com.snp.site.model.SiteSpmp4Sub;
import com.snp.site.model.SiteSpmp6;
import com.snp.site.model.SiteSpmp9;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.core.common.util.WebAppContextUtils;

public class SiteClientAction extends ActionSupport {
	private static Log log = LogFactory.getLog(SiteClientAction.class);
	private List systemErrors = new ArrayList(3);
	private Map results = new HashMap();

	public Map getResults() {
		return results;
	}

	public SiteUser get_siteuser(String id) {
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		SiteUser siteuser = (SiteUser) adao.loadById("SiteUser",
				Long.parseLong(id));
		return siteuser;
	}

	public void setResults(Map results) {
		this.results = results;
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

	public String guestLeaveword() {
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		SiteUser siteuser = (SiteUser) adao.loadById("SiteUser",
				Long.parseLong(common_getpara("userid")));
		try {
			String strCurrTime = Dateprocess.getTimeStr("yyyy-MM-dd hh:mm:ss");
			String title = "网站咨询";
			SendMailThead.sendmail(title, common_getpara("guest_email") + "："
					+ common_getpara("guest_leaveword") + "<br>"
					+ "<br>Time</b>：" + strCurrTime, siteuser.getCheckEmail(),
					null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(SystemInit.get_info_title() + siteuser.getUsername()
				+ "的访客EMAIL留言：  " + common_getpara("guest_leaveword"));
		ActionContext.getContext().getSession()
				.put("guest_eamil", common_getpara("guest_eamil"));
		return "site_guest_leaveword";
	}

	// 用户留言提交，得到guest对象，该对象要返回，因为出错了，还可以返回原先数据
	public String siteGuestSubmit() {
		String username = "";

		try {
			HttpServletRequest requestServelt = ServletActionContext
					.getRequest();

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			SiteUser siteuser = (SiteUser) get_siteuser(common_getpara("siteuserid"));
			SiteGuest siteguest = new SiteGuest();
			siteguest.setLeaveword(common_getpara("leaveword_lanmu"));
			siteguest.setName(common_getpara("name_lanmu"));
			siteguest.setIp(requestServelt.getRemoteAddr());
			username = siteuser.getUsername();
			String strCurrTime = Dateprocess.getTimeStr("yyyy-MM-dd hh:mm:ss");
			siteguest.setWordtime(strCurrTime);
			siteguest.setSiteUser(siteuser);
			adao.saveObject(siteguest);
			results.put("ajax_info", "ok,sucess 留言成功.");
		} catch (Exception e) {
			log.error(SystemInit.getHttpString(), e);
			return "operr_client";
		}
		return "ajax_result";
		// return "site_guest_submit";
	}

	public String siteExtLink() {

		try {

			String linkid = common_getpara("id");

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			// 加载SPMP9
			java.lang.Object obj = ApplicationContextFactory.getWebAppContext()
					.getBean("SiteSpmp9");
			SiteSpmp9 siteSpmp9 = (SiteSpmp9) adao.getObject(obj.getClass(),
					new Long(linkid));
			results.put("extlink", siteSpmp9.getSiteSpmp9Items());

			results.put("language", common_getpara("language"));
			results.put("local", common_getpara("local"));
			results.put("infomap", new I18n());
			return "site_ext_link";
		} catch (Exception e) {

			log.error(SystemInit.getHttpString(), e);
			String content = SystemInit.getHttpString() + "\n 异常信息：\n"
					+ ExceptionUtils.getFullStackTrace(e);
			SendMailThead.sendmail("ext_linkerror", content,
					SystemInit.mail_error, null);

			return "operr_client";
		}

	}

	public void common_detail(String username) throws Exception {
		LanmuConfig lanmuObject = SystemInit.getLanmuObjectFromXml(SystemInit
				.getSiteHome() + username + "/" + SystemInit.LanmuConfFileName);
		results.put("LanmuObject", lanmuObject);
		results.put("language", common_getpara("language"));
		results.put("local", common_getpara("local"));
		results.put("infomap", new I18n());
		results.put("username", username);
		// results.put("fullscreen", common_getpara("fullscreen"));
		results.put("lanmuname", common_getpara("lanmuname"));

	}

	public String siteSpmp9Detail() {
		try {
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteSpmp9 spmp = (SiteSpmp9) adao.loadById("SiteSpmp9",
					Long.parseLong(common_getpara("id")));
			String username = spmp.getSiteUser().getUsername();
			results.put("SiteSpmp", spmp);
			results.put("SiteUser", spmp.getSiteUser());
			common_detail(username);
			return "site_spmp9_detail";
		} catch (Exception e) {
			log.error(e);
			return "operr_client";
		}
	}

	public String siteSpmp1Detail() {
		try {

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteSpmp1 spmp = (SiteSpmp1) adao.loadById("SiteSpmp1",
					Long.parseLong(common_getpara("id")));
			String username = spmp.getSiteUser().getUsername();
			results.put("SiteSpmp", spmp);
			results.put("language", common_getpara("language"));
			results.put("SiteUser", spmp.getSiteUser());
			common_detail(username);

			return "site_spmp1_detail";
		} catch (Exception e) {
			log.error(e);
			return "operr_client";
		}
	}

	public String siteSpmp2Detail() {
		try {

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			SiteSpmp2 spmp = (SiteSpmp2) adao.loadById("SiteSpmp2",
					Long.parseLong(common_getpara("id")));
			String username = spmp.getSiteUser().getUsername();
			results.put("language", common_getpara("language"));
			results.put("SiteSpmp", spmp);
			results.put("SiteUser", spmp.getSiteUser());
			common_detail(username);

			return "site_spmp2_detail";
		} catch (Exception e) {
			log.error(e);
			return "operr_client";
		}
	}

	public String siteSpmp3Detail() {
		try {

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			SiteSpmp3 spmp = (SiteSpmp3) adao.loadById("SiteSpmp3",
					Long.parseLong(common_getpara("id")));
			String username = spmp.getSiteUser().getUsername();
			results.put("language", common_getpara("language"));
			results.put("SiteSpmp", spmp);
			results.put("SiteUser", spmp.getSiteUser());
			common_detail(username);

			return "site_spmp3_detail";
		} catch (Exception e) {
			log.error(e);
			return "operr_client";
		}
	}

	public String siteSpmp6Detail() {
		try {

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");

			SiteSpmp6 spmp = (SiteSpmp6) adao.loadById("SiteSpmp6",
					Long.parseLong(common_getpara("id")));
			String username = spmp.getSiteUser().getUsername();
			results.put("language", common_getpara("language"));
			results.put("SiteSpmp", spmp);
			results.put("SiteUser", spmp.getSiteUser());
			common_detail(username);

			return "site_spmp6_detail";
		} catch (Exception e) {
			log.error(e);
			return "operr_client";
		}
	}

	public String siteSpmp5Export() {
		String username = "";
		try {
			String lanmuname = common_getpara("lanmuname");
			username = common_getpara("username");
			results.put("lanmuname", lanmuname);
			results.put("language", WebAppContextUtils.getpara("language"));
			results.put("local", WebAppContextUtils.getpara("local"));
			common_detail(username);
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteUser siteUser = (SiteUser) adao.loadById("SiteUser",
					Long.parseLong(common_getpara("id")));
			results.put("SiteUser", siteUser);
			results.put("infomap", new I18n());
			return "site_spmp5_export";
		} catch (Exception e) {
			String title = SystemInit.getTitle("|站点：顶部栏目链接点击错误:用户", username);
			String content = SystemInit.getHttpString() + "\n 异常信息：\n"
					+ ExceptionUtils.getFullStackTrace(e);
			SendMailThead.sendmail(title, content, SystemInit.mail_error, null);

			systemErrors.add(e);
			log.error(title + SystemInit.getHttpString(), e); // 如果邮件统治方式成功稳定的话的话，基本不需要打印此日志了
			return "operr_client";

		}

	}

	/*
	 * 根据多图列表的类别id,得到此类别的所有图片对象集合
	 */
	public String siteSpmp4Detail() {
		String username = "";

		try {
			String subid = common_getpara("subid");
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteSpmp4 spmp = (SiteSpmp4) adao.loadById("SiteSpmp4",
					Long.parseLong(common_getpara("id")));
			username = spmp.getSiteUser().getUsername();
			results.put("SiteSpmp", spmp);
			results.put("subid", subid);
			if (!common_getpara("subid").equals("")) {
				SiteSpmp4Sub siteSpmp4Sub = (SiteSpmp4Sub) adao
						.loadById("SiteSpmp4Sub",
								Long.parseLong(common_getpara("subid")));
				results.put("subitem", siteSpmp4Sub);
			}
			results.put("SiteUser", spmp.getSiteUser());
			common_detail(username);
			return "site_spmp4_detail";
		} catch (Exception e) {
			log.error(SystemInit.getHttpString(), e);
			systemErrors.add(e);
			return "operr_client";

		}

	}

	public String showall() {
		String userid = common_getpara("userid");
		String username = "";
		try {
			SiteUser siteuser = get_siteuser(userid);
			results.put("items", siteuser.getImgList());
			results.put("videolist", siteuser.getVideoList());
			siteuser.getSiteSpmp4s();
			results.put("videodisplay", false);
			if (siteuser.getSiteSpmp8s().size() > 0) {

				results.put("videodisplay", true);
			}
			for (Iterator iterator = siteuser.getSiteSpmp4s().iterator(); iterator
					.hasNext();) {
				SiteSpmp4 siteSpmp4 = (SiteSpmp4) iterator.next();
				results.put("id", siteSpmp4.getId());
				break;
			}
			common_detail(siteuser.getUsername());

			return "site_show_all";
		} catch (Exception e) {

			log.error(SystemInit.getHttpString(), e);

			systemErrors.add(e);
			return "operr_client";

		}
	}

	public String show() {

		String username = "";
		try {
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteSpmp4 spmp = (SiteSpmp4) adao.loadById("SiteSpmp4",
					Long.parseLong(common_getpara("id")));
			username = spmp.getSiteUser().getUsername();

			results.put("SiteSpmp", spmp);
			String subid = common_getpara("subid");
			results.put("subid", subid);
			results.put("show", common_getpara("show"));

			if (!common_getpara("subid").equals("")) {

				SiteSpmp4Sub siteSpmp4Sub = (SiteSpmp4Sub) adao
						.loadById("SiteSpmp4Sub",
								Long.parseLong(common_getpara("subid")));
				results.put("subitem", siteSpmp4Sub);
			}
			common_detail(username);
			return "site_show";
		} catch (Exception e) {
			log.error(SystemInit.getHttpString(), e);
			systemErrors.add(e);
			return "operr_client";

		}

	}

	public String siteSpmp4Export() {
		String username = "";
		try {
			String spmp4id = common_getpara("id");
			java.lang.Object obj = ApplicationContextFactory.getWebAppContext()
					.getBean("SiteSpmp4");
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteSpmp4 siteSpmp4 = (SiteSpmp4) adao.getObject(obj.getClass(),
					new Long(spmp4id));
			username = siteSpmp4.getSiteUser().getUsername();
			results.put("SiteSpmp4", siteSpmp4);
			results.put("subid", common_getpara("subid"));
			common_detail(username);
			return "site_spmp4_export";
		} catch (Exception e) {
			String title = SystemInit.getTitle("|siteSpmp4export:用户", username);
			log.error(title + SystemInit.getHttpString(), e);
			String content = SystemInit.getHttpString() + "\n 异常信息：\n"
					+ ExceptionUtils.getFullStackTrace(e);
			SendMailThead.sendmail(title, content, SystemInit.mail_error, null);

			systemErrors.add(e);
			return "operr_client";

		}

	}

	public String sitePicture() {
		results.put("language", common_getpara("language"));
		results.put("local", common_getpara("local"));
		results.put("id", common_getpara("id"));
		results.put("", common_getpara("id"));

		// 如果ITEM的MEMBER是YES，切SESSION没有登陆，则错

		return "site_picture";
	}

	public String siteSpmp4byid() {
		String id = common_getpara("id");
		java.lang.Object obj = ApplicationContextFactory.getWebAppContext()
				.getBean("SiteSpmp4");
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		SiteSpmp4 siteSpmp4 = (SiteSpmp4) adao.getObject(obj.getClass(),
				new Long(id));
		results.put("language", common_getpara("language"));
		results.put("local", common_getpara("local"));
		results.put("siteSpmp4", siteSpmp4);

		return "site_spmp4byid";
	}

	public String siteSpmp4move() {
		String id = common_getpara("id");
		java.lang.Object obj = ApplicationContextFactory.getWebAppContext()
				.getBean("SiteSpmp4Item");
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) adao.getObject(
				obj.getClass(), new Long(id));

		results.put("language", common_getpara("language"));
		results.put("local", common_getpara("local"));
		results.put("id", id);
		results.put("siteSpmp4Item", siteSpmp4Item);

		return "site_spmp4move";
	}

	// 缩图的详细内容，模型版里面带了该文件

	public String siteSpmp4ItemDetail() {
		String username = "";
		try {
			String id = common_getpara("id");

			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) adao.loadById(
					"SiteSpmp4Item", Long.parseLong(common_getpara("id")));

			username = siteSpmp4Item.getSiteSpmp4().getSiteUser().getUsername();
			LanmuConfig lanmuObject = SystemInit
					.getLanmuObjectFromXml(SystemInit.getSiteHome() + username
							+ "/" + SystemInit.LanmuConfFileName);
			results.put("LanmuObject", lanmuObject);
			results.put("siteSpmp4Item", siteSpmp4Item);
			results.put("language", common_getpara("language"));
			results.put("local", common_getpara("local"));
			results.put("username", username);
			results.put("infomap", new I18n());

			String op = common_getpara("op");
			if (op.equals("show")) {
				return "site_spmp4item_detail_show";
			}
			return "site_spmp4item_detail";
		} catch (Exception e) {
			String title = SystemInit.getTitle(
					"|siteSpmp4ItemDetail缩略图详细打开错误:用户", username);
			log.error(title + SystemInit.getHttpString(), e);
			String content = SystemInit.getHttpString() + "\n 异常信息：\n"
					+ ExceptionUtils.getFullStackTrace(e);
			SendMailThead.sendmail(title, content, SystemInit.mail_error, null);

			systemErrors.add(e);
			return "operr_client";

		}

	}

	public String version() {
		results.put("version", SystemInit.snp_version + "|"
				+ SystemInit.other_version);
		return ("version");
	}

	public String execute() throws Exception {

		return Action.SUCCESS;
	}

	public List getSystemErrors() {
		return systemErrors;
	}

	public void setSystemErrors(List systemErrors) {
		this.systemErrors = systemErrors;
	}

	/* 资源管理放在这里的原因是eidt的弹出窗体是没有SESSION的 */
	public String private_res() {

		String filetype = WebAppContextUtils.getpara("filetype");
		String userid = WebAppContextUtils.getpara("userid");

		String username = "";
		try {

			SiteUser siteuser = (SiteUser) SystemInit.getObjectById("SiteUser", // adao.getObject没有问题
					userid);
			username = siteuser.getUsername();
			ArrayList reslist = new ArrayList();
			for (Iterator iter = siteuser.getSitePresources().iterator(); iter
					.hasNext();) {
				SitePresource element = (SitePresource) iter.next();
				if (element.getFiletype().equals(filetype)) {
					reslist.add(element);
				}
			}
			// log.debug("资源个数" + reslist.size());
			results.put("res", reslist);
			return "private_res";
		} catch (Exception e) {
			String title = SystemInit.getTitle("|私人资源错误:用户", username);
			log.error(title + SystemInit.getHttpString(), e);
			String content = SystemInit.getHttpString() + "\n 异常信息：\n"
					+ ExceptionUtils.getFullStackTrace(e);
			log.error(title + SystemInit.getHttpString(), e);
			SendMailThead.sendmail(title, content, SystemInit.mail_error, null);

			return "operr_client";
		}

	}

	// 首页登陆时选择语言版本
	public String chang_admin_lang() {
		// 如果是第一次，langString=first,则根据，问题是，不一定有我们已经有的语言，所以需要一个MAP
		String langString = WebAppContextUtils.getpara("lang");
		if (langString.equals("first")) { // 如果不是第一次，认证错误了的话
			HttpServletRequest requestServelt = ServletActionContext
					.getRequest();
			// zh-cn,zh;q=0.5 FIREFOX又有所不同了,IE是zh-cn
			langString = requestServelt.getHeader("Accept-Language").split(",")[0]
					.toLowerCase();
			// 去后台判断是否需要显示
			HashMap languageMap = SystemInit.getLanguage();
			if (!languageMap.containsKey(langString)) {
				langString = "en";
			}
		}
		// 如果不是第一次，还有用户名密码
		Map sessionMap = ActionContext.getContext().getSession();
		sessionMap.put("lang", "zh-cn");
		sessionMap.put("snpinfo", new I18n());

		results.put("validateImage", SystemInit.validate_image);

		results.put("username", WebAppContextUtils.getpara("username"));
		results.put("from", WebAppContextUtils.getpara("from"));
		return "chang_login_lang"; // login.ftl
	}

}
