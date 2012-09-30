package com.sunrise.sup.core.common.dao.hibernate;

import java.util.Iterator;
import java.util.Map;

/**
 * Util class to create an hibernate properties object in Spring so it can be
 * used with jndi obtained properties
 * 
 * @author Carlos Sanchez
 * @version $Revision: 1.1 $
 */
public class HibernateProperties extends java.util.Properties {
	/**
	 * Create a Properties object with specified properties
	 * 
	 * @param properties
	 */
	public HibernateProperties(java.util.Properties properties) {
		super();
		Iterator iterator = properties.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry element = (Map.Entry) iterator.next();
			this.put(element.getKey(), element.getValue());
		}
	}

	public void setHibernateDialect(String hibernateDialect) {
		super.put("hibernate.dialect", hibernateDialect);
	}
}