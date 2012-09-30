package com.sunrise.sup.core.inf;

/**
 * ������Ĳ�����Ϣ������װ���ض��Ĳ���(IOperation)
 * 
 * @author ����
 * @version v1.0.0
 */
public interface IOperationWrapper {

	/**
	 * �Բ�����Ϣ���а�װ,������һ���ض�����
	 * 
	 * @param expression
	 *            �ض��Ĳ�����ʽ
	 * @param context
	 *            ����������Ĳ���
	 * @return com.sunrise.wbmp.operation.IOperation
	 */
	public IOperation wrap(IExpression expression, IOperationContext context);

	/**
	 * ��鴫��Ĳ�����ʽ�Ƿ����������װ����з�װ
	 * 
	 * @param expression
	 * @return Boolean
	 */
	public boolean isType(IExpression expression);
}
