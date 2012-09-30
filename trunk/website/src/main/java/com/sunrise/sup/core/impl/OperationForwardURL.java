/*
 * �������� 2005-1-5
 *
 */
package com.sunrise.sup.core.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class OperationForwardURL {

	private String forwardType;

	private String forwardURL;

	public String getForwardName() {
		return forwardName;
	}

	public void setForwardName(String name) {
		this.forwardName = name;
	}

	private String forwardName;

	private Map params = new HashMap(3);

	public String getForwardType() {
		return forwardType;
	}

	public void setForwardType(String forwardType) {
		this.forwardType = forwardType;
	}

	public String getForwardURL() {
		return forwardURL;
	}

	public void setForwardURL(String forwardURL) {
		this.forwardURL = forwardURL;
		getParams().put("location", forwardURL);
	}

	public Map getParams() {
		return params;
	}
}
