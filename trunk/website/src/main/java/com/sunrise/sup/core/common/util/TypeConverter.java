/*
 * 创建日期 2005-1-17
 *
 */
package com.sunrise.sup.core.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import ognl.OgnlOps;

import com.opensymphony.xwork.XworkException;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class TypeConverter {
	// ~ Methods
	// ////////////////////////////////////////////////////////////////

	public static Object convertValue(String value, Class toType, Locale locale) {
		Object result = null;

		if (value.getClass().isAssignableFrom(toType)) {
			// no need to convert at all, right?
			return value;
		}

		if (toType == String.class) {
			result = doConvertToString(value);
		} else if (toType == boolean.class) {
			result = doConvertToBoolean(value);
		} else if (toType == Boolean.class) {
			result = doConvertToBoolean(value);
		} else if (toType == Date.class) {
			result = doConvertToDate(value, locale);
		} else if (Number.class.isAssignableFrom(toType)) {
			result = doConvertToNumber(value, toType, locale);
		} else {
			return OgnlOps.convertValue(value, toType);
		}
		return result;
	}

	/*
	 * private Locale getLocale(Map context) { Locale locale = (Locale)
	 * context.get(ActionContext.LOCALE);
	 * 
	 * if (locale == null) { locale = Locale.getDefault(); }
	 * 
	 * return locale; }
	 */

	/**
	 * Creates a Collection of the specified type.
	 * 
	 * @param toType
	 *            the type of Collection to create
	 * @param memberType
	 *            the type of object elements in this collection must be
	 * @param size
	 *            the initial size of the collection (ignored if 0 or less)
	 * @return a Collection of the specified type
	 * 
	 *         private Collection createCollection(Class toType, Class
	 *         memberType, int size) { Collection result;
	 * 
	 *         if (toType == Set.class) { if (size > 0) { result = new
	 *         HashSet(size); } else { result = new HashSet(); } } else if
	 *         (toType == SortedSet.class) { result = new TreeSet(); } else { if
	 *         (size > 0) { result = new XWorkList(memberType, size); } else {
	 *         result = new XWorkList(memberType); } }
	 * 
	 *         return result; }
	 */
	private static Object doConvertToBoolean(Object value) {
		if (value instanceof String) {
			String bStr = (String) value;

			return Boolean.valueOf(bStr);
		}

		return null;
	}

	private static Object doConvertToDate(Object value, Locale locale) {
		Date result = null;

		if (value instanceof String) {
			String sa = (String) value;

			DateFormat df = DateFormat
					.getDateInstance(DateFormat.SHORT, locale);

			try {
				result = df.parse(sa);
			} catch (ParseException e) {
				throw new XworkException("Could not parse date", e);
			}
		} else if (Date.class.isAssignableFrom(value.getClass())) {
			result = (Date) value;
		}

		return result;
	}

	private static Object doConvertToNumber(Object value, Class toType,
			Locale locale) {
		if (value instanceof String) {
			if (toType == BigDecimal.class) {
				return new BigDecimal((String) value);
			} else if (toType == BigInteger.class) {
				return new BigInteger((String) value);
			} else {

				value = OgnlOps.convertValue(value, toType);
			}
		} else if (value instanceof Object[]) {
			Object[] objArray = (Object[]) value;

			if (objArray.length == 1) {
				return doConvertToNumber(objArray[0], toType, locale);
			}
		}

		return OgnlOps.convertValue(value, toType);
	}

	private static String doConvertToString(Object value) {
		if (value == null)
			return "";
		return value.toString();
	}
}
