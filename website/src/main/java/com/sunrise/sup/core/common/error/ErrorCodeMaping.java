package com.sunrise.sup.core.common.error;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.sup.core.common.util.Properties;

public class ErrorCodeMaping implements java.io.Serializable {
	private static Properties errorMsg;
	private static Log log = LogFactory.getLog(ErrorCodeMaping.class);
	public static final String NO_ERROR = "0000";

	// �м���쳣 0001-2999
	public static final String OA_FRONT_VAR_SENSITIVITY = "0001";

	public static final String OA_EXPRESS_VAR_DIFFER = "0002";

	public static final String OA_EXPRESS_VAR_DEPENDERROR = "0003";

	public static final String OA_FRONT_RULE_ERROR = "0004";

	// shark���ʽӿ��쳣3000
	public static final String SK_UKOWN_ERROR = "3001";

	public static final String SK_SUCH_MODULE = "3002";

	// ����
	public static final String SK_CENSE_ERROR = "H001";

	public ErrorCodeMaping() {
	}

	protected static String getErrorMsg(String errorCode) {
		return errorMsg.getProperty(errorCode);
	}

	static {
		errorMsg = new Properties();
		try {
			errorMsg.load(new FileInputStream("sup-errormessage.txt"), "GB2312");
		} catch (IOException e) {

		}
	}

	public static void main(String[] args) {
		log.debug(ErrorCodeMaping.getErrorMsg("4001"));
		log.debug(ErrorCodeMaping.getErrorMsg("4003"));
	}
}
