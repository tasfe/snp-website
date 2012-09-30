/*
 * �������� 2005-6-23
 *
 */
package com.sunrise.sup.core.impl;

import java.util.Date;

import com.sunrise.sup.core.inf.IFunctionData;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class SystemData implements IFunctionData {
	/** ϵͳʱ�� */
	public static final String SYSTEM_DATE = "date";

	public static final String SYSTEM_NULL = "null";

	public Object getData(String key, IOperationContext context) {
		if (key.equalsIgnoreCase(SYSTEM_DATE)) {
			return new Date();
		} else if (key.equalsIgnoreCase(SYSTEM_NULL)) {
			return null;
		}

		return null;
	}

}
