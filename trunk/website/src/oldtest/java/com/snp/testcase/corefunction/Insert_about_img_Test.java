package com.snp.testcase.corefunction;

/*
 
有压缩算法的：GIF和JPG的压缩算法    (选择多目录栏目测试)
其他文件格式  png, ico，tga, pcx, tif, （利用在SPMP4中上传 ） 

 */
import java.io.File;
import java.util.Map;

import com.snp.testcase.common.WebTest;


public class Insert_about_img_Test extends WebTest{

	public void test_insert_jpg() throws Exception{
       MockHttpServletRequest request = new MockHttpServletRequest();
       Map params = ServletActionContext.getContext().getParameters();
       
       File file=new File("src/test/resources/picture/jpg-1.jpg"); 
	   File[] file_array={file};
	   
	  
	  /*因为有重复  */
	   
	   ParametersUtils.addParameter(params,"fileLocationContentType","image/pjpeg");
       ParametersUtils.addParameter(params,"fileLocationFileName",file.getName());
 	   ServletActionContext.getContext().getParameters().put("fileLocation", file_array);
       ParametersUtils.addParameter(params,"DM.Object.SiteAbout","SiteAbout");
       ParametersUtils.addParameter(params,"DM.Object.upld","uploadPicFile");
 	   ParametersUtils.addParameter(params,"DM.Instance.upld.docroot","path_userhome");
       ParametersUtils.addParameter(params,"DM.Instance.upld.height","160");
       ParametersUtils.addParameter(params,"DM.Instance.upld.width","180");
       ParametersUtils.addParameter(params,"DM.Instance.upld.subdir","/u1/");
       ParametersUtils.addParameter(params,"DM.Instance.upld.uploadFileName","fileLocation");
       
       
       ParametersUtils.addParameter(params,"DM.Upload.upld","");
       
       
       ParametersUtils.addParameter(params,"DM.Update.SiteAbout","");
       ParametersUtils.addParameter(params,"DM.Update.SiteAbout.__Depends","DM.Upload.upld");
       ParametersUtils.addParameter(params,"DM.Instance.SiteAbout.filename","@{upld.fileName}");
       ParametersUtils.addParameter(params,"DM.Instance.SiteAbout.filepath","@{upld.filepath}");
       ParametersUtils.addParameter(params,"DM.Instance.SiteAbout.height","@{upld.height}");
       ParametersUtils.addParameter(params,"DM.Instance.SiteAbout.width","@{upld.width}");
       ParametersUtils.addParameter(params,"DM.Instance.SiteAbout.id","1");

     
       ServletActionContext.setRequest(request);
       
       assertEquals(action.execute(), "success");
       assertEquals(action.getOperationContext().isSystemError(), false);
       assertEquals(action.getOperationContext().isOperationError(), false);
       log.info("测试:上传 JPG图片格式");
}	

}
