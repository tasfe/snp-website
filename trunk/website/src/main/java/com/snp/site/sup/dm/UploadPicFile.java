package com.snp.site.sup.dm;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.common.FileProcessor;
import com.snp.common.ImageProcessor;
import com.snp.site.init.SystemInit;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.dm.IUploadFile;

public class UploadPicFile implements IUploadFile {
	protected Log log = LogFactory.getLog(this.getClass());
	private String uploadFileName;
	private String fileName;
	private String smallFileName;
	private String saveName;
	private String saveFolder;
	public String filepath;
	private String docroot = "doc_root";
	private String size;
	private String subdir;
	private String rename;
	public String compress = "no";
	public String smallpic = "no";
	public String width = SystemInit.img_spmp4_width;
	public String height = SystemInit.img_spmp4_height;
	private String widthsamllpic = SystemInit.img_spmp4_sm_width;
	private String heightsamllpic = SystemInit.img_spmp4_sm_height;
	private long fileLength;
	private String fileContentType;
	private String op = ""; // 是否是批量上传

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
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

	/*
	 * 如果要压缩，必须是JPG或者GIF格式的,因为GIF的压缩会损坏图片动画格式， 所以如果图片不做处理算了
	 * 批量导入时，还是不要自动压缩，要根据图片大小来定，如果大于400K，就压缩如果单张传就按规则处理 批量导入规则是什么： 1.
	 * 如果文件小于400K，就不都用压缩了，高 ，宽是没有意义的 其它文件直接上传 只有是JPG和GIF格式才能压缩， 默认800：600，
	 * 但是按比例压缩， 高宽其实没有意义，因为我们显示的时候是真实图片的大小 2.当图片 改进，在SPMP4中，其实只有压缩时，才需要显示高和宽
	 */

	public void saveFile(File file) throws OperationException {
		try {
			if (subdir != null) {
				try {
					FileUtils.forceMkdir(new File(SystemInit.getSiteHome()
							+ subdir));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			String writeFilePath = SystemInit.getSiteHome() + subdir
					+ getFilepath(); // 图片的保存路径
			width = ImageProcessor.get_img_width(file);
			height = ImageProcessor.get_img_height(file);
			log.debug("width:" + width + "height:" + height);
			// 普通图片资源文件，不做处理了
			if (docroot.equals("resself")) {
				FileProcessor.checkFileExit(SystemInit.getRespath());
				writeFilePath = SystemInit.getRespath() + getFilepath(); // 图片的保存路径
			}
			log.debug("writeFilePath=" + writeFilePath);

			if (compress.equals("yes")
					&& (!getFilePostfix().equalsIgnoreCase("ico"))) {
				if (op.equals("bat") && file.length() < 400000)// 批量上传大于400k一定是要压缩的,
					FileUtils.copyFile(file, new File(writeFilePath));
				else
					try {
						ImageProcessor.compress_img(file, writeFilePath, true);
					} catch (Exception e) {
						FileUtils.copyFile(file, new File(writeFilePath)); // 如果不能压缩，也直接复制
					}
			} else {
				FileUtils.copyFile(file, new File(writeFilePath));
			}
			if (smallpic.equals("yes")) {
				String writeSmallFilePath = SystemInit.getSiteHome() + subdir
						+ getSmallFilepath();
				if (!getFilePostfix().equalsIgnoreCase("ico"))
					ImageProcessor.resize(file, writeSmallFilePath,
							Integer.parseInt(heightsamllpic),
							Integer.parseInt(widthsamllpic), true);
				else
					FileUtils.copyFile(file, new File(writeSmallFilePath));
			}

		} catch (Exception e) {
			OperationException opEx = new OperationSystemException(
					"saveFile eorror", e);
			throw opEx;
		}

	}

	public String getFilepath() {
		return filepath;
	}

	public String getSmallFilepath() {
		return smallFileName;
	}

	public void setFilepath(String filepath) {
		String newfilenamebytime = getNewFileNameByTime();
		this.filepath = newfilenamebytime;
		/*
		 * if (subdir != null) { try { FileUtils.forceMkdir(new
		 * File(SystemInit.getSiteHome() + subdir)); } catch (IOException e) {
		 * e.printStackTrace(); } String newfilenamebytime =
		 * getNewFileNameByTime(); this.filepath = subdir + newfilenamebytime;
		 * 
		 * }
		 */
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

	@Override
	public String getTimeprefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTimeprefix(String timeprefix) {
		// TODO Auto-generated method stub

	}

}
