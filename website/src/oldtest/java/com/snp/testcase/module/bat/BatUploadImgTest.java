package com.snp.testcase.module.bat;

/*
 
有压缩算法的：GIF和JPG的压缩算法    (选择多目录栏目测试)
其他文件格式  png, ico，tga, pcx, tif, （利用在SPMP4中上传 ） 

 */
import java.util.Map;

import com.snp.testcase.common.WebTest;


public class BatUploadImgTest extends WebTest{

	public void test_batup_img() throws Exception{
       MockHttpServletRequest request = new MockHttpServletRequest();
       Map params = ServletActionContext.getContext().getParameters();
       ParametersUtils.addParameter(params,"DM.business.BatUploadImg","");
       ParametersUtils.addParameter(params,"OT.Forward.success.Type","freemarker");
       ParametersUtils.addParameter(params,"OT.Forward.success.URL","/siteactionresultadmin/exportuserdata.ftl");
       ParametersUtils.addParameter(params,"exportpath","webroot/bak/");
       ParametersUtils.addParameter(params,"userid","1");
       assertEquals(action.execute(), "success");
       assertEquals(action.getOperationContext().isSystemError(), false);
       assertEquals(action.getOperationContext().isOperationError(), false);
       log.info("测试:批量到如图片");
}	

}
