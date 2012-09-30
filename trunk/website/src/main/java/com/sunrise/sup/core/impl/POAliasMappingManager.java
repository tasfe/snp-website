package com.sunrise.sup.core.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.ObjectUtils;
import com.sunrise.sup.core.inf.IPOAliasMappingManager;

/**
 * ������ݰ󶨹�������ݺ�PO��֮��Ĺ�ϵ
 * 
 * @author ����
 * @version v1.0.0
 */
public class POAliasMappingManager implements IPOAliasMappingManager {
	// private static Log log = LogFactory.getLog(POAliasMappingManager.class);

	private Map aliasPOMapping;

	/**
	 */
	public POAliasMappingManager() {
	}

	/**
	 * ��ݴ������ƣ� �������Ӧ��PO��ʵ��
	 * 
	 * @param name
	 * @return Object
	 */
	public Object createPOInstance(String name, ApplicationContext appContext)
			throws OperationException {

		String aliasName = StringUtils.trimToNull(name);
		if (aliasPOMapping == null || aliasName == null)
			return null;

		Object obj = null;
		/*
		 * lingli 20050829�޸����PO�����ERROR���������ļ�
		 * if(aliasPOMapping.containsKey(aliasName)){ obj =
		 * ObjectUtils.createPoInstanse
		 * (StringUtils.trimToEmpty(aliasName),appContext); }
		 */
		obj = ObjectUtils.createPoInstanse(StringUtils.trimToEmpty(aliasName),
				appContext);
		/*
		 * if(obj == null){ log.error("Can not create the po object,the poname
		 * ="+aliasName+".please check the the poname of the action!"); }
		 */
		return obj;
	}

	public Map getAliasPOMapping() {
		return aliasPOMapping;
	}

	public void setAliasPOMapping(Map aliasPOMapping) {
		this.aliasPOMapping = aliasPOMapping;
	}

}