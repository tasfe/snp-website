package com.snp.site.exception;

import org.apache.commons.lang.exception.ExceptionUtils;

public class SnpException extends Exception {

	private String detailMsg = "";

	/**
	 * @param message
	 */
	public SnpException(String message) {
		super(message);
		detailMsg = ExceptionUtils.getFullStackTrace(this);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public SnpException(String message, Throwable cause) {
		super(message, cause);
		detailMsg = message + ExceptionUtils.getFullStackTrace(cause);
	}

	public String toString() {

		return detailMsg;

	}

}
