package com.snp.testcase.module.downwebfile;

import junit.framework.TestCase;

public class SnpVersionTest extends TestCase {
	public void testAdd() {
		SystemInit.snp_version="10.1";
		String server_version="";
		try {
			 server_version=SnpVersion.get_str_serverversion();
		} catch (Exception e) {
	
			e.printStackTrace();
		}	 
			log.debug("server_version="+server_version);
			log.debug(SnpVersion.compile_version(server_version, SystemInit.snp_version));
		
		
		//log.debug(SnpVersion.get_server_version("snp"));;
	}
}
