/*
 * �������� 2005-1-5
 *
 */
package com.sunrise.sup.core.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperation;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public abstract class OperationSupport implements IOperation {
	protected Log log = LogFactory.getLog(this.getClass());

	protected IExpression expression;

	protected IOperationContext context;

	protected boolean executed = true;

	public OperationSupport(IExpression expression, IOperationContext context) {
		this.expression = expression;
		this.context = context;
	}

	protected String getResultKey() {
		return expression.getNames()[0] + "." + expression.getNames()[1] + "."
				+ expression.getNames()[2] + ".Result";
	}

	protected String getResultInfoKey() {
		return expression.getNames()[0] + "." + expression.getNames()[1] + "."
				+ expression.getNames()[2] + ".Result.Info";
	}

	protected String getOtherKey() {
		return expression.getNames()[0] + "." + expression.getNames()[1] + "."
				+ expression.getNames()[2] + ".Other";
	}

	protected String getErrorKey() {
		return expression.getNames()[0] + "." + expression.getNames()[1] + "."
				+ expression.getNames()[2] + ".Error";
	}

	public boolean isExecuted() {
		// �ж�Create�Ĳ����Ƿ�Ϊfalse�����Ϊfalse�� ������
		if (expression.getValues() != null
				&& expression.getValues().length > 0
				&& StringUtils.equalsIgnoreCase(expression.getValues()[0],
						"false")) {
			return false;
		}
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;

	}

	public void execute() throws OperationException {

	}

	public String getName() {
		return expression.getName();
	}
}
