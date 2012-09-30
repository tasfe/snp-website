/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.snp.common.DebugUtil;
import com.sunrise.sup.core.common.dao.hibernate.DAO;
import com.sunrise.sup.core.common.error.ErrorCodeMaping;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.OperationConstants;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DMDeleteOperation extends DMCURDOperation {

	public DMDeleteOperation(IExpression expression, IOperationContext context) {
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
		try {
			Object obj = getInstanceDeclare().getObjectInstanceWithData(true);
			dao.removeObject(obj);
		} catch (ObjectRetrievalFailureException ex) {
			throw new OperationSystemException(
					ErrorCodeMaping.OA_FRONT_RULE_ERROR,
					DebugUtil.getQryString(context.getParameters()), ex);
		}

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
