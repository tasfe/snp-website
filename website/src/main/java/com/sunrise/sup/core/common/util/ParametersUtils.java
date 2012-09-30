/*
 * 锟斤拷锟斤拷锟斤拷锟斤拷 2005-1-7
 *
 */
package com.sunrise.sup.core.common.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 锟斤拷锟斤拷锟阶帮拷锟? 锟斤拷锟皆把诧拷锟斤拷锟阶拔拷锟斤拷锟斤拷锟斤拷锟揭拷牟锟斤拷锟?
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class ParametersUtils {

	private ParametersUtils() {
	}

	public static void addParameter(Map params, String key, String obj) {
		if (params.containsKey(key) && (params.get(key) instanceof String[])) {
			String[] oldStrs = (String[]) params.get(key);
			String[] strs = new String[oldStrs.length + 1];
			for (int i = 0; i < oldStrs.length; i++) {
				strs[i] = oldStrs[i];
			}
			strs[oldStrs.length] = obj;
			params.put(key, strs);
		} else {
			params.put(key, new String[] { obj });
		}

	}

	public static void addParameter(Map params, String key, String[] objs) {
		if (params.containsKey(key) && (params.get(key) instanceof String[])) {
			String[] oldStrs = (String[]) params.get(key);
			String[] strs = new String[oldStrs.length + objs.length];
			for (int i = 0; i < oldStrs.length; i++) {
				strs[i] = oldStrs[i];
			}
			for (int i = oldStrs.length; i < strs.length; i++) {
				strs[i] = objs[i - oldStrs.length];
			}
			params.put(key, strs);
		} else {
			params.put(key, objs);
		}
	}

	public static void addParameter(Map params, String[] objs) {
		if (objs == null || objs.length < 1)
			return;
		for (int i = 0; i < objs.length; i++) {
			addParameter(params, objs[i]);
		}
	}

	public static void addParameter(Map params, String obj) {
		if (StringUtils.trimToNull(obj) == null) {
			return;
		}
		int cout = StringUtils.indexOf(obj, "=");
		if (cout > -1) {
			String key = StringUtils.substring(obj, 0, cout);
			String value = StringUtils.substring(obj, cout + 1, obj.length());
			addParameter(params, key.trim(), value);

		} else {
			addParameter(params, obj.trim(), "");
		}

	}

}
