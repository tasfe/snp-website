/*
 * �������� 2004-12-24
 *
 */
package com.sunrise.sup.core.inf;

/**
 * ��һ����ݱ������װΪPO����
 * 
 * ����˵��DM.Object��������ݱ����嶼��һ��IPODefineWrapperʵ��4����
 * 
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IInstanceDeclareWrapper {

	/**
	 * ����ݱ����а�װ,�����ر���ƺ�IPODefineӳ���HashMap
	 * 
	 * @param expression
	 * @param context
	 * @return com.sunrise.wbmp.operation.IOperation
	 */

	public IInstanceDeclare wrap(IExpression expression,
			IOperationContext context);

	/**
	 * 
	 * ��鴫��Ĳ�����ʽ�Ƿ��������ݱ����з�װ
	 * 
	 * @param expression
	 * @return Boolean
	 */
	public boolean isType(IExpression expression);
}
