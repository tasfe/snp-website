package com.snp.site.config;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 通过这个程序得到一个MEMBER的属性表
 以后就可以随便的添加属性

 admin 界面里面设置对象属性的时候，就靠这个总的

 将所有的属性列出来，然后让客户来选择属性，
 all_member_config.xml  直接写好的，总的配置文件(默认全部不显示)
 site_member_config.xml  admin_action_config  /site/client/site_member_config.xml 设置了字段的显示字段，value是无效
 realy_member_config.xml client_action_regist 有保存值的


 */
public class IpConfig {
	public ArrayList ipList = new ArrayList();

	public ArrayList getIpList() {
		return ipList;
	}

	public void setIpList(ArrayList ipList) {
		this.ipList = ipList;
	}

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * XMLEncoder e = new XMLEncoder(new BufferedOutputStream( new
		 * FileOutputStream("ipconfig.xml"))); IpConfig ipConfig =new
		 * IpConfig(); IpObject ipobject=new IpObject();
		 * ipobject.setIp("192.168.1.2"); ipobject.setPassword("123");
		 * ipobject.setName("lingfeng"); ipobject.setSiteusername("lf");
		 * ipConfig.ipList.add(ipobject);
		 * 
		 * 
		 * 
		 * e.writeObject(ipConfig); e.close(); log.debug("运行完毕");
		 */
	}

}
