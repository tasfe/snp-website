package com.snp.testcase.util;

import java.io.File;

import junit.framework.TestCase;

import com.snp.testcase.common.EnvTest;


/*
 结论是虽然ZIP里面直接打开文件名是乱码，但是最终解压出来的 
 文件还是正常的
 **/
public class FileProcessorTest extends TestCase {
	public static String user_name = "u1";
	public static String compresspath = "src/test/resources/" + user_name;
	public static String temp_path = "temp/" + user_name;


	public void setUp() throws Exception {
		// FileUtils.deleteDirectory(new File("temp"));
		FileProcessor.createNewDir(temp_path);
	}

	private static void listdir(File f, String base) throws Exception {
		if (f.isDirectory()) {
			String result=FileProcessor.check_chinese_string(f.getAbsolutePath())?"（中文目录）":"（英文目录）";
			log.debug(f.getAbsolutePath()+":"+result);
			File[] fl = f.listFiles();
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				listdir(fl[i], base + fl[i].getName());
			}
		}
	}

	public void test_check_chinese_string() throws Exception {
		listdir(new File(compresspath), "");
	}

	public void test_path() throws Exception {
		log.debug(System.getProperty("user.dir"));//
	}	
	public void test_file_size() throws Exception {
		log.debug("图片文件大小"+new File(EnvTest.path_img+"jpg-1.jpg").length());//

		log.debug(new File(EnvTest.path_img+"jpg-1.jpg").length()<500000);//
}	
}
