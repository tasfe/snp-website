/*
 * �������� 2005-1-28
 *
 */
package com.sunrise.sup.core.common.error;

/**
 * �����е�ϵͳ����
 * 
 * @version v1.0.0
 */
public class OperationSystemException extends OperationException {

	public OperationSystemException(String errorCode, String message) {
		super(errorCode, message);
	}

	public OperationSystemException(String errorCode, String message,
			Throwable cause) {
		super(errorCode, message, cause);
	}

	public OperationSystemException(String errorCode, Throwable cause) {
		super(errorCode, cause);
	}
}
