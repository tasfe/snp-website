/*
 * �������� 2004-12-27
 *
 */
package com.sunrise.sup.core.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CursorableLinkedList;
import org.apache.commons.lang.StringUtils;

import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.dm.DataOperationConstants;

/**
 * �Ա�������з����Map
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class InstanceDeclareMap extends AbstractMap {
	private Map copyMap = new HashMap();

	private boolean needDealCopy = true;

	/**
	 * �õ�Object���������� ����DM.Object
	 * 
	 * @return
	 */
	public Set getObjects() {
		return keys;
	}

	public void put(IExpression ex) {
		if (ex.getNames().length < 3)
			return;
		needDealCopy = true;
		String str = ex.getNames()[0].trim() + ".Object."
				+ ex.getNames()[2].trim();
		if (ex.isInstanceDeclareExpression()
				&& !StringUtils.equalsIgnoreCase(ex.getNames()[1], "Object")) {
			if (ex.getNames().length > 3
					&& ex.getValues() != null
					&& ex.getValues().length > 0
					&& StringUtils.equalsIgnoreCase(ex.getNames()[3],
							DataOperationConstants.OBJECT_COPY)) {
				copyMap.put(ex.getNames()[2], ex.getValues()[0]);
			} else {
				getRelationList(str).add(ex);
			}
		}
		if (StringUtils.equalsIgnoreCase(ex.getNames()[1], "Object")) {
			addKeySet(ex);
		}
	}

	public String getCopyObject(String orgObj) {
		if (copyMap.containsKey(orgObj)) {
			return (String) copyMap.get(orgObj);
		}
		return null;
	}

	public void remove(IExpression ex) {
		if (ex.getNames().length < 3)
			return;
		needDealCopy = true;
		String str = ex.getNames()[0].trim() + ".Object."
				+ ex.getNames()[2].trim();
		if (ex.isInstanceDeclareExpression()) {
			getRelationList(str).remove(ex);
		}
		if (StringUtils.equalsIgnoreCase(ex.getNames()[1], "Object")) {
			removeKeySet(ex);
		}
	}

	/**
	 * ��ݲ������ͺͱ���ƣ��õ���������ص���ݶ�����ʽ
	 * 
	 * @param type
	 * @param varName
	 * @return
	 */
	public List get(String type, String varName) {
		if (needDealCopy) {
			needDealCopy = false;
			for (Iterator it = copyMap.keySet().iterator(); it.hasNext();) {
				String key = (String) it.next();
				String value = (String) copyMap.get(key);

				CursorableLinkedList orgList = (CursorableLinkedList) getRelationList(type
						.trim() + ".Object." + key.trim());

				Iterator fromIt = getRelationList(
						type.trim() + ".Object." + value.trim()).iterator();

				for (; fromIt.hasNext();) {
					IExpression oldExpr = (IExpression) fromIt.next();
					IExpression newExpr = (IExpression) oldExpr.clone();

					if (newExpr != null && newExpr.getNames() != null
							&& newExpr.getNames().length > 2) {
						String[] newNames = newExpr.getNames();
						newNames[2] = key;
						newExpr.setNames(newNames);
						orgList.addFirst(newExpr);
					}
				}
			}
		}
		return getRelationList(type.trim() + ".Object." + varName.trim());
	}

}
