import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mortbay.http.HttpListener;
import org.mortbay.jetty.Server;

import com.snp.common.GetipAddress;

public class RunSnp {
	private static Log log = LogFactory.getLog(RunSnp.class);

	public static void main(String[] args) {
		try {
			File jettyFile = new File(".", "jettyconfig.xml");
			if (!jettyFile.exists()) {
				log.debug("jetty config does not exit");
			}
			log.debug("-------Start website and ftp-------");
			Server server;
			server = new Server(jettyFile.toString());
			HttpListener httpListener = (HttpListener) server.getListeners()[0];
			boolean flag_port_able = true;
			while (flag_port_able) {
				try {
					server.start();
					flag_port_able = false;
					GetipAddress.port = String.valueOf(httpListener.getPort());
					GetipAddress.openUrl(GetipAddress.getipurl()
							+ "/website/siteadmin");
				} catch (Exception e) {
					httpListener.setPort(httpListener.getPort() + 1);
				}
			}

			System.out.print("\n------启动完毕------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
