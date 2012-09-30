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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.snp.site.config.LanmuConfig;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SitePresource;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/**
 * 本业务类保存调整栏目后的，lanmu.xml的文件 首先根据前台传来的参数依次获取，更改SESSION的lanmuobject. 然后再写入用户目录下
 */
public class LanmuSetting implements IbusinessAction {
	private static Log log = LogFactory.getLog(LanmuSetting.class);

	public void excute(IOperationContext context) throws OperationException {
		try {

			SiteUser siteuser = (SiteUser) ActionContext.getContext()
					.getSession().get(SystemInit.clientloginflag);
			String userLunmuXmlPath = SystemInit.getSiteHome()
					+ siteuser.getUsername() + "/"
					+ SystemInit.LanmuConfFileName;

			LanmuConfig lanmuObject = SystemInit
					.getLanmuObjectFromXml(userLunmuXmlPath);

			if (WebAppContextUtils.getpara("paraname").equals("lanmu1")) {
				lanmuObject.setLanmu1(WebAppContextUtils.getpara("lanmu1"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmu2")) {
				lanmuObject.setLanmu2(WebAppContextUtils.getpara("lanmu2"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmu3")) {
				lanmuObject.setLanmu3(WebAppContextUtils.getpara("lanmu3"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmu4")) {
				lanmuObject.setLanmu4(WebAppContextUtils.getpara("lanmu4"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("lanmu5")) {
				lanmuObject.setLanmu5(WebAppContextUtils.getpara("lanmu5"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("lanmu6")) {
				lanmuObject.setLanmu6(WebAppContextUtils.getpara("lanmu6"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("lanmu7")) {
				lanmuObject.setLanmu7(WebAppContextUtils.getpara("lanmu7"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("lanmu8")) {
				lanmuObject.setLanmu8(WebAppContextUtils.getpara("lanmu8"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("lanmu9")) {
				lanmuObject.setLanmu9(WebAppContextUtils.getpara("lanmu9"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmudir1")) {
				lanmuObject.setLanmudir1(WebAppContextUtils
						.getpara("lanmudir1"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmudir2")) {
				lanmuObject.setLanmudir2(WebAppContextUtils
						.getpara("lanmudir2"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmudir3")) {
				lanmuObject.setLanmudir3(WebAppContextUtils
						.getpara("lanmudir3"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmudir4")) {
				lanmuObject.setLanmudir4(WebAppContextUtils
						.getpara("lanmudir4"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmudiralign")) {
				lanmuObject.setLanmudiralign(WebAppContextUtils
						.getpara("lanmudiralign"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("tx")) {
				lanmuObject.setTx(WebAppContextUtils.getpara("tx"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("divbancenter")) {
				SitePresource sitePresource = (SitePresource) context
						.getResults().get("DM.Create.SitePresource.Result");

				lanmuObject.setDivbancenter(StringUtils.substringAfterLast(
						sitePresource.getFilepath(), "/"));

			}
			if (WebAppContextUtils.getpara("paraname").equals("divbantl")) {
				SitePresource sitePresource = (SitePresource) context
						.getResults().get("DM.Create.SitePresource.Result");
				lanmuObject.setDivbantl(StringUtils.substringAfterLast(
						sitePresource.getFilepath(), "/"));

			}

			if (WebAppContextUtils.getpara("paraname").equals("divbantr")) {
				SitePresource sitePresource = (SitePresource) context
						.getResults().get("DM.Create.SitePresource.Result");

				lanmuObject.setDivbantr(StringUtils.substringAfterLast(
						sitePresource.getFilepath(), "/"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("divbanbl")) {
				SitePresource sitePresource = (SitePresource) context
						.getResults().get("DM.Create.SitePresource.Result");

				lanmuObject.setDivbanbl(StringUtils.substringAfterLast(
						sitePresource.getFilepath(), "/"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("divbanbr")) {
				SitePresource sitePresource = (SitePresource) context
						.getResults().get("DM.Create.SitePresource.Result");

				lanmuObject.setDivbanbr(StringUtils.substringAfterLast(
						sitePresource.getFilepath(), "/"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("imghuawen")) {
				SitePresource sitePresource = (SitePresource) context
						.getResults().get("DM.Create.SitePresource.Result");

				lanmuObject.setImghuawen(StringUtils.substringAfterLast(
						sitePresource.getFilepath(), "/"));

			}

			if (WebAppContextUtils.getpara("paraname").equals("styleimg")) { // 光照图片
				SitePresource sitePresource = (SitePresource) context
						.getResults().get("DM.Create.SitePresource.Result");
				// lanmuObject.setStyleimg(sitePresource.getFilepath());
				lanmuObject.setStyleimg(StringUtils.substringAfterLast(
						sitePresource.getFilepath(), "/"));
			}
			// 清除背景的代码
			if (WebAppContextUtils.getpara("paraname").equals("deldivbantl")) {
				lanmuObject.setDivbantl("");
			}
			if (WebAppContextUtils.getpara("paraname").equals("delstyleimg")) {
				lanmuObject.setStyleimg("");
			}
			if (WebAppContextUtils.getpara("paraname")
					.equals("deldivbancenter")) {
				lanmuObject.setDivbancenter("");
			}
			if (WebAppContextUtils.getpara("paraname").equals("deldivbantr")) {
				lanmuObject.setDivbantr("");
			}
			if (WebAppContextUtils.getpara("paraname").equals("deldivbanbr")) {
				lanmuObject.setDivbanbr("");
			}
			if (WebAppContextUtils.getpara("paraname").equals("delimghuawen")) {
				lanmuObject.setImghuawen("");
			}

			if (WebAppContextUtils.getpara("paraname").equals("deldivbanbl")) {
				lanmuObject.setDivbanbl("");
			}
			if (WebAppContextUtils.getpara("paraname").equals("hw")) {
				lanmuObject.setHw(WebAppContextUtils.getpara("hw"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("dirlever")) {
				lanmuObject.setDirlever(WebAppContextUtils.getpara("dirlever"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("dw")) {
				lanmuObject.setDw(WebAppContextUtils.getpara("dw"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("qq")) {
				lanmuObject.setQq(WebAppContextUtils.getpara("qq"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("qqtop")) {
				lanmuObject.setQqtop(WebAppContextUtils.getpara("qqtop"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("qqbottom")) {
				lanmuObject.setQqbottom(WebAppContextUtils.getpara("qqbottom"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("qqleft")) {
				lanmuObject.setQqleft(WebAppContextUtils.getpara("qqleft"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("msn")) {
				lanmuObject.setMsn(WebAppContextUtils.getpara("msn"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("taobao")) {
				lanmuObject.setTaobao(WebAppContextUtils.getpara("taobao"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("memberconfirm")) {
				lanmuObject.setMemberconfirm(WebAppContextUtils
						.getpara("memberconfirm"));
			}
			if (WebAppContextUtils.getpara("paraname")
					.equals("dirlanmudisplay")) {
				lanmuObject.setDirlanmudisplay(WebAppContextUtils
						.getpara("dirlanmudisplay"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("vphonindex")) {
				lanmuObject.setVphonindex(WebAppContextUtils
						.getpara("vphonindex"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("moveiframe")) {
				lanmuObject.setMoveiframe(WebAppContextUtils
						.getpara("moveiframe"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("shopcardisplay")) {
				lanmuObject.setShopcardisplay(WebAppContextUtils
						.getpara("shopcardisplay"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("videoautoplay")) {
				lanmuObject.setVideoautoplay(WebAppContextUtils
						.getpara("videoautoplay"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("videowidth")) {
				lanmuObject.setVideowidth(WebAppContextUtils
						.getpara("videowidth"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("videoheight")) {
				lanmuObject.setVideoheight(WebAppContextUtils
						.getpara("videoheight"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("videologtxt")) {
				lanmuObject.setVideologtxt(WebAppContextUtils
						.getpara("videologtxt"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("fullscreen")) {
				lanmuObject.setFullscreen(WebAppContextUtils
						.getpara("fullscreen"));
			}

			if (WebAppContextUtils.getpara("paraname").equals(
					"lanmualldirdisplay")) {
				lanmuObject.setLanmualldirdisplay(WebAppContextUtils
						.getpara("lanmualldirdisplay"));

			}
			if (WebAppContextUtils.getpara("paraname").equals("videologtxt")) {
				lanmuObject.setVideologtxt(WebAppContextUtils
						.getpara("videologtxt"));

			}
			if (WebAppContextUtils.getpara("paraname")
					.equals("imghuawenheight")) {
				lanmuObject.setImghuawenheight(WebAppContextUtils
						.getpara("imghuawenheight"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("divbantlimgw")) {
				lanmuObject.setDivbantlimgw(WebAppContextUtils
						.getpara("divbantlimgw"));

			}
			if (WebAppContextUtils.getpara("paraname").equals("divbantlimgh")) {
				lanmuObject.setDivbantlimgh(WebAppContextUtils
						.getpara("divbantlimgh"));

			}

			if (WebAppContextUtils.getpara("paraname").equals("divbantrimgw")) {
				lanmuObject.setDivbantrimgw(WebAppContextUtils
						.getpara("divbantrimgw"));

			}
			if (WebAppContextUtils.getpara("paraname").equals("divbantrimgh")) {
				lanmuObject.setDivbantrimgh(WebAppContextUtils
						.getpara("divbantrimgh"));

			}

			if (WebAppContextUtils.getpara("paraname").equals(
					"divbancenterimgw")) {
				lanmuObject.setDivbancenterimgw(WebAppContextUtils
						.getpara("divbancenterimgw"));

			}
			if (WebAppContextUtils.getpara("paraname").equals(
					"divbancenterimgh")) {
				lanmuObject.setDivbancenterimgh(WebAppContextUtils
						.getpara("divbancenterimgh"));

			}

			if (WebAppContextUtils.getpara("paraname").equals(
					"divbancenterimgx")) {
				lanmuObject.setDivbancenterimgx(WebAppContextUtils
						.getpara("divbancenterimgx"));

			}
			if (WebAppContextUtils.getpara("paraname").equals(
					"divbancenterimgy")) {
				lanmuObject.setDivbancenterimgy(WebAppContextUtils
						.getpara("divbancenterimgy"));

			}
			if (WebAppContextUtils.getpara("paraname").equals(
					"divbancenterrepeat")) {
				lanmuObject.setDivbancenterrepeat(WebAppContextUtils
						.getpara("divbancenterrepeat"));

			}

			if (WebAppContextUtils.getpara("paraname").equals("leftwidth")) {
				lanmuObject.setLeftwidth(WebAppContextUtils
						.getpara("leftwidth"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("rightwidth")) {
				lanmuObject.setRightwidth(WebAppContextUtils
						.getpara("rightwidth"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("sitewidth")) {
				lanmuObject.setSitewidth(WebAppContextUtils
						.getpara("sitewidth"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("topheight")) {
				lanmuObject.setTopheight(WebAppContextUtils
						.getpara("topheight"));
			}

			if (WebAppContextUtils.getpara("paraname").equals("musicfilename")) {
				lanmuObject.setMusicfilename(WebAppContextUtils
						.getpara("musicfilename"));
			}
			if (WebAppContextUtils.getpara("paraname").equals("set_dir")) {
				lanmuObject.setLanmudir1(WebAppContextUtils
						.getpara("lanmudir1"));
				lanmuObject.setLanmudir2(WebAppContextUtils
						.getpara("lanmudir2"));
				lanmuObject.setLanmudir3(WebAppContextUtils
						.getpara("lanmudir3"));
				lanmuObject.setLanmudir4(WebAppContextUtils
						.getpara("lanmudir4"));
				// lanmuObject.setLanmudir5(WebAppContextUtils.getpara("lanmudir5"));

			}
			if (WebAppContextUtils.getpara("paraname").equals("set_lanmu")) {
				lanmuObject.setLanmu1(WebAppContextUtils.getpara("lanmu1"));
				lanmuObject.setLanmu2(WebAppContextUtils.getpara("lanmu2"));
				lanmuObject.setLanmu3(WebAppContextUtils.getpara("lanmu3"));
				lanmuObject.setLanmu4(WebAppContextUtils.getpara("lanmu4"));
				lanmuObject.setLanmu5(WebAppContextUtils.getpara("lanmu5"));
				lanmuObject.setLanmu6(WebAppContextUtils.getpara("lanmu6"));
				lanmuObject.setLanmu7(WebAppContextUtils.getpara("lanmu7"));
				lanmuObject.setLanmu8(WebAppContextUtils.getpara("lanmu8"));
				lanmuObject.setLanmu9(WebAppContextUtils.getpara("lanmu9"));
				lanmuObject.setLanmu10(WebAppContextUtils.getpara("lanmu10"));

			}
			if (WebAppContextUtils.getpara("paraname").equals("set_home")) {
				lanmuObject.setLanmuindex1(WebAppContextUtils
						.getpara("lanmuindex1"));
				lanmuObject.setLanmuindex2(WebAppContextUtils
						.getpara("lanmuindex2"));

				lanmuObject.setLanmuindex3(WebAppContextUtils
						.getpara("lanmuindex3"));
				lanmuObject.setLanmuindex4(WebAppContextUtils
						.getpara("lanmuindex4"));

			}
			if (WebAppContextUtils.getpara("paraname").equals("lanmu_setting")) {
				lanmuObject.setLanmu1(WebAppContextUtils.getpara("lanmu1"));
				lanmuObject.setLanmu2(WebAppContextUtils.getpara("lanmu2"));
				lanmuObject.setLanmu3(WebAppContextUtils.getpara("lanmu3"));
				lanmuObject.setLanmu4(WebAppContextUtils.getpara("lanmu4"));
				lanmuObject.setLanmu5(WebAppContextUtils.getpara("lanmu5"));
				lanmuObject.setLanmu6(WebAppContextUtils.getpara("lanmu6"));
				lanmuObject.setLanmu7(WebAppContextUtils.getpara("lanmu7"));
				lanmuObject.setLanmu8(WebAppContextUtils.getpara("lanmu8"));
				lanmuObject.setLanmu9(WebAppContextUtils.getpara("lanmu9"));
				lanmuObject.setLanmu10(WebAppContextUtils.getpara("lanmu10"));

				lanmuObject.setLanmudir1(WebAppContextUtils
						.getpara("lanmudir1"));
				lanmuObject.setLanmudir2(WebAppContextUtils
						.getpara("lanmudir2"));
				lanmuObject.setLanmudir3(WebAppContextUtils
						.getpara("lanmudir3"));
				lanmuObject.setLanmudir4(WebAppContextUtils
						.getpara("lanmudir4"));
				// lanmuObject.setLanmudir5(WebAppContextUtils.getpara("lanmudir5"));

				lanmuObject.setLanmuindex1(WebAppContextUtils
						.getpara("lanmuindex1"));
				lanmuObject.setLanmuindex2(WebAppContextUtils
						.getpara("lanmuindex2"));
				lanmuObject.setLanmuindex3(WebAppContextUtils
						.getpara("lanmuindex3"));
				lanmuObject.setLanmuindex4(WebAppContextUtils
						.getpara("lanmuindex4"));

				lanmuObject.setLanmuindex1num(WebAppContextUtils
						.getpara("lanmuindex1num"));
				lanmuObject.setLanmuindex2num(WebAppContextUtils
						.getpara("lanmuindex2num"));
				lanmuObject.setLanmuindex3num(WebAppContextUtils
						.getpara("lanmuindex3num"));
				lanmuObject.setLanmuindex4num(WebAppContextUtils
						.getpara("lanmuindex4num"));

			}

			ActionContext.getContext().getSession()
					.put("lanmuobject", lanmuObject);
			// 多个用户帐号在一起的时候，需要更新用户的语言个数
			// ActionContext.getContext().getSession().put(SystemInit.otheruserlist,
			// SystemInit.otheruserlist(siteuser));

			XMLEncoder e;

			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(
					userLunmuXmlPath)));
			e.writeObject(lanmuObject);
			e.close();
		} catch (Exception e) {
			log.error("更新栏目位置错误", e);
			throw new OperationException("0000", "更新栏目位置错误", e);
		}

	}
}
