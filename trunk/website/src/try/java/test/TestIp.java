package test;

import com.snp.common.ipdata.IPSeeker;


public class TestIp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	log.debug(IPSeeker.getInstance().getAddress("69.249.69.164"));
	log.debug(IPSeeker.getInstance().getAddress("112.94.2.117"));
	
	log.debug(IPSeeker.getInstance().getAddress("203.169.195.15"));
		
	
	}

}
