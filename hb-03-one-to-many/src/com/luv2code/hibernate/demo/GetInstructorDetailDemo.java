package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Instructor;
import com.luv2code.com.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//Use session to save and retrieve objects
			
			
			//Start transaction
			session.beginTransaction();
			
			//Get InstructorDetail by primary key
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//Print InstructorDetail
			System.out.println("InstructorDetail :" + tempInstructorDetail);
			
			//Print associated Instructor object
			System.out.println("Associated Instructor :" + tempInstructorDetail.getInstructor());
							
			//Commit transaction
			session.getTransaction().commit();
			
			
		}
		catch(Exception exc)
		{
			
		}
		finally
		{
			//handle CONNECTION LEAK ISSUE
			session.close();
			
			factory.close();
		}

	}

}