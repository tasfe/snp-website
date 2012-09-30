/*
 * �������� 2005-1-18
 *
 */
package com.sunrise.sup.dm;

import java.util.List;
import java.util.Map;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IDataMHibernate {
	public void dealQueryParams(Class clazz, List qrPs, Map trueFields,
			List params, List types, DataInstanceDeclare instDec)
			throws Exception;
}