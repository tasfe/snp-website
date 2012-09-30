/*
 * Copyright (C), 2006-2009, Sunrise Tech. Co., Ltd.
 * SUNRISE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sunrise.sup.core.common.util;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author huangsj
 * @author Huang Weiqiang
 */
public class URLUtil {

	/**
	 * 32空格,是可打印字符的最低值
	 */
	private static final int PRINTABLE_CHAR_LOWER_LIMIT = 32;

	/**
	 * 构造Url
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String concatUrl(String url, Map params) {
		return concatUrl(url, params, false);
	}

	/**
	 * 构造Url
	 * 
	 * @param url
	 * @param params
	 * @param removeUnprintableChar
	 *            是否去掉不可打印ascii字符
	 * @return
	 */
	public static String concatUrl(String url, Map params,
			boolean removeUnprintableChar) {
		Iterator it = params.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			Object value = params.get(key);
			if (value instanceof Object[]) {
				Object[] temp = (Object[]) value;
				for (int i = 0; i < temp.length; i++) {
					url = concatUrl(url, key, temp[i].toString());
				}
			} else {
				url = concatUrl(url, key, value.toString());
			}
		}
		if (removeUnprintableChar) {
			return removeUnprintableChar(url);
		} else {
			return url;
		}
	}

	/**
	 * 去掉不可打印ascii字符
	 * 
	 * @param url
	 * @return
	 */
	public static String removeUnprintableChar(String url) {
		if (url == null)
			return null;
		StringBuffer finalUrl = new StringBuffer();
		for (int i = 0; i < url.length(); i++) {
			char a = url.charAt(i);
			if (a >= PRINTABLE_CHAR_LOWER_LIMIT) {
				finalUrl.append(a);
			}
		}
		return finalUrl.toString();
	}

	/**
	 * 构造Url
	 * 
	 * @param url
	 * @param name
	 * @param value
	 * @return
	 */
	public static String concatUrl(String url, String name, String value) {
		String params = name + "=" + value;
		params = StringUtils.replace(params, "#", "%23");
		if (url.indexOf("?") >= 0) {
			url += "&" + params;
		} else {
			url += "?" + params;
		}
		return url;
	}
}