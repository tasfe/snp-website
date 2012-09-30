/*
 * �������� 2005-3-10
 *
 */
package com.sunrise.sup.core.webwork.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork.ValidationAware;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class ValidationResult implements ValidationAware {
	private String varName = null;

	public ValidationResult(String varName) {
		super();
		this.varName = varName;
	}

	// ~ Instance fields
	// ////////////////////////////////////////////////////////

	private Collection actionErrors;

	private Collection actionMessages;

	private Map fieldErrors;

	// ~ Methods
	// ////////////////////////////////////////////////////////////////

	public synchronized void setActionErrors(Collection errorMessages) {
		this.actionErrors = errorMessages;
	}

	public synchronized Collection getActionErrors() {
		return new ArrayList(internalGetActionErrors());
	}

	public synchronized void setActionMessages(Collection messages) {
		this.actionMessages = messages;
	}

	public synchronized Collection getActionMessages() {
		return new ArrayList(internalGetActionMessages());
	}

	public synchronized void setFieldErrors(Map errorMap) {
		this.fieldErrors = errorMap;
	}

	public synchronized Map getFieldErrors() {
		return new LinkedHashMap(internalGetFieldErrors());
	}

	public synchronized void addActionError(String anErrorMessage) {
		internalGetActionErrors().add(anErrorMessage);
	}

	public void addActionMessage(String aMessage) {
		internalGetActionMessages().add(aMessage);
	}

	public synchronized void addFieldError(String fldName, String errorMessage) {
		String fieldName = fldName;
		if (StringUtils.trimToNull(varName) != null) {
			fieldName = varName + "." + fieldName;
		}
		final Map errors = internalGetFieldErrors();
		List thisFieldErrors = (List) errors.get(fieldName);

		if (thisFieldErrors == null) {
			thisFieldErrors = new ArrayList();
			errors.put(fieldName, thisFieldErrors);
		}

		thisFieldErrors.add(errorMessage);
	}

	public synchronized boolean hasActionErrors() {
		return (actionErrors != null) && !actionErrors.isEmpty();
	}

	public boolean hasActionMessages() {
		return (actionMessages != null) && !actionMessages.isEmpty();
	}

	public synchronized boolean hasErrors() {
		return (hasActionErrors() || hasFieldErrors());
	}

	public synchronized boolean hasFieldErrors() {
		return (fieldErrors != null) && !fieldErrors.isEmpty();
	}

	private Collection internalGetActionErrors() {
		if (actionErrors == null) {
			actionErrors = new ArrayList();
		}

		return actionErrors;
	}

	private Collection internalGetActionMessages() {
		if (actionMessages == null) {
			actionMessages = new ArrayList();
		}

		return actionMessages;
	}

	private Map internalGetFieldErrors() {
		if (fieldErrors == null) {
			fieldErrors = new LinkedHashMap();
		}

		return fieldErrors;
	}
}
