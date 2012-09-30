package com.sunrise.sup.core.webwork.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IOperationManager;

public class OperationControlAction implements Action {
	// private static Log log = LogFactory.getLog(OperationControlAction.class);
	private IOperationManager operationManager;

	private Map results;

	private Map parameters;

	private Map sessions;

	private Map tempvar; // OperationManagerImpl���ж�

	// private List systemErrors;

	// private List oprationErrors;

	private IOperationContext operationContext;

	public Map getResults() {
		return results;
	}

	public void setResults(Map results) {
		this.results = results;
	}

	public Map getTempvar() {
		return tempvar;
	}

	public void setTempvar(Map tempvar) {
		this.tempvar = tempvar;
	}

	/**
	 * ����IOperationManager��execute�����õ�IOperationContext��ʵ��
	 * operationContext<br>
	 * ��operationContext�еõ�Sessions�����н��
	 * 
	 * @return java.lang.String
	 */
	public String execute() {

		parameters = ActionContext.getContext().getParameters();
		operationContext = operationManager.execute(parameters,
				WebAppContextUtils.getWebApplicationContext());
		sessions = getOperationContext().getSession();
		results = getOperationContext().getResults();
		tempvar = getOperationContext().gettempvar();
		return SUCCESS;
		// return NONE;
	}

	public IOperationManager getOperationManager() {
		return operationManager;
	}

	public void setOperationManager(IOperationManager operationManager) {
		this.operationManager = operationManager;
	}

	public IOperationContext getOperationContext() {
		return operationContext;
	}

	public Map getParameters() {
		return parameters;
	}

	public Map getSessions() {
		return sessions;
	}

	public List getSystemErrors() {
		return getOperationContext().getSystemErrors();
	}

	public List getOprationErrors() {
		return getOperationContext().getOprationErrors();
	}

}