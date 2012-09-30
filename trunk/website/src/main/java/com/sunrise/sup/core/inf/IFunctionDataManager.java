/*
 * �������� 2005-6-23
 *
 */
package com.sunrise.sup.core.inf;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IFunctionDataManager {
	public Object getFunctionData(String funcType, String key,
			IOperationContext context);
}
