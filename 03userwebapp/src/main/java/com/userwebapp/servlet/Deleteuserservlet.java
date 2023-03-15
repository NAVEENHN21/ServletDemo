package com.userwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteUserServlet")
public class Deleteuserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;  
   
	   public void init(ServletConfig config) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				ServletContext context=config.getServletContext();
				String dburl = context.getInitParameter("dburl");
				String dbuser = context.getInitParameter("dbuser");
				String dbpass = context.getInitParameter("dbpass");
				connection=DriverManager.getConnection(dburl,dbuser,dbpass);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
    public Deleteuserservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname =request.getParameter("firstname");
		response.setContentType("text/html");
		

		try(
				Statement statement=connection.createStatement();){

			int result=statement.executeUpdate("delete from user where firstname = '" +firstname+ "'");
			PrintWriter out=response.getWriter();
			if(result>0) {
				out.print("<h1>User Name deleted from DB</h1>");
			}else {
				out.print("<h1>Error delete user</h1>");
			}
			out.print("<a href=\"index.html\">Home</a>");

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void destroy() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
