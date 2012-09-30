package com.snp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;

public class JumpServlet extends HttpServlet {
	private static Log log = LogFactory.getLog(JumpServlet.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		log.debug(url);
		String name = (String) request.getRequestURL().subSequence(7,
				request.getRequestURL().indexOf("."));
		RequestDispatcher rd = request.getRequestDispatcher(SystemInit.urljump(
				url, name));
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private void doUpload(HttpServletRequest request) throws Exception {

	}

}
