package com.snp.testcase.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.snp.testcase.common.EnvTest;

import freemarker.template.Configuration;
import freemarker.template.Template;
/*
 结论是虽然ZIP里面直接打开文件名是乱码，但是最终解压出来的 
文件还是正常的
 **/
public class FreemarkProcessorTest extends TestCase{
	public void path() throws Exception {
	     Configuration cfg = Configuration.getDefaultConfiguration();
	        cfg.setDirectoryForTemplateLoading(
	                new File(EnvTest.path_res+"freemarker"));

	        /* Create a template */
	        Template temp = cfg.getTemplate("test.ftl");

	        /* Create a data model */
	        Map root = new HashMap();
	        root.put("user", "Big Joe");
	        Map latest = new HashMap();
	        root.put("latestProduct", latest);
	        latest.put("url", "products/greenmouse.html");
	        latest.put("name", "green mouse");
        
	        /* Merge data model with template */
	      
	        Writer out = new OutputStreamWriter(System.out);

	        temp.process(root, out);
	  
	        out.flush();
	        

	}	
	public void test_file() throws Exception {
	     Configuration cfg = Configuration.getDefaultConfiguration();
	        cfg.setDirectoryForTemplateLoading(
	                new File(EnvTest.path_res+"freemarker"));

	        /* Create a template */
	        Template temp = cfg.getTemplate("test.ftl");

	        /* Create a data model */
	        Map root = new HashMap();
	        root.put("user", "Big Joe");
	        Map latest = new HashMap();
	        root.put("latestProduct", latest);
	        latest.put("url", "products/greenmouse.html");
	        latest.put("name", "green mouse");
       
	        Charset charset = Charset.forName("utf-8"); //保存到本地的文件就是GBK，如果浏览起器打开就是正确的
			CharsetEncoder encoder = charset.newEncoder();
			FileOutputStream fos=new FileOutputStream(
					"temp.txt", false);
			Writer out = new OutputStreamWriter(fos, encoder);
			
			BufferedWriter bufferedWriter=new  BufferedWriter(out);
			temp.process(root, bufferedWriter);
			
			
	        out.flush();
	        log.debug("得到"+ StringSourceFrom.getformfile("temp.txt"));

	}	
}
