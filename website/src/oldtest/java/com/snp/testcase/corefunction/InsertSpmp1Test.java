package com.snp.testcase.corefunction;

/*
添加用户是APP客户端来做的，所以ADO是用文件拿出来的
每次我需要删除，所以表配置，我用UPDATE就可以了
 */
import junit.framework.Test;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.snp.testcase.common.EnvTest;




public class InsertSpmp1Test extends EnvTest {
	public ApplicationContext ctx;


	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(InsertSpmp1Test.class);
		return suite;
	}
	

	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}	
	public void test_add_user(){
		ctx = new FileSystemXmlApplicationContext(springconfigfile); //必须写在这里才能短点调试
		AdvanceDAO adao = (AdvanceDAO) ctx.getBean("advanceDAO");
		SiteUser siteUser = (SiteUser) adao.loadById("SiteUser", Long.parseLong("1"));
		SiteSpmp1 siteSpmp1 = new SiteSpmp1();
		siteSpmp1.setSiteUser(siteUser);
		siteSpmp1.setDetail("ok");
		adao.saveObject(siteSpmp1);
		SiteSpmp1Item siteSpmp1Item = new SiteSpmp1Item();
		siteSpmp1Item.setDetail("111子-ok");
		siteSpmp1Item.setSiteSpmp1(siteSpmp1);
		adao.saveObject(siteSpmp1Item);
		
		
	}
   
}
