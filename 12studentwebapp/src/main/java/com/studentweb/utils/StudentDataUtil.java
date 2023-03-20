package com.studentweb.utils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement stmt=null;

		try {
			
			con=this.datasource.getConnection();
			String sql="delete from student where id=?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			stmt.execute();
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,stmt);
			}
		
		
	}

	private void close(Connection con2, PreparedStatement stmt2) {
		// TODO Auto-generated method stub
		
	}

	private void close1(Connection con2, Statement stmt2, ResultSet rs2) {
		// TODO Auto-generated method stub
		try {
			
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

	public Student getStudent(int studentId) {
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Student student=null;
		
	try {
			
			con=this.datasource.getConnection();
			String sql="select * from student where id=?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, studentId);
		
			ResultSet resultset=stmt.executeQuery();
			while(resultset.next()) {
				int id=resultset.getInt("id");
				String fname=resultset.getString("firstname");
				String lname=resultset.getString("lastname");
				String email=resultset.getString("email");
				student=new Student(id,fname,lname,email);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,stmt,rs);
			}
		return student;
		
	}

	public void addStudent(String firstname, String lastname, String emailid) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement stmt=null;

		try {
			con=this.datasource.getConnection();
			String sql="insert into student(first_name,last_name,email)" + "values()";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,firstname);
			stmt.setString(2,lastname);
			stmt.setString(3,emailid);
			stmt.execute();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,stmt,null);
		}
	}

	public void updateStudent(int studentId, String firstname, String lastname, String emailId) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement stmt=null;

		try {
			
			con=this.datasource.getConnection();
			String sql="update student set first_name=?,last_name=?,email=? where id=?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(4, studentId);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, emailId);

			stmt.execute();
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,stmt);
			}
		
		
	}
		
	}
	
	
		
	

	

