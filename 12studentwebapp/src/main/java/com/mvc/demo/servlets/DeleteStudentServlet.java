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
@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/studentweb")
	private DataSource datasource;
	
	private StudentDataUtil studentDataUtil;
//	private Connection connection;
	
	public void init(ServletConfig config) throws ServletException {
		
		
		
		try {
			studentDataUtil=new StudentDataUtil(datasource);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String studentid=request.getParameter("studentID");
		int id=Integer.parseInt(studentid);
		
		studentDataUtil.deleteStudent(id);
		
		request.setAttribute("student_list", studentDataUtil.getStudents());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/view_students.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void deleteStudent(String studentId) {
		
	}

}
