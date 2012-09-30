/*

 *
 */
package com.sunrise.sup.dm;

import java.io.File;

import com.sunrise.sup.core.common.error.OperationException;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IUploadFile {
	public String getFileContentType();

	public void setFileContentType(String fileContentType);

	public long getFileLength();

	public void setFileLength(long fileLength);

	public String getSaveName();

	public void setSaveName(String saveName);

	public String getFileName();

	public void setFileName(String fileName);

	public String getUploadFileName();

	public void setUploadFileName(String uploadFileName);

	public String getSaveFolder();

	public void setSaveFolder(String saveFolder);

	public void saveFile(File file) throws OperationException;

	public String getFilepath();

	public void setFilepath(String filepath);

	public String getRename();

	public void setRename(String rename);

	public String getSize();

	public void setSize(String size);

	public String getSubdir();

	public void setSubdir(String subdir);

	public String getDocroot();

	public void setDocroot(String docroot);

	public String getTimeprefix();

	public void setTimeprefix(String timeprefix);

	public String getHeight();

	public void setHeight(String height);

	public String getWidth();

	public void setWidth(String width);

}