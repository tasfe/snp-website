package com.snp.site.config;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

public class UrlConfig {
	public HashMap urlmap = new HashMap();

	public HashMap getUrlmap() {
		return urlmap;
	}

	public void setUrlmap(HashMap urlmap) {
		this.urlmap = urlmap;
	}

	public static void main(String[] args) throws FileNotFoundException {
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(
				new FileOutputStream("UrlConfig.xml")));
		UrlConfig urlConfig = new UrlConfig();
		urlConfig.urlmap.put("snp", "www.snpsoft.net");
		urlConfig.urlmap.put("jos", "www.chinajos.cn");

		e.writeObject(urlConfig);
		e.close();

	}

}
