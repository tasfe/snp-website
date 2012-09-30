/*
 * �������� 2005-3-10
 *
 */
package com.sunrise.sup.core.inf;

/**
 * ��½����ӿڣ����ڼ�鵱ǰ��½�û��Ƿ���ڣ�<br>
 * ͬʱ���Եõ���ǰ��½�û����û��������
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface ILoginUserManager {
	/**
	 * ����û��Ƿ��½
	 * 
	 * @return
	 */
	boolean checkLogin();

	/**
	 * �õ���½�û����û���
	 * 
	 * @return
	 */
	String getLoginUserName();

	/**
	 * �õ���½�û�������
	 * 
	 * @return
	 */
	String getLoginPasswrod();
}
