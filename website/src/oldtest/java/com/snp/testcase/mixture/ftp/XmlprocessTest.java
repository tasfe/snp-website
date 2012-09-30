package com.snp.testcase.mixture.ftp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 <file-system>
 <users-path>home</users-path>
 <users>
 <user>
 <username>anonymous</username>
 <home/>
 </user>
 <user>
 <username>ftpuser</username>
 <home/>
 </user>
 </users>
 </file-system>
 */
public class XmlprocessTest extends TestCase {
	//修改一个xml
	File file = new File("src/test/resources/filesystem.xml");
	Document xml;
	public void testwritexml() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			xml = builder.newDocument();

			Element elementuser = xml.createElement("users");

			Element user = xml.createElement("user");
			Element username = xml.createElement("username");
			Element home = xml.createElement("home");
			user.appendChild(username);
			username.appendChild(xml.createTextNode("lingli"));
			user.appendChild(home);
			elementuser.appendChild(user);

			xml.appendChild(elementuser);
			//xml.appendChild(elementusername);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(xml);
			transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream("test.xml"));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	public void testgetPort() {
		int port=11;
		try {
		  File file = new File("conf/ftp/filesystem.xml");
		  Document xml;
		  
		
				xml = Xml.loadXml(file);
				NodeList nl;
				nl = xml.getElementsByTagName("port");  //这种方法可以随意换XML位置
				log.debug(nl.getLength());
				Element portElement = (Element) nl.item(0);
			//	port=Integer.parseInt(portElement.getTextContent());
				//log.debug("端口"+portElement.getTextContent());
				
				}catch (Exception e) {
					e.printStackTrace();
				}		
			log.debug(port);
	}
	public void testAddxml() {
		try {
			xml = Xml.loadXml(file);
			NodeList nl;
			log.debug("整个就一个节点："+xml.getFirstChild().getNodeName());//第一个节点和最后一个都是file-system
			//增加 lingli配置文件
			//nl = xml.getFirstChild().getChildNodes();
		    //Element users = (Element) nl.item(1); //关建是在这里，这里跳第二个节点users
			nl = xml.getElementsByTagName("users");  //这种方法可以随意换XML位置
			Element users = (Element) nl.item(0);
			Element user = xml.createElement("user");
			Element username = xml.createElement("username");
			Element home = xml.createElement("home");
			user.appendChild(username);
			username.appendChild(xml.createTextNode("lingli"));
			user.appendChild(home);
			users.appendChild(user);

			/*读 */
			nl = xml.getElementsByTagName("user");
			log.debug("用户总个数" + nl.getLength());
			for (int i = 0; i < nl.getLength(); i++) {

				log.debug(user.getNodeName());
				log.debug("用户名:"
						+ xml.getElementsByTagName("username").item(i)
								.getFirstChild().getNodeValue());
			}

			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(xml);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream("filesystem.xml"));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);			
			
		}catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
}
