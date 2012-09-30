package com.snp.testcase.module.exporthtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 如果要执行一条DOS内部命令，有两种方法。
 一种方法是把命令解释器包含在exec()的参数中。
 例如，执行dir命令，在NT上，可写成 exec("cmd.exe /c dir")，
 在windows 95/98下，可写成“command.exe /c dir”
 ，其中参数“/c”表示命令执行后关闭Dos立即关闭窗口。
 另一种方法是，把内部命令放在一个批命令my_dir.bat文件中，在Java程序 中写成exec("my_dir.bat")。如果仅仅写成exec("dir")，Java虚拟机则会报运行时错误。前一种方法要保证程序的可移植性， 
 需要在程序中读取运行的操作系统平台，以调用不同的命令解释器。后一种方法则不需要做更多的处理。
 
 */
public class ExportExe {

	 static boolean done = false;

	 public static void main(String argv[]) throws IOException {

	   final Process p;     // 声明命令项
	   BufferedReader is;  // 命令输出项
	   String line;   

	   String cmd_exe="video\\7z a  -t7z  export_temp\\temp.7z  export_temp\\*";

	   //String cmd_exe="cmd.exe /c copy /b /y D:\\workspace-snp\\maven\\snp\\video\\7zsd.sfx + D:\\workspace-snp\\maven\\snp\\video\\conf.txt + D:\\workspace-snp\\maven\\snp\\export_temp\\demo.7z F:\\demo.exe";
		//String cmd_exe="copy /b /y   video/7zsd.sfx + video/conf.txt + export_temp/demo.7z "+filepath;
		
		log.debug(cmd_exe);
	    p = Runtime.getRuntime().exec(cmd_exe);//执行命令
	   // 执行命令线程，
	   Thread waiter = new Thread() {
	     public void run() {
	       try {
	         p.waitFor();
	       } catch (InterruptedException ex) {
	         return;
	       }
	       log.debug("Program terminated!");//如果已经运行了这个程序。就输出程序已运行
	       done = true;//如果执行完成设置done为真，用于判断命令结束。
	     }
	   };
	   waiter.start();
	   //以下是和获得执行结果，就是说在完成情况下输出运行结果
	   is = new BufferedReader(new InputStreamReader(p.getInputStream()));
	   while (!done && ((line = is.readLine()) != null))
	     log.debug(line);

	   return;
	 }



}
