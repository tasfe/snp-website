/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import com.opensymphony.util.BeanUtils;
import com.sunrise.sup.core.common.dao.hibernate.DAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.OperationConstants;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DMCreateOperation extends DMCURDOperation {

	/**
	 * @param expression
	 * @param context
	 */
	public DMCreateOperation(IExpression expression, IOperationContext context) {
		super(expression, context);
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperation#execute()
	 */
	public void execute() throws OperationException {

		DAO dao = getDAO();
		DataInstanceDeclare insDec = this.getInstanceDeclare();
		Object obj = insDec.getObjectInstanceWithData(false);
		dao.saveObject(obj);
		String[] names = BeanUtils.getPropertyNames(obj);

		for (int i = 0; i < names.length; i++) {

			if (names[i].endsWith("sortstr")) {

				BeanUtils.setValue(obj, "sortstr", BeanUtils
						.getValue(obj, "id").toString());
				dao.updateObject(obj);
				break;
			}
		}
		context.addResults(expression.getNames()[2], obj);
		context.addResults(getResultKey(), obj);
		context.addResults("id", BeanUtils.getValue(obj, "id").toString());
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
