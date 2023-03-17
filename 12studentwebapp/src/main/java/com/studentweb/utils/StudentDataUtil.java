package com.studentweb.utils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.studentweb.model.Student;

public class StudentDataUtil {
	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	List<Student> students=new ArrayList<>();
	
	private DataSource datasource;
	
	public StudentDataUtil(DataSource datasource) {
		this.datasource=datasource;
	}
	
	public List<Student>getStudents(){

		List<Student> students=new ArrayList<>();
		
		
		
	
	

		try {
			
			con=this.datasource.getConnection();
			stmt=con.createStatement();
			ResultSet resultset=stmt.executeQuery("select * from student order by id");
			while(resultset.next()) {
				int id=resultset.getInt("id");
				String fname=resultset.getString("firstname");
				String lname=resultset.getString("lastname");
				String email=resultset.getString("email");
				Student student=new Student(id,fname,lname,email);
				students.add(student);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
