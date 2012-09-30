package com.snp.testcase.module.upload;

/*

 有压缩算法的：GIF和JPG的压缩算法    (选择多目录栏目测试)
 其他文件格式  png, ico，tga, pcx, tif, （利用在SPMP4中上传 ） 

 */
import java.io.File;
import java.util.Map;

import com.snp.testcase.common.EnvTest;
import com.snp.testcase.common.WebTest;

public class UploadSpmp8Test extends WebTest {
	public void test_insert_flv() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		Map params = ServletActionContext.getContext().getParameters();
		String format = "avi";
		File file = new File(EnvTest.path_video + format + "." + format);
		File[] file_array = { file };
		ParametersUtils.addParameter(params, "DM.Instance.upld.uploadFileName",
				"fileLocation");
		ParametersUtils.addParameter(params, "fileLocationFileName", file
				.getName());
		ServletActionContext.getContext().getParameters().put("fileLocation",
				file_array);
		ParametersUtils.addParameter(params, "DM.Create.SiteSpmp8", "");
		ParametersUtils.addParameter(params, "DM.Create.SiteSpmp8.__Depends",
				"DM.Upload.upld");
		ParametersUtils.addParameter(params, "DM.Instance.SiteSpmp8.SiteUser",
				"@{SiteUser}");
		ParametersUtils.addParameter(params, "DM.Instance.SiteSpmp8.filename",
				"@{upld.fileName}");
		ParametersUtils.addParameter(params, "DM.Instance.SiteSpmp8.filepath",
				"@{upld.filepath}");
		
	       ParametersUtils.addParameter(params,"DM.Instance.upld.height","250");
	       ParametersUtils.addParameter(params,"DM.Instance.upld.width","350");
		
		ParametersUtils.addParameter(params, "DM.Instance.SiteSpmp8.height",
				"@{upld.height}");
		ParametersUtils.addParameter(params, "DM.Instance.SiteSpmp8.width",
				"@{upld.width}");
		ParametersUtils.addParameter(params,
				"DM.Instance.SiteSpmp8Item.title", "影响图片格式:" + format);
		ParametersUtils.addParameter(params, "DM.Instance.SiteUser.id", "1");
		ParametersUtils.addParameter(params, "DM.Object.SiteUser", "SiteUser");

		ParametersUtils.addParameter(params, "DM.Instance.upld.docroot",
				"path_userhome");
		ParametersUtils.addParameter(params, "DM.Instance.upld.subdir", "/u1/");

		ParametersUtils
				.addParameter(params, "DM.Object.SiteSpmp8", "SiteSpmp8");
		ParametersUtils.addParameter(params, "DM.Object.upld", "uploadFlvFile");
		ParametersUtils.addParameter(params, "DM.Reload.SiteUser", "SiteUser");
		ParametersUtils.addParameter(params, "DM.Reload.SiteUser.__Depends",
				"DM.Create.SiteSpmp8");

		ParametersUtils.addParameter(params, "DM.Upload.upld", "");

		ParametersUtils.addParameter(params, "fileLocationContentType",
				"video/" + format);

		ServletActionContext.setRequest(request);
		action.execute();
		/*
		 * assertEquals(action.execute(), "success");
		 * assertEquals(action.getOperationContext().isSystemError(), false);
		 * assertEquals(action.getOperationContext().isOperationError(), false);
		 */
		log.info("测试上传格式:" + file.getName());
	}

}
