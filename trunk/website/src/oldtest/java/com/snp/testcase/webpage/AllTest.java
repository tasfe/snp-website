package com.snp.testcase.webpage;

import junit.framework.TestCase;

public class AllTest extends TestCase {
	private Selenium selenium;

	protected void setUp() throws Exception {
		String url = "http://localhost:80/site/u1";
		selenium = new DefaultSelenium("localhost", 4444,
				"*firefox e:\\soft\\Mozilla Firefox\\firefox.exe", url);
		// 主要是IE设置了拦截弹出窗口插件
		selenium.start();
		super.setUp();

	}
	

	
	public void test_all() throws Exception {
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
		
		
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
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
		
		selenium.waitForPageToLoad("30000");
		selenium.click("insert_img");
		selenium.waitForPageToLoad("30000");
		selenium.type("oursite_filelocate", "E:\\datum-material\\pic-图片\\pic-运动\\F80666.JPG");
		selenium.click("oursite_input");
		*/
		
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=up");
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
	
		//备份
		selenium.selectFrame("top");
		selenium.click("link=网站备份");
        
		//导入
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("top");
		selenium.click("link=导入备份");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("mainFrame");
		selenium.type("fileLocation",
				"webroot\\bak\\u1.zip");
		selenium.click("//input[@id='oursite_input' and @value='确定']");
		selenium.waitForPageToLoad("30000");		
	}
	

	
	


	
	
	




	protected void tearDown() throws Exception {

		// selenium.stop();
		super.tearDown();

	}

}
