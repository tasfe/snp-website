/*
 * �������� 2005-1-31
 *
 */
package com.sunrise.sup.core.common.error;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public final class ErrorCodes {

	private ErrorCodes() {
	}

	/**
	 * <code>WrapperClassNotFound</code> �޷��ҵ���Ӧ��Wrapper��
	 */
	public final static String WrapperClassNotFound = "WrapperClassNotFound";

	/**
	 * <code>OperationParameterError</code> ����Ĳ���������
	 */
	public final static String OperationParameterError = "OperationParameterError";

	/**
	 * <code>DMSQLError</code> ����ݲ����SQL������
	 */
	public final static String DMSQLError = "DMSQLError";

	/**
	 * <code>OperationDependsCycleError</code> ����֮�����5��ϵ����ѭ��
	 */
	public final static String OperationDependsCycleError = "OperationDependsCycleError";

	/**
	 * <code>WFNotDefineAppWorkflow</code> û��ΪӦ�ö����Ӧ�Ĺ�����
	 */
	public final static String WFNotDefineAppWorkflow = "WFNotDefineAppWorkflow";

	/**
	 * <code>ClassInstantError</code> �޷�ʵ��ָ������
	 */
	public final static String ClassInstantError = "ClassInstantError";

	/**
	 * <code>WorkFlowOperationError</code> ��������ж���Ĳ�����̴���
	 */
	public final static String OperationInWorkFlowDefineError = "OperationInWorkFlowDefineError";
}
