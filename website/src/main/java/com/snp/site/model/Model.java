package com.snp.site.model;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import com.snp.site.init.SystemInit;

public abstract class Model {
	public boolean checkVideofile(String Filepath) {
		return new File(SystemInit.getSiteHome()
				+ StringUtils.substringBeforeLast(Filepath, ".") + ".flv")
				.exists();
	}

	public String get_video_path(String Filepath) {
		return StringUtils.substringBeforeLast(Filepath, ".");
	}

}
