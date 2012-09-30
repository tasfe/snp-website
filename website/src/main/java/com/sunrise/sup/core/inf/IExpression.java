/*
 * �������� 2004-12-25
 *
 */
package com.sunrise.sup.core.inf;

/**
 * �Բ�����ʽ�ķ�װ�� ����: DM.Create=req1����һ����ʽ
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IExpression {

	/**
	 * �õ����ʽ�����
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * �õ����Ե����
	 * 
	 * @return
	 */
	public String getPropertieName();

	/**
	 * �õ����Ե����
	 * 
	 * @return
	 */
	public String[] getPropertieNames();

	/**
	 * ���õ�ǰ�����ʽ�����
	 */
	public void setNames(String[] name);

	/**
	 * �õ���ǰ�����ʽ�����
	 */
	public String[] getNames();

	/**
	 * �õ���ǰ�����ʽ��ֵ
	 */
	public void setValues(String[] value);

	/**
	 * �õ���ǰ�����ʽ��ֵ
	 */
	public String[] getValues();

	/**
	 * �Ƿ�Ϊ��������ʽ
	 * 
	 * @return
	 */
	public boolean isInstanceDeclareExpression();

	/**
	 * �Ƿ�Ϊ�����ʽ
	 * 
	 * @return
	 */
	public boolean isResultExpression();

	/**
	 * �����ʽ�Ƿ�Ϊ����ת���Ĳ���
	 */
	public boolean isOperationForwardExpression();

	/**
	 * �����ʽ�Ƿ����ڶ��������5
	 */
	public boolean isDependsExpression();

	/**
	 * �����ʽ�Ƿ����˶�Session�Ĳ���
	 * 
	 * @return
	 */
	public boolean isSessionExpression();

	/**
	 * �Ƿ����ڶ������ƻ�����
	 * 
	 * @return
	 */
	public boolean isToken();

	/**
	 * �Ƿ�����Cookie����
	 * 
	 * @return
	 */
	public boolean isCookie();

	/**
	 * IExpression�����ǿ��Կ�¡��
	 * 
	 * @return
	 */
	public Object clone();
}
