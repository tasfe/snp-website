/*
 * �������� 2005-1-17
 *
 */
package com.sunrise.sup.core.impl;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class OperationUtils {

	private OperationUtils() {
		super();
	}

	public static String getKey(String[] keys, int start) {
		if (keys.length < start + 1) {
			return null;
		}
		String str = "";

		for (int i = start; i < keys.length; i++) {
			if (i > start) {
				str += ".";
			}
			str += keys[i];
		}
		return str;
	}

	public static String[] getKeys(String[] keys, int start) {
		// new String[keys().length-start-1];
		if (keys.length < start + 1) {
			return null;
		}
		String[] strs = new String[keys.length - start];

		for (int i = start; i < keys.length; i++) {

			strs[i - start] = keys[i];
		}
		return strs;
	}

	public static String getOperationParam(String qKey, IExpression expression,
			IOperationContext context) {
		Iterator it = context.getOperationProperties(expression.getNames()[0],
				expression.getNames()[1], expression.getNames()[2]);
		String values = null;
		for (; it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			String keys = expr.getPropertieName();
			if (StringUtils.trimToNull(keys) == null
					|| expr.getValues() == null || expr.getValues().length < 1) {
				continue;
			}
			if (StringUtils.equalsIgnoreCase(keys, qKey)) {
				values = expr.getValues()[0];
				break;
			}
		}

		return values;
	}
}
