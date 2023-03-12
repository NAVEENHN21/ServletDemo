package com.userwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;  
  
    public AddUserServlet() {
        super();
    }

    public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String firstname =request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("emailid");
		String pass=request.getParameter("password");
		

		try(
				Statement statement=connection.createStatement();){

			int result=statement.executeUpdate("insert into user values('" +firstname+ "','"+lastname+"','"+email+"','"+pass+"')");
			PrintWriter out=response.getWriter();
			if(result>0) {
				out.print("<h1>User Created in DB</h1>");
			}else {
				out.print("<h1>Error creating user</h1>");
			}
			
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
