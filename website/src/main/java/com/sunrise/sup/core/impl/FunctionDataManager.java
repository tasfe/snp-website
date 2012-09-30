/*
 * �������� 2005-6-23
 *
 */
package com.sunrise.sup.core.impl;

import java.util.Map;

import com.sunrise.sup.core.inf.IFunctionData;
import com.sunrise.sup.core.inf.IFunctionDataManager;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class FunctionDataManager implements IFunctionDataManager {
	private Map functionDatas;

	public Object getFunctionData(String funcType, String key,
			IOperationContext context) {
		if (functionDatas.containsKey(funcType)) {
			IFunctionData funcData = (IFunctionData) functionDatas
					.get(funcType);
			return funcData.getData(key, context);
		}
		return null;
	}

	public void setFunctionDatas(Map functionDatas) {
		this.functionDatas = functionDatas;
	}
}
