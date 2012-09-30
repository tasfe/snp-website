package com.snp.site.update;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.common.Compress;
import com.snp.common.FileProcessor;
import com.snp.site.init.SystemInit;

public class SnpVersion extends Thread {
	private static Log log = LogFactory.getLog(SnpVersion.class);

	public void run() {
		boolean up_flag = true;
		String server_version = "";
		try {
			server_version = SnpVersion.get_str_serverversion();
		} catch (Exception e2) {
			up_flag = false;
			JOptionPane
					.showConfirmDialog(null, "请检查网络连接，无法访问网络在线升级", "",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
		}

		if (compile_version(server_version, SystemInit.snp_version)) {
			Long long1 = System.currentTimeMillis();
			// 如果需要升级就下载文件和解压
			String filename = "snp" + "_" + server_version + ".zip";
			String url = SystemInit.snp_update_url + filename;
			String savepath = "./" + filename;
			try {
				FileProcessor.getNetfile(url, savepath);
			} catch (Exception e1) {
				up_flag = false;
				JOptionPane.showConfirmDialog(null, SystemInit.snp_version
						+ "->" + server_version + "升级包下载错误，无法在线升级！", "",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			}// 可能出现异常
			try {
				Compress.unpack(filename, "./"); // 可能出现异常
			} catch (Exception e) {
				up_flag = false;
				JOptionPane.showConfirmDialog(null, SystemInit.snp_version
						+ "->" + server_version + "升级包解压错误！", "",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE);

			}

			if (up_flag) {
				log.debug("t_v:" + (System.currentTimeMillis() - long1));
				JOptionPane.showConfirmDialog(null, "SNP已经自动升级为最新版本，"
						+ SystemInit.snp_version + "->" + server_version
						+ "，为了正常使用最新功能，请重新启动SNP软件！", "",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane
					.showConfirmDialog(null, "您已经是最新版本！", "",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// 返回服务器的版本号，如果 不需要升级则为"
	public static String get_server_version(String zipname) throws Exception {
		URL address;
		String version_info = "";
		String srv_version = "";
		try {
			address = new URL(SystemInit.snp_versininfo_url);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					address.openStream())); // 获取输入流
			String line;
			StringBuffer content = new StringBuffer(); // 文件内容
			while ((line = in.readLine()) != null) { // 读取文件
				version_info = version_info + line;
			}
			in.close(); // 关闭输入流
		} catch (Exception e) {
			throw e;

		}
		String[] vsn_split = StringUtils.split(version_info, "|");
		String[] array_server;
		String[] array_local;

		if (zipname.endsWith("snp")) {
			srv_version = vsn_split[0];
			array_server = StringUtils.split(srv_version, ".");
			array_local = StringUtils.split(SystemInit.snp_version, ".");
		} else {
			srv_version = vsn_split[1];
			array_server = StringUtils.split(srv_version, ".");
			array_local = StringUtils.split(SystemInit.other_version, ".");

		}
		int bit = array_server.length;
		if (array_server.length > array_local.length) {
			bit = array_local.length;
		}
		for (int i = 0; i < bit; i++) {
			if (Integer.parseInt(array_server[i]) > Integer
					.parseInt(array_local[i]))
				return srv_version;
			if (Integer.parseInt(array_server[i]) < Integer
					.parseInt(array_local[i]))
				return "";

		}
		if (array_server.length > array_local.length) {
			return srv_version;
		}
		return "";
	}

	public static String get_str_serverversion() throws Exception {
		URL address;
		String version_info = "";
		String srv_version = "";
		try {
			address = new URL(SystemInit.snp_versininfo_url);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					address.openStream())); // 获取输入流
			String line;
			StringBuffer content = new StringBuffer(); // 文件内容
			while ((line = in.readLine()) != null) { // 读取文件
				version_info = version_info + line;
			}
			in.close(); // 关闭输入流
		} catch (Exception e) {
			throw e;
		}

		String[] vsn_split = StringUtils.split(version_info, "|");
		srv_version = vsn_split[0];
		return vsn_split[0];

	}

	// true 是需要升级
	public static boolean compile_version(String srv_version,
			String local_version) {

		String[] array_server;
		String[] array_local;
		array_server = StringUtils.split(srv_version, ".");
		array_local = StringUtils.split(local_version, ".");
		int bit = array_server.length;

		if (array_server.length > array_local.length) {
			bit = array_local.length;
		}
		for (int i = 0; i < bit; i++) {
			if (Integer.parseInt(array_server[i]) > Integer
					.parseInt(array_local[i]))
				return true;
			if (Integer.parseInt(array_server[i]) == Integer
					.parseInt(array_local[i]))
				continue;
			if (Integer.parseInt(array_server[i]) < Integer
					.parseInt(array_local[i]))
				return false;

		}
		if (array_server.length > array_local.length) {
			return true;
		}
		return false; // 默认返回不需要升级
	}
}
