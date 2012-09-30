/*
 * �������� 2004-12-23
 */
package com.sunrise.sup.core.inf;

import java.util.Iterator;

import com.sunrise.sup.core.common.error.OperationException;

/**
 * ��ݿͻ��˵������PO������з�װ
 * 
 * @author Jerry Tang
 * @version
 * 
 */
public interface IInstanceDeclare {
	/**
	 * @return ������ݱ���������
	 */
	public String getVarName();

	/**
	 * @return ������ݱ������
	 */
	public void setVarName(String varName);

	/**
	 * ������������Ӧ��һ�����ʵ����ô����ֱ�ӷ���������ʵ��
	 * 
	 * @return
	 * @throws OperationException
	 */
	public Object getObjectInstance() throws OperationException;

	/**
	 * �õ����������������ʽ ����: DM.Object.req1=RequireMent
	 * 
	 * @return
	 */
	public IExpression getExpression();

	/**
	 * �õ����PO�����j��POʵ�� public IInstanceDeclare[] getRelationObjects();
	 */

	/**
	 * �õ����PO�������������
	 */
	public Iterator getProperties();

}
