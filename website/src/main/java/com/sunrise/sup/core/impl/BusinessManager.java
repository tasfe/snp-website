/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sunrise.sup.core.impl;

import java.util.Map;

import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.inf.IBusinessManager;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/**
 * @author root
 * 
 *         To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Style - Code Templates
 */
public class BusinessManager implements IBusinessManager {
	private Map businessNames;

	/**
	 * @return Returns the businessNames.
	 */
	public Map getBusinessNames() {
		return businessNames;
	}

	/**
	 * @param businessNames
	 *            The businessNames to set.
	 */
	public void setBusinessNames(Map businessNames) {
		this.businessNames = businessNames;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.wbmp.operation.IBusinessManager#excute(java.lang.String)
	 */
	public void excute(String businessnamess, IOperationContext context)
			throws OperationException {
		IbusinessAction businessAction = (IbusinessAction) businessNames
				.get(businessnamess);
		businessAction.excute(context);
		// businessAction.excute(context);
	}
}
