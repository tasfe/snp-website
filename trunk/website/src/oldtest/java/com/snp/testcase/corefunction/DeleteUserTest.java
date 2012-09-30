package com.snp.testcase.corefunction;

/*
添加用户是APP客户端来做的，所以ADO是用文件拿出来的
每次我需要删除，所以表配置，我用UPDATE就可以了
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.snp.testcase.common.EnvTest;




public class DeleteUserTest extends EnvTest {
	public ApplicationContext ctx;


	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(DeleteUserTest.class);
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
	
	/*
	 做的实验，模拟前台删除用户数据
	 如果没有cascade="all-delete-orphan" 
	 * */
	public void test_del_user(){
		List siteUserList = new ArrayList();
		ctx = new FileSystemXmlApplicationContext(springconfigfile); //必须写在这里才能短点调试
		AdvanceDAO adao = (AdvanceDAO) ctx.getBean("advanceDAO");
		siteUserList = adao.findByNamedQuery("findalluser");
		log.debug("用户个数"+siteUserList.size());
		SiteUser siteUser = (SiteUser) siteUserList.get(0);
		log.debug("删除用户："+siteUser.getUsername());
		adao.removeObject(siteUser);
		try {
			FileUtils.deleteDirectory(new File(SystemInit.getSiteHome()+siteUser.getUsername()));
		} catch (IOException e) {
		//e.printStackTrace();
		}		
		
		log.debug("用户删除完毕");
		String sql = "from SiteUser as siteuser";
		List ls = adao.find(sql);
		log.info("个数是" + ls.size());
		
	}
   
}
