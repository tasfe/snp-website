/*
 * �������� 2005-5-7
 *
 */
package com.snp.site.sup.dm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.snp.site.init.SystemInit;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.dm.IUploadFile;

/**
 * 其实UploadFile只是数据对象，都DMUploadOperation来进行调用操作的
 */
public class UploadFile implements IUploadFile {

	private static String ADD_TIME_PREIFEX = "yes";
	private static String RENAME_BY_ONLYTIME = "bytime";
	private String uploadFileName;
	private String fileName; // �ļ���
	private String saveName; //
	private String saveFolder; //

	private String filepath;
	private String docroot = "doc_root";
	private String size;
	private String subdir;
	private String timeprefix = ADD_TIME_PREIFEX; //
	private String rename; // �������������÷���

	private long fileLength;

	private String fileContentType;

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

	// �ļ������·��
	public String getSaveFolder() {

		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.sunrise.wbmp.operation.dm.IUploadFile#getSaveName()
	 */
	public String getSaveName() {
		if (StringUtils.trimToNull(saveName) == null) {
			saveName = new SimpleDateFormat("yyyyMMddHHmmss.SS")
					.format(new Date()) + "." + this.getFileName();
		}
		return saveName;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see
	 * com.sunrise.wbmp.operation.dm.IUploadFile#setSaveName(java.lang.String)
	 */
	public void setSaveName(String saveName) {
		this.saveName = saveName;

	}

	public String getFilepath() {

		return filepath;
	}

	public void setFilepath(String filepath) {
		if (subdir != null) {

			// FileProcessor.checkFileDir(SystemInit.getSiteHome(),subdir);
			try {
				FileUtils
						.forceMkdir(new File(SystemInit.getSiteHome() + subdir));
			} catch (IOException e) {

				e.printStackTrace();
			}
			if (rename == null) {
				this.filepath = subdir + getFileName();
				return;
			}
			if (rename.equals(RENAME_BY_ONLYTIME))
				this.filepath = subdir + getNewFileNameByTime();

		}

	}

	public void saveFile(File file) throws OperationException {

		try {
			String writeFilePath = SystemInit.getSiteHome() + getFilepath();
			FileInputStream filein = new FileInputStream(file);
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

		} catch (Exception e) {

			OperationException opEx = new OperationSystemException(
					"uploadfile error", e);
			throw opEx;
		}

	}

	public String getNewFileNameByTime() {
		String newfilename = (new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()) + "." + StringUtils.substringAfter(
				getFileName(), "."));
		// setFileName(newfilename);
		return newfilename;
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

	public String getHeight() {
		// Auto-generated method stub
		return null;
	}

	public void setHeight(String height) {
		// Auto-generated method stub

	}

	public String getWidth() {
		// Auto-generated method stub
		return null;
	}

	public void setWidth(String width) {
		// Auto-generated method stub

	}

}
