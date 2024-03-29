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


@WebServlet("/updateuserervlet")
public class UpdateUserServlet extends HttpServlet {
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
  
    public UpdateUserServlet() {
        super();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String email=request.getParameter("emailid");
		String password=request.getParameter("password");
	
		response.setContentType("text/html");
		
		try( 
				Statement statement=connection.createStatement();){

			int result=statement.executeUpdate("update user set password = '"+password+"' where email='"+email+"'");
			PrintWriter out=response.getWriter();
			if(result>0) {
				out.print("<h1>Password Updated</h1>");
			}else {
				out.print("<h1>Error Updating user</h1>");
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
