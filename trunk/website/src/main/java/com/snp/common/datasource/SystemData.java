package com.snp.common.datasource;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;

public class SystemData {
	private static Log log = LogFactory.getLog(SystemData.class);
	public static DataBaseConfig SystemDbObject;

	static public DataBaseConfig getDbObjectByDbConfFileName() {
		DataBaseConfig systemDbObject = null;
		if (SystemDbObject != null)
			return SystemDbObject; // 因为此方法被两个BEAN调用过。所以临时文件消失后就出错了
		XMLDecoder xmlDecoder;
		try {

			xmlDecoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(SystemInit.getDatabaseCongfile())));
			systemDbObject = (DataBaseConfig) xmlDecoder.readObject();
			xmlDecoder.close();
			SystemDbObject = systemDbObject;
			// log.debug("数据库配置文件"+SystemInit.getDatabaseCongfile());
		} catch (Exception e) {
			log.error("加载数据源错误", e);
		}
		return systemDbObject;
	}

	/**
	 * 修改数据库连接后，调用这个方法 通过业务类来构造新的数据库对象，然后再次些入
	 */
	static public void updateDbObject(DataBaseConfig systemDbObject)
			throws FileNotFoundException, IOException {
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(
				new FileOutputStream(SystemInit.getDatabaseCongfile())));
		e.writeObject(systemDbObject);
		e.close();
		log.debug("数据库对象生成完毕,保存路径" + SystemInit.getDatabaseCongfile());

	}
}
