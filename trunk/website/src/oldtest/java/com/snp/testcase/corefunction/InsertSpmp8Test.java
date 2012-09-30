package com.snp.testcase.corefunction;

/*

 有压缩算法的：GIF和JPG的压缩算法    (选择多目录栏目测试)
 其他文件格式  png, ico，tga, pcx, tif, （利用在SPMP4中上传 ） 

 */
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.commons.lang.StringUtils;

import com.snp.testcase.common.EnvTest;
import com.snp.testcase.common.WebTest;
import com.snp.testcase.util.VideoProsessTest;

public class InsertSpmp8Test extends WebTest {
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(InsertSpmp8Test.class);
		return suite;
	}

	public HashMap getpara(File file) {
		HashMap video_params = new HashMap();
		File[] file_array = { file };
		String format = StringUtils.substringAfterLast(file.getName(), ".");
		ParametersUtils.addParameter(video_params,
				"DM.Instance.upld.uploadFileName", "fileLocation");
		ParametersUtils.addParameter(video_params, "fileLocationFileName", file
				.getName());
		ServletActionContext.getContext().getParameters().put("fileLocation",
				file_array);

		ParametersUtils.addParameter(video_params, "DM.Create.SiteSpmp8", "");
		ParametersUtils.addParameter(video_params,
				"DM.Create.SiteSpmp8.__Depends", "DM.Upload.upld");
		ParametersUtils.addParameter(video_params,
				"DM.Instance.SiteSpmp8.SiteUser", "@{SiteUser}");
		ParametersUtils.addParameter(video_params,
				"DM.Instance.SiteSpmp8.filename", "@{upld.fileName}");
		ParametersUtils.addParameter(video_params,
				"DM.Instance.SiteSpmp8.filepath", "@{upld.filepath}");
		ParametersUtils.addParameter(video_params, "DM.Instance.upld.height",
				"250");
		ParametersUtils.addParameter(video_params, "DM.Instance.upld.width",
				"350");

		ParametersUtils.addParameter(video_params,
				"DM.Instance.SiteSpmp8.height", "@{upld.height}");
		ParametersUtils.addParameter(video_params,
				"DM.Instance.SiteSpmp8.width", "@{upld.width}");
		ParametersUtils.addParameter(video_params,
				"DM.Instance.SiteSpmp8Item.detail", "影响图片格式:" + format);
		ParametersUtils.addParameter(video_params, "DM.Instance.SiteUser.id",
				"1");
		ParametersUtils.addParameter(video_params, "DM.Object.SiteUser",
				"SiteUser");

		ParametersUtils.addParameter(video_params, "DM.Instance.upld.docroot",
				"path_userhome");
		ParametersUtils.addParameter(video_params, "DM.Instance.upld.subdir",
				"/u1/");

		ParametersUtils.addParameter(video_params, "DM.Object.SiteSpmp8",
				"SiteSpmp8");
		ParametersUtils.addParameter(video_params, "DM.Object.upld",
				"uploadFlvFile");
		ParametersUtils.addParameter(video_params, "DM.Reload.SiteUser",
				"SiteUser");
		ParametersUtils.addParameter(video_params,
				"DM.Reload.SiteUser.__Depends", "DM.Create.SiteSpmp8");

		ParametersUtils.addParameter(video_params, "DM.Upload.upld", "");

		ParametersUtils.addParameter(video_params, "fileLocationContentType",
				"video/" + format);

		return video_params;

	}

	public void test_insert_flv() throws Exception {
		// File[] filelist = new File(EnvTest.path_video).listFiles();
		VideoProsessTest.clean();
		File[] filelist = SystemInit.get_video_filelist(new File(
				EnvTest.path_video));
		for (int i = 0; i < filelist.length; i++) {
			log.debug(filelist[i].getAbsolutePath());
		}
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].getName().endsWith("bat")
					|| filelist[i].getName().endsWith("svn"))
				continue;
			MockHttpServletRequest request = new MockHttpServletRequest();
			Map params = ServletActionContext.getContext().getParameters();
			params.putAll(getpara(filelist[i])); // 才能保证参数不会重复，不然在直接ADD会导致参数不断累加；

			ServletActionContext.setRequest(request);
			action.execute();
			log.info("测试上传格式:" + filelist[i].getName());
		}

	}

}
