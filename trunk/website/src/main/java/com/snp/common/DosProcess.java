package com.snp.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DosProcess {
	static boolean done = false;
	private static Log log = LogFactory.getLog(DosProcess.class);

	public static void runcmd(String command) {
		DosProcess.done = false;
		final Process p; // 声明命令项
		BufferedReader is; // 命令输出项
		String line;
		try {
			log.debug(command);
			p = Runtime.getRuntime().exec(command);
			Thread waiter = new Thread() {
				public void run() {
					try {
						p.waitFor();
					} catch (InterruptedException ex) {
						return;
					}
					DosProcess.done = true;// 如果执行完成设置done为真，用于判断命令结束。
				}
			};
			waiter.start();
			is = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while (!done && ((line = is.readLine()) != null))
				log.debug(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
