package com.sunrise.sup.core.common.util;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork.ActionContext;

/**
 * 
 */
public final class WebAppContextUtils {
	private static Log log = LogFactory.getLog(WebAppContextUtils.class);

	public static WebApplicationContext getWebApplicationContext() {
		return getWebApplicationContext(ActionContext.getContext());
	}

	/**
	 * 根据KEY获取前台传过来的参数，如果不存在这个参数，会打印出来 如果要抛出异常，ACTION要该很多地方
	 */
	public static String getpara(String key) {
		Map props = ActionContext.getContext().getParameters();
		if (props.get(key) == null) {
			log.debug("http pareamete does not exists:" + key);
			return "";
		} else {
			String[] para = (String[]) props.get(key);
			return para[0].trim();
		}
	}

	/**
	 * 求WebApplicationContext
	 */
	public static WebApplicationContext getWebApplicationContext(
			ActionContext actionContext) {
		Map applicationMap = actionContext.getApplication();

		if (applicationMap == null) {
			return null;
		}
		Object webApplicationContext = applicationMap
				.get(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if (webApplicationContext == null) {
			return null;
		}
		if (webApplicationContext instanceof RuntimeException) {
			throw (RuntimeException) webApplicationContext;
		}
		if (webApplicationContext instanceof Error) {
			throw (Error) webApplicationContext;
		}
		if (!(webApplicationContext instanceof WebApplicationContext)) {
			throw new IllegalStateException(
					"Root context attribute is not of type WebApplicationContext: "
							+ webApplicationContext);
		}

		return (WebApplicationContext) webApplicationContext;
	}

}
