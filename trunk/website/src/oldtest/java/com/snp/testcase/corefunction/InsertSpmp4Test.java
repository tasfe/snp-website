package com.snp.testcase.corefunction;

/*
添加用户是APP客户端来做的，所以ADO是用文件拿出来的
每次我需要删除，所以表配置，我用UPDATE就可以了
 */
import java.io.File;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.snp.testcase.common.EnvTest;


/*
 20090805 只能支持5种图片格式JPG GIF， png,ico,bmp IE不能直接显示 pcx,tif,tga,
 * 
 * */

public class InsertSpmp4Test extends EnvTest {
	public ApplicationContext ctx;
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(InsertSpmp4Test.class);
		return suite;
	}
	
	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}	
     //将图片目录下的文件全部插入
	public void test_import_pic(){
		ctx = new FileSystemXmlApplicationContext(springconfigfile); //必须写在这里才能短点调试
		AdvanceDAO adao = (AdvanceDAO) ctx.getBean("advanceDAO");
		SiteUser siteUser = (SiteUser) adao.loadById("SiteUser", Long.parseLong("1"));
		BatUploadImg.importpic(new File(EnvTest.path_img), siteUser, adao);
	}

   
}
