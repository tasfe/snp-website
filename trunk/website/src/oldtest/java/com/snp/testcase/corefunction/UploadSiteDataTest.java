package com.snp.testcase.corefunction;
import java.io.File;
import java.util.Map;

import com.snp.testcase.common.WebTest;

public class UploadSiteDataTest extends WebTest {

	public void test_upload_sitedata()  {
		MockHttpServletRequest request = new MockHttpServletRequest();
		Map params = ServletActionContext.getContext().getParameters();
		File file = new File("webroot/bak/u1.zip");
		File[] file_array = { file };
		ParametersUtils.addParameter(params, "fileLocationContentType",
				"application/x-zip-compressed");
	
		ParametersUtils.addParameter(params, "fileLocationFileName", file
				.getName());
		ServletActionContext.getContext().getParameters().put("fileLocation",
				file_array);
		String userid="2";
		AdvanceDAO adao = (AdvanceDAO) ctx.getBean("advanceDAO");
		SiteUser siteUser = (SiteUser) adao.loadById("SiteUser", Long.parseLong(userid));
		ServletActionContext.getContext().getSession().put(SystemInit.clientloginflag, siteUser);
		//SiteUser current_user=(SiteUser)sessionMap.get(SystemInit.clientloginflag);
		ParametersUtils.addParameter(params, "DM.Instance.SiteUser.id", userid);
		ParametersUtils.addParameter(params, "DM.Instance.upld.docroot",
				"path_userhome");
		ParametersUtils.addParameter(params, "DM.Instance.upld.op", "onlydata");
		ParametersUtils.addParameter(params, "DM.Instance.upld.subdir", "/u2/");
		ParametersUtils.addParameter(params, "DM.Instance.upld.timeprefix",
				"no");
		ParametersUtils.addParameter(params, "DM.Instance.upld.uploadFileName",
				"fileLocation");
		ParametersUtils.addParameter(params, "DM.Object.SiteUser", "SiteUser");
		ParametersUtils
				.addParameter(params, "DM.Object.upld", "uploadSiteData");
		ParametersUtils.addParameter(params, "DM.Reload.SiteUser", "");
		ParametersUtils.addParameter(params, "DM.Upload.upld", "");

		ServletActionContext.setRequest(request);
		assertEquals(action.execute(), "success");
//		assertEquals(action.getOperationContext().isSystemError(), false);
//		assertEquals(action.getOperationContext().isOperationError(), false);
		log.info("测试:导入数据");
	}

}
