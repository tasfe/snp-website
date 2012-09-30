package com.snp.site.config;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.snp.site.init.SystemInit;

public class LanmuConfig {
	// 栏目的位置
	String lanmualldirdisplay = "";
	String lanmudir1 = "";

	String lanmudir2 = "";

	String lanmudir3 = "";

	String lanmudir4 = "";

	String lanmudir5 = "";

	String lanmuindex1 = "";

	String lanmuindex2 = "";

	String lanmuindex3 = "";

	String lanmuindex4 = "";

	String lanmuindex1num = "4";

	String lanmuindex2num = "4";

	String lanmuindex3num = "4";

	String lanmuindex4num = "4";

	String lanmu1 = "";

	String lanmu2 = "";

	String lanmu3 = "";

	String lanmu4 = "";

	String lanmu5 = "";

	String lanmu6 = "";

	String lanmu7 = "";

	String lanmu8 = "";

	String lanmu9 = "";

	String lanmu10 = "";
	String lanmu11 = "";
	String lanmu12 = "";
	String lanmu13 = "";
	String lanmu14 = "";
	String dirlever = ""; /* 默认 下是2层 1首页显示1层 2 首页显示1层， 3都显示1层 */
	String mailaddress = "";
	String divbantl = "";

	String displayadmin = "";
	String displayshow = "";
	String displayemail = "";

	public String getDisplayadmin() {
		return displayadmin;
	}

	public void setDisplayadmin(String displayadmin) {
		this.displayadmin = displayadmin;
	}

	public String getDisplayshow() {
		return displayshow;
	}

	public void setDisplayshow(String displayshow) {
		this.displayshow = displayshow;
	}

	public String getDisplayemail() {
		return displayemail;
	}

	public void setDisplayemail(String displayemail) {
		this.displayemail = displayemail;
	}

	public String getMailaddress() {
		return mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	String divbantr = "";

	String divbantlimgw = "100";
	String divbantlimgh = "400";

	String divbantrimgw = "100";
	String divbantrimgh = "400";
	String divbancenterimgw = "400";
	String divbancenterimgh = "300";
	String divbancenterrepeat = "";

	public String getDivbancenterrepeat() {
		return divbancenterrepeat;
	}

	public void setDivbancenterrepeat(String divbancenterrepeat) {
		this.divbancenterrepeat = divbancenterrepeat;
	}

	String divbancenterimgx = "50";
	String divbancenterimgy = "50";

	public String getDivbancenterimgx() {
		return divbancenterimgx;
	}

	public void setDivbancenterimgx(String divbancenterimgx) {
		this.divbancenterimgx = divbancenterimgx;
	}

	public String getDivbancenterimgy() {
		return divbancenterimgy;
	}

	public void setDivbancenterimgy(String divbancenterimgy) {
		this.divbancenterimgy = divbancenterimgy;
	}

	public String getDivbantlimgh() {
		return divbantlimgh;
	}

	public void setDivbantlimgh(String divbantlimgh) {
		this.divbantlimgh = divbantlimgh;
	}

	public String getDivbantrimgw() {
		return divbantrimgw;
	}

	public void setDivbantrimgw(String divbantrimgw) {
		this.divbantrimgw = divbantrimgw;
	}

	public String getDivbancenterimgw() {
		return divbancenterimgw;
	}

	public void setDivbancenterimgw(String divbancenterimgw) {
		this.divbancenterimgw = divbancenterimgw;
	}

	public String getDivbancenterimgh() {
		return divbancenterimgh;
	}

	public void setDivbancenterimgh(String divbancenterimgh) {
		this.divbancenterimgh = divbancenterimgh;
	}

	public String getDivbantlimgw() {
		return divbantlimgw;
	}

	public void setDivbantlimgw(String divbantlimgw) {
		this.divbantlimgw = divbantlimgw;
	}

	public String getDivbantrimgh() {
		return divbantrimgh;
	}

	public void setDivbantrimgh(String divbantrimgh) {
		this.divbantrimgh = divbantrimgh;
	}

	String divbanbr = "";
	String divbanbl = "";
	String divbancenter = "";
	String imghuawen = "";
	String imghuawenheight = "100";

	String styleimg = ""; // 黑色的滤镜

	public String getStyleimg() {
		return styleimg;
	}

	public void setStyleimg(String styleimg) {
		this.styleimg = styleimg;
	}

	public String getImghuawenheight() {
		return imghuawenheight;
	}

	public void setImghuawenheight(String imghuawenheight) {
		this.imghuawenheight = imghuawenheight;
	}

	public String getImghuawen() {
		return imghuawen;
	}

	public void setImghuawen(String imghuawen) {
		this.imghuawen = imghuawen;
	}

	public String getDivbantl() {
		return divbantl;
	}

	public void setDivbantl(String divbantl) {
		this.divbantl = divbantl;
	}

	public String getDivbantr() {
		return divbantr;
	}

	public void setDivbantr(String divbantr) {
		this.divbantr = divbantr;
	}

	public String getDivbanbr() {
		return divbanbr;
	}

	public void setDivbanbr(String divbanbr) {
		this.divbanbr = divbanbr;
	}

	public String getDivbanbl() {
		return divbanbl;
	}

	public void setDivbanbl(String divbanbl) {
		this.divbanbl = divbanbl;
	}

	public String getDivbancenter() {
		return divbancenter;
	}

	public void setDivbancenter(String divbancenter) {
		this.divbancenter = divbancenter;
	}

	public String getDirlever() {
		return dirlever;
	}

	public void setDirlever(String dirlever) {
		this.dirlever = dirlever;
	}

	public String getLanmu11() {
		return lanmu11;
	}

	public void setLanmu11(String lanmu11) {
		this.lanmu11 = lanmu11;
	}

	public String getLanmu12() {
		return lanmu12;
	}

	public void setLanmu12(String lanmu12) {
		this.lanmu12 = lanmu12;
	}

	public String getLanmu13() {
		return lanmu13;
	}

	public void setLanmu13(String lanmu13) {
		this.lanmu13 = lanmu13;
	}

	public String getLanmu14() {
		return lanmu14;
	}

	public void setLanmu14(String lanmu14) {
		this.lanmu14 = lanmu14;
	}

	String moveiframe = "";

	String tx = "0"; // 为空就是显示
	String hw = "0"; // 为空就是显示
	String dw = "0"; // 为空就是显示

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getHw() {
		return hw;
	}

	public void setHw(String hw) {
		this.hw = hw;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	String linklanmudisplay = ""; // 为空就是显示
	String linklanmugundong = "";
	String dirlanmudisplay = ""; // 为空就是显示1层目录
	String shopcardisplay = ""; // 为空就是显示，NO不显示
	String shopsimple = ""; // 为空就是简化的购显示，NO不显示
	String sitewidth = ""; // 为空就是简化的购显示，NO不显示
	String leftwidth = ""; // 为空就是简化的购显示，NO不显示
	String rightwidth = ""; // 为空就是简化的购显示，NO不显示
	String musicfilename = ""; // 音乐背景文件名
	String topheight = "";

	public String getTopheight() {
		return topheight;
	}

	public void setTopheight(String topheight) {
		this.topheight = topheight;
	}

	public String checknav(String lanmuname) {
		try {
			HashMap map_nav = getNavMap();
			for (Iterator iterator = map_nav.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				// log.debug(lanmuname+":"+key+"="+map_nav.get(key));
			}
			if (map_nav.containsKey(lanmuname))
				return "yes";
			else
				return "no";

			// 可以将lanmuObject 的value作为KEY存在HASHAMAP中，然后根据取的位置

		} catch (Exception e) {

			e.printStackTrace();
			return "no";
		}
	}

	public HashMap getNavMap() {
		HashMap map_nav = new HashMap();
		if (!lanmu1.equals("")) {
			map_nav.put(lanmu1, "lanmu1");
		}
		if (!lanmu2.equals("")) {
			map_nav.put(lanmu2, "lanmu2");
		}
		if (!lanmu3.equals("")) {
			map_nav.put(lanmu3, "lanmu3");
		}
		if (!lanmu4.equals("")) {
			map_nav.put(lanmu4, "lanmu4");
		}
		if (!lanmu5.equals("")) {
			map_nav.put(lanmu5, "lanmu5");
		}
		if (!lanmu6.equals("")) {
			map_nav.put(lanmu6, "lanmu6");
		}
		if (!lanmu7.equals("")) {
			map_nav.put(lanmu7, "lanmu7");
		}
		if (!lanmu8.equals("")) {
			map_nav.put(lanmu8, "lanmu8");
		}
		if (!lanmu9.equals("")) {
			map_nav.put(lanmu9, "lanmu9");
		}
		if (!lanmu10.equals("")) {
			map_nav.put(lanmu10, "lanmu10");
		}
		if (!lanmu11.equals("")) {
			map_nav.put(lanmu11, "lanmu11");
		}
		if (!lanmu12.equals("")) {
			map_nav.put(lanmu12, "lanmu12");
		}
		if (!lanmu13.equals("")) {
			map_nav.put(lanmu13, "lanmu13");
		}
		if (!lanmudir1.equals("")) {
			map_nav.put(lanmudir1, "lanmudir1");
		}
		if (!lanmudir2.equals("")) {
			map_nav.put(lanmudir2, "lanmudir2");
		}
		if (!lanmudir3.equals("")) {
			map_nav.put(lanmudir3, "lanmudir3");
		}
		if (!lanmudir4.equals("")) {
			map_nav.put(lanmudir4, "lanmudir4");
		}
		if (!lanmudir5.equals("")) {
			map_nav.put(lanmudir5, "lanmudir5");
		}

		return map_nav;
	}

	public ArrayList getNavListLanmu() {
		ArrayList list_nav = new ArrayList();
		list_nav.add(getSortObject(lanmu1, "lanmu1"));
		list_nav.add(getSortObject(lanmu2, "lanmu2"));
		list_nav.add(getSortObject(lanmu3, "lanmu3"));
		list_nav.add(getSortObject(lanmu4, "lanmu4"));
		list_nav.add(getSortObject(lanmu5, "lanmu5"));
		list_nav.add(getSortObject(lanmu6, "lanmu6"));
		list_nav.add(getSortObject(lanmu7, "lanmu7"));
		list_nav.add(getSortObject(lanmu8, "lanmu8"));
		list_nav.add(getSortObject(lanmu9, "lanmu9"));
		// list_nav.add(getSortObject(lanmu10, "lanmu10"));
		// list_nav.add(getSortObject(lanmu11, "lanmu11"));
		// list_nav.add(getSortObject(lanmu12, "lanmu12"));
		// list_nav.add(getSortObject(lanmu13, "lanmu13"));
		/*
		 * if(!lanmu1.equals("")){list_nav.add(getSortObject(lanmu1,
		 * "lanmu1"));}
		 * if(!lanmu2.equals("")){list_nav.add(getSortObject(lanmu2,
		 * "lanmu2"));}
		 * if(!lanmu3.equals("")){list_nav.add(getSortObject(lanmu3,
		 * "lanmu3"));}
		 * if(!lanmu4.equals("")){list_nav.add(getSortObject(lanmu4,
		 * "lanmu4"));}
		 * if(!lanmu5.equals("")){list_nav.add(getSortObject(lanmu5,
		 * "lanmu5"));}
		 * if(!lanmu6.equals("")){list_nav.add(getSortObject(lanmu6,
		 * "lanmu6"));}
		 * if(!lanmu7.equals("")){list_nav.add(getSortObject(lanmu7,
		 * "lanmu7"));}
		 * if(!lanmu8.equals("")){list_nav.add(getSortObject(lanmu8,
		 * "lanmu8"));}
		 * if(!lanmu9.equals("")){list_nav.add(getSortObject(lanmu9,
		 * "lanmu9"));}
		 * if(!lanmu10.equals("")){list_nav.add(getSortObject(lanmu10,
		 * "lanmu10"));}
		 */
		return list_nav;
	}

	public ArrayList getNavListDir() {
		ArrayList list_nav = new ArrayList();
		list_nav.add(getSortObject(lanmudir1, "lanmudir1"));
		list_nav.add(getSortObject(lanmudir2, "lanmudir2"));
		list_nav.add(getSortObject(lanmudir3, "lanmudir3"));
		list_nav.add(getSortObject(lanmudir4, "lanmudir4"));
		list_nav.add(getSortObject(lanmudir5, "lanmudir5"));

		return list_nav;
	}

	public ArrayList getIndexListDir() {
		ArrayList list_nav = new ArrayList();
		list_nav.add(getSortObject(lanmuindex1, "lanmuindex1"));
		list_nav.add(getSortObject(lanmuindex2, "lanmuindex2"));
		list_nav.add(getSortObject(lanmuindex3, "lanmuindex3"));
		list_nav.add(getSortObject(lanmuindex4, "lanmuindex4"));
		return list_nav;
	}

	public ArrayList getLanmuIndexList() {
		ArrayList list_nav = new ArrayList();
		list_nav.add(getSortObject(lanmuindex1, "lanmuindex1"));
		list_nav.add(getSortObject(lanmuindex2, "lanmuindex2"));
		list_nav.add(getSortObject(lanmuindex3, "lanmuindex3"));
		list_nav.add(getSortObject(lanmuindex4, "lanmuindex4"));

		return list_nav;
	}

	public SortLanmuObject getSortObject(String value, String property) {
		SortLanmuObject sortObject = new SortLanmuObject();
		sortObject.setProperty(property);
		sortObject.setValue(value);
		return sortObject;
	}

	public String getMusicfilename() {
		return musicfilename;
	}

	public void setMusicfilename(String musicfilename) {
		this.musicfilename = musicfilename;
	}

	public String getLeftwidth() {
		return leftwidth;
	}

	public void setLeftwidth(String leftwidth) {
		this.leftwidth = leftwidth;
	}

	public String getRightwidth() {
		return rightwidth;
	}

	public void setRightwidth(String rightwidth) {
		this.rightwidth = rightwidth;
	}

	public String getSitewidth() {
		return sitewidth;
	}

	public void setSitewidth(String sitewidth) {
		this.sitewidth = sitewidth;
	}

	public String getShopsimple() {
		return shopsimple;
	}

	public void setShopsimple(String shopsimple) {
		this.shopsimple = shopsimple;
	}

	String fullscreen = "";
	String lanmudiralign = "";
	String mailurl = ""; // 企业邮箱的地址
	String searchdisplay = ""; // 搜索为yes显示，空就是不显示，
	String weburl = ""; // 客户的网址，搜索指定
	String searchservice = ""; // 选择那个引擎

	String otherusername = ""; // 为空没有，就要通过用户名把数据传入

	String vphonindex = "";

	String videowidth = "";
	String videoheight = "";

	String videoautoplay = "1"; // 默认是1
	String videologtxt = ""; // 默认是空
	String qq = ""; // 默认是空
	String qqtop = ""; // 默认是空
	String qqbottom = ""; // 默认是空
	String qqleft = ""; // 默认是空
	String msn = ""; // 默认是空
	String taobao = ""; // 默认是空
	String preview = ""; // 默认是空

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getTaobao() {
		return taobao;
	}

	public void setTaobao(String taobao) {
		this.taobao = taobao;
	}

	String memberlink = "";
	String memberconfirm = "";// need be conform by admin

	public String getLinklanmudisplay() {
		return linklanmudisplay;
	}

	public void setLinklanmudisplay(String linklanmudisplay) {
		this.linklanmudisplay = linklanmudisplay;
	}

	public String getLanmu1() {
		return lanmu1;
	}

	public void setLanmu1(String lanmu1) {
		this.lanmu1 = lanmu1;
	}

	public String getLanmu2() {
		return lanmu2;
	}

	public void setLanmu2(String lanmu2) {
		this.lanmu2 = lanmu2;
	}

	public String getLanmu3() {
		return lanmu3;
	}

	public void setLanmu3(String lanmu3) {
		this.lanmu3 = lanmu3;
	}

	public String getLanmu4() {
		return lanmu4;
	}

	public void setLanmu4(String lanmu4) {
		this.lanmu4 = lanmu4;
	}

	public String getLanmu5() {
		return lanmu5;
	}

	public void setLanmu5(String lanmu5) {
		this.lanmu5 = lanmu5;
	}

	public String getLanmu6() {
		return lanmu6;
	}

	public void setLanmu6(String lanmu6) {
		this.lanmu6 = lanmu6;
	}

	public String getLanmu7() {
		return lanmu7;
	}

	public void setLanmu7(String lanmu7) {
		this.lanmu7 = lanmu7;
	}

	public String getLanmu8() {
		return lanmu8;
	}

	public void setLanmu8(String lanmu8) {
		this.lanmu8 = lanmu8;
	}

	public static void main(String[] args) throws IOException {
		LanmuConfig test = new LanmuConfig();
		test.setLanmu2("spmp2");
		test.setLanmu1("spmp1");
		test.setLanmu3("spmp3");
		test.setLanmu4("spmp4");
		test.setLanmu5("guest");
		test.setLanmu6("check");
		test.setLanmu7("job");
		test.setLanmu8("address");
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(
				new FileOutputStream(SystemInit.getClassPath() + "lanmu.xml")));
		e.writeObject(test);
		e.close();
		// log.debug("数据库对象生成完毕,保存路径" + SystemInit.ClassPath+ "lanmu.xml");
	}

	public String getLanmudir1() {
		return lanmudir1;
	}

	public void setLanmudir1(String lanmudir1) {
		this.lanmudir1 = lanmudir1;
	}

	public String getLanmudir2() {
		return lanmudir2;
	}

	public void setLanmudir2(String lanmudir2) {
		this.lanmudir2 = lanmudir2;
	}

	public String getLanmudir3() {
		return lanmudir3;
	}

	public void setLanmudir3(String lanmudir3) {
		this.lanmudir3 = lanmudir3;
	}

	public String getLanmudir4() {
		return lanmudir4;
	}

	public void setLanmudir4(String lanmudir4) {
		this.lanmudir4 = lanmudir4;
	}

	public String getLanmudir5() {
		return lanmudir5;
	}

	public void setLanmudir5(String lanmudir5) {
		this.lanmudir5 = lanmudir5;
	}

	public String getLanmuindex1() {
		return lanmuindex1;
	}

	public void setLanmuindex1(String lanmuindex1) {
		this.lanmuindex1 = lanmuindex1;
	}

	public String getLanmuindex2() {
		return lanmuindex2;
	}

	public void setLanmuindex2(String lanmuindex2) {
		this.lanmuindex2 = lanmuindex2;
	}

	public String getLanmuindex3() {
		return lanmuindex3;
	}

	public void setLanmuindex3(String lanmuindex3) {
		this.lanmuindex3 = lanmuindex3;
	}

	public String getLanmuindex4() {
		return lanmuindex4;
	}

	public void setLanmuindex4(String lanmuindex4) {
		this.lanmuindex4 = lanmuindex4;
	}

	public String getLanmu10() {
		return lanmu10;
	}

	public void setLanmu10(String lanmu10) {
		this.lanmu10 = lanmu10;
	}

	public String getLanmu9() {
		return lanmu9;
	}

	public void setLanmu9(String lanmu9) {
		this.lanmu9 = lanmu9;
	}

	public String getLanmuindex4num() {
		return lanmuindex4num;
	}

	public void setLanmuindex4num(String lanmuindex4num) {
		this.lanmuindex4num = lanmuindex4num;
	}

	public String getLanmuindex1num() {
		return lanmuindex1num;
	}

	public void setLanmuindex1num(String lanmuindex1num) {
		this.lanmuindex1num = lanmuindex1num;
	}

	public String getLanmuindex2num() {
		return lanmuindex2num;
	}

	public void setLanmuindex2num(String lanmuindex2num) {
		this.lanmuindex2num = lanmuindex2num;
	}

	public String getLanmuindex3num() {
		return lanmuindex3num;
	}

	public void setLanmuindex3num(String lanmuindex3num) {
		this.lanmuindex3num = lanmuindex3num;
	}

	public String getMoveiframe() {
		return moveiframe;
	}

	public void setMoveiframe(String moveiframe) {
		this.moveiframe = moveiframe;
	}

	public String getShopcardisplay() {
		return shopcardisplay;
	}

	public void setShopcardisplay(String shopcardisplay) {
		this.shopcardisplay = shopcardisplay;
	}

	public String getOtherusername() {
		return otherusername;
	}

	public void setOtherusername(String otherusername) {
		this.otherusername = otherusername;
	}

	public String getVphonindex() {
		return vphonindex;
	}

	public void setVphonindex(String vphonindex) {
		this.vphonindex = vphonindex;
	}

	public String getVideoheight() {
		return videoheight;
	}

	public void setVideoheight(String videoheight) {
		this.videoheight = videoheight;
	}

	public String getVideowidth() {
		return videowidth;
	}

	public void setVideowidth(String videowidth) {
		this.videowidth = videowidth;
	}

	public String getVideoautoplay() {
		return videoautoplay;
	}

	public void setVideoautoplay(String videoautoplay) {
		this.videoautoplay = videoautoplay;
	}

	public String getVideologtxt() {
		return videologtxt;
	}

	public void setVideologtxt(String videologtxt) {
		this.videologtxt = videologtxt;
	}

	public String getDirlanmudisplay() {
		return dirlanmudisplay;
	}

	public void setDirlanmudisplay(String dirlanmudisplay) {
		this.dirlanmudisplay = dirlanmudisplay;
	}

	public String getSearchdisplay() {
		return searchdisplay;
	}

	public void setSearchdisplay(String searchdisplay) {
		this.searchdisplay = searchdisplay;
	}

	public String getSearchservice() {
		return searchservice;
	}

	public void setSearchservice(String searchservice) {
		this.searchservice = searchservice;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public String getMailurl() {
		return mailurl;
	}

	public void setMailurl(String mailurl) {
		this.mailurl = mailurl;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getLinklanmugundong() {
		return linklanmugundong;
	}

	public void setLinklanmugundong(String linklanmugundong) {
		this.linklanmugundong = linklanmugundong;
	}

	public String getFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(String fullscreen) {
		this.fullscreen = fullscreen;
	}

	public String getMemberlink() {
		return memberlink;
	}

	public void setMemberlink(String memberlink) {
		this.memberlink = memberlink;
	}

	public String getMemberconfirm() {
		return memberconfirm;
	}

	public void setMemberconfirm(String memberconfirm) {
		this.memberconfirm = memberconfirm;
	}

	public String getLanmualldirdisplay() {
		return lanmualldirdisplay;
	}

	public void setLanmualldirdisplay(String lanmualldirdisplay) {
		this.lanmualldirdisplay = lanmualldirdisplay;
	}

	public String getQqtop() {
		return qqtop;
	}

	public void setQqtop(String qqtop) {
		this.qqtop = qqtop;
	}

	public String getQqbottom() {
		return qqbottom;
	}

	public void setQqbottom(String qqbottom) {
		this.qqbottom = qqbottom;
	}

	public String getQqleft() {
		return qqleft;
	}

	public void setQqleft(String qqleft) {
		this.qqleft = qqleft;
	}

	public String getLanmudiralign() {
		return lanmudiralign;
	}

	public void setLanmudiralign(String lanmudiralign) {
		this.lanmudiralign = lanmudiralign;
	}

}
