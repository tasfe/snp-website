/*
 * �������� 2005-6-23
 *
 */
package com.sunrise.sup.core.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.sup.core.inf.IFunctionData;
import com.sunrise.sup.core.inf.IOperationContext;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class SessionData implements IFunctionData {
	protected Log log = LogFactory.getLog(this.getClass());

	public Object getData(String key, IOperationContext context) {
		String obj = null;

		String[] objectlever = StringUtils.split(key, ".");

		if (objectlever.length == 1 && context.getSession().containsKey(key)) {
			obj = (String) context.getSession().get(key);
		}
		if (objectlever.length > 1
				&& context.getSession().containsKey(objectlever[0])) {
			Object sessionObject = context.getSession().get(objectlever[0]);
			try {
				return BeanUtils.describe(sessionObject).get(objectlever[1]);
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("sup sessiondata error!", e);
			}

		}
		return obj;
	}

}
