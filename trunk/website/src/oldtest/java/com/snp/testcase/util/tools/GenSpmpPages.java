package com.snp.testcase.util.tools;

import java.io.IOException;

public class GenSpmpPages {

	/**
	 * 
	 * 首先读本地文件然后将该文件的pmp1进行替换，5次
	 * 
	 * @param args
	 * 
	 * @throws IOException
	 * 
	 */

	public static void main(String[] args) throws Exception {
		// 4是产品栏目列表
		String filecontent = StringSourceFrom.getformfile("spmp1.ftl");
		for (int i = 2; i <= 3; i++) {
			String newString = filecontent.replaceAll("pmp1", "pmp" + i);

			log.debug("栏目" + i);
			FileProcessor.writetofileNotime("spmp" + i + ".ftl", newString);
		}
		String newString = filecontent.replaceAll("pmp1", "pmp6");
		log.debug("栏目" + 6);
		FileProcessor.writetofileNotime("spmp6.ftl", newString);

	}
}
