package com.snp.testcase.webpage;

import junit.framework.TestCase;

public class WebTest extends TestCase {
	private Selenium selenium;

	protected void setUp() throws Exception {
		String url = "http://localhost:80/site/u1";
		selenium = new DefaultSelenium("localhost", 4444,
				"*firefox e:\\soft\\Mozilla Firefox\\firefox.exe", url);
		// 主要是IE设置了拦截弹出窗口插件
		selenium.start();
		super.setUp();

	}
	
	
	public void OK_testAbout() throws Exception {
		selenium.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.waitForPageToLoad("30000");
		selenium.type("account", "u1");
		selenium.type("passwd", "u1");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("menutree");
		selenium.click("//a[@id='oursite_a']/b");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.click("release_new");
		selenium.waitForPageToLoad("30000");
		selenium.type("DM.Instance.SiteAbout.detail", "首页的第一条消息");
		selenium.click("op_sure");
		
		/*
		*/
		selenium.waitForPageToLoad("30000");
		selenium.click("insert_img");
		selenium.waitForPageToLoad("30000");
		selenium.type("oursite_filelocate", "E:\\datum-material\\pic-图片\\pic-运动\\F80666.JPG");
		selenium.click("oursite_input");
		
		
		
		/* 插入视频，有待研究
		selenium.waitForPageToLoad("30000");
		selenium.click("insert_video");
		selenium.waitForPageToLoad("30000");
		selenium.type("fileLocation", "D:\\workspace-snp\\maven\\other\\video\\3gp.3gp");
		selenium.click("//input[@id='oursite_input' and @value='上传文件']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
	    */
		}
	
	public void ok_test_marquee() throws Exception {
		selenium.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
	
		selenium.waitForPageToLoad("30000");
		selenium.type("account", "u1");
		selenium.type("passwd", "u1");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("menutree");
		selenium.click("//a[@id='oursite_a']/b");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.click("op_marquee");
		
		selenium.waitForPageToLoad("30000");
		selenium.type("DM.Instance.SiteUser.marquee", "333333");
		selenium.click("op_sure");
		
	}
	public void xtest_all() throws Exception {
		selenium.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.type("account", "u1");
		selenium.type("passwd", "u1");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("menutree");
		
		selenium.click("link=顶部");
		selenium.click("link=顶部");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.waitForPageToLoad("30000");
		selenium.type("DM.Instance.SiteUser.title", "1111");
		selenium.click("oursite_input");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("menutree");
		selenium.click("link=图片展示");
	
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.click("oursite_a");
		selenium.waitForPageToLoad("30000");
		selenium.type("DM.Instance.SiteSpmp4.name", "1111");
		selenium.click("oursite_a");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=管理图片");
		selenium.waitForPageToLoad("30000");
		selenium.click("sa-edit-a");
		selenium.waitForPageToLoad("30000");
		selenium.type("oursite_filelocate", "E:\\datum-material\\pic-图片\\pic-运动\\F80666.JPG");
		selenium.click("oursite_input");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=返回");
		selenium.waitForPageToLoad("30000");
		
		
	}
	public void ok_test_spmp4() throws Exception {
		selenium.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.type("account", "u1");
		selenium.type("passwd", "u1");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("menutree");
		selenium.click("link=图片展示");
		selenium.click("link=图片展示");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.click("oursite_a");
		selenium.waitForPageToLoad("30000");
		selenium.type("DM.Instance.SiteSpmp4.name", "1111");
		selenium.click("oursite_a");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=管理图片");
		selenium.waitForPageToLoad("30000");
		selenium.click("sa-edit-a");
		selenium.waitForPageToLoad("30000");
		selenium.type("oursite_filelocate", "E:\\datum-material\\pic-图片\\pic-运动\\F80666.JPG");
		selenium.click("oursite_input");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=返回");
		selenium.waitForPageToLoad("30000");
	}
	public void ok_testBuckupU1() throws Exception {
		selenium
				.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.type("account", "u1");
		selenium.type("passwd", "u1");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("top");
		selenium.click("link=网站备份");
	}

	public void OK_testImportU2() throws Exception {
		selenium
				.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.type("account", "u2");
		selenium.type("passwd", "u2");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("top");
		selenium.click("link=导入备份");
		
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.type("fileLocation",
				"D:\\work\\release2\\windows\\snp\\webroot\\bak\\u1.zip");
		selenium.click("//input[@id='oursite_input' and @value='确定']");
		selenium.waitForPageToLoad("30000");
	}

	
	
	
	public void xtestSnp() throws Exception {
		log.debug("开始测试");
		String url = "http://localhost:80/site/u1";
		selenium.open(url);
		log.debug("标题:" + selenium.getTitle());
		selenium.click("//ul[@id='top-lanmu']/li[1]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//ul[@id='top-lanmu']/li[4]/a/span");
		selenium.waitForPageToLoad("30000");
	}

	public void xtestChangeStyle() throws Exception {
		selenium
				.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.type("account", "test");
		selenium.type("passwd", "test");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("menutree");
		selenium.click("//a[@id='oursite_tree_a']/img");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.click("sa-colorstyle-img");
		selenium.waitForPageToLoad("30000");
		selenium.click("//td[@id='sa-bd-1']/p/span[9]/img");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("menutree");
		selenium.click("//a[2]/img");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");

		selenium.selectFrame("relative=up");
		selenium.selectFrame("menutree");
		selenium.click("//a[3]/img");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.click("radio_none2");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("top");
		selenium.click("link=更新网站");
		selenium.click("link=预览网站");

	}

	public void xtestUploadVideo() throws Exception {
		selenium
				.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.type("account", "test");
		selenium.type("passwd", "test");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("menutree");
		selenium.click("link=视频");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.click("sa-edit-a");
		selenium.waitForPageToLoad("2000");
		selenium.type("oursite_input",
				"D:\\workspace-snp\\maven\\other\\video\\3gp.3gp");
		selenium.click("//input[@id='oursite_input' and @value='确定']");
		selenium.waitForPageToLoad("2000");
		selenium.click("sa-edit-a");
		selenium.waitForPageToLoad("2000");
		selenium.type("oursite_input",
				"D:\\workspace-snp\\maven\\other\\video\\avi.avi");
		selenium.click("//input[@id='oursite_input' and @value='确定']");
		selenium.waitForPageToLoad("2000");
		selenium.click("sa-edit-a");
		selenium.waitForPageToLoad("2000");
		selenium.type("oursite_input",
				"D:\\workspace-snp\\maven\\other\\video\\flv.flv");
		selenium.click("//input[@id='oursite_input' and @value='确定']");
		selenium.waitForPageToLoad("2000");
		selenium.click("sa-edit-a");
		selenium.waitForPageToLoad("2000");
		selenium.type("oursite_input",
				"D:\\workspace-snp\\maven\\other\\video\\mp4.mp4");
		selenium.click("//input[@id='oursite_input' and @value='确定']");
		selenium.waitForPageToLoad("2000");
		selenium.click("sa-edit-a");
		selenium.waitForPageToLoad("2000");
		selenium.type("oursite_input",
				"D:\\workspace-snp\\maven\\other\\video\\wmv.wmv");
		selenium.click("//input[@id='oursite_input' and @value='确定']");
		selenium.waitForPageToLoad("2000");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("top");
		selenium.click("link=更新网站");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("menutree");
		selenium.click("link=视频");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.selectFrame("");
		selenium
				.click("//table[@id='snp-video-bg']/tbody/tr[1]/td[1]/li[2]/a/img");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("top");
		selenium.click("link=预览网站");
		selenium.selectFrame("relative=up");
		selenium.click("//ul[@id='top-lanmu']/li[4]/a/span");
		selenium.waitForPageToLoad("2000");
	}

	public void xtestTest() throws Exception {
		selenium
				.open("/website/siteadmin/site!chang_admin_lang.action?lang=first&page=chang_login_lang");
		selenium.type("account", "demo");
		selenium.type("passwd", "demo");
		selenium.click("//input[@value='登录']");
		selenium.waitForPageToLoad("160000");
		selenium.selectFrame("top");
		selenium.click("link=更新网站");
		// selenium.click("link=预览网站");
		selenium.selectFrame("relative=up");
		/*
		 * selenium.click("//ul[@id='top-lanmu']/li[3]/a/span");
		 * selenium.waitForPageToLoad("160000");
		 * selenium.click("//ul[@id='top-lanmu']/li[4]/a/span");
		 * selenium.waitForPageToLoad("160000");
		 * selenium.click("//ul[@id='top-lanmu']/li[6]/a/span");
		 * selenium.waitForPageToLoad("160000");
		 */
	}

	protected void tearDown() throws Exception {

		// selenium.stop();
		super.tearDown();

	}

}
