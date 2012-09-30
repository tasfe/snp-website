/*
 * �������� 2005-3-7
 *
 */
package com.sunrise.sup.core.impl;

import java.util.Map;

import com.opensymphony.xwork.ActionContext;
import com.sunrise.sup.core.inf.IOperationSessionManager;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class WebWorkOperationSessionManager implements IOperationSessionManager {

	public Map getSession() {
		return ActionContext.getContext().getSession();
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.ricsson.operation.IOperationSystemSession#getApplication()
	 */
	public Map getApplication() {
		return ActionContext.getContext().getApplication();
	}

}
