/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import org.apache.commons.lang.StringUtils;

import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IInstanceDeclare;
import com.sunrise.sup.core.inf.IInstanceDeclareWrapper;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DataInstanceDeclareWrapper implements IInstanceDeclareWrapper {

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IInstanceDeclareWrapper#wrap(com.sunrise.wbmp
	 * .operation.IExpression, com.sunrise.wbmp.operation.IOperationContext)
	 */
	public IInstanceDeclare wrap(IExpression expression,
			IOperationContext context) {
		DataInstanceDeclare dtIn = new DataInstanceDeclare(expression, context);
		return dtIn;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IInstanceDeclareWrapper#isType(com.sunrise
	 * .wbmp.operation.IExpression)
	 */
	public boolean isType(IExpression expression) {
		if (StringUtils.equalsIgnoreCase(expression.getNames()[0], "DM")) {
			return true;
		}
		return false;
	}

}
