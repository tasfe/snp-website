package com.snp.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

public class GetipAddress implements java.io.Serializable {
	// private static char DELIMITER ;
	public static String ip = "localhost";
	public static String port = "80";
	public static String hostname = "localhost";
	public static boolean interflag = false;

	public GetipAddress() {
	}

	public static void main(String[] args) throws Exception {
		// openadmin() ;
	}

	public static String getipurl() {
		if (port.equals("80"))
			return "http://" + GetipAddress.ip;
		return "http://" + GetipAddress.ip + ":" + port;
	}

	public static String gethostnameurl() {
		if (port.equals("80"))
			return "http://" + GetipAddress.gethostname();
		return "http://" + GetipAddress.gethostname() + ":" + port;

	}

	public static void openUrl(String url) {

		try {

			Runtime.getRuntime().exec("cmd   /c   start  iexplore.exe " + url);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getProcessString() {
		String os = System.getProperty("os.name").toLowerCase();

		if (os == null)
			return null;
		if (os.indexOf("window") >= 0) {

			return "ipconfig ";
		}
		if (os.indexOf("aix") >= 0) {

			return "netstat -in";
		}
		if (os.indexOf("hp-ux") >= 0) {

			return "netstat -in";
		}

		return "netstat -in";
	}

	/**/

	public static String gethostname() {
		return "127.0.0.1";
	}

	public static void getipinfo() {
		Runtime run = Runtime.getRuntime();
		Process process = null;

		try {
			process = run.exec(getProcessString());

			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));

			String line;

			while ((line = reader.readLine()) != null) {
				if (StringUtils.contains(line, "PPP")) {
					// 拨号程序有一个真实IP
					interflag = true;
				}
				if (StringUtils.contains(line, "Address")) {
					ip = StringUtils.substringAfter(line, ":").trim();

					if (interflag == true || ip.equalsIgnoreCase("localhost")) {
						ip = StringUtils.substringAfter(line, ":").trim();
						break;
					}
				}
			}

		} catch (IOException ioe) { // not windows
			ioe.printStackTrace();

		}
	}

}
