import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.impl.DefaultFtpServer;
import org.apache.ftpserver.usermanager.impl.PropertiesUserManager;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Ftp {
	public static void main(String args[]) {
		try {
			FtpServer server = null;
			String config = "conf/ftp/conf/ftpd-typical.xml";
			FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(config);
			String[] beanNames = ctx.getBeanNamesForType(FtpServer.class);
			server = (FtpServer) ctx.getBean(beanNames[0]);
			server.start();
			DefaultFtpServer serverFtp = (DefaultFtpServer) server;
			PropertiesUserManager propertiesUserManager = (PropertiesUserManager) serverFtp.getUserManager();
			System.out.println("加密方式：" + propertiesUserManager.getPasswordEncryptor());
			System.out.println("======ftp启动完毕=======");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}