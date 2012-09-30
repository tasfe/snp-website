/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.core.common.error;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * ��������
 * 
 * @author lingli
 * @version v1.0.0
 */
public class OperationException extends Exception {

	private String errorCode = "";

	private String detailMsg = "";

	/**
	 * @param message
	 */
	public OperationException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.detailMsg = message;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public OperationException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		// cause.getStackTrace()ֻ��ӡ��[Ljava.lang.StackTraceElement;@898587
		// StackTraceElement[] errors = cause.getStackTrace();
		// cause.printStackTrace();//���������뷴!��ǰ̨����Ϣ
		detailMsg = message + ExceptionUtils.getFullStackTrace(cause);
	}

	/**
	 * @param cause
	 */

	public OperationException(String errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		String errortraceStr = "";
		StackTraceElement[] errors = cause.getStackTrace();
		for (int i = 0; i < errors.length; i++) {
			StackTraceElement element = errors[i];
			errortraceStr = errortraceStr + element + "\n";
		}
		// detailMsg = message+errortraceStr;
		detailMsg = cause.getMessage() + errortraceStr;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return detailMsg;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String toString() {

		return "error-id:" + this.getErrorCode()
				+ ErrorCodeMaping.getErrorMsg(errorCode);
	}

}
