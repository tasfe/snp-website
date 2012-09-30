/*
 * �������� 2005-1-5
 *
 */
package com.sunrise.sup.core.inf;

import com.sunrise.sup.core.impl.OperationForwardURL;

/**
 * ��ת��������з�װ
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IOperationForward {

	/**
	 * <code>SUCCESS</code> �ɹ��Ժ�Ĳ���ת������
	 */
	public static final String SUCCESS = "success";

	/**
	 * <code>SUCCESS</code> ҵ��ʧ���Ժ�Ĳ���ת������
	 */
	public static final String ERROR = "error";

	/**
	 * <code>SUCCESS</code> ϵͳ�������Ժ�Ĳ���ת������
	 */
	public static final String SYSTEMERROR = "systemerror";

	/**
	 * ��ݲ���ת�����͵õ�ת����Ϣ�ķ�װ��
	 * 
	 * @param type
	 * @return
	 */
	public OperationForwardURL getOperationForward(String type);

	/**
	 * ע��һ�����ת������
	 * 
	 * @param type
	 * @param operationErrorForward
	 */
	public void setOperationForward(String type,
			OperationForwardURL operationErrorForward);

}