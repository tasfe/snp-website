/*
 * �������� 2005-1-5
 *
 */
package com.sunrise.sup.dm;

import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.dao.hibernate.DAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.impl.InstanceDeclareMap;
import com.sunrise.sup.core.impl.OperationSupport;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public abstract class DMCURDOperation extends OperationSupport {
	/**
	 * @param expression
	 * @param context
	 */
	public DMCURDOperation(IExpression expression, IOperationContext context) {
		super(expression, context);
	}

	protected DAO getDAO() throws OperationException {

		return (DAO) context.getApplicationContext().getBean("dao");

	}

	protected AdvanceDAO getAdvanceDAO() {
		AdvanceDAO dao = (AdvanceDAO) context.getApplicationContext().getBean(
				"advanceDAO");
		return dao;
	}

	private DataInstanceDeclare dataInsDec;
	private InstanceDeclareMap instanceDeclareMap;

	protected DataInstanceDeclare getInstanceDeclare()
			throws OperationException {
		if (dataInsDec == null) {

			dataInsDec = (DataInstanceDeclare) context.getInstanceDeclare("DM",
					expression.getNames()[2]);
		}
		return dataInsDec;
	}

}
