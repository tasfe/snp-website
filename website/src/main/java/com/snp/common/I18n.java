package com.snp.common;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;

public class I18n {
	private static Log log = LogFactory.getLog(I18n.class);

	public I18n() {
	}

	/**
	 * 得到网站的字符串，则 <td width="40%"><FONT
	 * color=#ffffff>${results["infomap"].getStringbyfile
	 * (local,"shopproductname")?if_exists}</FONT></td>
	 */
	public static String getStringbyfile(String lang, String keyname) {
		try {
			if (SystemInit.siteStrMap.size() == 0) {
				SystemInit.siteStrMap = SystemInit.getMapFromePropFile(
						SystemInit.getClassPath() + "/lang", "txt");
			}
			return (String) SystemInit.siteStrMap.get("webinfo-" + lang + "_"
					+ keyname);
		} catch (Exception e) {
			log.error(e);
			return "";
		}
	}

	/** } */

	public static HashMap getSnpLanguageList() {

		return SystemInit.getLanguage();

	}

	public static void main(String[] args) {
		// DebugUtil.printmap_string( AppConfFile.getMap("webinfo-zh-TW"));
		// DebugUtil.printmap_string( snpStrMap);
		/*
		 * 通过一个ACTION将这个APPCONFIGLE放入SESSION中，然后，只要进入登陆界面，如果没有就调用一下， 执行后要刷新页面
		 */
		// log.debug("用户名"+AppConfFile.getSnpStringbyfile("zh-CN","username"));
	}
}
