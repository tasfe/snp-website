package com.snp.testcase.util.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

public class test163 {
	private static Log log = LogFactory.getLog(test163.class);

	public static void main(String[] args) throws MessagingException {
		/*
		 * new sendmail() 使用GBK的默认编码发送文本信息 new sendmail(编码,文本还是html);
		 */
		// sendmail mail = new sendmail("GBK", true);
		/*
		 * mail.connect (smtp服务器); main.connect(smtp服务器,用户名,密码); 适用于smtp认证的发信服务器
		 */
		// mail.connect(hostname); //如果不写明地址，是默认使用localhost的服务地址。
		// mail.connect("smtp.163.com", "sendmailbytemp", "sendmailbytemp1");
	
		/*
		 * main.send(from,to，cc,bcc,主题,正文,附件文件名) to,cc（抄送）,bcc(暗送)可填写多个mail地址
		 * 抄送多个的话是要使用，隔开 附件文件名为null，表示不发送附件 定义两个字段，emailleavword , emailorder
		 */
		sendmail sendmail = new sendmail();
		sendmail.connect("smtp.163.com", "snpmaster", "snpmaster100","25");
		sendmail.send(
						"snpmaster@163.com",
						"lingli@revenco.com",
						"",
						"",
						"from 163 用户发的",
						"test这是正文",
						null);
		sendmail.close();
		log.debug("发送完毕");

	}

}
