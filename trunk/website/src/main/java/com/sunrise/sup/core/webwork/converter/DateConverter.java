package com.sunrise.sup.core.webwork.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import ognl.DefaultTypeConverter;

import com.opensymphony.xwork.XworkException;

public class DateConverter extends DefaultTypeConverter {
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");

	public Object convertValue(Map ognlContext, Object value, Class toType) {
		Object result = null;
		if (toType == Date.class) {
			result = doConvertToDate(value);
		} else if (toType == String.class) {
			result = doConvertToString(value);
		}
		return result;
	}

	private Date doConvertToDate(Object value) {
		Date result = null;

		if (value instanceof String) {
			try {
				result = sdf.parse((String) value);
			} catch (Exception e) {
				throw new XworkException("Could not parse date", e);
			}
		} else if (value instanceof Object[]) {
			// let's try to convert the first element only
			Object[] array = (Object[]) value;
			if ((array != null) && (array.length >= 1)) {
				value = array[0];
				result = doConvertToDate(value);
			}
		} else if (Date.class.isAssignableFrom(value.getClass())) {
			result = (Date) value;
		}
		return result;
	}

	private String doConvertToString(Object value) {
		String result = null;
		if (value instanceof Date) {
			result = sdf.format(value);
		}
		return result;
	}
}
