package com.snp.testcase.module.update;

/*
 因为在HTTP请求的过程中，不会关闭掉SESSION
 所以跟这个有关的就要放到SESSION中去做
 lazy 
 导出

 导入是OK的

 */
import junit.framework.TestCase;

public class ServerVersionTest extends TestCase {

	/*
	 * 主要是测试static String add_user(String username,String password,AdvanceDAO
	 * adao){
	 */
	public void print_version() {
		log.debug("编译时间" + SystemInit.snp_compiletime);
		log.debug("SNP主程序版本" + SystemInit.snp_version);
		log.debug("比较少更新版本" + SystemInit.other_version);

	}
	// 只需要比较到短的版本号为数，
	public void compare_version() {
		String server_version = "6.7.1.1";
		String local_version = "6.7";
	}
	// http请求测试
	public void http_version() {
		SystemInit.snp_version="6.6";
		SystemInit.other_version="0.5";
 	
	}
	public void test_get_str_serverversion() {
        try {
        	SystemInit.snp_version="6.9.2";
        	String server_version=SnpVersion.get_str_serverversion();
			log.debug("服务器版本"+ SnpVersion.get_str_serverversion());
			log.debug(SnpVersion.compile_version(server_version,SystemInit.snp_version));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SystemInit.snp_version="6.9.2";
//		SystemInit.other_version="0.5";
	}
	
}
