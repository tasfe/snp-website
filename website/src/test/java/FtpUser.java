import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.impl.DefaultFtpServer;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.ConcurrentLoginPermission;
import org.apache.ftpserver.usermanager.impl.PropertiesUserManager;
import org.apache.ftpserver.usermanager.impl.TransferRatePermission;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**添加FTP和删除FTP用户都可以用户界面进行处理，参数需要手工设置
 * 
 * 缺点：用户属性文件是乱的
 * @author Administrator
 *
 */
public class FtpUser {
	private static Log log = LogFactory.getLog(FtpUser.class);

	public static void main(String[] args) {
		try {

			FtpServer ftpserver = null;
			String config = "conf/ftp/conf/ftpd-typical.xml";
			FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(config);
			String[] beanNames = ctx.getBeanNamesForType(FtpServer.class);
			ftpserver = (FtpServer) ctx.getBean(beanNames[0]);

			DefaultFtpServer serverFtp = (DefaultFtpServer) ftpserver;
			PropertiesUserManager propertiesUserManager = (PropertiesUserManager) serverFtp.getUserManager();

			UserManager um = serverFtp.getUserManager();
			BaseUser user = new BaseUser();
			user.setName("u1");
			user.setPassword("u1");
			user.setHomeDirectory("./conf/ftp/home");
			user.setEnabled(true);
			user.setMaxIdleTime(10);
			List<Authority> authorities = new ArrayList<Authority>();
			authorities.add(new WritePermission());
			int maxLogins = 0;
			int maxLoginsPerIp = 0;
			authorities.add(new ConcurrentLoginPermission(maxLogins, maxLoginsPerIp));
			int downloadRate = 0;//askForInt(in, "Maximum download rate (0 for no restriction)");
			int uploadRate = 0;// askForInt(in, "Maximum upload rate (0 for no restriction)");
			authorities.add(new TransferRatePermission(downloadRate, uploadRate));
			user.setAuthorities(authorities);
			um.save(user);

			//um.delete("u1");
			propertiesUserManager.refresh();
			System.out.print("\n------用户名test密码123------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
