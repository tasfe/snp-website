package com.snp.testcase.module.newspublic;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Iterator;

import com.snp.testcase.common.EnvTest;

public class ReadFromhttpXml {
	public static NewsConfig getNewsConfigObject() {
		try {
			String newsconfigXmlPath = EnvTest.path_url_public + "zh_encoder.xml";
            log.debug(newsconfigXmlPath);
			XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(newsconfigXmlPath)));
			NewsConfig news_config = (NewsConfig) xmlDecoder.readObject();

			xmlDecoder.close();
			return news_config;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String args[]) {
		NewsConfig news_config = ReadFromhttpXml.getNewsConfigObject();
		log.debug(news_config.getNewsList());
		for (Iterator iterator = news_config.getNewsList().iterator(); iterator
				.hasNext();) {
			NewsObject newsobject = (NewsObject) iterator.next();
			log.debug(newsobject.getTitle());
			log.debug(newsobject.getUrl());

		}
	}
}
