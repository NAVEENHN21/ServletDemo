package com.hibernatehelloworld.configuration;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Address;
import com.hibernatehelloworld.domain.person;
import com.hibernatehelloworld.utils.HibernateUtil;



public class HibernateDemo {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Address address=new Address("1234 Main street","mysore","657898");
		
		Address address1=new Address("1234 Main street","mysore","657898");

		person person=new person("Sohan",address,address1);
		session.save(person);
		session.getTransaction().commit();
		session.close();
	
	}
}
