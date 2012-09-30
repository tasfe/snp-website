/*
 * �������� 2005-1-3
 *
 */
package com.sunrise.sup.dm;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.inf.IExpression;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.OperationConstants;

/*
 * 
 */
public class DMUploadOperation extends DMCURDOperation {

	/**
	 * @param expression
	 * @param context
	 */
	public DMUploadOperation(IExpression expression, IOperationContext context) {
		super(expression, context);
	}

	public void execute() throws OperationException {

		DataInstanceDeclare insDec = this.getInstanceDeclare();
		Object obj = insDec.getObjectInstanceWithData(false);
		if (obj instanceof IUploadFile) {
			IUploadFile uploadFile = (IUploadFile) obj;
			saveFile(uploadFile);
		}
		context.addResults(expression.getNames()[2], obj);
		context.addResults(getResultKey(), obj);
		context.addResults(getResultInfoKey(),
				OperationConstants.OPERATION_SUCCESS);
		this.setExecuted(true);
	}

	protected void saveFile(IUploadFile uploadFile) throws OperationException {
		String uploadFileName = StringUtils.trimToNull(uploadFile
				.getUploadFileName());
		if (uploadFileName == null) {
			log.error("file location para error,please ");
			OperationException opEx = new OperationSystemException("0000",
					"DmUploadOperation save file error ");
			throw opEx;
		}
		// log.debug("文件名是"+uploadFileName);
		String key_type = uploadFileName + "ContentType";
		String key_filename = uploadFileName + "FileName";
		// log.debug("key_type="+key_type);
		// log.debug("key_filename="+key_filename);
		Object filesObj = context.getParameters().get(uploadFileName);
		Object fileTypeObj = context.getParameters().get(key_type);
		Object fileNameObj = context.getParameters().get(key_filename);

		if (!(filesObj != null && filesObj instanceof File[]
				&& ((File[]) filesObj).length > 0 && fileTypeObj != null
				&& fileTypeObj instanceof String[]
				&& ((String[]) fileTypeObj).length > 0 && fileNameObj != null
				&& fileNameObj instanceof String[] && ((String[]) fileNameObj).length > 0)) {

			OperationException opEx = new OperationSystemException("0000",
					"DmUploadOperation  file object error ");
			throw opEx;
		}

		/* 2.求得文件对象 */

		File[] files = (File[]) filesObj;
		String[] fileContentType = (String[]) fileTypeObj;
		String[] fileNames = (String[]) fileNameObj;
		uploadFile.setFileName(fileNames[0]); //
		uploadFile.setFileContentType(fileContentType[0]); //
		String saveFolder = StringUtils.trimToNull(uploadFile.getSaveFolder()); // 前台传来的保存的文件路径

		/*
		 * 3.正式调用保存
		 */
		uploadFile.setFilepath(saveFolder); // 这个是设置上传业务类真正的保存路径

		uploadFile.setSaveFolder(uploadFile.getFilepath());
		log.info("filepath=" + uploadFile.getFilepath());
		uploadFile.saveFile(files[0]);
		// context.addResults("file", uploadFile);
		// context.addResults("filename", uploadFile.getFileName());
		context.addResults("filepath", uploadFile.getFilepath()); // 资源图片文件上传后，会自动更新插入URL，需要这个FILEPATH

	}

	/*
	 */
	public String getName() {
		return expression.getName();
	}

}
