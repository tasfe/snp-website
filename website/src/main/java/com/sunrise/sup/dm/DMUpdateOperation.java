/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import com.sunrise.sup.core.common.dao.hibernate.DAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.OperationConstants;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DMUpdateOperation extends DMCURDOperation {

	public DMUpdateOperation(IExpression expression, IOperationContext context) {
		super(expression, context);
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperation#execute()
	 */
	public void execute() throws OperationException {
		log.debug("execute()");
		DAO dao = getDAO();
		Object obj = getInstanceDeclare().getObjectInstanceWithData(true);
		dao.updateObject(obj);
		context.addResults(expression.getNames()[2], obj);
		context.addResults(getResultKey(), obj);
		context.addResults(getResultInfoKey(),
				OperationConstants.OPERATION_SUCCESS);
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

}
