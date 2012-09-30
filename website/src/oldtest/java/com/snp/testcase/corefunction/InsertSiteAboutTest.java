package com.snp.testcase.corefunction;

/*
插入数据是web下插入的
测试语法用发

 */
import java.util.Map;

import com.snp.testcase.common.WebTest;


/*所有的测试案例在这里不要考虑可以每个方法
 单独运行，一切满足  alltest的数据思路
 */
public class InsertSiteAboutTest extends WebTest{
	protected void tearDown() throws Exception {
		log.debug("用户U1数据出始化完毕");
		super.tearDown();
	}
	public void test_insert_siteabout() throws Exception{
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        Map params = ServletActionContext.getContext().getParameters();
	       
	        ParametersUtils.addParameter(params,"DM.Instance.SiteUser.id", "1");
	        ParametersUtils.addParameter(params,"DM.Object.SiteUser", "SiteUser");

	        ParametersUtils.addParameter(params,"DM.Object.SiteAbout", "SiteAbout");
	        ParametersUtils.addParameter(params,"DM.Create.SiteAbout", "");
	        ParametersUtils.addParameter(params,"DM.Instance.SiteAbout.SiteUser", "@{SiteUser}");
	        ParametersUtils.addParameter(params,"DM.Instance.SiteAbout.detail", "hello.world!");

	        ParametersUtils.addParameter(params,"DM.Object.SiteAbout2", "SiteAbout");
	        ParametersUtils.addParameter(params,"DM.Create.SiteAbout2", "");
	        ParametersUtils.addParameter(params,"DM.Instance.SiteAbout2.SiteUser", "@{SiteUser}");
	        ParametersUtils.addParameter(params,"DM.Instance.SiteAbout2.detail", "测试第一!");
	        	        
	        ServletActionContext.setRequest(request);
	        assertEquals(action.execute(), "success");
	        assertEquals(action.getOperationContext().isSystemError(), false);
	        assertEquals(action.getOperationContext().isOperationError(), false);
	        log.info("testAddOperation测试成功");
	}


}
