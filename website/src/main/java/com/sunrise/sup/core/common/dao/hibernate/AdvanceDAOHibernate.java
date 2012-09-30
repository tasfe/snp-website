/*
 * �������� 2005-1-17
 *
 */
package com.sunrise.sup.core.common.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;

import com.sunrise.sup.core.common.util.Pagination;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class AdvanceDAOHibernate extends BaseDAOHibernate implements AdvanceDAO {

	public List find(String sql, Object[] objs, Type[] types,
			Pagination pagination) throws Exception {

		if (pagination == null || pagination.isShowAll()) {
			// lingli:此句我删除了，没办法
			// return getHibernateTemplate().find(sql, objs, types);

		}
		pagination.setTotalSize(loadTotalSize(sql, objs, types));
		Session session = this.getSession();
		Query sqlQuery = null;
		List ls = null;
		try {
			sqlQuery = session.createQuery(sql);
			if (objs != null && objs.length > 0 && types != null
					&& types.length > 0 && objs.length == types.length) {
				for (int i = 0; i < objs.length; i++) {
					sqlQuery.setParameter(i, objs[i], types[i]);
				}
			}
			sqlQuery.setFirstResult((int) pagination.getStart() - 1)
					.setMaxResults((int) pagination.getMaxSize());

			ls = sqlQuery.list();
			if (ls == null) {
				ls = new ArrayList(0);
			}
		} catch (HibernateException e) {
			log.error(e);
		}
		return ls;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.common.dao.AdvanceDAO#find(java.lang.String)
	 */
	public List find(String sql, Pagination pagination) throws Exception {
		try {
			if (pagination == null || pagination.isShowAll()) {
				return getHibernateTemplate().find(sql);
			}

		} catch (Exception he) {
			log.error(
					"Query error,Please check there parameter!"
							+ he.getMessage(), he);
			throw he;
		}
		// ����������и����Ĵ����ӡ�����ﲻӦ���ٴδ�ӡ
		try {
			return find(sql, new Object[0], new Type[0], pagination);
		} catch (Exception he) {

			throw he;
		}
	}

	public List find(String sql) {
		return getHibernateTemplate().find(sql);

	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.common.dao.AdvanceDAO#find(java.lang.String,
	 * java.lang.Object, net.sf.hibernate.type.Type)
	 */
	public List find(String sql, Object obj, Type type, Pagination pagination)
			throws Exception {
		if (pagination == null || pagination.isShowAll()) {
			// lingli:此句我删除了，没办法
			// return getHibernateTemplate().find(sql, obj, type);
		}
		return find(sql, new Object[] { obj }, new Type[] { type }, pagination);
	}

	protected long loadTotalSize(String sql, Object[] objs, Type[] types)
			throws Exception {
		long count = 0;
		try {
			String midSql = getCountSql(sql);
			midSql = "select count(*) " + midSql;

			// lingli 我换掉了这里
			// List ls = this.getHibernateTemplate().find(midSql, objs, types);
			List ls = this.getHibernateTemplate().find(midSql, objs);
			// ��ȡ������
			if (ls != null && ls.size() > 0) {
				Object obj = ls.get(0);
				if (obj instanceof Integer) {
					count = ((Integer) obj).longValue();
				} else if (obj instanceof Long) {
					count = ((Long) obj).longValue();
				}
			}
		} catch (Exception he) {
			log.error(
					"Please check the parent talbe has child records when you delete parent record!"
							+ he.getMessage(), he);
			throw he;
		}
		return count;
	}

	protected String getCountSql(String sql) {
		String midSql = sql;
		int count = StringUtils.indexOf(midSql.toLowerCase(), "from");
		midSql = StringUtils.substring(midSql, count);
		return midSql;

	}

	public Object loadById(String entity, Long id) {
		List result = getHibernateTemplate().find(
				"from " + entity + " where id = ? ", id);
		if (result != null && result.size() > 0) {
			if (result.size() == 1) {
				return result.get(0);
			} else {
				return null;
			}
		}
		return null;
	}

	public Object loadByName(Class namedEntity, String name) {
		List result = getHibernateTemplate().find(
				"from " + namedEntity.getName() + " where name = ? ", name);
		if (result != null && result.size() > 0) {
			if (result.size() == 1) {
				return result.get(0);
			} else {
				log.error("more than one object using the name: " + name
						+ " with namedEntity: " + namedEntity.getName());
				// throw exception or return null?
			}
		}
		return null;
	}

	public Object loadByNamedQuery(String query, Object obj) {
		List result = findByNamedQuery(query, obj);
		if (result != null && result.size() > 0) {
			if (result.size() == 1) {
				return result.get(0);
			} else {
				log.error("got more than one object using the query: " + query
						+ " with parameter: " + obj);
				// throw exception or return null?
			}
		}
		return null;
	}

	public List findAll(Class entity) {
		return getHibernateTemplate().find("from " + entity.getName());
	}

	public List findByNamedQuery(String namedQuery) {
		return getHibernateTemplate().findByNamedQuery(namedQuery);
	}

	public List findByNamedQuery(String query, Object parameter) {
		return getHibernateTemplate().findByNamedQuery(query, parameter);
	}

	public List findByNamedQuery(String query, Object[] parameters) {
		return getHibernateTemplate().findByNamedQuery(query, parameters);
	}

	public List findbyhsql(String query, Object parameter) {
		return getHibernateTemplate().find(query, parameter);
	}

	public List findbyhsql(String query, Object[] parameters) {
		return getHibernateTemplate().find(query, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.core.persistence.QueryManager#findByValueBean(java.lang.String
	 * , java.lang.Object)
	 */
	public List findByValueBean(String query, Object resource) {
		return getHibernateTemplate().findByNamedQuery(query, resource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.core.persistence.QueryManager#findByNamedQuery(java.lang.
	 * String, java.lang.String, java.lang.Object)
	 */
	public List findByNamedQuery(String query, String paramName, Object value) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(query,
				paramName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.core.persistence.QueryManager#findByNamedQuery(java.lang.
	 * String, java.lang.String[], java.lang.Object[])
	 */
	public List findByNamedQuery(String query, String[] paramNames,
			Object[] values) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(query,
				paramNames, values);
	}
}
