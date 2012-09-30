/*
 *  2005-1-17
 *
 */
package com.sunrise.sup.core.common.dao.hibernate;

import java.util.List;

import org.hibernate.type.Type;

import com.sunrise.sup.core.common.util.Pagination;

/* add by lingli 20060607 rich the ado funtion */
public interface AdvanceDAO extends DAO {

	// type1: query with page parameter.
	public List find(String sql, Pagination pagination) throws Exception;

	public List find(String sql, Object objs, Type types, Pagination pagination)
			throws Exception;

	public List find(String sql, Object[] obj, Type[] type,
			Pagination pagination) throws Exception;

	// type2: query no page parameter
	public List find(String sql);

	public List findbyhsql(String query, Object parameter);

	public List findbyhsql(String query, Object[] parameters);

	// type3: load object
	public Object loadById(String entity, Long id);

	public Object loadByName(Class namedEntity, String name);

	public Object loadByNamedQuery(String query, Object obj);

	// type3: Miscellaneous way get list
	public List findAll(Class entity);

	public List findByNamedQuery(String query);

	public List findByNamedQuery(String query, Object parameter);

	public List findByNamedQuery(String query, Object[] parameters);

	public List findByValueBean(String query, Object resource);

	public List findByNamedQuery(String query, String paramName, Object value);

	public List findByNamedQuery(String query, String[] paramNames,
			Object[] values);
}
