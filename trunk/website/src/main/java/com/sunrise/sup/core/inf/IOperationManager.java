package com.sunrise.sup.core.inf;

import java.util.Map;

import org.springframework.context.ApplicationContext;

/**
 * ���������ͳһ������,
 * ���ȵ���IOperationWraper������Ĳ�����г�Ĵ���Ͱ�װ��Ȼ��ִ�з��ص�IOperati
 * on���о���Ĳ�����.
 * 
 * @author ����
 * @version v1.0.0
 */
public interface IOperationManager {
	/**
	 * �Դ����һ�����������д���
	 * 
	 * @param props
	 * @return ����IOperationContext
	 */
	public IOperationContext execute(Map props, ApplicationContext appContext);
}
