package com.snp.site.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.Action;
import com.snp.common.mail.SendMailThead;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteJob;
import com.snp.site.model.SiteLink;
import com.snp.site.model.SiteOrder;
import com.snp.site.model.SiteSpmp5Item;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationManager;

public class FileDownloadAction implements Action {
	private static Log log = LogFactory.getLog(FileDownloadAction.class);

	private String contentType, fileName;

	private Map parameters;

	private InputStream inputStream;

	public String getContentType() {
		return contentType;
	}

	private IOperationManager operationManager;

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public IOperationManager getOperationManager() {
		return operationManager;
	}

	public void setOperationManager(IOperationManager operationManager) {
		this.operationManager = operationManager;
	}

	public String filedown_lanmu() {
		try {
			String fileid = WebAppContextUtils.getpara("fileid");
			log.debug("文件id=" + fileid);
			AdvanceDAO advanceDao = (AdvanceDAO) WebAppContextUtils
					.getWebApplicationContext().getBean("advanceDAO");
			SiteSpmp5Item file = (SiteSpmp5Item) advanceDao.loadById(
					"SiteSpmp5Item", Long.valueOf(fileid));
			String filename = file.getFilename(); // 保存的中文名字，就可以实现中文名字下载了
			this.fileName = new String(filename.getBytes("gb2312"),
					"iso-8859-1");
			inputStream = new FileInputStream(SystemInit.getSiteHome()
					+ file.getSiteSpmp5().getSiteUser().getUsername() + "/"
					+ file.getFilepath());
			// log.debug( SystemInit.getSiteHome()+ file.getFilepath());
			setContentType("application/x-download");
			/**/
			String siteuserid = WebAppContextUtils.getpara("userid");
			java.lang.Object obj = ApplicationContextFactory.getWebAppContext()
					.getBean("SiteUser");
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			SiteUser siteuser = (SiteUser) adao.getObject(obj.getClass(),
					new Long(siteuserid));
			if (siteuser.getFileEmail() == null
					|| siteuser.getFileEmail().length() > 0) {
				HttpServletRequest requestServelt = ServletActionContext
						.getRequest();
				SendMailThead.sendmail(" [IP:" + requestServelt.getRemoteAddr()
						+ "] downing file:" + file.getFilename(),
						"snp system email notify ,please don't reply",
						siteuser.getFileEmail(), null);
			}
			return "filedown_lanmu";
		} catch (Exception e) {
			log.error("filedown_lanmu spmp5 error", e);
			return "error";
		}
	}

	public String filedown_linklanmu() {
		try {
			String fileid = WebAppContextUtils.getpara("fileid");

			AdvanceDAO advanceDao = (AdvanceDAO) WebAppContextUtils
					.getWebApplicationContext().getBean("advanceDAO");

			SiteLink file = (SiteLink) advanceDao.loadById("SiteLink",
					Long.valueOf(fileid));
			String filename = file.getFilename(); // 保存的中文名字，就可以实现中文名字下载了
			this.fileName = new String(filename.getBytes("gb2312"),
					"iso-8859-1");
			inputStream = new FileInputStream(SystemInit.getSiteHome()
					+ file.getFilenamedown());
			setContentType("application/x-download");
			return "filedown_lanmu";
		} catch (Exception e) {
			log.error("filedown_linklanmu error", e);
			return "error";
		}
	}

	public String filedown_joblanmu() {
		try {
			String fileid = WebAppContextUtils.getpara("fileid");
			log.debug("文件id=" + fileid);
			AdvanceDAO advanceDao = (AdvanceDAO) WebAppContextUtils
					.getWebApplicationContext().getBean("advanceDAO");

			SiteJob file = (SiteJob) advanceDao.loadById("SiteJob",
					Long.valueOf(fileid));
			String filename = file.getFilename(); // 保存的中文名字，就可以实现中文名字下载了
			this.fileName = new String(filename.getBytes("gb2312"),
					"iso-8859-1");
			inputStream = new FileInputStream(SystemInit.getSiteHome()
					+ file.getFilepath());
			setContentType("application/x-download");
			return "filedown_lanmu";
		} catch (Exception e) {
			log.error("文件打开错误", e);
			return "error";
		}
	}

	public String filedown_check() {
		try {
			String fileid = WebAppContextUtils.getpara("fileid");
			log.debug("文件id=" + fileid);

			AdvanceDAO advanceDao = (AdvanceDAO) WebAppContextUtils
					.getWebApplicationContext().getBean("advanceDAO");
			SiteOrder file = (SiteOrder) advanceDao.loadById("SiteOrder",
					Long.valueOf(fileid));
			String filename = file.getFilename(); // 保存的中文名字，就可以实现中文名字下载了
			this.fileName = new String(filename.getBytes("gb2312"),
					"iso-8859-1");
			inputStream = new FileInputStream(SystemInit.getSiteUserDocPath()
					+ file.getFilepath());
			setContentType("application/x-download");

			return "filedown_lanmu";
		} catch (Exception e) {
			log.error("filedown_check error", e);
			return "error";
		}
	}

	public String execute() throws Exception {

		return SUCCESS;

	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

}
