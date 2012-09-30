/*
 * �������� 2004-12-30
 *
 */
package com.sunrise.sup.core.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.CursorableLinkedList;

import com.sunrise.sup.core.inf.IExpression;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public abstract class AbstractMap {

	protected HashMap datasMap = new HashMap(10);

	protected Set keys = new TreeSet();

	public abstract void put(IExpression ex);

	public abstract void remove(IExpression ex);

	protected void addKeySet(IExpression ex) {
		keys.add(ex);
	}

	protected void removeKeySet(IExpression ex) {
		keys.remove(ex);
	}

	protected List getRelationList(String name) {
		List ls = null;
		if (datasMap.containsKey(name)) {
			ls = (List) datasMap.get(name);
		} else {
			ls = new CursorableLinkedList();
			datasMap.put(name, ls);
		}
		return ls;
	}

}
