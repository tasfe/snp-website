package com.snp.testcase.mixture.ftp;

import java.io.File;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class readxml {
	static Document document;

	private boolean validating;

	public readxml() {
	}

	public Vector toRead(String filename) {
		Vector title = new Vector();
		Vector content = new Vector();
		String myStr = new String();
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(validating);
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(new File(filename));
			document.getDocumentElement().normalize();
			Node node = document.getFirstChild();
			NodeList list = node.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node nodeitm = list.item(i);
				if (nodeitm.getNodeName().equals("Title")) {
					myStr = nodeitm.getFirstChild().getNodeValue();
					title.addElement(myStr);// getFirstChild()
				}
				if (nodeitm.getNodeName().equals("Content")) {
					myStr = nodeitm.getFirstChild().getNodeValue();
					content.addElement(myStr);
				}
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			return null;
		}
		Vector all = new Vector();
		all.add(title);
		all.add(content);
		return all;
	}
	   /*
     * 
<?xml version="1.0" encoding="GB2312"?>
<WorkShop>
	<Title>中文题目</Title>
	<Content>中文内容</Content>
</WorkShop>
     * */
	public static void main(String[] args) {
		Vector A;
		readxml my = new readxml();
		A = my.toRead("9.xml");
		for (int i = 0; i < A.size(); i++) {
			log.debug(A.elementAt(i));
		}
	}
}
