/*
 * �������� 2005-1-5
 *
 */
package com.sunrise.sup.core.impl;

import java.util.HashMap;

import com.sunrise.sup.core.inf.IOperationForward;

/**
 * ����ת��
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class OperationForward implements IOperationForward {
	private HashMap map = new HashMap(3, 2);

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IOperationForward#getOperationForward(java
	 * .lang.String)
	 */
	public OperationForwardURL getOperationForward(String type) {
		if (map.containsKey(type))
			return (OperationForwardURL) map.get(type);
		return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IOperationForward#setOperationForward(java
	 * .lang.String, com.ricsson.operation.OperationForwardURL)
	 */
	public void setOperationForward(String type,
			OperationForwardURL operationErrorForward) {
		map.put(type, operationErrorForward);

	}

}
