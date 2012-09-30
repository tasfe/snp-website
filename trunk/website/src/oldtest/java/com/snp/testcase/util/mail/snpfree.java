package com.snp.testcase.util.mail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

public class snpfree {
	private static Log log = LogFactory.getLog(test163.class);

	public static void main(String[] args) throws MessagingException {
	
		sendmail sendmail = new sendmail();
		sendmail.connect("mail.snpsoft.net", "snpfree", "654321","25");
		sendmail.send(
						"snpfree@snpsoft.net",
						"lingli@revenco.com,snpsoft@qq.com",
						"",
						"",
						"from snpfree 用户发的11111111",
						"test这是正文",
						null);
		sendmail.close();
		log.debug("发送完毕");

	}

}
