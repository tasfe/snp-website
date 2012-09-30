/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.inf.IBusinessManager;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DMBusinessOperation extends DMCURDOperation {
	private IBusinessManager BusinessManager;

	/**
	 * @param expression
	 * @param context
	 */
	public DMBusinessOperation(IExpression expression, IOperationContext context) {
		super(expression, context);
		BusinessManager = (IBusinessManager) context.getApplicationContext()
				.getBean("businessManager");

	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperation#execute()
	 */
	public void execute() throws OperationException {
		BusinessManager.excute(expression.getNames()[2], context);

		/*
		 * context.addResults(expression.getNames()[2],obj);
		 * context.addResults(getResultKey(),obj);
		 * context.addResults(getResultInfoKey
		 * (),OperationConstants.OPERATION_SUCCESS);
		 */
		this.setExecuted(true);
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperation#getName()
	 */
	public String getName() {
		return expression.getName();
	}

	/**
	 * @return Returns the businessDataManager.
	 */

	/**
	 * @return Returns the businessManager.
	 */
	public IBusinessManager getBusinessManager() {
		return BusinessManager;
	}

	/**
	 * @param businessManager
	 *            The businessManager to set.
	 */
	public void setBusinessManager(IBusinessManager businessManager) {
		BusinessManager = businessManager;
	}
}
