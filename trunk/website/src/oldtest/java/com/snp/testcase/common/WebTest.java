package com.snp.testcase.common;

import java.util.HashMap;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
/*
 * 是否需要删除数据库
 * */
public class WebTest extends EnvTest {
	boolean participate = true;
	private boolean singleSession = true;

	public static XmlWebApplicationContext ctx;
	SessionFactory sessionFactory = null;
	Session session = null;
	protected OperationControlAction action;
	//<bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
	private String sessionFactoryBeanName = "sessionFactory";

	static {
		String[] paths = {springconfigfile};
		ctx = new XmlWebApplicationContext();
		ctx.setConfigLocations(paths);
		ctx.setServletContext(new MockServletContext(""));
		ctx.refresh();
	}
	


	protected void setUp() throws Exception {
		ServletActionContext.getContext().setApplication(new HashMap());
		ServletActionContext.getContext().setSession(new HashMap());
		ServletActionContext.getContext().setParameters(new HashMap());
		ServletActionContext.getContext().getApplication().put(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
				ctx);
		participate = false;
		sessionFactory = (SessionFactory) ctx.getBean(getSessionFactoryBeanName());
		session = null;
		doFilterBegin();
		action = (OperationControlAction) ctx.getBean("operationControlAction");
		
	}
	
	
	protected void tearDown() throws Exception {
		ServletActionContext.getContext().setApplication(null);
		ServletActionContext.getContext().setSession(null);
		ServletActionContext.getContext().setParameters(null);
		doFilterEnd();
		participate = false;
		sessionFactory = null;
		session = null;
		action = null;
	}

	public void doFilterBegin() {

		if (singleSession) {
			// single session mode
			if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
				participate = true;
			} else {
				//log.debug("Opening single Hibernate session in OpenSessionInViewFilter");
				session = getSession(sessionFactory);
				TransactionSynchronizationManager.bindResource(sessionFactory,
						new SessionHolder(session));
			}
		} else {
			// deferred close mode
			if (SessionFactoryUtils.isDeferredCloseActive(sessionFactory)) {
				// do not modaify deferred close: just set the participate flag
				participate = true;
			} else {
				SessionFactoryUtils.initDeferredClose(sessionFactory);
			}
		}

	}

	public void doFilterEnd() {

		if (!participate) {
			if (singleSession) {
				// single session mode
				TransactionSynchronizationManager
						.unbindResource(sessionFactory);
				//log.debug("Closing single Hibernate session in OpenSessionInViewFilter");
				closeSession(session, sessionFactory);
			} else {
				// deferred close mode
				SessionFactoryUtils.processDeferredClose(sessionFactory);
			}
		}
	}

	/**
	 * Set the bean name of the SessionFactory to fetch from Spring's root
	 * application context. Default is "sessionFactory".
	 * 
	 * @see #DEFAULT_SESSION_FACTORY_BEAN_NAME
	 */
	public void setSessionFactoryBeanName(String sessionFactoryBeanName) {
		this.sessionFactoryBeanName = sessionFactoryBeanName;
	}

	/**
	 * Return the bean name of the SessionFactory to fetch from Spring's root
	 * application context.
	 */
	protected String getSessionFactoryBeanName() {
		return sessionFactoryBeanName;
	}
    /*
	public void setSingleSession(boolean singleSession) {
		this.singleSession = singleSession;
	}
   */
	protected Session getSession(SessionFactory sessionFactory)
			throws DataAccessResourceFailureException {
		Session session = SessionFactoryUtils.getSession(sessionFactory, true);
		session.setFlushMode(FlushMode.NEVER);
		return session;
	}

	/**
	 * Return whether to use a single session for each request.
	 */
	protected boolean isSingleSession() {
		return singleSession;
	}

	protected void closeSession(Session session, SessionFactory sessionFactory) {
		// SessionFactoryUtils.closeSessionIfNecessary(session, sessionFactory);
	}
}