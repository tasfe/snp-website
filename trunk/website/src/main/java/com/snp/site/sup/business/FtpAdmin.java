/*
ChangeRank.java * Created on 2005-8-10
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.snp.site.sup.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.ConcurrentLoginPermission;
import org.apache.ftpserver.usermanager.impl.TransferRatePermission;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import com.snp.site.init.SystemInit;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.util.WebAppContextUtils;
import com.sunrise.sup.core.inf.IOperationContext;
import com.sunrise.sup.core.inf.IbusinessAction;

/*求得所有的用户列表，然后放入SYSTEMINIT，然后重新生成配置文件*/
public class FtpAdmin implements IbusinessAction {
	private static Log log = LogFactory.getLog(DownSitedata.class);

	public void excute(IOperationContext context) throws OperationException {
		try {
			String flag = WebAppContextUtils.getpara("flag");
			String username = WebAppContextUtils.getpara("username");
			System.out.println(SystemInit.serverFtp.getUserManager());
			if (flag.equals("open")) {
				BaseUser user = new BaseUser();
				user.setName(username);
				user.setPassword(username);
				user.setHomeDirectory("./webroot/site/" + username);
				user.setEnabled(true);
				user.setMaxIdleTime(10);
				List<Authority> authorities = new ArrayList<Authority>();
				authorities.add(new WritePermission());
				int maxLogins = 0;
				int maxLoginsPerIp = 0;
				authorities.add(new ConcurrentLoginPermission(maxLogins,
						maxLoginsPerIp));
				int downloadRate = 0;// askForInt(in,
										// "Maximum download rate (0 for no restriction)");
				int uploadRate = 0;// askForInt(in,
									// "Maximum upload rate (0 for no restriction)");
				authorities.add(new TransferRatePermission(downloadRate,
						uploadRate));
				user.setAuthorities(authorities);
				SystemInit.serverFtp.getUserManager().save(user);
			} else {
				SystemInit.serverFtp.getUserManager().delete(username);
			}
			for (int i = 0; i < SystemInit.serverFtp.getUserManager()
					.getAllUserNames().length; i++) {
				System.out.println("用户名"
						+ SystemInit.serverFtp.getUserManager()
								.getAllUserNames()[i]);
			}
		} catch (Exception e) {

			OperationException opEx = new OperationException("用户session临时放入错误",
					e);
			log.error(e);
			throw opEx;
		}
	}
}
