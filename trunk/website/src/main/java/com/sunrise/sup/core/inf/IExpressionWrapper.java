/*
 * �������� 2004-12-25
 *
 */
package com.sunrise.sup.core.inf;

/**
 * �Ѳ�������װΪ���ʽ�� ����: DM.Create.req1=����һ����ʽ
 * 
 * һ�ֲ�������ֻ����һ���װ
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IExpressionWrapper {

	/**
	 * ���õ�ǰ�����ʽ�����
	 * 
	 * @param context
	 */
	public IExpression[] wrap(String name, Object[] value,
			IOperationContext context);

	/**
	 * ��鴫��Ĳ�������Ƿ��������ʽ��װ����з�װ
	 * 
	 * @param expression
	 * @return boolean
	 */
	public boolean isType(IExpression expression);
}
