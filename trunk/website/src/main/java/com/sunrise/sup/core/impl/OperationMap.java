/*
 * �������� 2004-12-27
 *
 */
package com.sunrise.sup.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CursorableLinkedList;
import org.apache.commons.lang.StringUtils;

import com.sunrise.sup.core.common.error.ErrorCodeMaping;
import com.sunrise.sup.core.common.error.ErrorCodes;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.OperationConstants;

/**
 * �Ա�������з����Map
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class OperationMap extends AbstractMap {

	protected HashMap dependsMap = new HashMap(2);

	protected HashMap operationsMap = new HashMap(2);

	/**
	 * �õ�Object���������� ����DM.Object
	 * 
	 * @return
	 */
	public Set getOperations() {
		return keys;
	}

	private boolean modified = true;

	private CursorableLinkedList linkedList;

	public Iterator getOperationExecuteIterator() throws OperationException {
		if (modified || linkedList == null) {
			initLinkedList();
		}
		return linkedList.iterator();
	}

	/**
	 * ���壺 DM.Create.user.__Depends = DM.Create.user1 DM.Create.user��Ϊ��5����
	 * DM.Create.user1��Ϊ����5����
	 */
	private void initLinkedList() throws OperationException {
		linkedList = new CursorableLinkedList();
		for (Iterator it = getOperations().iterator(); it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			String depSrc = expr.getName();
			// ������������5��ϵ�Ѿ���������ˣ�������һ���Ĳ���
			if (linkedList.indexOf(expr) > -1) {
				continue;
			}
			// ���������û����5��ϵ��ô�ӵ�����t�Ŀ�ʼ
			if (!dependsMap.containsKey(depSrc)) {
				linkedList.addLast(expr);
				continue;
			}
			// ��������5��ϵ���б�
			dealDepends(expr, (List) dependsMap.get(depSrc), new ArrayList());
		}
		modified = false;

	}

	/**
	 * @param depSrc
	 *            ��5����
	 * @param ls
	 *            ����5������б�
	 * @param dealedOperations
	 *            �ڵ�ǰt���Ѿ�������Ĳ���
	 */
	private void dealDepends(IExpression exprSrc, List ls, List dealedOperations)
			throws OperationException {
		// �ѵ�ǰ��������뵱ǰ�������t��
		dealedOperations.add(exprSrc.getName());
		// ��֤��ǰ�����б���5�Ķ��󶼱�������
		for (Iterator itLs = ls.iterator(); itLs.hasNext();) {
			String depTg = (String) itLs.next();
			IExpression exprTg = (IExpression) operationsMap.get(depTg);
			if (exprTg == null) {
				throw getDependsException(depTg);
			}
			// ��鱻��5��ϵ�Ƿ��ڵ�ǰ�������t�У������ڣ� �׳���5��ϵ��������
			if (dealedOperations.contains(depTg)) {
				throw getDependsException(dealedOperations, depTg);
			}
			// ������������5��ϵ�Ѿ���������ˣ�������һ���Ĳ���
			if (linkedList.indexOf(exprTg) > -1) {
				continue;
			}
			// ���������û����5��ϵ��ô�ӵ�����t�Ŀ�ʼ
			if (!dependsMap.containsKey(depTg)) {
				linkedList.addLast(exprTg);
				continue;
			}
			dealDepends(exprTg, (List) dependsMap.get(depTg), dealedOperations);
		}
		// ȷ�����б���5�Ķ��󶼱�����ѵ�ǰ������봦��t�����
		linkedList.addLast(exprSrc);
		// �ѵ�ǰ������ӵ�ǰ�������t��ɾ��
		dealedOperations.remove(exprSrc.getName());
	}

	public OperationException getDependsException(String depTg) {
		String error = "�ڲ������5��ϵ�У��޷���������Ĳ���,�ò�����" + depTg + ".";
		return new OperationSystemException(
				ErrorCodes.OperationDependsCycleError, error);

	}

	public OperationException getDependsException(List dealedOperations,
			String depTg) {
		String error = "����ѭ������5��ϵ,�����5tΪ";
		for (Iterator itLs = dealedOperations.iterator(); itLs.hasNext();) {
			error += itLs.next().toString() + ",";
		}
		return new OperationSystemException(
				ErrorCodeMaping.OA_EXPRESS_VAR_DEPENDERROR, error);

	}

	/**
	 * ��Ӳ���֮�����5��ϵ
	 * 
	 * @param dependSrc
	 *            ��5����
	 * @param dependTags
	 *            ����5����
	 */
	public void addOperationDepends(String dependSrc, String[] dependTags) {
		modified = true;
		if (dependTags != null && dependTags.length > 0) {
			for (int i = 0; i < dependTags.length; i++) {
				getDependsList(StringUtils.trimToEmpty(dependSrc)).add(
						StringUtils.trimToEmpty(dependTags[i]));
			}
		}
	}

	public void put(IExpression ex) {
		// ������Ĺؼ���С�����򷵻أ�������
		if (ex.getNames().length < 3) {
			return;
		}
		String str = ex.getNames()[0].trim() + "." + ex.getNames()[1].trim()
				+ "." + ex.getNames()[2].trim();
		if (ex.getNames().length == 3) {
			addKeySet(ex);
			operationsMap.put(str, ex);
		} else if (ex.getNames().length == 4
				&& StringUtils.equalsIgnoreCase(ex.getNames()[3],
						OperationConstants.OPERATION_DEPENDS_KEY)) {
			String value = ex.getValues()[0];
			String[] dps = StringUtils.split(value, ",");
			addOperationDepends(str, dps);
		} else {
			getRelationList(str).add(ex);
		}
	}

	public void remove(IExpression ex) {
		if (ex.getNames().length > 2) {
			String str = ex.getNames()[0].trim() + "."
					+ ex.getNames()[1].trim() + "." + ex.getNames()[2].trim();
			getRelationList(str).add(ex);
			removeKeySet(ex);
			operationsMap.remove(str);
		}
	}

	/**
	 * ��ݲ������ͺͱ���ƣ��õ���������ص���ݶ�����ʽ
	 * 
	 * @param type
	 * @param varName
	 * @return
	 */
	public List get(String type, String operation, String varName) {
		return getRelationList(type.trim() + "." + operation.trim() + "."
				+ varName.trim());
	}

	protected List getDependsList(String name) {
		List ls = null;
		if (dependsMap.containsKey(name)) {
			ls = (List) dependsMap.get(name);
		} else {
			ls = new ArrayList(2);
			dependsMap.put(name, ls);
		}
		return ls;
	}
}