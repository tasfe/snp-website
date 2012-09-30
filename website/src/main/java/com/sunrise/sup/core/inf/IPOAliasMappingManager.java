/*
 * �������� 2004-12-24
 *
 */
package com.sunrise.sup.core.inf;

import org.springframework.context.ApplicationContext;

import com.sunrise.sup.core.common.error.OperationException;

/**
 * ��PO������й���
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IPOAliasMappingManager {
	/**
	 * ���PO�ı���õ�PO��ʵ��
	 * 
	 * @param aliasName
	 * @param appContext
	 * @return
	 */
	public Object createPOInstance(String aliasName,
			ApplicationContext appContext) throws OperationException;

}