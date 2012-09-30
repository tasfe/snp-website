/*
 * 创建日期 2005-7-20
 *
 * 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.sunrise.sup.core.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.dao.hibernate.DAO;
import com.sunrise.sup.core.common.error.OperationException;

/**
 * @author Keith Lee
 * 
 *         要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class BusinessUtils {
	protected Log log = LogFactory.getLog(this.getClass());

	ApplicationContext context = WebAppContextUtils.getWebApplicationContext();

	protected DAO getDAO() throws OperationException {
		return (DAO) context.getBean("dao");
	}

	protected AdvanceDAO getAdvanceDAO() {
		return (AdvanceDAO) context.getBean("advanceDAO");
	}
}
