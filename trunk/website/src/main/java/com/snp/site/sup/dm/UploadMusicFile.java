package com.snp.site.sup.dm;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.snp.site.config.LanmuConfig;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.dm.IUploadFile;

public class UploadMusicFile implements IUploadFile {
	protected Log log = LogFactory.getLog(this.getClass());
	private static String ADD_TIME_PREIFEX = "yes";
	private String uploadFileName;
	private String fileName;
	private String smallFileName;
	private String saveName;
	private String saveFolder;
	public String filepath;
	private String docroot = "doc_root";
	private String size;
	private String subdir;
	private String timeprefix = ADD_TIME_PREIFEX; //
	private String rename;
	public String compress = "no";
	public String smallpic = "no";
	public String width = "350";
	public String height = "250";
	private String widthsamllpic = "120";
	private String heightsamllpic = "150";
	private long fileLength;
	private String fileContentType;

	public void saveFile(File file) throws OperationException {
		try {

			String writeFilePath = SystemInit.getSiteHome() + getFilepath(); // 图片的保存路径
			String filename = StringUtils.substringBeforeLast(writeFilePath,
					".");
			FileInputStream filein = new FileInputStream(file);
			filein = new FileInputStream(file);
			File fileOut = new File(writeFilePath);
			FileOutputStream fileOutput = new FileOutputStream(fileOut);
			byte[] bytes = new byte[1024];
			int c = 0;
			while ((c = filein.read(bytes)) != -1) {
				fileOutput.write(bytes, 0, c);
			}
			fileOutput.flush();
			fileOutput.close();
			filein.close();
			;
			SiteUser siteuser = (SiteUser) ActionContext.getContext()
					.getSession().get(SystemInit.clientloginflag);
			String userLunmuXmlPath = SystemInit.getSiteHome()
					+ siteuser.getUsername() + "/"
					+ SystemInit.LanmuConfFileName;

			LanmuConfig lanmuObject = SystemInit
					.getLanmuObjectFromXml(userLunmuXmlPath);
			lanmuObject.setMusicfilename(filepath);
			ActionContext.getContext().getSession()
					.put("lanmuobject", lanmuObject);
			XMLEncoder e;
			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(
					userLunmuXmlPath)));
			e.writeObject(lanmuObject);
			e.close();

		} catch (Exception e) {

			throw new OperationException("upload_music_file error", e);
		}

	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public long getFileLength() {
		return fileLength;
	}

	public void setFileLength(long fileLength) {
		this.fileLength = fileLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSaveFolder() {

		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public String getSaveName() {
		if (StringUtils.trimToNull(saveName) == null) {
			saveName = new SimpleDateFormat("yyyyMMddHHmmss.SS")
					.format(new Date()) + "." + this.getFileName();
		}
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;

	}

	public String getFilepath() {
		return filepath;
	}

	public String getSmallFilepath() {
		return subdir + smallFileName;
	}

	public void setFilepath(String filepath) {
		if (subdir != null) {
			// FileProcessor.checkFileDir(SystemInit.getSiteHome(), subdir);
			try {
				FileUtils
						.forceMkdir(new File(SystemInit.getSiteHome() + subdir));
			} catch (IOException e) {

				e.printStackTrace();
			}
			String newfilenamebytime = getNewFileNameByTime();
			this.filepath = subdir + newfilenamebytime;

		}
	}

	public String getNewFileNameByTime() {

		String houzhui = StringUtils.substringAfterLast(getFileName(), ".");
		String newfilename = new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date());
		this.smallFileName = newfilename + "_sm." + houzhui;
		return newfilename + "." + houzhui;
	}

	public String getFilePostfix() {
		return StringUtils.substringAfterLast(getFileName(), ".");
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSubdir() {
		return subdir;
	}

	public void setSubdir(String subdir) {
		this.subdir = subdir;
	}

	public String getDocroot() {
		return docroot;
	}

	public void setDocroot(String docroot) {
		this.docroot = docroot;
	}

	public String getTimeprefix() {
		return timeprefix;
	}

	public void setTimeprefix(String timeprefix) {
		this.timeprefix = timeprefix;
	}

	public String getCompress() {
		return compress;
	}

	public void setCompress(String compress) {
		this.compress = compress;
	}

	public String getSmallpic() {
		return smallpic;
	}

	public void setSmallpic(String smallpic) {
		this.smallpic = smallpic;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeightsamllpic() {
		return heightsamllpic;
	}

	public void setHeightsamllpic(String heightsamllpic) {
		this.heightsamllpic = heightsamllpic;
	}

	public String getWidthsamllpic() {
		return widthsamllpic;
	}

	public void setWidthsamllpic(String widthsamllpic) {
		this.widthsamllpic = widthsamllpic;
	}

	public String getSmallFileName() {
		return smallFileName;
	}

	public void setSmallFileName(String smallFileName) {
		this.smallFileName = smallFileName;
	}

}
