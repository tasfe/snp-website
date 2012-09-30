/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperation;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IOperationWrapper;

/**
 * ������ݲ���İ�װ��
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DataCURDOperationWrapper implements IOperationWrapper {
	private String resourceFile;

	private Properties resource;

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IOperationWrapper#wrap(com.sunrise.wbmp.operation
	 * .IExpression, com.sunrise.wbmp.operation.IOperationContext)
	 */
	public IOperation wrap(IExpression expression, IOperationContext context) {
		if (resource == null) {
			init();
		}
		// context.getApplicationContext().getResource()
		if (StringUtils.equalsIgnoreCase(expression.getNames()[1], "business")) {
			return new DMBusinessOperation(expression, context);
		}
		if (StringUtils.equalsIgnoreCase(expression.getNames()[1], "Create")) {
			return new DMCreateOperation(expression, context);
		}
		if (StringUtils.equalsIgnoreCase(expression.getNames()[1], "Update")) {
			return new DMUpdateOperation(expression, context);
		}
		if (StringUtils.equalsIgnoreCase(expression.getNames()[1], "Delete")) {
			return new DMDeleteOperation(expression, context);
		}
		if (StringUtils.equalsIgnoreCase(expression.getNames()[1], "Reload")) {
			return new DMReloadOperation(expression, context);
		}

		if (StringUtils.equalsIgnoreCase(expression.getNames()[1], "Query")) {
			return new DMQueryOperation(expression, context, resource);
		}
		/* 文件上传操作，实际的对文件对象的处理在业务系统中定义BEAN来实现 */
		if (StringUtils.equalsIgnoreCase(expression.getNames()[1], "Upload")) {
			return new DMUploadOperation(expression, context);
		}

		return null;
	}

	private synchronized void init() {
		resource = new Properties();
		if (StringUtils.trimToNull(resourceFile) != null) {
			try {
				InputStream inStr = this.getClass().getClassLoader()
						.getResourceAsStream(resourceFile);
				if (inStr != null) {

					resource.load(inStr);
				}
			} catch (IOException e) {
			}
		}

	}

	public boolean isType(IExpression expression) {
		if (StringUtils.equalsIgnoreCase(expression.getNames()[0], "DM")
				&& (StringUtils.equalsIgnoreCase(expression.getNames()[1],
						"Create")
						|| StringUtils.equalsIgnoreCase(
								expression.getNames()[1], "Update")
						|| StringUtils.equalsIgnoreCase(
								expression.getNames()[1], "Delete")
						|| StringUtils.equalsIgnoreCase(
								expression.getNames()[1], "Reload") || StringUtils
							.equalsIgnoreCase(expression.getNames()[1], "Query")))
			return true;
		return false;
	}

	public String getResourceFile() {
		return resourceFile;
	}

	public void setResourceFile(String resourceFile) {
		this.resourceFile = resourceFile;
	}
}
