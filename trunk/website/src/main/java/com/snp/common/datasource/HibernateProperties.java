package com.snp.common.datasource;

import java.util.Iterator;
import java.util.Map;

/**
 * 
 * 数据库会话需要获得的一个属性BEAN，我们自己构造这个bean的属性 这里我们把一些常变化的写在这里 好处是把所有的属性培植放在一个文件里面了
 * 
 * @author
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
		DataBaseConfig systemDbObject = SystemData
				.getDbObjectByDbConfFileName();
		this.put("hibernate.dialect", systemDbObject.getHibernate_dialect());
		this.put("hibernate.show_sql", systemDbObject.getHibernate_show_sql());
		this.put("hibernate.hbm2ddl.auto",
				systemDbObject.getHibernate_hbm2ddl());
		this.put("hibernate.transaction.factory_class",
				systemDbObject.getHibernate_transactionfactoryclass());

		// this.put("hibernate.connection.shutdown", "true");

	}

	public void setHibernateDialect(String hibernateDialect) {
		super.put("hibernate.dialect", hibernateDialect);
	}
}