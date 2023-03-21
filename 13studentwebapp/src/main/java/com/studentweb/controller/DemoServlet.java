package com.studentweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentweb.utils.StudentDataUtil;


@WebServlet("/mvcdemo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private StudentDataUtil studentDataUtil;
	private Connection connection;
	
	public void init(Servlet Config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ServletContext context=((ServletConfig) Config).getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			connection=DriverManager.getConnection(dburl,dbuser,dbpassword);
			studentDataUtil=new StudentDataUtil(connection);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("student_list", studentDataUtil.getStudents());
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/view_students.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
