package com.sunrise.sup.core.webwork.result;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.dispatcher.WebWorkResultSupport;
import com.opensymphony.xwork.ActionInvocation;

/**
 * Implements an XWork Result that takes an InputStream object available from a
 * chained Action and redirects it to the browser.
 * 
 * <p/>
 * 
 * The following declaration must be added to the xwork.xml file after the
 * &lt;package&gt; element:
 * 
 * <p/>
 * 
 * <pre>
 * &lt;result-types&gt;
 * &lt;result-type name=&quot;stream&quot; class=&quot;com.opensymphony.webwork.dispatcher.StreamResult&quot;/&gt;
 * &lt;/result-types&gt;
 * </pre>
 * 
 * <p/>
 * 
 * To use the stream result type add the following as part of the action
 * declaration:
 * 
 * <p/>
 * 
 * <pre>
 * &lt;result name=&quot;success&quot; type=&quot;stream&quot;&gt;
 * &lt;param name=&quot;contentType&quot;&gt;image/jpeg&amp;lt/param&gt;
 * &lt;param name=&quot;inputName&quot;&gt;imageStream&amp;lt/param&gt;
 * &lt;param name=&quot;contentDisposition&quot;&gt;filename=&quot;document.pdf&quot;&amp;lt/param&gt;
 * &lt;param name=&quot;bufferSize&quot;&gt;1024&amp;lt/param&gt;
 * &lt;/result&gt;
 * </pre>
 * 
 * <p/>
 * 
 * <ul>
 * <li>contentType - the stream mime-type as sent to the web browser</li>
 * <li>contentDispostion - the content disposition header value for specifing
 * the file name. (default = "inline", values are typically
 * <i>filename="document.pdf"</i></li>
 * <li>inputName - the name of the InputStream property from the chained action
 * (default = "inputStream")</li>
 * <li>bufferSize - the size of the buffer to copy from input to output (defaul
 * = 1024)</li>
 * </ul>
 * 
 * @author mcrawford
 */
/* ʵ�ʵ����ع���û��ʹ�ô��ļ� */
public class FiledownResult extends WebWorkResultSupport {
	protected String contentType = "text/plain";

	protected String contentDisposition = "inline";

	protected String inputName = "inputStream";

	protected int bufferSize = 1024;

	/**
	 * @return Returns the bufferSize.
	 */
	public int getBufferSize() {
		return (bufferSize);
	}

	/**
	 * @param bufferSize
	 *            The bufferSize to set.
	 */
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	/**
	 * @return Returns the contentType.
	 */
	public String getContentType() {
		return (contentType);
	}

	/**
	 * @param contentType
	 *            The contentType to set.
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return Returns the Content-disposition header value.
	 */
	public String getContentDisposition() {
		return contentDisposition;
	}

	/**
	 * @param contentDisposition
	 *            the Content-disposition header value to use.
	 */
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	/**
	 * @return Returns the inputName.
	 */
	public String getInputName() {
		return (inputName);
	}

	/**
	 * @param inputName
	 *            The inputName to set.
	 */
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	/**
	 * @see com.opensymphony.xwork.Result#execute(com.opensymphony.xwork.ActionInvocation)
	 */
	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		// Find the inputstream from the invocation variable stack
		// InputStream oInput = (InputStream)
		// invocation.getStack().findValue(conditionalParse(inputName,
		// invocation));
		// lingli
		InputStream oInput = new FileInputStream("c://����.txt");
		// Find the Response in context
		HttpServletResponse oResponse = (HttpServletResponse) invocation
				.getInvocationContext().get(HTTP_RESPONSE);

		// Set the content type

		oResponse.setContentType(conditionalParse(contentType, invocation));

		/*
		 * Set the content-disposition if (contentDisposition != null) {
		 * oResponse.addHeader("Content-disposition",
		 * conditionalParse(contentDisposition, invocation)); }
		 */
		// lingli
		String filename = "����.txt";
		oResponse.addHeader("Content-disposition",
				new String(filename.getBytes("gb2312"), "iso-8859-1"));

		// Get the outputstream
		OutputStream oOutput = oResponse.getOutputStream();
		// Copy input to output
		byte[] oBuff = new byte[bufferSize];
		int iSize = 0;
		while (-1 != (iSize = oInput.read(oBuff))) {
			oOutput.write(oBuff, 0, iSize);
		}

		// Flush
		oOutput.flush();
	}

}
