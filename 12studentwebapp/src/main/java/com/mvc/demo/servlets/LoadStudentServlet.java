package com.mvc.demo.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.studentweb.model.Student;
import com.studentweb.utils.StudentDataUtil;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/loadstudent")
public class LoadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/studentweb")
	private DataSource datasource;
	
	private StudentDataUtil studentDataUtil;
	
	public void init(ServletConfig config) throws ServletException {
		
		
		
		try {
			studentDataUtil=new StudentDataUtil(datasource);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String studentid=request.getParameter("studentId");
		int id=Integer.parseInt(studentid);
		
		Student student= studentDataUtil.getStudent(id);
		
		request.setAttribute("STUDENT", student);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/update_student.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
