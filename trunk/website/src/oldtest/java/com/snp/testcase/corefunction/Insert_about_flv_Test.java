package com.snp.testcase.corefunction;

/*

 有压缩算法的：GIF和JPG的压缩算法    (选择多目录栏目测试)
 其他文件格式  png, ico，tga, pcx, tif, （利用在SPMP4中上传 ） 

 */
import java.io.File;
import java.util.Map;

import com.snp.testcase.common.EnvTest;
import com.snp.testcase.common.WebTest;

public class Insert_about_flv_Test extends WebTest {

	public void test_insert_jpg() throws Exception {
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
		ParametersUtils.addParameter(params,
				"DM.Instance.SiteAbout.filepathvideo", "@{upld.filepath}");
		ParametersUtils.addParameter(params,
				"DM.Instance.SiteAbout.heightvideo", "@{upld.heigth}");
		ParametersUtils.addParameter(params, "DM.Instance.SiteAbout.id", "1");
		ParametersUtils.addParameter(params,
				"DM.Instance.SiteAbout.widthvideo", "@{upld.width}");
		ParametersUtils.addParameter(params, "DM.Instance.SiteUser.id", "1");
		ParametersUtils.addParameter(params, "DM.Instance.upld.docroot",
				"path_userhome");
		ParametersUtils.addParameter(params, "DM.Instance.upld.height", "150");
		ParametersUtils.addParameter(params, "DM.Instance.upld.subdir", "/u1/");
		ParametersUtils.addParameter(params, "DM.Instance.upld.uploadFileName",
				"fileLocation");
		ParametersUtils.addParameter(params, "DM.Instance.upld.width", "200");
		ParametersUtils
				.addParameter(params, "DM.Object.SiteAbout", "SiteAbout");
		ParametersUtils.addParameter(params, "DM.Object.SiteUser", "SiteUser");
		ParametersUtils.addParameter(params, "DM.Object.upld", "uploadFlvFile");
		ParametersUtils.addParameter(params, "DM.Reload.SiteUse.__Depends",
				"DM.Update.SiteAbout");
		ParametersUtils.addParameter(params, "DM.Reload.SiteUser", "SiteUser");
		ParametersUtils.addParameter(params, "DM.Update.SiteAbout", "");
		ParametersUtils.addParameter(params, "DM.Update.SiteAbout.__Depends",
				"DM.Upload.upld");
		ParametersUtils.addParameter(params, "DM.Upload.upld", "");

		ParametersUtils.addParameter(params, "fileLocationContentType",
				"video/" + format);

		ServletActionContext.setRequest(request);

		assertEquals(action.execute(), "success");
		assertEquals(action.getOperationContext().isSystemError(), false);
		assertEquals(action.getOperationContext().isOperationError(), false);
		log.info("测试:上传 JPG图片格式");
	}

}
