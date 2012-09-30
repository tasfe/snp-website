package com.snp.site.init;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.impl.DefaultFtpServer;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork.ActionContext;
import com.snp.common.StringSourceFrom;
import com.snp.common.datasource.DataBaseConfig;
import com.snp.common.freemarker.FreemarkProcessor;
import com.snp.common.regex.GetObject;
import com.snp.site.config.IpObject;
import com.snp.site.config.LanmuConfig;
import com.snp.site.config.UrlConfig;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;

public class SystemInit {
	private static Log log = LogFactory.getLog(SystemInit.class);
	public static String snp_compiletime = "2010-11-26";
	public static String snp_version = "8.6";
	public static String snp_qq = "870133482";
	public static String snp_websiteurl = "http://www.snpsoft.net";
	public static String snp_email = "snpsoft@qq.com";
	public static String snp_max_user = "2";

	public static String snp_user_test = "T";
	public static String snp_user_demo = "D";
	public static String snp_user_client = "C";
	public static int snp_mas_testday = 5;
	public static boolean stop = false;
	public static String snp_update_url = "http://www.snpsoft.net/update/";
	public static String snp_url_public = "http://www.snpsoft.net/public/";
	public static String snp_versininfo_url = "http://www.snpsoft.net/site!version.action";

	public static String other_version = "1.0";
	public static String img_spmp4_width = "600";
	public static String img_spmp4_height = "400";

	public static String img_spmp4_sm_width = "165";
	public static String img_spmp4_sm_height = "170";
	public static String img_spmp8_width = "70";
	public static String img_spmp8_height = "50";
	public static String video_init_width = "250";// 上传转化视频默认SIZE
	public static String video_init_height = "150";

	public static String img_support_format = "gif|jpg|ico|png|bmp";
	public static String video_support_format = "flv";// mp3|flv|avi|mov|mpg|3gp|wmv|mp4|asf|asx
	// public static String url_public =
	// "http://www.snpsoft.net/public/index.html";

	public final static String clientloginflag = "clientlogined";
	public final static String otheruserlist = "otheruserlist";
	public final static String clientuserloginflag = "sitesuser";
	public final static String workerloginflag = "sitesworker";
	public final static String cookieuserid = "userid";
	public static boolean flag_init_adodata = false;
	public static String LanmuConfFileName = "LanmuConfig.xml"; // 客户登陆是加载这个文件
	public static DataBaseConfig SystemDbObject;
	public static boolean debug_junit = false;
	public static HashMap siteStrMap = new HashMap(); // 网站的多国语言MAP
	public static HashMap snpStrMap = new HashMap(); // 后台的多国语言配置，全部加载到一个文件中
	// public static HashMap languageMap = new HashMap();

	public static String mail_ansong = "";
	public static String validate_image = "";
	public static String mail_error = "";
	public static List siteEmailconf;
	// public static UpdateConfig updateconfig;
	public static HashMap ipmap = new HashMap();;
	public static HashMap urlmap; // 初始 用户名作为KEY，用户的IP是值，通过，URL参数传近来
	public static String domainname = "";
	public static String ipfile = "conf/ip/ipdata.dat";
	public static DefaultFtpServer serverFtp = null;

	// map_language_title.ftl 文件是app的
	public static String get_info_title() {

		try {
			return "";
			/*
			 * HttpServletRequest requestServelt = ServletActionContext
			 * .getRequest(); return
			 * "IP "+requestServelt.getRemoteAddr()+Dateprocess
			 * .getTimeStr(" [yyyy年MM月dd日hh时mm分ss秒] "
			 * )+IPSeeker.getInstance().getAddress
			 * (requestServelt.getRemoteAddr());
			 */
		} catch (Exception e) {

			return "*";
		}
	}

	public static HashMap getLanguage() {
		HashMap languageMap = new HashMap();
		String filename = "webroot/website/macro/map_language_title.ftl";
		try {
			String src = StringSourceFrom.getformfile(filename);
			src = src.replaceAll("\r", "");
			src = src.replaceAll("\n", "");
			String strvarreg = "1;2;3;4;5;6;7;8;";
			String strReg = "\"(.*?)\":\"(.*?)\"";
			List rslList = FreemarkProcessor.getlistbyPerl(src, strReg,
					strvarreg);
			for (Iterator iter = rslList.iterator(); iter.hasNext();) {
				GetObject element = (GetObject) iter.next();
				languageMap.put(element.a0, element.a1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return languageMap;

	}

	public static File[] get_video_filelist(File file) {
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) { // 可接受的文件类型
				String name = file.getName().toLowerCase(); // 获取文件名
				String[] format = StringUtils.split(video_support_format, "|");
				for (int i = 0; i < format.length; i++) {
					if (name.endsWith(format[i])) {
						return true;
					}
				}
				return false;
			}
		};
		return file.listFiles(fileFilter);
	}

	public static File[] get_pic_filelist(File file) {
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) { // 可接受的文件类型
				String name = file.getName().toLowerCase(); // 获取文件名
				String[] format = StringUtils.split(img_support_format, "|");
				for (int i = 0; i < format.length; i++) {
					if (name.endsWith(format[i])) {
						return true;
					}
				}
				return false;
				/*
				 * return name.endsWith(".jpg") ||name.endsWith(".gif")
				 * ||name.endsWith(".png") ||name.endsWith(".ico")
				 * ||name.endsWith(".bmp") ;
				 */
			}
		};
		return file.listFiles(fileFilter);
	}

	public static String getConfigRoot() {
		return System.getProperty("configpath", "conf/");
	}

	public static String getDatabaseCongfile() {
		return getConfigRoot() + "database/"
				+ System.getProperty("database", "DataBaseConfig.xml");
	}

	public static String getEmailConfigpath() throws Exception {
		return getConfigRoot() + "smtp/email_config.xml";
	}

	public static String getMemberConfigpath() throws Exception {
		return getConfigRoot() + "member/member_config.xml";
	}

	public static String getUrlmapConfigpath() throws Exception {
		return getConfigRoot() + "urlmap/UrlConfig.xml";
	}

	public static String getIpmapConfigpath() throws Exception {
		return getConfigRoot() + "ipmap/ipconfig.xml";
	}

	public static String getLicensepath() throws Exception {
		return getConfigRoot() + "license/";
	}

	public static String getSiteUserDocPath() throws Exception {
		return getConfigRoot() + "userdoc/";
	}

	public static String getHtmlTemplatePath() {
		return getWebroot() + "sitetemplateweb/";
	}

	public static String getJettyConfig() {
		return getConfigRoot() + "jetty/config.xml";
	}

	public static String getUserLogpath() {
		return "logs/";
	}

	/*
	 * 这样可能可以省一个参数 WebRoot =
	 * StringUtils.replace(sce.getServletContext().getRealPath( "/"), "\\", "/")
	 * + "/";// 得到web应用的根路径这里是绝对路径了，这样的话，我们程序是否可以不用管的
	 */
	public static String getWebroot() {
		return System.getProperty("webroot", "webroot/");
	}

	public static String getSiteHome() {

		return getWebroot() + "site/";

	}

	public static String getClassPath() {
		return getWebroot() + "WEB-INF/classes/";
	}

	public static String getRespath() {
		return getWebroot() + "resself/";
	}

	public static String getUserDatapath() {
		return getWebroot() + "bak/";
	}

	/**
	 * 根据文件后缀解吸 拆分等号的字符串，作为公共函数提取出来, 我们在实现直接用页面编辑多国语言的时候有用到 siteStrMap =
	 * FileProcessor.getMapFromePropFile(getConfigRoot() + "lang",
	 * "properties"); snpStrMap =
	 * FileProcessor.getMapFromePropFile(getConfigRoot() + "lang", "txt");
	 * 初试化MAP有用到
	 */
	public static HashMap getMapFromePropFile(String filepath, String file_dx)
			throws Exception {
		try {
			HashMap MapData = new HashMap();
			String[] extensions = { file_dx };
			Collection files = FileUtils.listFiles(new File(filepath),
					extensions, false);
			for (Iterator iter = files.iterator(); iter.hasNext();) {
				File element = (File) iter.next();
				String filename = StringUtils.substringBefore(
						element.getName(), ".").toLowerCase();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(element), "utf-8"));
				String strvalue = "";
				while (strvalue != null) {
					strvalue = br.readLine();
					String[] mapValue = StringUtils.split(strvalue, "=");
					if (mapValue != null && mapValue.length > 1) {
						MapData.put(filename + "_" + mapValue[0].trim(),
								StringUtils.trim(mapValue[1]));
					}
				}

			}
			return MapData;
		} catch (Exception e) {
			throw e;
		}

	}

	// 被SystemRobotListener调用
	public static void initSystemStaitcData(ServletContextEvent sce) {
		try {
			// siteStrMap = getMapFromePropFile(getClassPath() + "/lang",
			// "txt");
			// snpStrMap = getMapFromePropFile(getClassPath() + "/lang", "txt");
			FtpServer ftpserver = null;
			String config = "conf/ftp/conf/ftpd-typical.xml";
			FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
					config);
			String[] beanNames = ctx.getBeanNamesForType(FtpServer.class);
			ftpserver = (FtpServer) ctx.getBean(beanNames[0]);
			ftpserver.start();
			DefaultFtpServer defaultFtpServer = (DefaultFtpServer) ftpserver;
			System.out.println(defaultFtpServer);
			// PropertiesUserManager propertiesUserManager =
			// (PropertiesUserManager) defaultFtpServer.getUserManager();
			SystemInit.serverFtp = defaultFtpServer;
		} catch (Exception e) {
			log.error("出始化路径错误", e);
		}
	}

	/* 本方法得到一个对象根据ID和PO名字 */
	public static Object getObjectById(String poname, String id) {
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		Object obj = ApplicationContextFactory.getWebAppContext().getBean(
				poname);
		try {

			Object objbyid = adao.getObject(obj.getClass(), new Long(id));
			return objbyid;
		} catch (Exception e) {
			return null; // TODO: handle exception
		}

	}

	public static String getStoredPassword(String useranme) {
		try {
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getFileAppContext().getBean("advanceDAO");
			String sql = "select o from com.snp.site.model.SiteUser o where o.username='"
					+ useranme + "'";
			List ls = adao.find(sql);
			if (ls.equals(null) || ls.size() == 0) {
				return null;
			}
			SiteUser siteUser = (SiteUser) ls.get(0);
			return siteUser.getPassword();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static ArrayList otheruserlist(SiteUser siteuser) {

		ArrayList otheruserlist = new ArrayList();
		if ((siteuser.getOtherusername() != null)
				&& (!siteuser.getOtherusername().equalsIgnoreCase(""))) {
			String strUserList = siteuser.getOtherusername();
			String[] usernamearray = strUserList.split(",");
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			if (usernamearray.length > 0) {
				for (int i = 0; i < usernamearray.length; i++) {
					if (!siteuser.getUsername().equals(usernamearray[i])) {
						String sql = "select o from com.snp.site.model.SiteUser o where o.username='"
								+ usernamearray[i] + "'";
						List ls = adao.find(sql);
						for (Iterator iter = ls.iterator(); iter.hasNext();) {
							SiteUser element = (SiteUser) iter.next();
							otheruserlist.add(element);
						}

					}
				}
			}

		}
		return otheruserlist;
	}

	public static void initUrlmap() {
		XMLDecoder xmlDecoder;
		try {
			xmlDecoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(getUrlmapConfigpath())));
			UrlConfig urlconfig = (UrlConfig) xmlDecoder.readObject();
			urlmap = urlconfig.getUrlmap();

		} catch (Exception e) {
			log.debug("email urlmap config file doest not exit!");

		}
	}

	public static String urljump(String url, String name) {
		if (urlmap == null) {
			log.debug("第一次初始化initUrlmap()");
			initUrlmap();
		}
		for (Iterator i = urlmap.entrySet().iterator(); i.hasNext();) {
			Map.Entry e = (Map.Entry) i.next();
			// log.debug(e.getKey() + "="+e.getValue());
			if (url.indexOf(e.getValue().toString()) >= 0) {
				log.debug("配置域名" + e.getKey() + "-" + e.getValue());
				return "/site/" + e.getKey().toString();
			}
		}
		if (url.indexOf("www.snpsoft") >= 0)
			return ("/site/snp");// 这个一定要放到最后,禁止非法地域名访问
		return "/site/" + name;
	}

	public static String ipjump(String name) {
		IpObject ipObject = (IpObject) ipmap.get(name);
		return ipObject.getIp() + ipObject.getPort() + "/site/"
				+ ipObject.getSiteusername();
	}

	public static void ipchange(String name, String ip, String port,
			String siteusername) {
		IpObject ipObject = new IpObject();
		ipObject.setIp(ip);
		ipObject.setName(name);
		ipObject.setPort(port);
		ipObject.setSiteusername(siteusername);
		ipmap.put(ipObject.getName(), ipObject);
		log.debug("ip地址已经更换！");

	}

	public static void initIpmap() {

	}

	/**
	 * 因为如果WEB直接调用此方法的化会有问题，导致CTX是从文件初始化建立，所以SESSION直接关闭 会导致懒加载问题
	 * 本函数主要出使化一些数据库中的数据，比方邮件列表信息
	 */
	public static void initEmail() {

	}

	/** demo模式 是根据文件名来取数据源对象 */
	static public DataBaseConfig getObjectDemo(String xmlObjectString)
			throws FileNotFoundException, IOException {

		// 判断培植文件是否存在，
		// 1.存在就直接取到
		XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
				new FileInputStream(xmlObjectString)));
		DataBaseConfig objectDemo = (DataBaseConfig) xmlDecoder.readObject();
		xmlDecoder.close();
		/*
		 * 2.不存在就说明是产品模式,所以开发产品模式的时候只要删除掉配置文件就可以了，我要一个函数检查文件是否存在等
		 * 需要求一个目录下所有的DEMO打头的文件个数，并且解析，不如全部用XML来保存DEMO的描述文件
		 */
		return objectDemo;
	}

	/**
	 * 从XML构造用户的菜单文件， 在模目录下有一个默认的，第一次登陆会从模版出加载，然后写入用户目录
	 * 
	 */
	static public LanmuConfig getLanmuObjectFromXml(String xmlObjectString)
			throws Exception {
		try {

			XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(xmlObjectString)));
			LanmuConfig lanmuObject = (LanmuConfig) xmlDecoder.readObject();
			xmlDecoder.close();
			if (lanmuObject == null)
				throw new Exception();
			return lanmuObject;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * 错误异常时有用：本方法得到HTTP请求的所有参数，作为一个字符串返回 通过HTTP请求参数MAP取得参数字符串，文件类型跳过
	 * 在异常的时候，发送到邮件时需要使用到此函数
	 */
	public static String getHttpString() {
		try {
			Map map = ActionContext.getContext().getParameters();
			String junitPara = "";
			List l = new LinkedList();
			for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
				Map.Entry e = (Map.Entry) i.next();
				String key = (String) e.getKey();
				l.add(key);
			}
			Collections.sort(l);
			for (int i = 0; i < l.size(); i++) {
				if (map.get(l.get(i)).getClass().getName()
						.equals("[Ljava.io.File;"))
					continue;
				String[] value = (String[]) map.get(l.get(i));
				for (int j = 0; j < value.length; j++) {
					junitPara = junitPara
							+ "\n                                           &"
							+ l.get(i) + "=" + value[j];
				}
			}
			String temp = "<br>HTTP REQUEST PARAMETER:" + junitPara;
			return temp;
		} catch (Exception e) {
			return "Geting http para error!";
		}
	}

	/**
	 * 返回异常记录日志时的作为邮件标题的字符串内容
	 */
	public static String getTitle(String detail, String username) {
		return detail + username // + SystemInit.getip()
		;
	}

}
