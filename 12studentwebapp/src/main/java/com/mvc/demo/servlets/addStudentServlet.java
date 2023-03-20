package com.mvc.demo.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.studentweb.utils.StudentDataUtil;

/**
 * Servlet implementation class addStudentServlet
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
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
    public addStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String emailid=request.getParameter("emailid");
		
		studentDataUtil.addStudent(firstname,lastname,emailid);
		
		request.setAttribute("student_list",studentDataUtil.getStudents());
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
