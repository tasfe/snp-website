/*
 * 创建日期 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.util.OgnlValueStack;
import com.sunrise.sup.core.common.dao.hibernate.DAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.impl.InstanceDeclareSupport;
import com.sunrise.sup.core.impl.OperationContext;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IInstanceDeclare;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.OperationConstants;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class DataInstanceDeclare extends InstanceDeclareSupport {
	private Log log = LogFactory.getLog(this.getClass());

	private Object dataObject;

	/**
	 * @param expression
	 * @param context
	 */
	public DataInstanceDeclare(IExpression expression, IOperationContext context) {
		super(expression, context);
	}

	public Object getObjectInstance() throws OperationException {
		// 返回的是经过属性加载以后的对象值
		if (dataObject != null) {
			return dataObject;
		}
		Object obj = getObjectInstanceWithData(true);
		if (obj == null) {
			log.error("无法创建别名" + this.expression.getValues()[0] + "对应的PO类");
		}
		dataObject = obj;
		return obj;
	}

	public Class getObjectClass() throws OperationException {
		Object obj = null;
		obj = ((OperationContext) context).getPOAliasMappingManager()
				.createPOInstance(this.expression.getValues()[0],
						context.getApplicationContext());// ObjectUtils.createObjectInstanse();
		return obj.getClass();
	}

	/**
	 * 得到PO实例并填充数据
	 * 
	 * @param reload
	 * @return
	 */
	public Object getObjectInstanceWithData(boolean reload)
			throws OperationException {
		Object obj = null;
		if (reload) {
			obj = loadObject();
		}
		if (obj == null) {
			obj = ((OperationContext) context).getPOAliasMappingManager()
					.createPOInstance(this.expression.getValues()[0],
							context.getApplicationContext());// ObjectUtils.createObjectInstanse();
		}
		if (obj == null) {
			return null;
		}
		dataObject = obj;
		OgnlValueStack stack = new OgnlValueStack();
		stack.push(obj);

		Iterator it = context.getInstanceProperties("DM",
				expression.getNames()[2]);
		for (; it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			String key = getKey(expr);

			if (StringUtils.trimToNull(key) == null) {
				continue;
			}
			if (expr.getValues().length == 1 && !isCollection(obj, key)) {
				Object valueObj = dealProperties(key, stack,
						expr.getValues()[0]);
				stack.setValue(key, valueObj);

			} else if (expr.getValues().length > 0) {

				List ls = new ArrayList();
				for (int i = 0; i < expr.getValues().length; i++) {
					Object valueObj = dealProperties(key, stack,
							expr.getValues()[i]);
					if (valueObj != null) {
						ls.add(valueObj);
					}
				}

				Object[] objs = new Object[ls.size()];
				ls.toArray(objs);
				Object objP = stack.pop();
				Collection collect = checkCollection(objP, key);
				stack.push(objP);
				if (collect != null) {
					for (int i = 0; i < objs.length; i++) {
						collect.add(objs[i]);
					}
					stack.setValue(key, collect);
				} else {
					stack.setValue(key, objs);

				}
			}
		}
		// if(obj instanceof IContainFile){
		// setFile((IContainFile)obj);
		// }

		// 查看是否需要验证
		/*
		 * lingli20090728日注释了 因为升级WEBWORK2 IExpression validationExpr =
		 * checkValidationExpression(); if(validationExpr!=null){ String
		 * vadContext= null; if(validationExpr.getValues()!=null &&
		 * validationExpr.getValues().length>0 ){ vadContext =
		 * StringUtils.trimToNull(validationExpr.getValues()[0]); }
		 * ValidationResult vaResult = new ValidationResult(null); try {
		 * ValidatorContext validatorContext = new
		 * DelegatingValidatorContext(vaResult);
		 * ActionValidatorManager.validate(obj, vadContext, validatorContext); }
		 * catch (ValidationException e) { throw new
		 * OperationSystemException("ValidatorManagerError",e); } Map map =
		 * vaResult.getFieldErrors(); if(map!=null && !map.isEmpty()){
		 * context.addResults(getValidationResult(),map); throw new
		 * OperationException
		 * ("ValidationError","变量"+expression.getNames()[2]+"字段验证报错"); }
		 * 
		 * }
		 */
		return obj;
	}

	private String getValidationResult() {
		return this.expression.getName() + "."
				+ OperationConstants.OPERATION_VALIDATION + ".Result";
	}

	private boolean isCollection(Object obj, String key)
			throws OperationException {
		Method mth = null;
		try {
			mth = obj.getClass().getMethod("get" + getFUpperCase(key),
					new Class[0]);
			// mth = obj.getClass().getMethod("get"+key,new Class[0]);

			Class cls = mth.getReturnType();
			if (cls != null && Collection.class.isAssignableFrom(cls)) {
				return true;
			}
		} catch (Exception e) {
			log.error("if the the key is belong to object", e);
			throw new OperationException(
					"0000",
					"the object's get way is not fit the key,please check the key of object of rule of front.",
					e);
		}
		return false;
	}

	private Collection checkCollection(Object obj, String key) {
		try {
			Method mth = obj.getClass().getMethod("get" + getFUpperCase(key),
					new Class[0]);
			Class cls = mth.getReturnType();
			if (cls != null && Collection.class.isAssignableFrom(cls)) {

				Object connObj = mth.invoke(obj, new Object[0]);
				if (connObj != null) {
					((Collection) connObj).clear();
					return (Collection) connObj;
				}
				if (cls == Set.class) {
					return new HashSet();
				} else if (cls == List.class) {
					return new ArrayList();
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	private void setCollection(Object obj, String key) {
		try {
			Method mth = obj.getClass().getMethod("set" + getFUpperCase(key),
					new Class[0]);

		} catch (Exception e) {
		}
	}

	private String getFUpperCase(String key) {
		String keyMidd = key.substring(0, 1);
		keyMidd = keyMidd.toUpperCase() + key.substring(1);
		return keyMidd;
	}

	protected Object dealProperties(String key, OgnlValueStack stack,
			String value) throws OperationException {
		/* 参数的值是否带@{}得到里面的值 */
		String refVar = getRefVar(value);
		Object obj = null;
		if (refVar == null) {
			// 后面的值对象不是引用的参考变量
			obj = value;
			// stack.setValue(key, value);
		} else {
			// 后面的值对象是 引用的参数变量, 其定义为@{obj}, @{spring:obj}, @{cookie:obj}
			String[] vars = StringUtils.split(refVar, ":");
			if (vars.length == 1) {
				// 默认关联到对象是一个属性变量
				obj = dealPropertiesObject(refVar, stack, value);
			}// Object如果是等于一个对象
			else if (vars.length == 2
					&& StringUtils.equalsIgnoreCase(
							OperationConstants.OPERATION_OBJECT_KEY, vars[0])) {
				// 默认为,关联到对象
				obj = dealPropertiesObject(vars[1], stack, value);
			} else if (vars[0].equalsIgnoreCase("Timestamp")) {
				// @{Timestamp:2004-08-04 12:03:01}refVar=Timestamp:2004-08-04
				// 12:03:01
				String strdate = refVar.substring(10);
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				// String strdate = "2004-08-04 12:03:01";
				try {
					Date date = df.parse(strdate);

					return date;
				} catch (ParseException e) {
					log.error("Timestamp convernt error", e);
					throw new OperationException(
							"0000",
							"the Timestamp para errror!Plase check the date para!",
							e);
				}
			} else {
				// 关联到系统数据
				obj = functionDataManager.getFunctionData(vars[0], vars[1],
						this.context);
			}
		}
		return obj;
	}

	/*
	 * protected Object dealPropertiesCookie(String refVar)throws
	 * OperationException { Object obj =null;
	 * if(context.getCookies().containsKey(refVar)){ obj =
	 * context.getCookies().get(refVar); } return obj; } protected Object
	 * dealPropertiesSession(String refVar)throws OperationException { Object
	 * obj =null; if(context.getSession().containsKey(refVar)){ obj =
	 * context.getSession().get(refVar); } return obj; }
	 */
	protected Object dealPropertiesObject(String refVar, OgnlValueStack stack,
			String value) throws OperationException {
		Object obj = null;
		String[] refVars = StringUtils.split(refVar, ".");
		IInstanceDeclare dataInsDec = null;
		try {
			dataInsDec = (IInstanceDeclare) context.getInstanceDeclare("DM",
					refVars[0]);
		} catch (OperationException e) {
			context.registerSystemError(e);
			return null;
		}
		// 得到引用的变量
		Object refObj = dataInsDec.getObjectInstance();

		if (refVars.length == 1) {
			obj = refObj;
			// stack.setValue(key, refObj);
		} else {
			String refVarKey = getRefVarKey(refVars);

			stack.push(refObj);
			obj = stack.findValue(refVarKey);
			stack.pop();
			// stack.setValue(key, obj);
		}
		return obj;
	}

	protected Object loadObject() throws OperationException {
		DAO dao = (DAO) this.context.getApplicationContext().getBean("dao");
		Object sObj = ((OperationContext) context).getPOAliasMappingManager()
				.createPOInstance(this.expression.getValues()[0],
						context.getApplicationContext());
		long id = findID();
		if (id < 1) {
			return sObj;
		}
		Object obj = dao.getObject(sObj.getClass(), new Long(id));

		return obj;
	}

	protected long findID() {
		Iterator it = context.getInstanceProperties("DM",
				expression.getNames()[2]);
		long id = 0;
		for (; it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			if (expr.getNames().length > 3
					&& StringUtils.equalsIgnoreCase(expr.getNames()[3], "id")) {
				// 20060426 lingli:这里没有考虑如果这个ID也可能时替换的可能性
				id = Long
						.parseLong(StringUtils.trimToEmpty(expr.getValues()[0]));
			}
		}
		return id;
	}

	private IExpression checkValidationExpression() {
		Iterator it = context.getInstanceProperties("DM",
				expression.getNames()[2]);
		for (; it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			if (expr.getNames().length > 3
					&& StringUtils.equalsIgnoreCase(expr.getNames()[3],
							DataOperationConstants.OBJECT_VALIDATION)) {
				return expr;
			}
		}
		return null;
	}

	public String getPropertie(String key) {
		if (datas == null) {
			initDatas();
		}
		return (String) datas.get(key);
	}

	private Map datas = null;

	private void initDatas() {
		datas = new HashMap(4);
		for (Iterator it = getProperties(); it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			String key = getKey(expr);
			if (StringUtils.trimToNull(key) == null
					&& expr.getValues().length < 1
					&& expr.getValues()[0] == null) {
				continue;
			}
			datas.put(key, expr.getValues()[0]);
		}
	}
}