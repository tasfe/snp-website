package com.snp.common.datasource;

import org.apache.commons.dbcp.BasicDataSource;

public class SpringDataSourceBeanExt extends BasicDataSource {
	/**
	 * 主要是数据库连接的用户名和密码
	 */
	public SpringDataSourceBeanExt() {
		super();
		DataBaseConfig systemDbObject = SystemData
				.getDbObjectByDbConfFileName();// 这个方法可以返回不同的数据源对象
		this.setDriverClassName(systemDbObject.getDriverClassName());
		this.setUrl(systemDbObject.getUrl());
		this.setUsername(systemDbObject.getUsername());
		this.setPassword(systemDbObject.getPassword());
		this.setMaxIdle(systemDbObject.getMaxIdle());
		this.setMaxActive(systemDbObject.getMaxActive());
		this.setMaxWait(systemDbObject.getMaxWait());
	}

	public String tostring() {
		return "";

	}

}
