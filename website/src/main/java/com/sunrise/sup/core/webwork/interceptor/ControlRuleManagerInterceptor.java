package com.sunrise.sup.core.webwork.interceptor;

import com.opensymphony.webwork.WebWorkStatics;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.config.entities.ResultConfig;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.sunrise.sup.core.inf.ILoginUserManager;

// com.sunrise.wbmp.operation.actions.ControlRuleManagerInterceptor
public class ControlRuleManagerInterceptor implements Interceptor,
		WebWorkStatics {
	public static final String LOGIN_ERROR = "loginError";

	private ILoginUserManager checkLogin;

	// private static Log log =
	// LogFactory.getLog(ControlRuleManagerInterceptor.class);

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.opensymphony.xwork.interceptor.Interceptor#destroy()
	 */
	public void destroy() {

	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.opensymphony.xwork.interceptor.Interceptor#init()
	 */
	public void init() {

	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.opensymphony.xwork.interceptor.Interceptor#intercept(com.opensymphony
	 * .xwork.ActionInvocation)
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		// ActionContext.get
		// HttpServletRequest request = (HttpServletRequest)
		// ActionContext.getContext().get(HTTP_REQUEST);
		// HttpServletResponse response = (HttpServletRequest)
		// ActionContext.getContext().get(HTTP_RESPONSE);
		// response.addCookie(new Cookie());
		// Enumeration enum = request.get;
		String result = null;
		if (checkLogin != null && checkLogin.checkLogin()) {
			result = invocation.invoke();
			ResultConfig resultConf = new ResultConfig();
			resultConf.setName("SUCCESS");
		} else {
			result = LOGIN_ERROR;
		}
		return result;
	}

	public ILoginUserManager getCheckLogin() {
		return checkLogin;
	}

	public void setCheckLogin(ILoginUserManager checkLogin) {
		this.checkLogin = checkLogin;
	}
}
