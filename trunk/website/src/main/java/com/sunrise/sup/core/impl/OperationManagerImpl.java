package com.sunrise.sup.core.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections.CursorableLinkedList;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.NDC;
import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork.ActionContext;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.ObjectUtils;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IExpressionWrapper;
import com.sunrise.sup.core.inf.ILogFlagClass;
import com.sunrise.sup.core.inf.IOperation;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IOperationManager;
import com.sunrise.sup.core.inf.IOperationWrapper;
import com.sunrise.sup.core.inf.IPOAliasMappingManager;

import freemarker.ext.beans.BeansWrapper;

/**
 * 对IOperationManager的实现
 * 
 * @author 凌黎
 * @version v1.0.0
 */
public class OperationManagerImpl implements IOperationManager {

	private static Log log = LogFactory.getLog(OperationManagerImpl.class);

	/**
	 * <code>operationWrappers</code>: 所有对操作进行封装的类
	 */
	private Map operationWrappers;

	/**
	 * <code>instanceDeclareWrappers</code> ：所有变量声明的操作
	 */
	private Map instanceDeclareWrappers;

	/**
	 * <code>aliasPOMappingManager</code>: PO类和别名之间关系的定义
	 */
	private IPOAliasMappingManager aliasPOMappingManager;

	/**
	 * <code>defaultExpressionWrapper</code>: 默认的操作表达式封装类
	 */
	private IExpressionWrapper defaultExpressionWrapper;

	private ILogFlagClass logFlagClass;

	private OperationContext context = null;

	/**
	 * <code>expressionWrappers</code>: 所有对表达式进行封装的类
	 */
	private Map expressionWrappers;

	public OperationManagerImpl() {
	}

	public void init() {
	}

	/**
	 * @param props
	 * @return int
	 */
	public IOperationContext execute(Map props, ApplicationContext appContext) {
		long begintime = System.currentTimeMillis();
		String logMsgFlag = "";
		if (logFlagClass != null) {
			logMsgFlag = logFlagClass.getFlagId();
		} else {
			// logMsgFlag = ServletActionContext.getRequest().getRemoteAddr();
		}
		NDC.push(logMsgFlag);
		if (props == null || props.size() < 1) {
			log.debug("没有语法参数!");
			return null;
		}
		log.info("\n<------\nhttp请求接受，参数："
				+ com.snp.common.DebugUtil.getJunitParaString(props));
		OperationContext context = new OperationContext(props, appContext,
				instanceDeclareWrappers, aliasPOMappingManager);

		ActionContext.getContext().put(IOperationContext.OperationContext,
				context);

		try {
			expressionWrap(context, props);
		} catch (Exception e) {
			context.registerSystemError(e);
			log.error("参数封装错误，操作没有执行!");
			return context;
		}
		String operationLog = "";
		// 检查令牌环,如果不合理的点击,就忽略,不对前台报错
		if (context.checkToken()) {
			try {
				// 执行操作
				operationLog = executeOperation(context);
			} catch (OperationException e) {
				log.error("操作执行过程中错误，返回OperationWorkException异常");
				context.registerOprationErrors(e);
				// 如果抛出的异常是业务错误，
			} catch (Exception e) {
				log.error("操作执行过程中错误，返回Exception异常", e);
				context.registerSystemError(e);
			}
		}
		// 特殊回传结果: 系统时间
		context.addResults("System.Date", new Date());
		/*
		 * 下两种方式都是返回一个静态类，应该利用static更加合理， adoOperation
		 * 
		 * 利用static，可以方便开发人员随意指定实现业务类，自己实现 <#if
		 * results?exists&&results["static"]?exists> <#assign static =
		 * results["static"][" com.sunrise.wbmp.common .business.onebusiness"]>
		 * <#assign objects = static.getresult("para")> <#list objects as
		 * object> 打印出查出结果 ${object.id} </#list> </#if>
		 */

		context.addResults("static", BeansWrapper.getDefaultInstance()
				.getStaticModels());
		/*
		 * <#assign static =
		 * results["static"]["com.sunrise.wbmp.common.action.CommonDataHandle"]>
		 * <#assign date = static.getDate("2006-04-11",7)>
		 */
		log.warn("\nHttp请求结束" + (System.currentTimeMillis() - begintime)
				+ "毫秒{" + operationLog + "}\n------>");
		NDC.pop();
		NDC.remove();
		return context;
	}

	public String executeOperation(OperationContext context)
			throws OperationException, Exception {
		CursorableLinkedList operations = new CursorableLinkedList();
		// 按照执行顺序得到所有需要执行操作
		// 操作执行顺序由相互之间的依赖关系决定
		for (Iterator it = context.getOperationExecuteIterator(); it.hasNext();) {
			IExpression expr = (IExpression) it.next();
			String optKey = expr.getNames()[0] + "." + expr.getNames()[1];
			String opt = (String) operationWrappers.get(optKey);
			// 使用操作包装来对操作表达式进行包装得到IOperation的实例
			IOperationWrapper optWrapper = null;
			if (opt != null) {
				try {
					Object obj = ObjectUtils.createObjectInstanse(opt,
							context.getApplicationContext());
					if (obj instanceof IOperationWrapper) {
						optWrapper = (IOperationWrapper) obj;
					}
				} catch (Exception e) {
					throw new OperationException("0000",
							"SUP中间层语法定义错误，请检查语法定义的配置文件:" + optKey
									+ "找不到对应的操作声明类");
				}
			} else {
				throw new OperationException("0000",
						"SUP中间层语法定义错误，请检查语法定义的配置文件:" + optKey + "找不到对应的操作声明类");
			}
			// 创造出操作得实例比如：Create，Update
			IOperation operation = optWrapper.wrap(expr, context);
			operations.addLast(operation);
		}
		// 执行所有的操作
		String operationLog = "";
		for (Iterator it = operations.iterator(); it.hasNext();) {
			IOperation operation = (IOperation) it.next();
			// if (operation.isExecuted()) {
			// 判断是否执行,请参看OperationSupport的isExecuted实现
			long begintime = System.currentTimeMillis();
			if (operation.isExecuted()) {
				try {
					operation.execute();
				} catch (Exception e) {
					// 这里如果出了错，在日志中无法看出是哪个错误执行有问题，应该显示所有的action名字
					String uncompleteaction = "|*" + operation.getName();
					while (it.hasNext()) {
						operation = (IOperation) it.next();
						uncompleteaction = uncompleteaction
								+ operation.getName() + "|";
					}
					String message = "[已执行的操作]:" + operationLog
							+ "[未完成的操作:检查是否存在下面业务类]" + uncompleteaction;
					log.error(message, e);
					context.registerOperationError(message);
					throw e;

				}
			}
			operationLog = operationLog + operation.getName() + "="
					+ (System.currentTimeMillis() - begintime) + "毫秒";
			// }
		}

		return operationLog;
	}

	/*
	 * 解析操作表达式 @param props
	 */
	private void expressionWrap(OperationContext context, Map props)
			throws OperationException {
		// log.debug("根据表达式的类型不同,初始化OperationContext");

		for (Iterator it = props.keySet().iterator(); it.hasNext();) {
			String name = (String) it.next();
			if (props.get(name) instanceof Object[]) {
				Object[] objs = (Object[]) props.get(name);
				String[] names = StringUtils.split(name, ".");
				// names是key的值,如果小于2就会打印,默认语法每个属性的key都会有前缀.
				if (names.length < 2) {
					/*
					 * 未处理的的操作一般是自己定义得参数， 我们将这些参数传入一个map中，供下一个操作使用
					 */
					log.debug("非语法参数:" + "ActionName=" + name
							+ "|Put into context.tempvar|");
					// 这种直接在前台传入自定义得http请求操作参数得操作可以在这里直接返回
					context.gettempvar().put(name, objs[0]);
					continue;
				}

				/*
				 * expressionWrappers是map对象,key是:DM.Update,<value>spring:
				 * dataCRUDOperationWrapper</value> 这个声明指定了对应的操作对象的声明
				 * 配置文件中定义得expressionWrappers是空得， <property
				 * name="expressionWrappers"> <map/> 目的是为以后的扩充？那下面的exp 肯定是 null
				 * operationWrappers定义了各种操作，例如 <entry key="DM.Create">
				 * <value>spring:dataCRUDOperationWrapper</value> </entry>
				 */
				String exp = (String) expressionWrappers.get(names[0] + "."
						+ names[1]);
				// exp表示是dm.*wf.*
				IExpressionWrapper expWrapper = null;
				if (exp != null) {
					Object obj = ObjectUtils.createObjectInstanse(exp,
							context.getApplicationContext());
					// IExpressionWrapper分别是数据库和工作流操作的封装
					if (obj instanceof IExpressionWrapper) {
						expWrapper = (IExpressionWrapper) obj;
					}
				}
				/* 默认的封装类是通过spring的注入的 */
				if (expWrapper == null) {
					expWrapper = defaultExpressionWrapper;
				}
				// log.debug("PrasePara:"+"ActionName="+name+",Prasesclass("+expWrapper.getClass()+")
				// ");
				/*
				 * 操作表达式，不同得操作可以用不同得解析参数 log.debug("解析操作: 操作名称＝" + name + " 值＝"
				 * + objs.toString() + " 调用的解析类:" + expWrapper.getClass());
				 */
				// 表达式封装，参数是http参数名字和叔祖值
				IExpression[] exprs = expWrapper.wrap(name, (String[]) objs,
						context);
				/* 根据表达式的第二节判断是什么类型操作，然后放入context的map中保存 */
				expressionFilt(context, exprs);

			}
		}
		log.debug("解析参数完毕");
	}

	/**
	 * 对传入的操作表达式进行过滤 区分数据定义操作和数据处理操作
	 * 
	 * @param props
	 */
	private void expressionFilt(OperationContext context, IExpression[] exprs) {

		for (int i = 0; i < exprs.length; i++) {
			IExpression expr = exprs[i];
			// 处理数据声明表达式
			if (expr.isInstanceDeclareExpression()) {
				context.getInstanceDeclareMap().put(expr);
				continue;
			}
			// 处理转发表达式
			if (expr.isOperationForwardExpression()) {
				context.registerOperationForward(expr);
				continue;
			}
			// 处理Session
			if (expr.isSessionExpression()) {
				context.registerSession(expr);
				continue;
			}
			// 处理Cookie
			if (expr.isCookie()) {
				context.registerCookie(expr);
				continue;
			}

			// 处理令牌环表达式

			if (expr.isToken()) {
				context.addTokenOperaion(expr);
				continue;
			}

			if (!expr.isResultExpression()) {
				context.getOperationMap().put(expr);
				continue;
			}
			// log.debug("未分类的操作："+expr.toString());
		}

	}

	public Map getOperationWrappers() {
		return operationWrappers;
	}

	public void setOperationWrappers(Map operationWrappers) {
		this.operationWrappers = operationWrappers;
	}

	public Map getInstanceDeclareWrappers() {
		return instanceDeclareWrappers;
	}

	public void setInstanceDeclareWrappers(Map instanceDeclareWrapper) {
		this.instanceDeclareWrappers = instanceDeclareWrapper;
	}

	public IPOAliasMappingManager getAliasPOMappingManager() {
		return aliasPOMappingManager;
	}

	public void setAliasPOMappingManager(
			IPOAliasMappingManager aliasPOMappingManager) {
		this.aliasPOMappingManager = aliasPOMappingManager;
	}

	public Map getExpressionWrappers() {
		return expressionWrappers;
	}

	public void setExpressionWrappers(Map expressionWrappers) {
		this.expressionWrappers = expressionWrappers;
	}

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}

	public IExpressionWrapper getDefaultExpressionWrapper() {
		return defaultExpressionWrapper;
	}

	public void setDefaultExpressionWrapper(
			IExpressionWrapper defaultExpressionWrapper) {
		this.defaultExpressionWrapper = defaultExpressionWrapper;
	}

	public ILogFlagClass getLogFlagClass() {
		return logFlagClass;
	}

	public void setLogFlagClass(ILogFlagClass logFlagClass) {
		this.logFlagClass = logFlagClass;
	}

}