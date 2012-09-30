package com.snp.common.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegex {
	/*
	 * 通过正则表达式替换掉字符串中的一部分，比如换行，回车等
	 * 
	 * 导出网页中大量用到 str_html = StringUtils.replace(str_html, "=/", "=./");
	 */
	public static String replace(String src, String str_new,
			String str_old_regex) {
		src = src.replaceAll("\r", "");
		src = src.replaceAll("\n", "");
		Pattern pattern = Pattern.compile(str_old_regex);
		Matcher matcher = pattern.matcher(src);
		StringBuffer sbr = new StringBuffer();

		while (matcher.find()) {
			matcher.appendReplacement(sbr, str_new);

		}
		matcher.appendTail(sbr);

		return sbr.toString();

	}

}
