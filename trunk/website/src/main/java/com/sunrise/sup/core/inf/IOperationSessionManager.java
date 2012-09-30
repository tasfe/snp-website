/*
 * �������� 2005-3-7
 *
 */
package com.sunrise.sup.core.inf;

import java.util.Map;

/**
 * Operation��Session������<br>
 * �Բ��������Sessionʵ��ͳһ����
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IOperationSessionManager {
	/**
	 * �õ������û���Session
	 * 
	 * @return
	 */
	public Map getSession();

	/**
	 * �õ�ϵͳ��Application
	 * 
	 * @return
	 */
	public Map getApplication();
}
