package com.userwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listusers")
public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
       

    public ListUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
	


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	

		try(
				Statement statement=connection.createStatement();
				ResultSet result=statement.executeQuery("select * from user");){

			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Email ID</th>");

			out.println("</tr>");

			while(result.next()) {
			String firstname = result.getString(1);
			String lastname=   result.getString(2);
			String email=      result.getString(3);
			out.println("<tr>");
			out.println("<th>"+firstname+"</th>");
			out.println("<th>"+lastname+"</th>");
			out.println("<th>"+email+"</th>");
			out.println("</tr>");
			}
				out.print("</table>");
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
