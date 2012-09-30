/*
 * �������� 2004-12-25
 *
 */
package com.sunrise.sup.core.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.OperationConstants;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class Expression implements IExpression, Comparable {

	private String[] names;

	private String name;

	private String propertieName;

	private String[] propertieNames;

	private String[] values;

	private boolean init = true;

	public String getPropertieName() {
		if (init) {
			initPropertieName();
		}
		return propertieName;
	}

	public String[] getPropertieNames() {
		if (init) {
			initPropertieName();
		}
		return propertieNames;
	}

	private void initPropertieName() {
		init = false;

		if (getNames().length < 4) {
			return;
		}

		propertieName = OperationUtils.getKey(getNames(), 3);
		propertieNames = OperationUtils.getKeys(getNames(), 3);
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IExpression#getName()
	 */
	public String[] getNames() {
		return names;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IExpression#getValue()
	 */
	public String[] getValues() {
		return values;
	}

	public void setNames(String[] names) {
		this.names = names;
		name = conName();

	}

	public void setValues(String[] value) {
		this.values = value;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IExpression#isInstanceDefineExpression()
	 */
	public boolean isInstanceDeclareExpression() {
		if (names != null
				&& names.length > 1
				&& (StringUtils.equalsIgnoreCase(names[1],
						OperationConstants.OPERATION_OBJECT_KEY) || StringUtils
						.equalsIgnoreCase(names[1],
								OperationConstants.OPERATION_INSTANCE_KEY))) {

			return true;
		}
		return false;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IExpression#isResultExpression()
	 */
	public boolean isResultExpression() {
		if (names != null
				&& names.length > 1
				&& StringUtils.equalsIgnoreCase(names[1],
						OperationConstants.OPERATION_RESULT_KEY)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return getName() + "=" + values;
	}

	public String getName() {
		return name;
	}

	private String conName() {
		String str = "";
		for (int i = 0; i < names.length; i++) {
			if (i != 0) {
				str = str + ".";
			}
			str = str + names[i].trim();
		}
		return str;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(names).append(values).toHashCode();
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IExpression#isOperationForwardExpression()
	 */
	public boolean isOperationForwardExpression() {
		if (names != null
				&& names.length > 3
				&& StringUtils.equalsIgnoreCase(names[0], "OT")
				&& StringUtils.equalsIgnoreCase(names[1],
						OperationConstants.OPERATION_FORWARD_KEY)) {
			return true;
		}
		return false;
	}

	public boolean isDependsExpression() {
		if (names != null
				&& names.length > 3
				&& StringUtils.equalsIgnoreCase(names[3],
						OperationConstants.OPERATION_DEPENDS_KEY)) {
			return true;
		}
		return false;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IExpression#isToken()
	 */
	public boolean isToken() {
		if (names != null
				&& names.length > 2
				&& StringUtils.equalsIgnoreCase(names[1],
						OperationConstants.OPERATION_TOKEN_KEY)) {
			return true;
		}
		return false;
	}

	public Object clone() {
		Expression expr = new Expression();

		String[] newNames = null;
		String[] newValues = null;
		if (this.getNames() != null) {
			newNames = new String[this.getNames().length];
			for (int i = 0; i < this.getNames().length; i++) {
				newNames[i] = new String(getNames()[i]);
			}
		}
		if (this.getValues() != null) {
			newValues = new String[this.getValues().length];
			for (int i = 0; i < this.getValues().length; i++) {
				newValues[i] = new String(getValues()[i]);
			}
		}
		expr.setNames(newNames);
		expr.setValues(newValues);
		return expr;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IExpression#isSessionExpression()
	 */
	public boolean isSessionExpression() {
		if (names != null
				&& names.length > 2
				&& StringUtils.equalsIgnoreCase(names[1],
						OperationConstants.OPERATION_SESSION_KEY)) {
			return true;
		}
		return false;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IExpression#isCookie()
	 */
	public String getnameStr() {
		String nameStr = "";

		for (int i = 0; i < names.length; i++) {
			nameStr = nameStr + names[i];
		}
		return nameStr;
	}

	public boolean isCookie() {
		if (names != null
				&& names.length > 2
				&& StringUtils.equalsIgnoreCase(names[1],
						OperationConstants.OPERATION_COOKIE_KEY)) {
			return true;
		}
		return false;
	}

	public int compareTo(Object o) {
		Expression n = (Expression) o;
		int cmp = getnameStr().compareTo(n.getnameStr());
		return cmp;
	}
}
