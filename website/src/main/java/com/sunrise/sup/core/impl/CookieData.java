/*
 * �������� 2005-6-23
 *
 */
package com.sunrise.sup.core.impl;

import com.sunrise.sup.core.inf.IFunctionData;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class CookieData implements IFunctionData {

	public Object getData(String key, IOperationContext context) {
		String obj = "";
		if (context.getCookies().containsKey(key)) {
			obj = (String) context.getCookies().get(key);
		}
		return obj;
	}

}
