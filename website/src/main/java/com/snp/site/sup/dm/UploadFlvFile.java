package com.snp.site.sup.dm;

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

import com.snp.site.init.SystemInit;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.dm.IUploadFile;

public class UploadFlvFile implements IUploadFile {
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

			String writeFilePath = SystemInit.getSiteHome() + subdir
					+ getFilepath(); // 图片的保存路径
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

		} catch (Exception e) {

			throw new OperationException("upload_flv_file error", e);
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
			try {
				FileUtils
						.forceMkdir(new File(SystemInit.getSiteHome() + subdir));
			} catch (IOException e) {
				e.printStackTrace();
			}
			String newfilenamebytime = getNewFileNameByTime();
			this.filepath = newfilenamebytime;

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

/*
 * 
 * 
 * 
 * /* try { // 2.应该根据文件名判断是否转化成FLV的 String filename =
 * StringUtils.substringBefore(writeFilePath,"."); Runtime run =
 * Runtime.getRuntime(); Process process = null; process =
 * run.exec(VideoProcess.getConverntCmdStr( writeFilePath, filename+ ".flv",
 * 440, 280)); InputStream stderr = process.getErrorStream(); InputStreamReader
 * isr = new InputStreamReader(stderr); BufferedReader br = new
 * BufferedReader(isr); String line = null; // 如果是FLV结尾，就不要转化和删除 if
 * (!(getFilePostfix().equalsIgnoreCase("flv"))) { while ((line = br.readLine())
 * != null) log.debug(line); int exitVal = process.waitFor(); if (exitVal != 0)
 * { } else { process = run.exec(VideoProcess.get_video_gif(filename)); } }
 * 
 * process = null; process =
 * run.exec(VideoProcess.get_video_gif(writeFilePath));
 * 
 * } catch (Exception ioe) { // not windows log.error("后台传换错误", ioe); }
 * 
 * } catch (Exception e) { OperationException opEx = new
 * OperationSystemException( "upload flv File eorror", e); throw opEx; }
 */
