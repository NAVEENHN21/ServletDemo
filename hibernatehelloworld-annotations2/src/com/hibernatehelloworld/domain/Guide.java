package com.hibernatehelloworld.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guide {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String staffid;
	private String name;
	private Integer salary;
	
	public Guide() {}
	public Guide(String staffid, String name, Integer salary) {
		super();
		this.staffid = staffid;
		this.name = name;
		this.salary = salary;
	}
}
