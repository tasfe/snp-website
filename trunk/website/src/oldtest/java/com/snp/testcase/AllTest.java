package com.snp.testcase;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.snp.testcase.common.EnvTest;
import com.snp.testcase.corefunction.AddUserTest;
import com.snp.testcase.corefunction.InsertSiteAboutTest;
import com.snp.testcase.corefunction.InsertSpmp1Test;
import com.snp.testcase.corefunction.InsertSpmp4Test;
import com.snp.testcase.corefunction.InsertSpmp8Test;
import com.snp.testcase.corefunction.Insert_about_flv_Test;
import com.snp.testcase.corefunction.Insert_about_img_Test;
import com.snp.testcase.corefunction.UploadSiteDataTest;

/*
平时JUNIT调试是用MYSQL为默认数据库的
本程序是为了HSQL数据库程序的总体测试


为什么只有这里可以设置断点
完整的测试过程，应该是， 
* CREATE DATABASE `dreams` 
*.打印版本信息
*.调用SnpDemo.adduser建立用户1，用户2
*.插入测试数据，其实这里可以使用HIBENATE的父子表的用例
  插入视频
  插入图片
*.导出用户1数据
4.导入新用户2数据
运行查看2是否正常
5.删除用户1，用户2
*/
public class AllTest extends TestCase {
	public static Test suite() {
		EnvTest.delete_old_data();
		System.setProperty("database", "DataBaseConfig-hsql.xml");
		TestSuite suite= new TestSuite();
		suite.addTestSuite(AddUserTest.class);//调用SnpDemo.adduser建立用户u1，用户u2
		
		suite.addTestSuite(InsertSiteAboutTest.class);//插入U1的about数据1条,视频和图片
		suite.addTestSuite(Insert_about_flv_Test.class);
		suite.addTestSuite(Insert_about_img_Test.class);
		
		suite.addTestSuite(InsertSpmp1Test.class);//
		suite.addTestSuite(InsertSpmp4Test.class);//
		suite.addTestSuite(InsertSpmp8Test.class);//
		//suite.addTestSuite(DownUserdataTest.class);// 导出导入用WEBPAGE来进行自动测试
		suite.addTestSuite(UploadSiteDataTest.class);//将u2.zip导入
		
		//	suite.addTestSuite(ReleaseTest.class); //打印版本信息
		

		return suite;
	
	}
	

	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	
		Main main=new Main();
		main.main(args);
	}

}
