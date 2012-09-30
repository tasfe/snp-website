/************************************************************************
 * $Id: ObjectUtil.java,v 1.1 2008/01/03 06:46:49 ln Exp $
 *
 * Copyright (C) 2002 by Ricsson Corporation. All rights reserved.
 ************************************************************************/

package com.sunrise.sup.core.common.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * @author huangsj
 * 
 */
public class ObjectUtil {
	protected static Logger log = Logger.getLogger(ObjectUtil.class);

	public static Object convertObject(Object val, String in) throws Exception {
		if (val instanceof Integer) {
			return Integer.valueOf(in);
		} else if (val instanceof Long) {
			return Long.valueOf(in);
		} else if (val instanceof Float) {
			return Float.valueOf(in);
		} else if (val instanceof Double) {
			return Double.valueOf(in);
		} else if (val instanceof Boolean) {
			return Boolean.valueOf(in);
		}
		return in;
	}

	public static Object convertObject(Object val, String[] in)
			throws Exception {
		if (in == null || in.length == 0) {
			return null;
		}
		if (val instanceof ArrayList) {
			ArrayList list = new ArrayList();
			for (int i = 0; i < in.length; i++) {
				log.debug("add data to list: " + in[i]);
				list.add(in[i]);
			}
			return list;
		} else if (val instanceof Object[]) {
			return in;
		} else {
			return convertObject(val, in[0]);
		}
	}

	public static Object getSingleObject(Object o) {
		if (o instanceof Object[]) {
			return ((Object[]) o)[0];
		}
		return o;
	}
}
