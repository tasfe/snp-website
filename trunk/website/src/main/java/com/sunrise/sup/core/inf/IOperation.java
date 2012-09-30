package com.sunrise.sup.core.inf;

import com.sunrise.sup.core.common.error.OperationException;

/**
 * ����Ľӿڣ� ��4��װһ���������Ҫ��������Ϣ����(�������ͣ� �����漰�Ĳ���ȵȡ�
 * 
 * @author ����
 * @version v1.0.0
 */
public interface IOperation {

	/**
	 * ִ�в��� ���õ�����Ľ��
	 * 
	 * @throws OperationException
	 */
	public void execute() throws OperationException;

	/**
	 * �õ��������
	 * 
	 * @return String
	 * @roseuid 41C671B3006B
	 */
	public String getName();

	/**
	 * �Ƿ��Ѿ�ִ��
	 * 
	 * @return String
	 * @roseuid 41C671B3006B
	 */
	public boolean isExecuted();

	/**
	 * �Ƿ��Ѿ�ִ��
	 * 
	 * @return String
	 * @roseuid 41C671B3006B
	 */
	public void setExecuted(boolean executed);
}
