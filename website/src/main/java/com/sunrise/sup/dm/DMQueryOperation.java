/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.CursorableLinkedList;
import org.apache.commons.lang.StringUtils;
import org.hibernate.type.Type;

import com.snp.common.DebugUtil;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.ErrorCodeMaping;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.common.util.Pagination;
import com.sunrise.sup.core.impl.OperationUtils;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.OperationConstants;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DMQueryOperation extends DMCURDOperation {
	String queryObj = null;

	private Properties sqlResource;

	public DMQueryOperation(IExpression expression, IOperationContext context,
			Properties resource) {
		super(expression, context);
		queryObj = expression.getNames()[2].trim();
		sqlResource = resource;
	}

	private Map querySQLMap = new HashMap();

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperation#execute()
	 */
	public void execute() throws OperationException {

		AdvanceDAO dao = getAdvanceDAO();
		List resultList = null;
		QueryParam queryParam = dealQueryParam();

		StringBuffer sqlBuf = new StringBuffer();
		// tow type :results and sql define in sup-SQLResources.properties.
		if (StringUtils.equalsIgnoreCase(queryParam.queryType,
				DataOperationConstants.QUERY_TYPE_RESULTS)) {
			Class objClas = getInstanceDeclare().getObjectClass();
			// 1.query fields
			sqlBuf.append(getQueryFieldsSQL(queryParam) + " from "
					+ objClas.getName() + " " + queryObj + " ");

			// 2.condition
			QuerySQL querySQL = dealQueryCond(queryParam);

			if (querySQL != null && querySQL.sql.length() > 0
					&& StringUtils.trimToNull(querySQL.sql.toString()) != null) {
				sqlBuf.append(" where " + querySQL.sql);
			}
			// 3.order
			sqlBuf.append(getOrderSQL(queryParam));

			// 4.Group
			sqlBuf.append(getGroupSQL(queryParam));
			log.debug("Sup:query HQL=" + sqlBuf);
			List paramsLs = new ArrayList();
			List typesLs = new ArrayList();
			IDataMHibernate dmH = (IDataMHibernate) context
					.getApplicationContext().getBean("dataMHibernate");
			// 5.continue deal qurey condition
			try {
				if (querySQL != null) {
					dmH.dealQueryParams(objClas, querySQL.params,
							queryParam.trueFields, paramsLs, typesLs,
							getInstanceDeclare());
				}
				// ������û�в�����޷�ִ��
				if (paramsLs.size() > 0) {
					Object[] objs = new Object[paramsLs.size()];
					Type[] types = new Type[paramsLs.size()];
					paramsLs.toArray(objs);
					typesLs.toArray(types);
					resultList = dao.find(sqlBuf.toString(), objs, types,
							queryParam.pagination);
				} else {
					resultList = dao.find(sqlBuf.toString(),
							queryParam.pagination);
				}
			} catch (Exception e) {
				log.debug("query error", e);
				throw new OperationException("0000", "Sup:Query Error!", e);
			}

		} else if (StringUtils.equalsIgnoreCase(queryParam.queryType,
				DataOperationConstants.QUERY_TYPE_SQL)
				&& queryParam.querySQL != null) {
			// ִ��SQL���
			String qrSQL = sqlResource.getProperty(queryParam.querySQL);
			try {
				resultList = dao.find(qrSQL, queryParam.pagination);
			} catch (Exception e) {
				OperationException opEx = new OperationException(
						"0000",
						"sup:Runsql Error!Please check sql define in the sup-SQLResources.properties.",
						e);
				log.error(e);
				throw opEx;
			}

		} else {
			throw new OperationSystemException(
					ErrorCodeMaping.OA_FRONT_RULE_ERROR,
					expression.getName()
							+ "����ĺ�̨�ı�sql���Ʋ�ѯ���ͣ�����ȱ�������ѯ��Ĳ����ѯ�ֺ�̨�����ѯ����ͨ��ѯ:"
							+ queryParam.queryType + "SQl���:"
							+ queryParam.querySQL + "����ȷ"
							+ DebugUtil.getQryString(context.getParameters()));
		}
		// ��Ҫ��ҳ�ĵط��ŷ���,������Ҫ�ó��з�ҳҪ�ŷ���,����ȡ����һ�β�ѯ�����������Ҫ���ϱ�
		// �����
		context.addResults("LastQueryPara", context.getParameters());
		// ����ķ����������ˣ���Ϊ��ѯ��ҳ����Ҫ�õ����url
		// context.addResults("QueryUrl", getQueryUrl(context.getParameters()));
		context.addResults(expression.getNames()[2], resultList);
		context.addResults(getResultKey(), resultList);
		context.addResults(getResultInfoKey(),
				OperationConstants.OPERATION_SUCCESS);
		context.addResults(getResultPaginationKey(), queryParam.pagination);
		this.setExecuted(true);
	}

	protected String getQueryUrl(Map map) {
		// HashMap uniquemap=new HashMap(map);
		// DebugUtil.printpara1(uniquemap);
		// uniquemap.entrySet().iterator()
		String QueryUrl = "";
		for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
			Map.Entry e = (Map.Entry) i.next();
			String[] value = (String[]) e.getValue();
			if (StringUtils.contains((String) e.getKey(), "Pagination")
					|| StringUtils.contains(value[0], "\n")) {
				continue;
			}
			// if(e.getKey().)
			for (int j = 0; j < 1; j++) {
				QueryUrl = QueryUrl + e.getKey() + "="
						+ StringUtils.replace(value[j], "%", "%25") + "&";
			}

		}

		log.debug("��ѯ���ַ�" + QueryUrl);
		return QueryUrl;
	}

	protected String getResultPaginationKey() {
		return expression.getNames()[0] + "." + expression.getNames()[1] + "."
				+ expression.getNames()[2] + ".Pagination";
	}

	private String getQueryFieldsSQL(QueryParam queryParam) {
		StringBuffer strBuffer = new StringBuffer();
		if (queryParam.fields != null && queryParam.fields.length > 0) {
			for (int i = 0; i < queryParam.fields.length; i++) {
				String odd = StringUtils.trimToNull(queryParam.fields[i]);
				if (odd != null) {
					if (strBuffer.length() > 0) {
						strBuffer.append(",");
					}
					strBuffer.append(" " + queryObj + "." + odd);
				}
			}
		}
		if (strBuffer.length() > 0) {
			return "select " + strBuffer.toString();
		}
		return "";
	}

	private String getOrderSQL(QueryParam queryParam) {
		StringBuffer strBuffer = new StringBuffer();
		if (queryParam.orders != null && queryParam.orders.length > 0) {
			for (int i = 0; i < queryParam.orders.length; i++) {
				String[] odd = StringUtils.split(
						StringUtils.trimToEmpty(queryParam.orders[i]), " ");
				if (odd != null && odd.length > 0) {
					if (strBuffer.length() > 0) {
						strBuffer.append(",");
					}
					strBuffer.append(" " + queryObj + "." + odd[0]);
					if (odd.length == 0) {
						strBuffer.append(" " + DataOperationConstants.DESC);
					} else {
						strBuffer.append(" " + odd[odd.length - 1]);
					}
				}
			}
		}
		if (strBuffer.length() > 0) {
			return " order by " + strBuffer.toString();
		}
		return "";
	}

	private String getGroupSQL(QueryParam queryParam) {
		StringBuffer strBuffer = new StringBuffer();
		if (queryParam.groups != null && queryParam.groups.length > 0) {
			for (int i = 0; i < queryParam.groups.length; i++) {
				String odd = StringUtils.trimToNull(queryParam.groups[i]);
				if (odd != null) {
					if (strBuffer.length() > 0) {
						strBuffer.append(",");
					}
					strBuffer.append(" " + queryObj + "." + odd);
				}
			}
		}
		if (strBuffer.length() > 0) {
			return " group by " + strBuffer.toString();
		}
		return "";
	}

	/**
	 * �����ѯ���
	 * 
	 * @param queryParam
	 * @return
	 * @throws OperationException
	 */
	private QuerySQL dealQueryCond(QueryParam queryParam)
			throws OperationException {
		// Set varSets = new HashSet();
		// Map filedsMap = new HashMap();
		// ��ݲ�ѯ�Ĺ�j�������õ���ѯSQL
		QuerySQL endQuerySQL = null;
		if (queryParam.masterQueryRelation != null) {
			List midList = new ArrayList();
			// �Թ�j�����ѭ������
			for (int iCount = 0; iCount < queryParam.masterQueryRelation.fields.length; iCount++) {
				String queryFiled = queryParam.masterQueryRelation.fields[iCount];
				// ���ǵݹ鴦��
				// ����j����е��ֶζ�Ӧ������һ���j����� ��ô��ѯ�Ǹ��j���
				// ��Ϊ��������Ļ�������relations���ˣ�������������ֵģ���˵���ǲ����������
				if (queryParam.relations.containsKey(queryFiled)) {
					QuerySQL querySQL = dealQueryCond(queryFiled, queryParam,
							new ArrayList());
					if (querySQL != null) {
						midList.add(querySQL);
					}

					// ����j����е��ֶζ�Ӧ��һ���ֶΣ���ô��ɲ�ѯ���
				} else if (getInstanceDeclare().getPropertie(queryFiled) != null) {
					QuerySQL querySQL = dealFiledCond(queryParam, queryFiled);
					if (querySQL != null) {
						midList.add(querySQL);
					}
				}
			}

			endQuerySQL = combQuerySQL(midList,
					queryParam.masterQueryRelation.relation);
		}

		return endQuerySQL;
	}

	private QuerySQL dealQueryCond(String pFiled, QueryParam queryParam,
			List keyList) throws OperationException {
		if (querySQLMap.containsKey(pFiled)) {
			return (QuerySQL) querySQLMap.get(pFiled);
		}
		if (keyList.contains(pFiled)) {
			return null;
		}
		keyList.add(pFiled);
		QueryRelation queryRelation = (QueryRelation) queryParam.relations
				.get(pFiled);

		List midList = new ArrayList();
		// �������˵ݹ�
		if (queryRelation.fields != null && queryRelation.fields.length > 0) {
			for (int i = 0; i < queryRelation.fields.length; i++) {
				String queryFiled = queryRelation.fields[i];
				if (queryParam.relations.containsKey(queryFiled)) {
					QuerySQL querySQL = dealQueryCond(queryFiled, queryParam,
							keyList);
					if (querySQL != null) {
						midList.add(querySQL);
					}
				} else if (getInstanceDeclare().getPropertie(queryFiled) != null) {
					QuerySQL querySQL = dealFiledCond(queryParam, queryFiled);
					if (querySQL != null) {
						midList.add(querySQL);
					}
				}
			}
		}
		QuerySQL querySQL = combQuerySQL(midList, queryRelation.relation);
		if (querySQL != null) {
			querySQLMap.put(pFiled, querySQL);
		}
		return querySQL;
	}

	private QuerySQL combQuerySQL(List ls, String cond) {
		if (ls == null || ls.size() < 1) {
			return null;
		}
		Iterator it = ls.iterator();
		QuerySQL qrSQL = new QuerySQL();
		for (; it.hasNext();) {
			QuerySQL nxSQL = (QuerySQL) it.next();
			qrSQL = combQuerySQL(qrSQL, nxSQL, cond);
		}
		if (ls.size() != 1) {
			StringBuffer strBuf = new StringBuffer();
			strBuf.append(" (");
			strBuf.append(qrSQL.sql);
			strBuf.append(") ");
			qrSQL.sql = strBuf;
		}
		return qrSQL;

	}

	private QuerySQL combQuerySQL(QuerySQL qr1, QuerySQL qr2, String cond) {
		if (qr1.sql.length() > 0) {
			qr1.sql.append(" " + cond + " " + qr2.sql);
		} else {
			qr1.sql.append(qr2.sql.toString());
		}
		for (Iterator it = qr2.params.iterator(); it.hasNext();) {
			qr1.params.addLast(it.next());
		}
		return qr1;
	}

	private QuerySQL dealFiledCond(QueryParam queryParam, String queryFiledOR) {
		if (querySQLMap.containsKey(queryFiledOR)) {
			return (QuerySQL) querySQLMap.get(queryFiledOR);
		}

		String cond = null;
		QuerySQL querySQL = new QuerySQL();
		if (queryParam.conditions.containsKey(queryFiledOR)) {
			cond = (String) queryParam.conditions.get(queryFiledOR);
		} else {
			cond = DataOperationConstants.EQUAL;
		}
		String queryFiled = queryFiledOR.trim();
		if (queryFiledOR.trim().endsWith("]")) {
			queryFiled = queryFiledOR.trim().substring(0,
					queryFiledOR.trim().indexOf("["));
		}
		// <--����ǵ��ڲ����� null��ϵ������Ҫ�жϲ������͵� add by lingli 20060607
		if (!(StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.EQUAL_NULL) || StringUtils
				.equalsIgnoreCase(cond, DataOperationConstants.NOT_EQUAL_NULL))) {
			queryParam.trueFields.put(queryFiledOR, queryFiled);
			querySQL.params.addLast(queryFiledOR);
		}
		// ����һ�����from ProjectTask p where p.projectId=41 and p.projectTask
		// is null
		// EQUAL_NULL NOT_EQUAL
		if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.EQUAL_NULL)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " is null) ");

		}
		if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.NOT_EQUAL_NULL)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " is not null) ");

		}
		// ����ǵ��ڲ�����null��ϵ������Ҫ�жϲ������͵� add by lingli 20060607-->
		if (StringUtils.equalsIgnoreCase(cond, DataOperationConstants.EQUAL)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim() + "="
					+ "?) ");
		} else if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.CONTAIN)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " like " + "?) ");
		} else if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.LESS_THAN)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " < " + "?) ");
		} else if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.LESS_THAN_EQUAL)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " <= " + "?) ");
		} else if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.MORE_THAN)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " > " + "?) ");
		} else if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.MORE_THAN_EQUAL)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " >= " + "?) ");
		} else if (StringUtils.equalsIgnoreCase(cond,
				DataOperationConstants.NOT_EQUAL)) {
			querySQL.sql.append(" (" + queryObj + "." + queryFiled.trim()
					+ " <> " + "?) ");
		}
		if (querySQL.sql.length() < 1) {
			return null;
		}
		querySQLMap.put(queryFiledOR, querySQL);
		return querySQL;
	}

	private QueryParam dealQueryParam() {

		return new QueryParam(context);

	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.IOperation#getName()
	 */
	public String getName() {
		return expression.getName();
	}

	private class QueryParam {

		public String queryType;

		public String querySQL;

		public Pagination pagination = new Pagination(true);

		public String[] orders;

		public String[] groups;

		public String[] fields;

		public Map trueFields = new HashMap();

		public Map relations;

		public Map params;

		public Map fieldsTypes;

		public QueryRelation masterQueryRelation;

		public Map conditions;

		public Map datas = null;

		public QueryParam(IOperationContext context) {
			initParams();
		}

		private void initParams() {

			conditions = new HashMap(3);
			relations = new HashMap(3);
			int varCount = 0;

			Iterator it = context.getOperationProperties(
					expression.getNames()[0], expression.getNames()[1],
					expression.getNames()[2]);
			for (; it.hasNext();) {
				IExpression expr = (IExpression) it.next();
				String[] keys = expr.getPropertieNames();

				if (keys == null || keys.length < 1 || expr.getValues() == null
						|| expr.getValues().length < 1) {
					continue;
				}

				if (StringUtils.equalsIgnoreCase(keys[0], "Type")) {
					queryType = expr.getValues()[0];
				} else if (StringUtils.equalsIgnoreCase(keys[0], "SQL")) {
					// �õ���Ҫִ�е�SQL���
					querySQL = expr.getValues()[0];
				} else if (keys.length > 1
						&& StringUtils.equalsIgnoreCase(keys[0], "Cond")) {
					String condKey = OperationUtils.getKey(keys, 1);// cond�����ֵ
					if (condKey != null) {
						for (int i = 0; i < expr.getValues().length; i++) {
							// &DM.Query.DemoItem.Cond.CONTAIN=filename
							// key�Ǳ���,ֵ������ı�
							conditions.put(expr.getValues()[i], condKey);

						}
					}
				} else if (keys.length > 1
						&& StringUtils.equalsIgnoreCase(keys[0], "Relation")) {
					/*
					 * ��ӶԹ�ϵ�Ĵ������ DM.Query.DemoItem.Relation.and=filename,
					 * ��j��������.
					 * DM.Query.relation.req1.OR.a=prop1,prop2,prop3
					 */
					String relationKey = OperationUtils.getKey(keys, 1);
					QueryRelation queryR = new QueryRelation();
					queryR.relation = keys[1];
					// ���������
					if (keys.length > 2
							&& StringUtils.trimToNull(keys[2]) != null) {
						queryR.varName = keys[2]; // ��j��������.�����
													// varname��de
					} else {
						// ���ϵ��ѯ��ϵ
						queryR.varName = "varName" + varCount++;
						masterQueryRelation = queryR;
					}
					if (relationKey != null) {
						String[] values = StringUtils.split(
								expr.getValues()[0], ",");
						queryR.fields = values; // ��ϵָ�����ֶΣ�age[0],age[1]
						relations.put(queryR.varName, queryR); // key��de,
					}
				} else if (StringUtils.equalsIgnoreCase(keys[0], "Order")) {
					orders = StringUtils.split(expr.getValues()[0], ",");
				} else if (StringUtils.equalsIgnoreCase(keys[0], "Group")) {
					groups = StringUtils.split(expr.getValues()[0], ",");
				} else if (keys.length > 1
						&& StringUtils.equalsIgnoreCase(keys[0], "Pagination")) {
					// TO DO��ӷ�ҳ����
					if (StringUtils.equalsIgnoreCase(keys[1], "CurrentPage")) {
						pagination.setCurrentPage(Long.parseLong(expr
								.getValues()[0]));
					} else if (StringUtils.equalsIgnoreCase(keys[1], "Size")) {
						pagination
								.setMaxSize(Integer.parseInt(expr.getValues()[0]));
					}
				} else if (StringUtils.equalsIgnoreCase(keys[0], "Field")) {
					fields = StringUtils.split(expr.getValues()[0], ",");
				} else if (StringUtils.equalsIgnoreCase(keys[0], "FieldType")) {
					if (keys.length > 2) {
						String fldTypeKey = keys[1];
						if (fldTypeKey != null) {
							for (int i = 0; i < expr.getValues().length; i++) {
								fieldsTypes
										.put(expr.getValues()[i], fldTypeKey);
							}
						}
					}
				}
			}
		}

		public String getQueryType() {
			if (StringUtils.equalsIgnoreCase(queryType,
					DataOperationConstants.QUERY_TYPE_RESULTS)
					|| StringUtils.equalsIgnoreCase(queryType,
							DataOperationConstants.QUERY_TYPE_STAT)) {
				return queryType;
			}
			return DataOperationConstants.QUERY_TYPE_RESULTS;
		}

		public void setQueryType(String queryType) {
			this.queryType = queryType;
		}

	}

	private class QueryRelation {
		public final static String OR = "or";

		public final static String AND = "and";

		public String relation = AND;

		public String varName;

		public String[] fields;
	}

	private class QuerySQL {

		public StringBuffer sql = new StringBuffer();

		public CursorableLinkedList params = new CursorableLinkedList();

	}

}
