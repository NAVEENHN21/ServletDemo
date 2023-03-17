package com.studentweb.model;
public class Student {

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(int id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	public Student(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	private String firstname;
	private String lastname;
	private String email;
}
