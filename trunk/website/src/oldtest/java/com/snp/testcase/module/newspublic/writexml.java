package com.snp.testcase.module.newspublic;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class writexml {
	private Document document;

	private String filename;

	public writexml(String name) throws ParserConfigurationException {
		filename = name;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.newDocument();
	}

	public void toWrite(String mytitle, String mycontent,Element root) {

		//首先拿到ROOT 再用root添加
		
		Element title = document.createElement("Title");
		title.appendChild(document.createCDATASection(mytitle));
		//title.appendChild(document.createTextNode(mytitle));
		root.appendChild(title);
		
		Element content = document.createElement("Content");
		content.appendChild(document.createTextNode(mycontent));
		root.appendChild(content);
	}

	public void toSave() {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
		} catch (TransformerException mye) {
			mye.printStackTrace();
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}
    /*
     * 
<?xml version="1.0" encoding="GB2312"?>
<WorkShop>
	<Title>中文题目</Title>
	<Content>中文内容</Content>
</WorkShop>
     * */
	public static void main(String args[]) {
		try {
			writexml myxml = new writexml(
					"zh2.xml");
			Element root = myxml.document.createElement("WorkShop");
			myxml.document.appendChild(root);	
			myxml.toWrite("<B>百度旅游<B><BR>最新安排", "http://www.baidu.com",root);
			myxml.toWrite("<B>goolge帮助", "http://www.google.com/notebook/public/05951760370772141165/BDQ9vDQoQ2fPZ8JEk?hl=zh-CN#SDRStDQoQqu3h8JEk",root);
			
			myxml.toSave();

			System.out.print("Your writing is successful.");
		} catch (Exception exp) {
			exp.printStackTrace();
			System.out.print("Your writing is failed.");
		}
	}
}
