/*
 * �������� 2004-12-30
 *
 */
package com.sunrise.sup.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork.ActionContext;
import com.sunrise.sup.core.common.error.ErrorCodeMaping;
import com.sunrise.sup.core.common.error.ErrorCodes;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.common.util.ObjectUtils;
import com.sunrise.sup.core.inf.ICookieManager;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IInstanceDeclare;
import com.sunrise.sup.core.inf.IInstanceDeclareWrapper;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IOperationForward;
import com.sunrise.sup.core.inf.IOperationSessionManager;
import com.sunrise.sup.core.inf.IPOAliasMappingManager;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class OperationContext implements IOperationContext {
	private Log log = LogFactory.getLog(this.getClass());

	private Map instanceDeclareWrappers;

	private ApplicationContext appContext;

	private Map params;

	private Map session;

	private Map cookies;

	private Map results = new HashMap(2);

	private Map tempvar = new HashMap(2);

	private IOperationForward otFor = new OperationForward();

	private IPOAliasMappingManager aliasPOMappingManager;

	private InstanceDeclareMap intDeclare = new InstanceDeclareMap();

	private OperationMap operationMap = new OperationMap();

	public Map getParameters() {
		return params;
	}

	public OperationContext(Map pars, ApplicationContext appContext,
			Map instanceDeclareWrappers,
			IPOAliasMappingManager aliasPOMappingManager) {
		params = pars;
		this.appContext = appContext;
		this.instanceDeclareWrappers = instanceDeclareWrappers;
		this.aliasPOMappingManager = aliasPOMappingManager;
	}

	public InstanceDeclareMap getInstanceDeclareMap() {
		return intDeclare;
	}

	public OperationMap getOperationMap() {
		return operationMap;
	}

	public void registerCookie(IExpression expression) {
		if (!expression.isSessionExpression()) {
			return;
		}
		ICookieManager cookieManager = (ICookieManager) this.appContext
				.getBean("cookieManager");
		if (expression.getValues() == null || expression.getValues().length < 1) {
			cookieManager.addCookie(expression.getNames()[2], "");
		} else {
			cookieManager.addCookie(expression.getNames()[2],
					expression.getValues()[0]);
		}
	}

	public void registerSession(IExpression expression) {
		if (!expression.isSessionExpression()) {
			return;
		}
		if (expression.getValues() == null || expression.getValues().length < 1) {

			if (getSession().containsKey(expression.getNames()[2])) {
				getSession().remove(expression.getNames()[2]);
			}
		} else {
			getSession().put(expression.getNames()[2],
					expression.getValues()[0]);
		}
	}

	public void registerOperationForward(IExpression expression) {
		if (!expression.isOperationForwardExpression()) {
			return;
		}
		OperationForwardURL forwURL = otFor.getOperationForward(expression
				.getNames()[2]);
		if (forwURL == null) {
			forwURL = new OperationForwardURL();
			forwURL.setForwardName(expression.getNames()[2]);
			otFor.setOperationForward(expression.getNames()[2], forwURL);
		}
		if (StringUtils.equalsIgnoreCase(expression.getNames()[3], "Type")) {
			forwURL.setForwardType(expression.getValues()[0]);
		} else if (StringUtils
				.equalsIgnoreCase(expression.getNames()[3], "URL")) {
			forwURL.setForwardURL(expression.getValues()[0]);
		} else if (StringUtils.equalsIgnoreCase(expression.getNames()[3],
				"Param") && expression.getNames().length > 4) {
			forwURL.getParams().put(expression.getNames()[4],
					expression.getValues()[0]);
		}
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperationContext#getOperationForward()
	 */
	public IOperationForward getOperationForward() {
		return otFor;
	}

	public void addResults(String key, Object obj) {
		results.put(key, obj);
	}

	public Map getResults() {
		return results;
	}

	public Map gettempvar() {
		return tempvar;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperationContext#getOperations()
	 */
	public Set getOperations() {
		return operationMap.getOperations();
	}

	/**
	 * <code>insDecMap</code> ���Ա����Ѿ���ɵ����ʵ��
	 */
	private HashMap insDecMap = new HashMap(3);

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.IOperationContext#getInstanceDeclare(java.
	 * lang.String)
	 */
	// public IInstanceDeclare getInstanceDeclare(String type,String varName)
	// throws OperationException {
	public IInstanceDeclare getInstanceDeclare(String type, String varName)
			throws OperationException {

		// ��ݱ����ȡ��IInstanceDeclare
		String strKey = varName;
		if (insDecMap.containsKey(strKey)) {
			return (IInstanceDeclare) insDecMap.get(strKey);
		}

		IExpression expr = findObjectExpression(type, varName);
		if (expr == null) {
			// throw new
			// OaOperationException("0001","��Сд���,����ǰ̨���Ĵ�Сд����");
			throw new OperationSystemException(
					ErrorCodeMaping.OA_EXPRESS_VAR_DIFFER, "�޷���������Ϊ"
							+ type + "��ݶ���:" + varName);
		}
		IInstanceDeclare instDec = getInstanceDeclare(expr);
		insDecMap.put(strKey, instDec);
		return instDec;
	}

	private IExpression findObjectExpression(String type, String varName) {
		IExpression expr = null;
		for (Iterator it = this.getInstanceDeclareMap().getObjects().iterator(); it
				.hasNext();) {
			IExpression exprMid = (IExpression) it.next();
			if (StringUtils.equalsIgnoreCase(exprMid.getNames()[2], varName)) {
				expr = exprMid;
				break;
			}
		}
		return expr;
	}

	public IInstanceDeclare getInstanceDeclare(IExpression expression)
			throws OperationException {
		IInstanceDeclareWrapper insdWrapper = null;

		String strKey = (String) instanceDeclareWrappers.get(expression
				.getNames()[0]);
		Object obj = ObjectUtils.createObjectInstanse(strKey,
				this.getApplicationContext());
		if (obj != null && obj instanceof IInstanceDeclareWrapper) {
			insdWrapper = (IInstanceDeclareWrapper) obj;
		} else {

			throw new OperationSystemException(ErrorCodes.WrapperClassNotFound,
					"Unknow the opreation type:" + expression.getNames()[0]
							+ ",please check the opration,as dm|wf!");
		}
		IInstanceDeclare ins = insdWrapper.wrap(expression, this);
		return ins;
	}

	public Iterator getInstanceProperties(String type, String varName) {
		return intDeclare.get(type, varName).iterator();
	}

	public Iterator getOperationProperties(String type, String operation,
			String varName) {
		return operationMap.get(type, operation, varName).iterator();
	}

	public IPOAliasMappingManager getPOAliasMappingManager() {
		return aliasPOMappingManager;
	}

	private List sysErrors = new ArrayList(3);

	private List oprationErrors = new ArrayList(3);

	public boolean isSystemError() {
		return sysErrors.size() > 0;
	}

	public boolean isOperationError() {
		return oprationErrors.size() > 0;
	}

	public List getOprationErrors() {
		return oprationErrors;
	}

	// �Ǽ�ҵ���ϵĴ���
	public void registerOprationErrors(Object error) {
		oprationErrors.add(error.toString());
	}

	public void registerSystemError(Object error) {
		sysErrors.add(error.toString());
	}

	public List getSystemErrors() {
		return sysErrors;
	}

	public void registerOperationError(IExpression expression) {
		log.error("language op:" + expression.getName());
		oprationErrors.add(expression.getName());
	}

	public void registerOperationError(String error) {
		log.error("language op:" + error);
		oprationErrors.add(error.toString());
	}

	public Iterator getOperationExecuteIterator() throws OperationException {
		return this.operationMap.getOperationExecuteIterator();
	}

	public void addOperationDepends(String dependSrc, String[] dependTags) {
		this.operationMap.addOperationDepends(dependSrc, dependTags);

	}

	public boolean checkToken() {

		if (token != null) {

			if (StringUtils.trimToNull(token.getOperationType()) != null
					&& StringUtils.trimToNull(token.getName()) != null) {

				if (StringUtils.equalsIgnoreCase(token.getOperationType(),
						Token.GET)) {
					token.setValue(System.currentTimeMillis() + "");

					ActionContext.getContext().getSession()
							.put(Token.SESSION_KEY + token.getName(), token);
					this.addResults("OT.Token.Result", token.getValue());
				}

				else if (StringUtils.equalsIgnoreCase(token.getOperationType(),
						Token.APPLY)) {

					if (!ActionContext.getContext().getSession()
							.containsKey(Token.SESSION_KEY + token.getName())) {
						this.registerOperationError("language op error: token="
								+ token.getName());
						this.addResults("OT.Token.Error", "token error");
						return false;
					}

					Token oldToken = (Token) ActionContext.getContext()
							.getSession()
							.get(Token.SESSION_KEY + token.getName());
					if (!token.equals(oldToken)) {
						this.registerOperationError("language op error: token="
								+ token.getName());
						this.addResults("OT.Token.Error",
								"language op error: token=");
						return false;
					}

					ActionContext.getContext().getSession()
							.remove(Token.SESSION_KEY + token.getName());
				}
			}
		}
		return true;
	}

	private Token token;

	public void addTokenOperaion(IExpression expr) {
		if (expr.isToken()) {
			if (token == null) {
				token = new Token();
			}
			if (StringUtils.equalsIgnoreCase(expr.getNames()[2],
					Token.TOKEN_NAME)) {
				token.setName(StringUtils.trimToEmpty(expr.getValues()[0]));
			} else if (StringUtils.equalsIgnoreCase(expr.getNames()[2],
					Token.TOKEN_OPERATIONTYPE)) {
				token.setOperationType(StringUtils.trimToEmpty(expr.getValues()[0]));
			} else if (StringUtils.equalsIgnoreCase(expr.getNames()[2],
					Token.TOKEN_VALUE)) {
				token.setValue(StringUtils.trimToEmpty(expr.getValues()[0]));
			}
		}
	}

	public ApplicationContext getApplicationContext() {
		return appContext;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperationContext#getSession()
	 */
	public Map getSession() {
		if (session == null) {
			IOperationSessionManager sysSes = (IOperationSessionManager) this.appContext
					.getBean("operationSessionManager");
			session = sysSes.getSession();
		}
		return session;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperationContext#getCookies()
	 */
	public Map getCookies() {
		if (cookies == null) {
			ICookieManager cookieManager = (ICookieManager) this.appContext
					.getBean("cookieManager");
			cookies = cookieManager.getCookies();
		}
		return cookies;
	}

	public void putValue2Instance(String instanceKey, String value) {
		String[] names = StringUtils.split(instanceKey, ".");
		String[] expvalue = { value };

		// IExpression expr;
		Expression expr = new Expression();
		expr.setNames(names);
		expr.setValues(expvalue);

		// String exp = "DM";
		String str = names[0].trim() + ".Object." + names[2].trim();
		getInstanceDeclareMap().getRelationList(str).add(expr);
		// getInstanceDeclareMap().put(expr);

	}
}
