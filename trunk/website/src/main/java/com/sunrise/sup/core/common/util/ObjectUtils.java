/*
 * 锟斤拷锟斤拷锟斤拷锟斤拷 2004-12-27
 *
 */
package com.sunrise.sup.core.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.sunrise.sup.core.common.error.OperationException;

/**
 * 锟斤拷荽锟斤拷锟侥诧拷锟斤拷锟斤拷啥锟斤拷锟绞碉拷锟?
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class ObjectUtils {
	private ObjectUtils() {
	}

	private static Log log = LogFactory.getLog(ObjectUtils.class);

	public static Object createObjectInstanse(String clss,
			ApplicationContext context) throws OperationException {
		try {
			String[] strs = StringUtils.split(clss, ':');
			/*
			 * 锟叫讹拷锟斤拷锟紹ean锟角凤拷锟斤拷spring锟斤拷锟斤拷锟斤拷桑锟阶帮拷锟斤拷锟捷碉拷时锟斤拷锟矫得ｏ拷锟斤拷锟斤导锟斤拷锟斤拷锟绞碉拷锟斤拷时锟斤拷要锟斤拷
			 * 锟斤拷锟揭伙拷锟斤拷锟斤拷玫枚锟斤拷锟? lingli 20050829
			 * 锟睫革拷锟斤拷锟絇O锟斤拷锟斤拷锟紼RROR锟斤拷锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷募锟斤拷锟街革拷锟斤拷亩锟斤拷锟
			 * ?锟酵斤拷b一锟斤拷CLASS锟斤拷锟斤拷
			 */
			if (strs.length > 1
					&& StringUtils.equalsIgnoreCase(strs[0], "spring")) {
				return context.getBean(strs[1]);
			}
			Class cls = Class.forName(clss);
			return cls.newInstance();
		} catch (Exception e) {
			throw new OperationException("0001", "Can not get the po name:"
					+ clss + ",please check the opreation objectName!", e);
		}
	}

	// 锟斤拷锟絚reatePoInstanse锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟皆猴拷锟斤拷锟绞碉拷锟揭拷锟斤拷锟斤拷锟斤拷募锟斤拷卸锟斤拷锟斤拷锟斤拷锟较?
	public static Object createPoInstanse(String clss,
			ApplicationContext context) throws OperationException {
		try {
			return context.getBean(clss);
		} catch (Exception e) {
			OperationException ex = new OperationException(
					"0000",
					"The 'poname="
							+ clss
							+ "' does exit in spring config,please check the po name!",
					e);
			log.debug("Get PoObject Error!", ex);
			throw ex;
		}
	}
}
