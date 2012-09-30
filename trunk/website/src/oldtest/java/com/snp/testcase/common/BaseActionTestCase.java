package com.snp.testcase.common;


import java.util.HashMap;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class BaseActionTestCase extends TestCase {
    protected static XmlWebApplicationContext ctx;
    protected transient final Log log = LogFactory.getLog(getClass());
    // This static block ensures that Spring's BeanFactory is only loaded
    // once for all tests
    static {
      //  ResourceBundle db = ResourceBundle.getBundle("database");
      //  String daoType = db.getString("dao.type");
        String[] paths = {   "file:src/conf/spring*.xml"};
        //String[] paths = { "file:D:/sqa/workspaceweb/sup/src/linglitest/test*.xml"};
		
        ctx = new XmlWebApplicationContext();
        ctx.setConfigLocations(paths);
        ctx.setServletContext(new MockServletContext(""));
        ctx.refresh();
    }

    boolean participate = false;
    SessionFactory sessionFactory = null;
    Session session = null;
    
    public static final String DEFAULT_SESSION_FACTORY_BEAN_NAME = "sessionFactory";
    private String sessionFactoryBeanName = DEFAULT_SESSION_FACTORY_BEAN_NAME;
    private boolean singleSession = true;    

    protected void setUp() throws Exception {
        ServletActionContext.getContext().setApplication(new HashMap());
        ServletActionContext.getContext().setSession(new HashMap());
        ServletActionContext.getContext().setParameters(new HashMap());
        ServletActionContext.getContext().getApplication().put(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
                ctx);
        participate = false;
        sessionFactory = lookupSessionFactory();
        session = null;
        
        doFilterBegin();
    }

    protected void tearDown() throws Exception {
        ServletActionContext.getContext().setApplication(null);
        ServletActionContext.getContext().setSession(null);
        ServletActionContext.getContext().setParameters(null);
        doFilterEnd();
        participate = false;
        sessionFactory = null;
        session = null;
    }

    protected SessionFactory lookupSessionFactory() {
        //WebApplicationContext wac =
        // WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        return (SessionFactory) ctx.getBean(getSessionFactoryBeanName());
    }


    public void doFilterBegin() {

        if (isSingleSession()) {
            // single session mode
            if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
                participate = true;
            } else {
                log.debug("Opening single Hibernate session in OpenSessionInViewFilter");
                session = getSession(sessionFactory);
                TransactionSynchronizationManager.bindResource(sessionFactory,
                        new SessionHolder(session));
            }
        } else {
            // deferred close mode
            if (SessionFactoryUtils.isDeferredCloseActive(sessionFactory)) {
                // do not modify deferred close: just set the participate flag
                participate = true;
            } else {
                SessionFactoryUtils.initDeferredClose(sessionFactory);
            }
        }

    }

    public void doFilterEnd() {

        if (!participate) {
            if (isSingleSession()) {
                // single session mode
                TransactionSynchronizationManager
                        .unbindResource(sessionFactory);
                log
                        .debug("Closing single Hibernate session in OpenSessionInViewFilter");
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

    public void setSingleSession(boolean singleSession) {
        this.singleSession = singleSession;
    }

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
    //    SessionFactoryUtils.closeSessionIfNecessary(session, sessionFactory);
    }
}