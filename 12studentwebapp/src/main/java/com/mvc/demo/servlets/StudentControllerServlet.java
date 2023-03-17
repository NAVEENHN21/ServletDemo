package com.mvc.demo.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.studentweb.utils.StudentDataUtil;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/students")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/studentweb")
	private DataSource datasource;
	
	private StudentDataUtil studentDataUtil;
	private Connection connection;
	
	public void init(ServletConfig config) throws ServletException {
		
		
		
		try {
			studentDataUtil=new StudentDataUtil(datasource);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
		
		
//		try {
//			ServletContext context=config.getServletContext();
//			String dburl=context.getInitParameter("dburl");
//			String dbuser=context.getInitParameter("dbuser");
//			String dbpassword=context.getInitParameter("dbpassword");
//			Class.forName("com.mysql.jdbc.Driver");
//			connection=DriverManager.getConnection(dburl,dbuser,dbpassword);
//			studentDataUtil=new StudentDataUtil(connection);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String[] students= {"anil","sunil","suman","naveen"};
//		request.setAttribute("student_list", students);
//		
		request.setAttribute("student_list", studentDataUtil.getStudents());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/view_students.jsp") ;
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
