/*
 * �������� 2004-12-28
 *
 */
package com.sunrise.sup.core.inf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;

import com.sunrise.sup.core.common.error.OperationException;

/**
 * ��Opration�������������,���ڷ��ò�����Ϣ�ͻش�����
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IOperationContext {
	public static final String OperationContext = "_Current_Operation_Context";

	/**
	 * �õ���ǰ�����û���Ӧ��Cookie
	 * 
	 * @return session
	 */
	public Map getCookies();

	/**
	 * �õ���ǰ�����û���Ӧ��Session
	 * 
	 * @return session
	 */
	public Map getSession();

	/**
	 * �õ���ǰ����ʹ�õ�Spring ApplicationContext
	 * 
	 * @return
	 */
	public ApplicationContext getApplicationContext();

	/**
	 * �õ����е�ϵͳ����������
	 * 
	 * @return
	 */
	public Map getParameters();

	/**
	 * �õ��ض�������Ĳ��� ���� DM.Object.req1 type=DM varName=req1 ���ص�������
	 * DM.Instance.req1....
	 * 
	 * @return
	 */
	public Iterator getInstanceProperties(String type, String varName);

	/**
	 * �õ���������Ҫ�Ĳ��� ���� DM.Query.req1 ��req1���в�ѯ ���ص�
	 * DM.Query.req1.type �ȵ�
	 * 
	 * @return
	 */
	public Iterator getOperationProperties(String type, String operation,
			String varName);

	/**
	 * �õ�ϵͳ��ǰ���еĲ������
	 * 
	 * @return
	 */
	public Set getOperations();

	/**
	 * ��ݱ���Ƶõ�������
	 * 
	 * @param varName
	 * @return
	 * @throws OperationException
	 */
	public IInstanceDeclare getInstanceDeclare(String type, String varName)
			throws OperationException;

	/**
	 * ��ݱ���Ƶõ�������
	 * 
	 * @param varName
	 * @return
	 * @throws OperationException
	 */
	public IInstanceDeclare getInstanceDeclare(IExpression expression)
			throws OperationException;

	/**
	 * �Ƿ��в������
	 */
	public boolean isOperationError();

	/**
	 * ����������ҵ����� ��Ҫע��
	 */
	public void registerOperationError(IExpression expression);

	/**
	 * ����������ҵ����� ��Ҫע��
	 */
	public void registerOperationError(String error);

	/**
	 * �Ƿ���ϵͳ����
	 */
	public boolean isSystemError();

	/**
	 * ע��ϵͳ����
	 */
	public void registerSystemError(Object error);

	/**
	 * �������е�ϵͳ����
	 */
	public List getSystemErrors();

	/**
	 * �������е�ҵ�����
	 */
	public List getOprationErrors();

	/**
	 * ���ղ����ִ��˳��õ����еĲ���
	 */
	public Iterator getOperationExecuteIterator() throws OperationException;

	/**
	 * ��Ӳ���֮�����5��ϵ
	 * 
	 * @param dependSrc
	 *            ��5����
	 * @param dependTags
	 *            ����5����
	 */
	public void addOperationDepends(String dependSrc, String[] dependTags);

	/**
	 * ����ִ�еõ��Ľ��
	 * 
	 * @param key
	 * @param obj
	 */
	public Map getResults();

	/**
	 * ���ز���ʶ��ò���
	 */
	public Map gettempvar();

	/**
	 * ���һ��ؽ��
	 * 
	 * @param key
	 * @param obj
	 */
	public void addResults(String key, Object obj);

	/**
	 * �õ�����ת��·��
	 * 
	 * @return
	 */
	public IOperationForward getOperationForward();

	/**
	 * ��ǰ���������Ƿ���Ҫ������ƻ�
	 * 
	 * @return
	 */
	public boolean checkToken();

	/**
	 * lingli��ҵ�����п����Լ�������һ����������ֵ ���磺
	 * instanceKey=DM.Instance.MsprojectTemp.ttaskname
	 */
	public void putValue2Instance(String instanceKey, String vlaue);
}
