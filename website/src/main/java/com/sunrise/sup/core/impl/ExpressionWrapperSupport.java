/*
 * �������� 2004-12-25
 *
 */
package com.sunrise.sup.core.impl;

import org.apache.commons.lang.StringUtils;

import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IExpressionWrapper;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class ExpressionWrapperSupport implements IExpressionWrapper {
	public IExpression[] wrap(String name, Object[] value,
			IOperationContext context) {
		// Ϊʲôһ������һ����ʽ���顣
		IExpression expr = (IExpression) context.getApplicationContext()
				.getBean("OperationExpression");
		expr.setNames(StringUtils.split(StringUtils.trimToEmpty(name), "."));
		expr.setValues((String[]) value);

		return new IExpression[] { expr };

	}

	public boolean isType(IExpression expression) {
		return false;
	}
}
