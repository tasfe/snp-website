/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sunrise.sup.core.inf;

import com.sunrise.sup.core.common.error.OperationException;

/**
 * @author root
 * 
 *         To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Style - Code Templates
 */
public interface IbusinessAction {
	// public void excute(IOperationContext context);

	/**
	 * @param context
	 * @throws OperationException
	 */
	public void excute(IOperationContext context) throws OperationException;

	/**
	 * @param context
	 */
	// public void excute(IOperationContext context);
}
