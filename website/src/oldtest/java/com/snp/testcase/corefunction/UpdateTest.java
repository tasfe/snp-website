package com.snp.testcase.corefunction;

/*
 因为在HTTP请求的过程中，不会关闭掉SESSION
 所以跟这个有关的就要放到SESSION中去做
 lazy 
 导出

 导入是OK的

 */
import junit.framework.TestCase;

public class UpdateTest extends TestCase {

	/*
	 * 主要是测试static String add_user(String username,String password,AdvanceDAO
	 * adao){
	 */
	public void test_print_version() {
		log.debug("编译时间" + SystemInit.snp_compiletime);
		log.debug("SNP主程序版本" + SystemInit.snp_version);
		log.debug("比较少更新版本" + SystemInit.other_version);

	}
	// 只需要比较到短的版本号为数，
	public void test_compare_version() {
		String server_version = "6.7.1.1";
		String local_version = "6.7";
	}
	// http请求测试
	public void test_http_version() {
		SystemInit.snp_version="6.6";
		SystemInit.other_version="0.5";
 	 //   SnpVersion.getfile("snp");
	   // SnpVersion.getfile("other");
	}
}
