/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.core.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.sup.core.common.dao.hibernate.IContainFile;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IFunctionDataManager;
import com.sunrise.sup.core.inf.IInstanceDeclare;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class InstanceDeclareSupport implements IInstanceDeclare {

	protected Log log = LogFactory.getLog(this.getClass());

	protected IOperationContext context;

	protected IExpression expression;

	protected IFunctionDataManager functionDataManager;

	public InstanceDeclareSupport(IExpression expression,
			IOperationContext context) {
		this.expression = expression;
		this.context = context;
		varName = expression.getNames()[0] + expression.getNames()[2];
		functionDataManager = (IFunctionDataManager) context
				.getApplicationContext().getBean("funcDataManager");
	}

	private String varName;

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IInstanceDeclare#getVarName()
	 */
	public String getVarName() {
		return varName;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IInstanceDeclare#setVarName(java.lang.String)
	 */
	public void setVarName(String varName) {
		this.varName = varName;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IInstanceDeclare#getObjectInstance()
	 */
	public Object getObjectInstance() throws OperationException {
		return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IInstanceDeclare#getExpression()
	 */
	public IExpression getExpression() {
		return expression;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IInstanceDeclare#getRelationObjects()
	 */
	public IInstanceDeclare[] getRelationObjects() {
		List ls = new ArrayList(4);
		for (Iterator it = getProperties(); it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			String[] strs = expr.getValues();
			for (int i = 0; i < strs.length; i++) {
				String str = checkRelatrion(strs[i]);
				if (str != null) {
					try {
						ls.add(context.getInstanceDeclare(
								expression.getNames()[0], str));
					} catch (OperationException e) {
						log.error(e);
					}
				}
			}
		}
		IInstanceDeclare[] indecs = new IInstanceDeclare[ls.size()];
		ls.toArray(indecs);
		return indecs;
	}

	/**
	 * ����Ƿ���ڹ�j�� �����ڹ�j�� �򷵻ع�j�ı���
	 * 
	 * @param value
	 * @return
	 */
	protected String checkRelatrion(String value) {

		if (StringUtils.indexOf(value, "@{") == 0
				&& StringUtils.indexOf(value, "}", value.length() - 1) == value
						.length() - 1) {
			return StringUtils.substring(value, 2, value.length() - 2);
		}
		return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IInstanceDeclare#getProperties()
	 */
	public Iterator getProperties() {
		return context.getInstanceProperties(expression.getNames()[0],
				expression.getNames()[2]);
	}

	protected String getKey(IExpression expr) {

		if (StringUtils.equalsIgnoreCase(expr.getNames()[1], "Object")
				&& expr.getNames().length < 4) {
			return null;
		}
		return OperationUtils.getKey(expr.getNames(), 3);

	}

	protected String[] getKeys(IExpression expr) {

		if (StringUtils.equalsIgnoreCase(expr.getNames()[1], "Object")
				&& expr.getNames().length < 4) {
			return null;
		}
		return OperationUtils.getKeys(expr.getNames(), 3);
	}

	/**
	 * �õ����õĲο���
	 * 
	 * @return
	 */

	protected String getRefVar(String val) {
		String str = null;
		String value = StringUtils.trimToNull(val);
		if (value != null && value.length() > 3
				&& StringUtils.indexOf(value, "@{") == 0
				&& StringUtils.indexOf(value, "}") == value.length() - 1) {
			str = StringUtils.trimToNull(StringUtils.substring(value, 2,
					value.length() - 1));
		}
		return str;
	}

	protected String getRefVarKey(String[] refVars) {
		String str = "";
		for (int i = 1; i < refVars.length; i++) {
			if (i > 1) {
				str += ".";
			}
			str += refVars[i];
		}
		return str;
	}

	/*
	 * 
	 * Object files =
	 * ActionContext.getContext().getParameters().get("testFile"); Object
	 * fileType =
	 * ActionContext.getContext().getParameters().get("testFileContentType");
	 * Object fileName =
	 * ActionContext.getContext().getParameters().get("testFileFileName");
	 */
	protected void setFile(IContainFile containFile) {
		String[] fileNames = containFile.getFileName();
		if (fileNames != null && fileNames.length > 0) {
			for (int i = 0; i < fileNames.length; i++) {
				Object files = context.getParameters().get(fileNames[i]);
				Object fileType = context.getParameters().get(
						fileNames[i] + "ContentType");
				Object fileName = context.getParameters().get(
						fileNames[i] + "FileName");
				if (files != null && files instanceof File[]
						&& fileType != null && fileType instanceof String[]
						&& fileName != null && fileName instanceof String[]) {
					containFile.setFile(fileNames[i], (File[]) files,
							(String[]) fileType, (String[]) fileName);
				}
			}
		}

	}
}
