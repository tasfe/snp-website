/*
 * �������� 2005-1-17
 *
 */
package com.sunrise.sup.dm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.AssociationType;
import org.hibernate.type.IdentifierType;
import org.hibernate.type.Type;
import org.hibernate.type.VersionType;

import com.sunrise.sup.core.common.dao.hibernate.BaseDAOHibernate;
import com.sunrise.sup.core.common.error.ErrorCodes;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.impl.OperationUtils;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DataMHibernate extends BaseDAOHibernate implements IDataMHibernate {

	public void dealQueryParams(Class clazz, List qrPs, Map trueFields,
			List params, List types, DataInstanceDeclare instDec)
			throws Exception {
		if (qrPs != null && qrPs.size() > 0) {
			Map datas = new HashMap();
			Map dtTypes = new HashMap();
			for (Iterator it = qrPs.iterator(); it.hasNext();) {
				String fild = (String) it.next();
				if (datas.containsKey(fild)) {
					params.add(datas.get(fild));
					types.add(dtTypes.get(fild));
					continue;
				}

				Type type = findType(clazz, (String) trueFields.get(fild));
				Object value = null;
				if (type != null && type instanceof IdentifierType) {
					IdentifierType idType = (IdentifierType) type;
					value = idType.stringToObject(instDec.getPropertie(fild));
				} else if (type != null && type instanceof VersionType) {
					// VersionType versType = (VersionType) type;
					// lingli hibernate修改跳不过的
					// value = versType.fromString(instDec.getPropertie(fild));

				} else {
					throw new OperationSystemException(
							ErrorCodes.OperationParameterError,
							"��ѯ����������ֶ�" + fild + "�޷��ҵ�!");

				}
				params.add(value);
				types.add(type);
				datas.put(fild, value);
				dtTypes.put(fild, type);

			}

		}
	}

	private Type findType(Class clazz, String filed) throws Exception {
		ClassMetadata clzM = this.getSessionFactory().getClassMetadata(clazz);
		String[] fileds = StringUtils.split(filed, ".");
		Type type = null;
		if (fileds.length == 1) {
			if (fileds[0].equals(clzM.getIdentifierPropertyName())) {
				type = clzM.getIdentifierType();
			} else {
				type = clzM.getPropertyType(fileds[0]);
			}
			if (type.isEntityType()) {
				return Hibernate.LONG;
			}
			return type;
		} else if (fileds.length > 1) {
			type = clzM.getPropertyType(fileds[0]);
			if (type.isAssociationType()) {
				AssociationType objType = (AssociationType) type;
				Class cla = null;
				// lingli hibernate修改跳不过的
				if (objType.isCollectionType()) {
					// if (objType.isPersistentCollectionType()) {
					// PersistentCollectionType perType =
					// (PersistentCollectionType) objType;
					// PersistentCollection perType = (PersistentCollection)
					// objType;

					// cla =
					// perType.getAssociatedClass((SessionFactoryImplementor)
					// this.getSessionFactory());

				} else {
					cla = objType.getReturnedClass();
				}
				return findType(cla, OperationUtils.getKey(fileds, 1));
			}
		}

		return null;
	}

}
