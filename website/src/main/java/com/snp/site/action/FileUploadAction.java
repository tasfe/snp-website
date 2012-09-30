package com.snp.site.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.util.BeanUtils;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.snp.common.ImageProcessor;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteProduct;
import com.snp.site.model.SiteSpmp4;
import com.snp.site.model.SiteSpmp4Item;
import com.snp.site.model.SiteSpmp5;
import com.snp.site.model.SiteSpmp5Item;
import com.snp.site.model.SiteSpmp7;
import com.snp.site.model.SiteSpmp7Item;
import com.snp.site.model.SiteSpmp8;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.core.common.util.WebAppContextUtils;

/**
 * 1.20100601 通过 commonupload结合serverlet实验成功
 * 2.但是webwork2却没有公共，原来WEBWORK自动处理，加入了拦截器的 <action name="site"
 * class="com.snp.site.action.SiteClientAction"> <interceptor-ref
 * name="fileUpload"/> 修改webwork.properties， 注释了这句OK了
 * #webwork.multipart.parser=com
 * .opensymphony.webwork.dispatcher.multipart.PellMultiPartRequest
 * 但是导致之前正常的使用就有问题了，除非有一种比较好的方式把之前的文件上传的部分全部处理掉 拦截器把文件放入了fildata
 * 3.通过研究SUP是怎么取得处理后的文件的，我们打印出所有的参数，发现SWF经处理后，变成 swf提交的3个参数经过webwork处理后，变成了下面3个
 * for (Iterator iterator =
 * ServletActionContext.getContext().getParameters().keySet().iterator();
 * iterator.hasNext();) { String key = (String ) iterator.next();
 * log.debug(key); log.debug(ServletActionContext.getContext().
 * getParameters().get(key)); }
 * 
 * FiledataFileName [Ljava.lang.String;@16ff8e7 FiledataContentType
 * [Ljava.lang.String;@3e4500 Filedata [Ljava.io.File;@243e9f Filename
 * 
 * 遇到一个很大的麻烦： webwork中的文件上传拦截器，运行时是在 认证拦截器之前的，所以 1.拦截器在验证前运行，我继承写一个也是在上传了之后才运行的
 * 2.到底当浏览器发请求到服务器上，是谁在处理呢 存在一些安全隐患，就是用户可以知道这个URL然后不断上传东西进来，我只能业务上做删除
 * 也许用SEVLET处理是可以的避免上传后的再处理的，但要研究一下
 */
public class FileUploadAction extends ActionSupport {
	private static Log log = LogFactory.getLog(FileUploadAction.class);

	public String get_username() {
		return WebAppContextUtils.getpara("sitename");
		// return get_user().getUsername();
	}

	/*
	 * firefox等取不出来 public SiteUser get_user() { Map sessionMap =
	 * ActionContext.getContext().getSession(); SiteUser currentuser =
	 * (SiteUser) sessionMap .get(SystemInit.clientloginflag); return
	 * currentuser; }
	 */
	public String filespmp4() throws Exception {
		String username = get_username();
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		String id = WebAppContextUtils.getpara("id");
		SiteSpmp4 siteSpmp4 = (SiteSpmp4) adao.loadById("SiteSpmp4", new Long(
				id));
		File[] files = (File[]) ServletActionContext.getContext()
				.getParameters().get("Filedata");
		for (int i = 0; i < files.length; i++) {
			String houzhui = StringUtils.substringAfterLast(files[i].getName(),
					".");
			String newfilename = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			String smallFileName = newfilename + "_sm." + houzhui;
			newfilename = newfilename + "." + houzhui;
			String path = SystemInit.getSiteHome() + username + "/";
			String destfile = SystemInit.getWebroot() + "site" + path;
			FileUtils.copyFile(files[i], new File(path + newfilename));
			// 压缩小图片，要判断是什么什么格式的
			FileUtils.copyFile(files[i], new File(path + smallFileName));
			ImageProcessor.resize(files[i], path + smallFileName,
					Integer.parseInt(SystemInit.img_spmp4_sm_height),
					Integer.parseInt(SystemInit.img_spmp4_sm_width), true);
			SiteSpmp4Item siteSpmp4Item = new SiteSpmp4Item();
			siteSpmp4Item.setFilepath(newfilename);
			siteSpmp4Item.setFilename(files[i].getName());
			siteSpmp4Item.setTitle(StringUtils.substringBefore(
					files[i].getName(), "."));
			siteSpmp4Item.setSiteSpmp4(siteSpmp4);
			adao.saveObject(siteSpmp4Item);

			BeanUtils.setValue(siteSpmp4Item, "sortstr",
					BeanUtils.getValue(siteSpmp4Item, "id").toString());
			adao.updateObject(siteSpmp4Item);
			files[i].delete();
		}
		return "ok";
	}

	public String filespmp4item() throws Exception {
		String username = get_username();
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		String id = WebAppContextUtils.getpara("id");
		SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) adao.loadById(
				"SiteSpmp4Item", new Long(id));
		File[] files = (File[]) ServletActionContext.getContext()
				.getParameters().get("Filedata");
		for (int i = 0; i < files.length; i++) {
			String houzhui = StringUtils.substringAfterLast(files[i].getName(),
					".");
			String newfilename = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			newfilename = newfilename + "." + houzhui;
			String path = SystemInit.getSiteHome() + username + "/";
			FileUtils.copyFile(files[i], new File(path + newfilename));

			SiteProduct siteProduct = new SiteProduct();
			siteProduct.setFilepath(newfilename);

			siteProduct.setSiteSpmp4Item(siteSpmp4Item);

			adao.saveObject(siteProduct);

			BeanUtils.setValue(siteProduct, "sortstr",
					BeanUtils.getValue(siteProduct, "id").toString());
			adao.updateObject(siteProduct);
			files[i].delete();
		}
		return "ok";
	}

	public String filespmp8() throws Exception {
		String username = get_username();
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		File[] files = (File[]) ServletActionContext.getContext()
				.getParameters().get("Filedata");
		for (int i = 0; i < files.length; i++) {
			String houzhui = StringUtils.substringAfterLast(files[i].getName(),
					".");
			String newfilename = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());

			String savefilename = newfilename + ".flv";
			newfilename = newfilename + "." + houzhui;
			String path = SystemInit.getSiteHome() + username + "/";
			String cmdString = null;
			if (houzhui.equalsIgnoreCase("flv")) {
				FileUtils.copyFile(files[i], new File(path + newfilename));
			} else {

			}

			SiteSpmp8 siteSpmp8 = new SiteSpmp8();
			siteSpmp8.setName(files[i].getName());
			siteSpmp8.setDetail(files[i].getName());
			siteSpmp8.setFilename(files[i].getName());
			siteSpmp8.setFilepath(savefilename);
			log.debug("文件名：" + files[i].getName() + siteSpmp8.getName());
			SiteUser siteUser = (SiteUser) adao.loadById("SiteUser", new Long(
					WebAppContextUtils.getpara("id")));

			siteSpmp8.setSiteUser(siteUser);
			adao.saveObject(siteSpmp8);

			BeanUtils.setValue(siteSpmp8, "sortstr",
					BeanUtils.getValue(siteSpmp8, "id").toString());
			adao.updateObject(siteSpmp8);

			files[i].delete();
		}
		return "ok";
	}

	public String filespmp5() throws Exception {
		String username = get_username();
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		String id = WebAppContextUtils.getpara("id");
		SiteSpmp5 siteSpmp5 = (SiteSpmp5) adao.loadById("SiteSpmp5", new Long(
				id));
		File[] files = (File[]) ServletActionContext.getContext()
				.getParameters().get("Filedata");
		for (int i = 0; i < files.length; i++) {
			String houzhui = StringUtils.substringAfterLast(files[i].getName(),
					".");
			String newfilename = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());

			newfilename = newfilename + "." + houzhui;
			String path = SystemInit.getSiteHome() + username + "/";
			String destfile = SystemInit.getWebroot() + "site" + path;
			FileUtils.copyFile(files[i], new File(path + newfilename));
			SiteSpmp5Item siteSpmp5Item = new SiteSpmp5Item();
			siteSpmp5Item.setFilepath(newfilename);
			siteSpmp5Item.setFilename(files[i].getName());
			siteSpmp5Item.setTitle(StringUtils.substringBefore(
					files[i].getName(), "."));
			siteSpmp5Item.setSiteSpmp5(siteSpmp5);
			adao.saveObject(siteSpmp5Item);

			BeanUtils.setValue(siteSpmp5Item, "sortstr",
					BeanUtils.getValue(siteSpmp5Item, "id").toString());
			adao.updateObject(siteSpmp5Item);

			files[i].delete();
		}
		return "ok";
	}

	public String filespmp7() throws Exception {
		String username = get_username();
		AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
				.getWebAppContext().getBean("advanceDAO");
		String id = WebAppContextUtils.getpara("id");
		SiteSpmp7 siteSpmp7 = (SiteSpmp7) adao.loadById("SiteSpmp7", new Long(
				id));
		File[] files = (File[]) ServletActionContext.getContext()
				.getParameters().get("Filedata");
		for (int i = 0; i < files.length; i++) {
			String houzhui = StringUtils.substringAfterLast(files[i].getName(),
					".");
			String newfilename = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());

			newfilename = newfilename + "." + houzhui;
			String path = SystemInit.getSiteHome() + username + "/";
			String destfile = SystemInit.getWebroot() + "site" + path;
			FileUtils.copyFile(files[i], new File(path + newfilename));
			SiteSpmp7Item siteSpmp7Item = new SiteSpmp7Item();
			siteSpmp7Item.setFilepath("/" + username + "/" + newfilename);
			siteSpmp7Item.setFilename(files[i].getName());
			siteSpmp7Item.setTitle(StringUtils.substringBefore(
					files[i].getName(), "."));
			siteSpmp7Item.setSiteSpmp7(siteSpmp7);
			adao.saveObject(siteSpmp7Item);

			BeanUtils.setValue(siteSpmp7Item, "sortstr",
					BeanUtils.getValue(siteSpmp7Item, "id").toString());
			adao.updateObject(siteSpmp7Item);

			files[i].delete();
		}
		return "ok";
	}

}

/*
 * public String import_word_spmp() throws Exception {
 * 
 * AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
 * .getWebAppContext().getBean("advanceDAO"); String
 * beanname=WebAppContextUtils.getpara("beanname"); String
 * subbeanname=WebAppContextUtils.getpara("subbeanname");
 * 
 * String userid=WebAppContextUtils.getpara("userid"); SiteUser siteUser =
 * (SiteUser) adao.loadById("SiteUser", new Long(userid));
 * 
 * File[] files = (File[]) ServletActionContext.getContext()
 * .getParameters().get("Filedata"); for (int i = 0; i < files.length; i++) {
 * String path = SystemInit.getSiteHome() + siteUser.getUsername() + "/";
 * InputStream is = new FileInputStream(files[i]); is = new
 * FileInputStream(files[i]); HWPFDocument doc = new HWPFDocument(is); Range r =
 * doc.getRange(); String html_str=""; String p_str=""; int img_nob=0; boolean
 * first_flag=true; Object obj_new_txt_parent=null; for(int j = 0; j <
 * r.numParagraphs(); j++) { //
 * log.debug("类型"+r.getParagraph(j).getStyleIndex()+
 * ":"+Range.stripFields(r.getParagraph(j).text()));
 * if(r.getParagraph(j).getStyleIndex()==1){ //碰到的是段落 if(first_flag){
 * log.debug("忽略txt:"+html_str); html_str=""; } else{//上一个目录的下面的内容
 * if(html_str.length()!=0) log.debug("内容:"+html_str); //SPMP1item } String
 * title_p=Range.stripFields(r.getParagraph(j).text());
 * log.debug("目录:"+title_p); //保存SPMP1 obj_new_txt_parent=
 * ApplicationContextFactory.getWebAppContext().getBean(beanname);
 * BeanUtils.setValue(obj_new_txt_parent, "name" ,title_p);
 * BeanUtils.setValue(obj_new_txt_parent, "siteUser" ,siteUser);
 * adao.saveObject(obj_new_txt_parent);
 * 
 * first_flag=false; continue; }
 * 
 * if(r.getParagraph(j).getStyleIndex()==2){ //碰到的是段落
 * 
 * if(html_str.length()!=0) log.debug("txt:"+html_str); String
 * title_child=Range.stripFields(r.getParagraph(j).text());
 * log.debug("子目录:"+title_child); Object obj_new_txt_sub=
 * ApplicationContextFactory.getWebAppContext().getBean(subbeanname);
 * BeanUtils.setValue(obj_new_txt_sub, "title" ,title_child);
 * BeanUtils.setValue(obj_new_txt_sub, "detail" ,html_str);
 * BeanUtils.setValue(obj_new_txt_sub, "siteSpmp1" ,obj_new_txt_parent);
 * 
 * adao.saveObject(obj_new_txt_sub);
 * 
 * first_flag=false; continue; }
 * html_str=html_str+Range.stripFields(r.getParagraph(j).text())+"<br>";
 * 
 * }
 * 
 * } return "ok"; }
 */