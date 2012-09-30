package com.snp.common;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.ServletActionContext;

/**
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class DebugUtil {

	private static Log log = LogFactory.getLog(DebugUtil.class);

	/**
	 * 得到http的请求参数信息add by lingli,http请求其实就是个MAP对象，里面是字符串数组
	 */

	//
	public static String getJunitParaString(Map map) {
		try {
			String junitPara = "";
			List l = new LinkedList();
			for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
				Map.Entry e = (Map.Entry) i.next();
				String key = (String) e.getKey();
				l.add(key);
			}
			Collections.sort(l);
			for (int i = 0; i < l.size(); i++) {
				if (map.get(l.get(i)).getClass().getName()
						.equals("[Ljava.io.File;"))
					continue;
				String[] value = (String[]) map.get(l.get(i));

				for (int j = 0; j < value.length; j++) {
					junitPara = junitPara
							+ "\n ParametersUtils.addParameter(params,\""
							+ l.get(i) + "\",\"" + value[j] + "\");";
				}
			}
			String temp = "HTTP junit PARAMETER:" + junitPara;
			return temp;
		} catch (Exception e) {
			return "前台参数类型错误,可能提交FORM里面带了文件登非字符串类型!";
		}
	}

	public static String getQryString(Map map) {
		try {
			String junitPara = "";
			List l = new LinkedList();

			for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
				Map.Entry e = (Map.Entry) i.next();
				String key = (String) e.getKey();
				l.add(key);
			}
			Collections.sort(l);
			for (int i = 0; i < l.size(); i++) {

				if (map.get(l.get(i)).getClass().getName()
						.equals("[Ljava.io.File;"))
					continue;
				String[] value = (String[]) map.get(l.get(i));

				for (int j = 0; j < value.length; j++) {
					junitPara = junitPara
							+ "\n                                           &"
							+ l.get(i) + "=" + value[j];
				}
			}
			String temp = "HTTP REQUEST PARAMETER:" + junitPara;

			return temp;
		} catch (Exception e) {
			return "前台参数类型错误,可能提交FORM里面带了文件登非字符串类型!";
		}
	}

	// 返回了请求的路径，远程地址和数据来源
	public static String getReqInfo() {
		try {
			HttpServletRequest requestServelt = ServletActionContext
					.getRequest();
			return " From：" + requestServelt.getRequestURL()
					+ requestServelt.getRemoteAddr();
		} catch (Exception e) {

			return "无法取得操作路径";
		}
	}

	public static void printmap(Map map) {
		try {

			log.debug("=====开始打印map对象============");
			for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
				Map.Entry e = (Map.Entry) i.next();
				log.debug(e.getKey() + "="
						+ printstrarr((String[]) e.getValue()));
			}

			log.debug("=====打印map对象结束============");
		} catch (Exception e) {
			log.debug("前台参数类型错误,可能提交FORM里面带了文件登非字符串类型!可以忽略此错误");

		}
	}

	public static String printstrarr(String[] strarr) {
		String str = "";
		for (int j = 0; j < strarr.length; j++) {
			str = str + strarr[j];
		}
		return str;
	}

}