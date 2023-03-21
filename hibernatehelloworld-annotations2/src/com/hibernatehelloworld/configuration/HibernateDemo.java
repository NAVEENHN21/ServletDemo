package com.hibernatehelloworld.configuration;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Address;
import com.hibernatehelloworld.domain.Guide;
import com.hibernatehelloworld.domain.Student;
import com.hibernatehelloworld.domain.person;
import com.hibernatehelloworld.utils.HibernateUtil;



public class HibernateDemo {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Guide guide=new Guide("wqerfnkdf2134","mike",2000);
		
		Student student1=new Student("STU001","max",guide);
		Student student2=new Student("STU002","john",guide);
		

		session.save(guide);
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();
	
	}
}
