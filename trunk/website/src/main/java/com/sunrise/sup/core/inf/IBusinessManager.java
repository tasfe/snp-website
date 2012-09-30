/*
 * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sunrise.sup.core.inf;

import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;

/**
 * @author root
 * 
 *         To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Style - Code Templates
 */
public interface IBusinessManager {
	public void excute(String businessnamess, IOperationContext context)
			throws OperationSystemException, OperationException;

}
