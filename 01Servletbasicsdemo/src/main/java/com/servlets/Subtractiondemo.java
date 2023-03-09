package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Subtractiondemo extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num1=req.getParameter("num1");
		String num2=req.getParameter("num2");
		
		int num1int=Integer.parseInt(num1);
		int num2int=Integer.parseInt(num2);
		int ressub=num1int-num2int;
		
		PrintWriter out=res.getWriter();
		out.print("<p>Result: "+ressub+"</p>");
	}

}
