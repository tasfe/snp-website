package test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.snp.site.init.SystemInit;


public class TestA {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String userhome = SystemInit.getSiteHome() +"11";
		FileUtils.copyDirectory(new File(userhome+ "/res"),new File(SystemInit.getWebroot() + "res"));

	}

}
