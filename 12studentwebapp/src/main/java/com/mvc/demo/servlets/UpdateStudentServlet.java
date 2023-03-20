package com.mvc.demo.servlets;

import java.io.IOException;
import java.sql.Connection;

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

       
@WebServlet("/updatestudent")
public class UpdateStudentServlet extends HttpServlet {
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentId=request.getParameter("studentId");
		int id=Integer.parseInt(studentId);
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");

		String emailId=request.getParameter("emailId");

		studentDataUtil.updateStudent(id,firstname,lastname,emailId);
		
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
