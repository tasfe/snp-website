package com.snp.testcase.corefunction;

/*
添加用户是APP客户端来做的，所以ADO是用文件拿出来的
每次我需要删除，所以表配置，我用UPDATE就可以了
 */
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.snp.testcase.common.EnvTest;




public class AddUserTest extends EnvTest {
	public ApplicationContext ctx;


	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(AddUserTest.class);
		return suite;
	}
	
	@Override
	protected void tearDown() throws Exception {
		log.debug("用户添加完毕");
		super.tearDown();
	}

	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}	
	public void test_add_user(){
		ctx = new FileSystemXmlApplicationContext(springconfigfile); //必须写在这里才能短点调试
		AdvanceDAO adao = (AdvanceDAO) ctx.getBean("advanceDAO");
		SnpDemo.add_user("u1", "u1", adao);
		SnpDemo.add_user("u2", "u2", adao);
		log.debug("用户添加完毕11");
		String sql = "from SiteUser as siteuser";
		List ls = adao.find(sql);
		log.info("个数是" + ls.size());
		
	}
   
}
