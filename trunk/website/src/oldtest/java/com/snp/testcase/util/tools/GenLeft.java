package com.snp.testcase.util.tools;

import java.io.IOException;

public class GenLeft {
	/**
	 * 首先读本地文件然后将该文件的pmp1进行替换，5次
	 * 
	 * @param args
	 * 
	 * @throws IOException
	 * 
	 */

	public static void main(String[] args) throws IOException {

		String filecontent = StringSourceFrom.getformfile("LeftTmp.ftl");
		for (int i = 1; i <= 4; i++) {
			String leftString = filecontent.replaceAll("pmp1", "pmp" + i);
			log.debug(leftString);
		}

		String leftString = filecontent.replaceAll("pmp1", "pmp6");
		log.debug(leftString);

	}

}
