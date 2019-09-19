package com.examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class HelloWorldServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialized...");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Request received...");
		PrintWriter out = response.getWriter();
		out.println("Hello World");
	}
	
	@Override
	public void destroy() {
		System.out.println("Sevlet Destroyed...");
	}
	
	
}
