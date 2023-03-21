package com.studentweb.utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.studentweb.model.Student;

public class StudentDataUtil {
	
	List<Student> students=new ArrayList<>();
	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	public StudentDataUtil(Connection con) {
		this.con=con;
	}
	
	public List<Student> getStudents(){
		try {
			stmt=con.createStatement();
			ResultSet resultSet=stmt.executeQuery("select * from student order by id");
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String fname=resultSet.getString("firstname");
				String lname=resultSet.getString("lastname");
				String email=resultSet.getString("email");
				
				Student student=new Student(id,fname,lname,email);
				
				students.add(student);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(con,stmt,rs);
		}
		return students;
	}

	private void close(Connection con2, Statement stmt2, ResultSet rs2) {
		// TODO Auto-generated method stub
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
