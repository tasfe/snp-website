package com.snp.testcase.util;
import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;

import com.snp.testcase.common.EnvTest;

public class VideoProsessTest extends TestCase {
	// rm格式是不支持的
	protected void setUp() throws Exception {
		super.setUp();
	    clean();
	}
	// 清理GIF和FLV文件
	public static void  clean() {
		File[] filelist = new File(EnvTest.path_video).listFiles();
		if (filelist != null && filelist.length > 0) {
			for (int i = 0; i < filelist.length; i++) {

				if (filelist[i].getName().endsWith("bat")
						|| filelist[i].getName().endsWith("svn"))
					continue;
				if (filelist[i].getName().endsWith(".gif")) {
					filelist[i].delete();
				}
				if (filelist[i].getName().endsWith(".flv")
						&& (!filelist[i].getName().equals("flv.flv")))
					filelist[i].delete();
			}
		}
		filelist = new File(EnvTest.path_video).listFiles();
	}

	public void test_video_convert() throws Exception {
		File[] filelist = new File(EnvTest.path_video).listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].getName().endsWith("bat")|| filelist[i].getName().endsWith("svn")) continue;
				VideoProcess.gen_video(filelist[i].getAbsolutePath(), StringUtils.substringBeforeLast(filelist[i].getAbsolutePath(), ".")
						+ ".flv",
						SystemInit.video_init_width, SystemInit.video_init_height);
				VideoProcess.gen_video_gif(filelist[i].getAbsolutePath());
		}
	}
}
