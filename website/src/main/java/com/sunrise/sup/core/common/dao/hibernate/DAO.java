/*
 * �������� 2004-12-24
 */
package com.sunrise.sup.core.common.dao.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jerry Tang
 * 
 */
public interface DAO {
	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @param clazz
	 *            the type of objects (a.k.a. while table) to get data from
	 * @return List of populated objects
	 */
	public List getObjects(Class clazz);

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param clazz
	 *            model class to lookup
	 * @param id
	 *            the identifier (primary key) of the class
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	public Object getObject(Class clazz, Serializable id);

	/**
	 * Generic method to save an object - handles insert.
	 * 
	 * @param o
	 *            the object to insert
	 */
	public void saveObject(Object o);

	public void refreshObject(Object o);

	/**
	 * Generic method to save an object - handles update
	 * 
	 * @param o
	 *            the object to update
	 */
	public void updateObject(Object o);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param clazz
	 *            model class to lookup
	 * @param id
	 *            the identifier (primary key) of the class
	 */
	public void removeObject(Class clazz, Serializable id);

	/**
	 * Generic method to delete an object
	 * 
	 * @param o
	 *            the object to remove
	 */
	public void removeObject(Object o);
}
