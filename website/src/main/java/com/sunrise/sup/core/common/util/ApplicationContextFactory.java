/************************************************************************
 * $Id: ApplicationContextFactory.java,v 1.4 2008/02/24 14:05:54 ln Exp $
 *
 * Copyright (C) 2002 by Ricsson Corporation. All rights reserved.
 ************************************************************************/

package com.sunrise.sup.core.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.snp.site.init.SystemInit;

/**
 * @author huangsj
 * 
 *         //应该加一个属性，说明是从哪里出始化的SESSION
 */
public class ApplicationContextFactory {
	private static ApplicationContext ctx_web = null;
	// private static ApplicationContext tool_ctx = null; //业务类的ADO到出不能懒加载
	private static ApplicationContext ctx_file = null;

	public static ApplicationContext getWebAppContext() {

		if (ctx_web == null) {
			ctx_web = WebAppContextUtils.getWebApplicationContext();
			/*
			 * 只返回WEB的APP if (ctx == null) { try { ctx = new
			 * FileSystemXmlApplicationContext("file:"+
			 * SystemInit.getClassPath() + "tool*.xml"); } catch (Exception e) {
			 * log.debug("ApplicationContextFactory error！");
			 * e.printStackTrace(); } }
			 */
		}
		return ctx_web;
	}

	/*
	 * public static ApplicationContext getFileAppContext() { if (tool_ctx ==
	 * null) { //log.debug("Init ToolContext!"); try { tool_ctx = new
	 * FileSystemXmlApplicationContext("file:"+ SystemInit.getClassPath() +
	 * "spring*.xml"); } catch (Exception e) { e.printStackTrace(); } } return
	 * tool_ctx; }
	 */
	public static ApplicationContext getFileAppContext() {
		if (ctx_file == null) {
			// log.debug("Init ToolContext!");
			try {
				ctx_file = new FileSystemXmlApplicationContext("file:"
						+ SystemInit.getClassPath() + "spring*.xml");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ctx_file;
	}
}