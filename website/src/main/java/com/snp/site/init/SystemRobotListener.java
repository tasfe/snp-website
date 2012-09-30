package com.snp.site.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*系统启动时调用的系统初试化信息*/
public class SystemRobotListener implements ServletContextListener {
	private static Log log = LogFactory.getLog(SystemRobotListener.class);

	public void contextInitialized(ServletContextEvent sce) {

		try {
			SystemInit.initSystemStaitcData(sce);

		} catch (Exception e) {
			log.error("[SNP-INFO] SystemData init error!", e);
		}

	}

	public void contextDestroyed(ServletContextEvent ce) {
		// log.debug("[SNP-INFO] Start End");
	}
}
