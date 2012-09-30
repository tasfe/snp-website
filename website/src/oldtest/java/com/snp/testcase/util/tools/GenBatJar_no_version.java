package com.snp.testcase.util.tools;
import java.io.File;

import org.apache.commons.lang.StringUtils;
public class GenBatJar_no_version {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File filepath=new File("c:/lib");
		File[] filelist=filepath.listFiles();
		String id="";
		String version="";
		 String cmd_install="";
		 String str_depend="";
		for (int i = 0; i < filelist.length; i++) {
			//log.debug(filename[i]);
		     id=StringUtils.substringBeforeLast(filelist[i].getName(), ".jar");
		     version="1.0";
		    // log.debug(id+":"+version);
		     cmd_install="mvn install:install-file -DgroupId=snpsoft   -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true"
		    	 +" -DartifactId="+id
		    	 +" -Dversion="+version
		    	 +" -Dfile="+filelist[i].getAbsolutePath()+" ";
		     log.debug(cmd_install);	
		     str_depend=str_depend+"<dependency><groupId>"+"snpsoft"+"</groupId><artifactId>"+id+"</artifactId><version>"+version+"</version></dependency>\n";
		}
		log.debug("文件的个数"+filelist.length);
		log.debug("配置文件\n"+str_depend);
		
		
		//FileUtils.
	}

}
