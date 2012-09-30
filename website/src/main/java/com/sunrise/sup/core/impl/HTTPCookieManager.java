/*
 * �������� 2005-3-15
 *
 */
package com.sunrise.sup.core.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.WebWorkStatics;
import com.opensymphony.xwork.ActionContext;
import com.sunrise.sup.core.inf.ICookieManager;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class HTTPCookieManager implements ICookieManager {

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.ICookieManager#addCookie(java.lang.String,
	 * java.lang.String)
	 */
	public void addCookie(String key, String value) {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(WebWorkStatics.HTTP_RESPONSE);
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(31536000);
		response.addCookie(cookie);
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.ICookieManager#getCookieValue(java.lang.String
	 * )
	 */
	public String getCookieValue(String key) {
		String value = "";
		Map map = getCookies();
		if (map.containsKey(key)) {
			return (String) map.get(key);
		}
		return value;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.ICookieManager#getCookies()
	 */
	public Map getCookies() {
		Map map = new HashMap();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(WebWorkStatics.HTTP_REQUEST);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				map.put(cookies[i].getName(), cookies[i].getValue());
			}
		}
		return map;
	}

}
