/**
 * 
 */
package com.snp.testcase.common;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EnvTest extends TestCase {
	protected transient final Log log = LogFactory.getLog(getClass());
	public static String springconfigfile = "file:./src/conf/spring*.xml";
	public static String path_img = "src/test/resources/picture/";
	public static String path_video = "../other/video/";
	public static String path_xml = "src/test/resources/xml/";
	public static String path_res = "src/test/resources/";
	public static String path_url_public = "http://www.snpsoft.net/public/";
	
	static{
         SystemInit.debug_junit=true;
	}
	public static void delete_old_data() {
		try {
			FileUtils.deleteDirectory(new File("conf/database/hsql"));
			FileUtils.deleteDirectory(new File("webroot/site/u1"));
			FileUtils.deleteDirectory(new File("webroot/site/u2"));
			
			log.debug("删除HSQ数据库.u1 u2 用户目录");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void cleantemp() {
		try {
			FileUtils.deleteDirectory(new File("temp"));
			FileProcessor.createNewDir("temp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
