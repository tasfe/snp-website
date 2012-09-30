package com.snp.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;

public class WebworkCookie {
	public static final int DEFAULT_COOKIE_AGE = 24 * 60 * 60;

	public static final String DEFAULT_COOKIE_PATH = "/";

	public static final int ONCE_COOKIE_TIME = -1000;

	public static void addCookie(String cookieName, String cookieValue,
			String cookiePath, int maxAge) {
		HttpServletResponse response = ServletActionContext.getResponse();

		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath(cookiePath);
		if (maxAge != ONCE_COOKIE_TIME) {
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}

	public static void invalidCookie(String cookieName, String cookiePath) {
		addCookie(cookieName, null, cookiePath, 0);
	}

	public static void invalidCookie(String cookieName) {
		addCookie(cookieName, null, DEFAULT_COOKIE_PATH, 0);
	}

	public static void addCookie(String cookieName, String cookieValue,
			String cookiePath) {
		addCookie(cookieName, cookieValue, cookiePath, ONCE_COOKIE_TIME);
	}

	public static void addCookie(String cookieName, String cookieValue,
			int maxAge) {
		addCookie(cookieName, cookieValue, DEFAULT_COOKIE_PATH, maxAge);
	}

	public static void addCookie(String cookieName, String cookieValue) {
		addCookie(cookieName, cookieValue, DEFAULT_COOKIE_PATH,
				ONCE_COOKIE_TIME);
	}

	public static String getCookieValue(String cookieName) {
		String cookieValue = null;
		Cookie c = getCookie(cookieName);
		if (c != null) {
			cookieValue = c.getValue();
		}
		return cookieValue;
	}

	public static Cookie getCookie(String cookieName) {
		Cookie cookie = null;
		Map map = getCookies();
		if (map.containsKey(cookieName)) {
			cookie = (Cookie) map.get(cookieName);
		}
		return cookie;
	}

	public static Map getCookies() {
		Map map = new HashMap();
		HttpServletRequest request = ServletActionContext.getRequest();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				map.put(cookies[i].getName(), cookies[i]);
			}
		}
		return map;
	}

}