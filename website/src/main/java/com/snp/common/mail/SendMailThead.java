package com.snp.common.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.common.Dateprocess;
import com.snp.site.config.EmailObject;
import com.snp.site.init.SystemInit;

/*******************************************************************************
 * 发送的邮箱线程模块: 需要和静态初始化配合
 * 
 */
public class SendMailThead extends Thread {
	private static Log log = LogFactory.getLog(SendMailThead.class);
	String mailtitle;
	String mailcontent;
	String mailaddress;
	String[] filenames;

	public SendMailThead(String title, String content, String address,
			String[] filename) {
		try {
			mailtitle = "[Time]"
					+ Dateprocess.getTimeStr("yyyy-MM-dd-hh.mm.ss") + title;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		filenames = filename;
		mailaddress = address;
		mailcontent = content + "\n ****本邮件由SNP系统自动发出，请勿直接回复！****";
	}

	public void run() {
		long begin = System.currentTimeMillis();
		boolean notsendflag = true;
		int stmpNumber = 0;
		/* 如果没有出始化，出始化一次，如果修改了要重新， */

		while (notsendflag && stmpNumber < SystemInit.siteEmailconf.size()) {
			EmailObject emailObject = (EmailObject) SystemInit.siteEmailconf
					.get(stmpNumber);
			stmpNumber++;
			try {
				sendmail mail = new sendmail();
				mail.connect(emailObject.getSmtphost(),
						emailObject.getSmtphostusername(),
						emailObject.getSmtphostpassword(),
						emailObject.getPort());
				// 错误也是暗送了;如果是错误的话，不要有暗送
				log.info("THE SMTP=" + emailObject.getFormsender()
						+ emailObject.getPort() + emailObject.getSmtphost());
				mail.send(emailObject.getFormsender(), mailaddress, "",
						SystemInit.mail_ansong, mailtitle, mailcontent,
						filenames);

				mail.close();
				notsendflag = false;
				log.info("THE SMTP=" + emailObject.getFormsender());
				log.info("Email Send Time = "
						+ (System.currentTimeMillis() - begin));
			} catch (Exception e) {
				log.error("Email send error = " + emailObject.getTitle(), e);

			}
		}

	}

	// 标题，内容，地址
	public static void sendmail(String title, String content,
			String mailaddress, String[] filename) {

		SendMailThead sendmail = new SendMailThead(title, content, mailaddress,
				filename);
		sendmail.start();

	}
}
