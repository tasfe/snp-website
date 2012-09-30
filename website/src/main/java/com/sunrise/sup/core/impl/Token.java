/*
 * �������� 2005-1-6
 *
 */
package com.sunrise.sup.core.impl;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class Token {

	public static final String TOKEN_NAME = "name";

	public static final String TOKEN_OPERATIONTYPE = "type";

	public static final String TOKEN_VALUE = "value";

	public static final String GET = "get";

	public static final String APPLY = "apply";

	public static final String SESSION_KEY = "OT.Token";

	private String name;

	private String operationType;

	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if (!(other instanceof Token))
			return false;
		Token castOther = (Token) other;
		return new EqualsBuilder().append(this.getName(), castOther.getName())
				.append(this.getValue(), castOther.getValue()).isEquals();
	}
}