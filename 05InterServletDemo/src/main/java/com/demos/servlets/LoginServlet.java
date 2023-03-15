package com.demos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") // Helps to eliminate the web mappings in the xml file
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement preparedStatement;

	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbpassword = context.getInitParameter("dbpassword");
			String dbuser = context.getInitParameter("dbuser");
			connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
			preparedStatement = connection.prepareStatement("select * from user where email=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
//System.out.println(username);
//System.out.println(password);

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (!isValidInputString(username, false) || !isValidInputString(password, false)) {
			out.println("<h1>Please Enter valid input</h1>");
			return;
		}

		try {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultset = null;
			boolean result = preparedStatement.execute();

			if (result ) {
				resultset=preparedStatement.getResultSet();
				//System.out.println(resultset.getFetchSize());
			}
			if(resultset.next()) {
				//Now navigate to home page
				System.out.println("User Successfully logged In, Navigating to home page");
				RequestDispatcher rd=request.getRequestDispatcher("HomeServlet");
				String welcomemessage="welcome to servlet Communication demo"+username+"!!";
				request.setAttribute("message", welcomemessage);
				rd.include(request, response);
			} else {
				//navigate to login.html
				out.println("<h1>User Not found</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isValidInputString(String inputValue, boolean isNumber) {
		if (inputValue == null || inputValue.isBlank() || inputValue.isEmpty()) {
			return false;
		} else if (isNumber) {
			try {
				Integer someint = Integer.parseInt(inputValue);
				return true;
			} catch (NumberFormatException nfe) {
				return false;
			}
		} else {
			return true;
		}
	}

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();

			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}