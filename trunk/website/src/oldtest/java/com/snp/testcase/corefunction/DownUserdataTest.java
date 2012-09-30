package com.snp.testcase.corefunction;


/*
 因为在HTTP请求的过程中，不会关闭掉SESSION
 所以跟这个有关的就要放到SESSION中去做
lazy 
 导出

 导入是OK的
 
*/
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Map;

import com.snp.testcase.common.WebTest;

public class DownUserdataTest extends WebTest {
	/*siteadmin/head.ftl的导出用户数据*/
	public void testUserDataAdminExport() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		Map params = ServletActionContext.getContext().getParameters();
		ParametersUtils.addParameter(params, "DM.business.DownSitedata", "");
		ParametersUtils.addParameter(params, "exportpath", SystemInit.getUserDatapath());
		ParametersUtils.addParameter(params, "userid", "1");
		ServletActionContext.setRequest(request);
		assertEquals(action.execute(), "success");
		assertEquals(action.getOperationContext().isSystemError(), false);
		assertEquals(action.getOperationContext().isOperationError(), false);
	//	log.info("导出用户数据测试成功");
	}
	
	
	public void printspmp1(String objectFilePath) {
		try {
			ObjectInputStream in;
			in = new ObjectInputStream(new FileInputStream(objectFilePath));
			SiteUser siteuser = (SiteUser) in.readObject();
			log.debug("从USER.DAT文件中读出的数据");
			for (Iterator iterator = siteuser.getSiteSpmp1s().iterator(); iterator
					.hasNext();) {
				SiteSpmp1 sitespmp1 = (SiteSpmp1) iterator.next();
				log.debug(sitespmp1.getDetail());
				for (Iterator iterator2 = sitespmp1.getSiteSpmp1Items()
						.iterator(); iterator2.hasNext();) {
					SiteSpmp1Item siteSpmp1Item = (SiteSpmp1Item) iterator2
							.next();
					log.debug(siteSpmp1Item.getDetail());
				}
			}
            /**/
			for (Iterator iterator = siteuser.getSiteSpmp4s().iterator(); iterator
					.hasNext();) {
				SiteSpmp4 sitespmp4 = (SiteSpmp4) iterator.next();
				log.debug(sitespmp4.getDetail());
				for (Iterator iterator2 = sitespmp4.getSiteSpmp4Items()
						.iterator(); iterator2.hasNext();) {
					SiteSpmp4Item siteSpmp4Item = (SiteSpmp4Item) iterator2
							.next();
					log.debug(siteSpmp4Item.getDetail());
					for (Iterator iterator3 = siteSpmp4Item.getSiteProducts().iterator(); iterator3
							.hasNext();) {
						SiteProduct product = (SiteProduct) iterator3.next();
						log.debug("产品"+product.getDetail());
					}
				
				}
			}	
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
