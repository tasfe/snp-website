package com.snp.testcase.util;


import junit.framework.TestCase;
/*
 结论是虽然ZIP里面直接打开文件名是乱码，但是最终解压出来的 
文件还是正常的
 **/
public class CompreessTest extends TestCase{
	public static String  user_name="u1";
    public static String  compresspath="src/test/resources/"+user_name;
    public static String  temp_path="temp/"+user_name;

	public void setUp() throws Exception {
		//FileUtils.deleteDirectory(new File("temp"));
		FileProcessor.createNewDir(temp_path);
	}
	public void test_zip() throws Exception {
		Compress.zip(compresspath, temp_path+".zip");
	}  
	/*
	 留意测试里面带中文乱码的，我们把中文拖进ZIP不会乱码，但是如果我们是用JAVA代码ZIP的就会乱码
	截压时，乱码文件删除不了，还
	*/
	public void test_unpack() throws Exception {
		//Compress.unpack(file.getAbsolutePath(), userhome);
		Compress.unpack(temp_path+".zip", temp_path+"/");
	}  
	public void test_unpack_no_config() throws Exception {
		//Compress.unpack(file.getAbsolutePath(), userhome);
		Compress.unpack_no_config(temp_path+".zip", temp_path+"/");
	}  	
}
