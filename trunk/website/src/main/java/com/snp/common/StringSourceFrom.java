package com.snp.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class StringSourceFrom {
	private static Log log = LogFactory.getLog(StringSourceFrom.class);

	/**
	 * 将http请求的字符串保存保存在磁盘，并且返回字符串
	 * */
	public static String getformhttp_get(String filesavepath, String url,
			String encode) throws HttpException, IOException {
		HttpClient client = new HttpClient(
				new MultiThreadedHttpConnectionManager());
		GetMethod get = new GetMethod(url);
		get.setFollowRedirects(true);
		client.executeMethod(get);
		String strHtml = new String(get.getResponseBody(), encode);
		OutputStream out = new BufferedOutputStream(new FileOutputStream(
				filesavepath));
		byte[] bufstr = strHtml.getBytes();
		out.write(bufstr);
		out.close();
		get.releaseConnection();
		return strHtml;
	}

	public static String getformfile(String filesavepath) throws IOException {
		InputStream in;
		in = new BufferedInputStream(new FileInputStream(filesavepath));
		byte[] buf = new byte[in.available()];
		while ((in.read(buf)) != -1) {
		}
		in.close();
		return new String(buf, "utf-8");

	}

	public static String getfromfreemarker(String template_dir,
			String template_name, Map root) throws Exception {
		Configuration cfg = Configuration.getDefaultConfiguration();
		cfg.setDirectoryForTemplateLoading(new File(template_dir));
		/* Create a template */
		Template temp = cfg.getTemplate(template_name);
		/* Create a data model */
		Charset charset = Charset.forName("utf-8"); // 保存到本地的文件就是GBK，如果浏览起器打开就是正确的
		CharsetEncoder encoder = charset.newEncoder();
		FileOutputStream fos = new FileOutputStream("temp.txt", false);
		Writer out = new OutputStreamWriter(fos, encoder);

		BufferedWriter bufferedWriter = new BufferedWriter(out);
		temp.process(root, bufferedWriter);
		out.flush();
		log.debug(StringSourceFrom.getformfile("temp.txt"));
		return StringSourceFrom.getformfile("temp.txt", "utf-8");
	}

	public static String getformfile(String filesavepath, String encode)
			throws IOException {
		InputStream in;
		in = new BufferedInputStream(new FileInputStream(filesavepath));
		byte[] buf = new byte[in.available()];
		while ((in.read(buf)) != -1) {
		}
		in.close();
		return new String(buf, encode);
	}

	public static void main(String[] args) {
	}

}
