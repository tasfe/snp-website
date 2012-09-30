package com.sunrise.sup.core.common.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * HibernateSupport实现了HibernateTemplate和SessionFactory实例的关联。
 * HibernateTemplate对Hibernate Session操作进行了封装，而
 * HibernateTemplate.execute方法则是一封装机制的核心，感兴趣的读者可以研究一 下其实现机制。 Hibernate
 * Developer’s Guide Version 1.0
 * 借助HibernateTemplate我们可以脱离每次数据操作必须首先获得Session实例、启
 * 动事务、提交/回滚事务以及烦杂的try/catch/finally等繁琐操作。从而获得以上代码 中精干集中的逻辑呈现效果。
 * 
 * <p>
 * <a href="BaseDAOHibernate.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible </a>
 */
public class BaseDAOHibernate extends HibernateDaoSupport implements DAO {
	public void removeObject(Object o) {
		getHibernateTemplate().delete(o);
	}

	protected Log log = LogFactory.getLog(this.getClass());

	/**
	 * @see org.appfuse.dao.DAO#getObject(java.lang.Class, java.io.Serializable)
	 */
	public Object getObject(Class clazz, Serializable id) {
		Object o = getHibernateTemplate().get(clazz, id);
		if (o == null) {
			throw new ObjectRetrievalFailureException(clazz, id);
		}

		return o;
	}

	/**
	 * @see org.appfuse.dao.DAO#getObjects(java.lang.Class)
	 */
	public List getObjects(Class clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	/**
	 * @see org.appfuse.dao.DAO#removeObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public void removeObject(Class clazz, Serializable id) {
		getHibernateTemplate().delete(getObject(clazz, id));
	}

	public void saveObject(Object o) {
		getHibernateTemplate().save(o);

	}

	public void refreshObject(Object o) {
		getHibernateTemplate().refresh(o);

	}

	public void updateObject(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
	}
}