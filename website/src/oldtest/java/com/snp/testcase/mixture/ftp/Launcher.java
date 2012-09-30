package com.snp.testcase.mixture.ftp;
import java.io.File;

import javax.management.ObjectName;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Launcher.
 *该成中文的
 * A simple class to start an FTP server as
 *  a standalone application.
 * When started, FTP server can be killed 
 * by killing the process it is running in,
 *  but doing
 * so will terminate the server immediately 
 * without calling its stop or poisoned routines.
 *
 *
 * ColoradoFTP - The Open Source FTP Server (http://cftp.coldcore.com)
 */
public class Launcher {
  



  public static void main(String[] args) {
	  
   
    String filename ="conf/ftp/beans.xml";
    File file = new File(filename);
  
    try {
      Resource resource = new FileSystemResource(file);
      ObjectFactory.setInternalFactory(new SpringFactory(resource));
    } catch (Throwable e) {
      log.debug("Cannot initialize object factory, terminating...");
      e.printStackTrace();
      System.exit(1);
    } 
        Core core = null;
    try {
      core = (Core) ObjectFactory.getObject(ObjectName.CORE);
      core.start();
    } catch (Throwable e) {
      log.debug("Unable to start the server, terminating...");
      e.printStackTrace();
      System.exit(1);
    }

  }


}
