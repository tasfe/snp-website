/*
 * �������� 2005-2-28
 *
 */
package com.sunrise.sup.core.common.dao.hibernate;

import java.io.File;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public interface IContainFile {
	public String[] getFileName();

	public void setFile(String fileName, File[] fiels,
			String[] fileContentType, String[] fileNames);
}
