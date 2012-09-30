/*
 * 创建日期 2005-1-5
 *
 */
package com.sunrise.sup.core.webwork.result;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.dispatcher.WebWorkResultSupport;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.ObjectFactory;
import com.opensymphony.xwork.Result;
import com.opensymphony.xwork.config.ConfigurationManager;
import com.opensymphony.xwork.config.entities.ResultConfig;
import com.opensymphony.xwork.config.entities.ResultTypeConfig;
import com.sunrise.sup.core.impl.OperationForwardURL;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IOperationForward;
import com.sunrise.sup.core.webwork.action.OperationControlAction;

/**
 * 制定一的WebWork结果处理类型
 * 
 * @author Jerry Tang
 * @version v1.0.0
 */
public class OperationResult extends WebWorkResultSupport {
	private Log log = LogFactory.getLog(this.getClass());
	private OperationForwardURL defaultOperationForwardURL;
	private OperationForwardURL InfoOperationForwardURL;

	public OperationResult() {
		defaultOperationForwardURL = new OperationForwardURL();
		defaultOperationForwardURL.setForwardType("freemarker");
		// 发布sup得时候一定要带上systemerrors.ftl
		defaultOperationForwardURL
				.setForwardURL("website/error/systemerrors.ftl");

	}

	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		// 这里的结果类型写死了要从这个操作里面得到结果，所以不好扩充链条的功能
		if (invocation.getAction() instanceof OperationControlAction) {
			OperationControlAction opCA = (OperationControlAction) invocation
					.getAction();
			OperationForwardURL otFw = getOperationForwardURL(opCA
					.getOperationContext()); // url和类型
			ResultTypeConfig resultTypeConfig = findResultTypeConfig(otFw
					.getForwardType());
			ResultConfig resultConfig = new ResultConfig(otFw.getForwardName(),
					resultTypeConfig.getClazz(), otFw.getParams());

			Result result = createResult(resultConfig);
			try {
				result.execute(invocation);
			} catch (Exception e) {
				log.error("可能缺乏参数OT.Forward.success.URL", e);
				throw e;
			}
		} else {
			/*
			 * lingli扩充：也有可能是一个action链条，但是页面已经不是OperationControlAction
			 * 通过一个默认的页面来处理也可以啊，如果没有异常就好，有异常就打印出来就是了,（本来可以取出页面的跳转参数的，只是无法判断异常）
			 * OperationForwardURL otFw = InfoOperationForwardURL;
			 * ResultTypeConfig resultTypeConfig =
			 * findResultTypeConfig(otFw.getForwardType()); ResultConfig
			 * resultConfig = new
			 * ResultConfig(otFw.getForwardName(),resultTypeConfig
			 * .getClazz(),otFw.getParams()); Result result =
			 * createResult(resultConfig) ; result.execute(invocation);
			 */
		}

	}

	public ResultTypeConfig findResultTypeConfig(String type) throws Exception {
		ResultTypeConfig resultTypeConfig = null;
		for (Iterator it = ConfigurationManager.getConfiguration()
				.getPackageConfigNames().iterator(); it.hasNext();) {
			/*
			 * 一共可以支持这么多种类型 {
			 * httpheader=com.opensymphony.xwork.config.entities.ResultTypeConfig
			 * @4a485bd1,
			 * dispatcher=com.opensymphony.xwork.config.entities.ResultTypeConfig
			 * @d1d04385, （jsp页面）
			 * chain=com.opensymphony.xwork.config.entities.ResultTypeConfig
			 * @a39a5cce,
			 * velocity=com.opensymphony.xwork.config.entities.ResultTypeConfig
			 * @699d02dd,
			 * freemarker=com.opensymphony.xwork.config.entities.ResultTypeConfig
			 * @dd55e05c,
			 * jasper=com.opensymphony.xwork.config.entities.ResultTypeConfig
			 * @2074f142,
			 * operationResult=com.opensymphony.xwork.config.entities.
			 * ResultTypeConfig@74fbeca1,
			 * xslt=com.opensymphony.xwork.config.entities
			 * .ResultTypeConfig@6ce3408,
			 * stream=com.opensymphony.xwork.config.entities
			 * .ResultTypeConfig@fbe7e512,
			 * redirect=com.opensymphony.xwork.config
			 * .entities.ResultTypeConfig@c40fa44a}
			 */
			if (ConfigurationManager.getConfiguration()
					.getPackageConfig((String) it.next())
					.getAllResultTypeConfigs().containsKey(type)) {
				resultTypeConfig = (ResultTypeConfig) ConfigurationManager
						.getConfiguration()
						.getPackageConfig((String) it.next())
						.getAllResultTypeConfigs().get(type);
				break;
			}
		}
		if (resultTypeConfig == null) {
			throw new Exception("不能发现对应的结果处理类型" + type);
		}
		return resultTypeConfig;
	}

	/* */
	public Result createResult(ResultConfig resultConfig) throws Exception {
		Result newResult = null;
		if (resultConfig != null) {
			try {
				newResult = ObjectFactory.getObjectFactory().buildResult(
						resultConfig);
				// Map extraContext = new HashMap();
				// newResult
				// =ObjectFactory.getObjectFactory().buildResult(resultConfig,
				// extraContext);
			} catch (Exception e) {
				log.error(
						"There was an exception while instantiating the result of type "
								+ resultConfig.getClassName(), e);
				throw e;
			}
		}

		return newResult;
	}

	/*
	 * 异常有两种一种是业务上的，一种是操作上的，操作上的异常应该增加操作上的异常处理 （也就是业务异常）. 操作异常是一定需要指定错误返回的页面的。
	 */
	protected OperationForwardURL getOperationForwardURL(
			IOperationContext context) {
		OperationForwardURL otFw = null;
		// 1.一种是系统错误,sup封装的错误都是系统错误.
		if (context.isSystemError()) {

			for (Iterator it = context.getSystemErrors().iterator(); it
					.hasNext();) {
				Object obj = it.next();
			}
			otFw = context.getOperationForward().getOperationForward(
					IOperationForward.SYSTEMERROR);
			if (otFw == null) {
				/*
				 * 通常如果是空的话就使用默认的，这个操作转向就是本结果中构造函数初始化的 指向:sup/systemerrors.ftl
				 */
				otFw = defaultOperationForwardURL;
			}
			otFw.setForwardName(IOperationForward.SYSTEMERROR);
			return otFw;
		}
		/*
		 * 2.一种是业务错误， 在action实现类中捕捉了业务异常,如果是业务异常就会通过OT.Forward.error.URL指定页面跳转.
		 * 通常业务异常是在业务类中抛出,sup的操作都数以系统异常. catch (OperationWorkException e) {
		 * log.error("业务上的异常，通过OT.Forward.error.URL跳到指定页面");
		 * context.registerOprationErrors(e); //如果抛出的异常是业务错误， }
		 */
		if (context.isOperationError()) {
			otFw = context.getOperationForward().getOperationForward(
					IOperationForward.ERROR);
			if (otFw == null) {
				// 通常如果是空的话就使用默认的，
				otFw = defaultOperationForwardURL;
			}
			otFw.setForwardName(IOperationForward.ERROR);
			return otFw;
		}
		otFw = context.getOperationForward().getOperationForward(
				IOperationForward.SUCCESS);
		otFw.setForwardName(IOperationForward.SUCCESS);

		if (otFw == null) {
			otFw = defaultOperationForwardURL;
			otFw.setForwardName(IOperationForward.SYSTEMERROR);
		}

		return otFw;
	}

	public OperationForwardURL getDefaultOperationForwardURL() {
		return defaultOperationForwardURL;
	}

	public void setDefaultOperationForwardURL(
			OperationForwardURL defaultOperationForwardURL) {
		this.defaultOperationForwardURL = defaultOperationForwardURL;
	}
}
