/*
 * �������� 2005-3-15
 *
 */
package com.sunrise.sup.core.inf;

import java.util.Map;

/**
 * ���ڶ�Cookie���й���
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface ICookieManager {

	public void addCookie(String key, String value);

	public String getCookieValue(String key);

	public Map getCookies();

}
