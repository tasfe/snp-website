package com.snp.testcase.util;

/*
添加用户是APP客户端来做的，所以ADO是用文件拿出来的
每次我需要删除，所以表配置，我用UPDATE就可以了
 */
import java.io.File;

import junit.framework.TestCase;

import com.snp.testcase.common.EnvTest;


/*
 20090805 只能支持4种图片格式的转换JPG GIF， png,bmp，   ico不能压缩处理
 水印和
 */

public class ImageProcessorTest extends TestCase {

	public void test_import_pic(){
	    EnvTest.cleantemp();	
		String target_path="temp/";
	
		File[] filelist = SystemInit.get_pic_filelist(new File(EnvTest.path_img));
		if(filelist!=null&&filelist.length>0){
			for (int i = 0; i < filelist.length; i++) {
				log.debug("开始处理"+filelist[i].getName());
				ImageProcessor.resize(filelist[i], target_path+filelist[i].getName(), 75,100,  true);
	          }
		}
	}	
}
