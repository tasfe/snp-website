package com.snp.common.datasource;

public class DataBaseConfig {
	/*
	 * this.setDriverClassName("com.mysql.jdbc.Driver"); this.setUrl(
	 * "jdbc:mysql://localhost:3306/dreams?useUnicode=true&characterEncoding=UTF-8"
	 * ); this.setUsername("root"); this.setPassword("admin");
	 * this.setMaxIdle(2); this.setMaxActive(60); this.setMaxActive(3);
	 */
	public String demodesc;

	public String DriverClassName;

	public String Url;

	public String Username;

	public String Password;

	public int MaxActive;

	public int MaxIdle;

	public int MaxWait;

	public String hibernate_dialect;

	public String hibernate_transactionfactoryclass;

	public String hibernate_hbm2ddl;

	public String hibernate_show_sql;

	public String getDriverClassName() {
		return DriverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		DriverClassName = driverClassName;
	}

	public int getMaxActive() {
		return MaxActive;
	}

	public void setMaxActive(int maxActive) {
		MaxActive = maxActive;
	}

	public int getMaxIdle() {
		return MaxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		MaxIdle = maxIdle;
	}

	public int getMaxWait() {
		return MaxWait;
	}

	public void setMaxWait(int maxWait) {
		MaxWait = maxWait;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getHibernate_dialect() {
		return hibernate_dialect;
	}

	public void setHibernate_dialect(String hibernate_dialect) {
		this.hibernate_dialect = hibernate_dialect;
	}

	public String getHibernate_hbm2ddl() {
		return hibernate_hbm2ddl;
	}

	public void setHibernate_hbm2ddl(String hibernate_hbm2ddl) {
		this.hibernate_hbm2ddl = hibernate_hbm2ddl;
	}

	public String getHibernate_transactionfactoryclass() {
		return hibernate_transactionfactoryclass;
	}

	public void setHibernate_transactionfactoryclass(
			String hibernate_transactionfactoryclass) {
		this.hibernate_transactionfactoryclass = hibernate_transactionfactoryclass;
	}

	public String getHibernate_show_sql() {
		return hibernate_show_sql;
	}

	public void setHibernate_show_sql(String hibernate_show_sql) {
		this.hibernate_show_sql = hibernate_show_sql;
	}

	public String getDemodesc() {
		return demodesc;
	}

	public void setDemodesc(String demodesc) {
		this.demodesc = demodesc;
	}

}
