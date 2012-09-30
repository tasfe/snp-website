package com.snp.testcase.module.exporthtml;

/*
在EXE 客户端导出HTML网页时需要用到，因为懒加载
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.snp.testcase.common.EnvTest;




public class findByNamedQueryTest extends EnvTest {
	public ApplicationContext ctx;


	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(findByNamedQueryTest.class);
		return suite;
	}
	
	@Override
	protected void tearDown() throws Exception {
	
		super.tearDown();
	}

	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}	
	/*
	 我们的数据因为是懒加载不能查子对象时，可以这样处理
	 <query name="findalluser"><![CDATA[from SiteUser user]]></query>
	 siteUserList = adao.findByNamedQuery("findalluser");
	 
	 this.getHibernateTemplate().find("from bean.User u where u.name=?", "test");   
	 */
	public void test_query(){
		List siteUserList = new ArrayList();
		ctx = new FileSystemXmlApplicationContext(springconfigfile); //必须写在这里才能短点调试
		AdvanceDAO adao = (AdvanceDAO) ctx.getBean("advanceDAO");
		siteUserList = adao.findByNamedQuery("findalluser");
		log.debug("用户个数"+siteUserList.size());
		SiteUser siteUser = (SiteUser) siteUserList.get(0);
		log.debug(siteUser.getUsername());
	    /*
		for (Iterator iterator = siteUser.getSiteSpmp1s().iterator(); iterator.hasNext();) {
			SiteSpmp1 siteSpmp1 = (SiteSpmp1) iterator.next();
			log.debug(siteSpmp1.getName());
		}
		*/
		List siteSpmp1List = adao.findByNamedQuery("findspmp1",siteUser.getId());
		log.debug("根据ID查的个数是"+siteSpmp1List.size());
		for (Iterator iterator = siteSpmp1List.iterator(); iterator.hasNext();) {
			SiteSpmp1 siteSpmp1 = (SiteSpmp1) iterator.next();
			log.debug(siteSpmp1.getName());
		}
	}
   
}
