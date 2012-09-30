package com.snp.testcase.module.webbrowser;

import static java.awt.Window.log;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

//HTTP连接与浏览 

public class SnpBrowser extends JFrame {
	JTextPane txtpane_public; // 显示页面
	static String url = "http://www.bbh.net.cn:6666/public/index1.html";



	public SnpBrowser() {
		super("HTTP连接与浏览"); // 调用父类构造函数
		txtpane_public = new JTextPane(); // 实例化显示内容框
		txtpane_public.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				botton_opensite(evt);
			}
		});

		Container container = getContentPane(); // 得到容器
		container.add(new JScrollPane(txtpane_public), BorderLayout.NORTH); // 增加组件到容器上
		try {
			URL address = new URL(url);
			txtpane_public.setContentType("text/html"); // 设置内容格式
			txtpane_public.setPage(address); 
			BufferedReader in = new BufferedReader(new InputStreamReader(address.openStream())); // 获取输入流
			String line;
			StringBuffer content = new StringBuffer(); // 文件内容
		
			while ((line = in.readLine()) != null) { // 读取文件
				content.append(line + "\n");

			}
			in.close(); // 关闭输入流
			
		} catch (Exception e) {
			log.debug("无法访问");
			txtpane_public.setVisible(false);

		}

		setSize(380, 300); 
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	private void botton_opensite(MouseEvent evt) {
		GetipAddress.openUrl(url);
	}
	public static void main(String[] args) {
		new SnpBrowser();

	}
}
