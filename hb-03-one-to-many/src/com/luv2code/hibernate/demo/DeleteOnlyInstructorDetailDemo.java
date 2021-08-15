package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Instructor;
import com.luv2code.com.hibernate.demo.entity.InstructorDetail;

public class DeleteOnlyInstructorDetailDemo {

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
			
			//Get Instructor by primary key
			int theId = 4;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//Delete Instructor
			if(tempInstructorDetail != null)
			{
				//Remove associated object reference
				//Break bidirectional link
				tempInstructorDetail.getInstructor().setInstructorDetail(null);
				
				//Will also delete associated Instructor because of CascadeType.ALL
				System.out.println("Deleting IntructorDetail :" + tempInstructorDetail);
				session.delete(tempInstructorDetail);
			}
			
							
			//Commit transaction
			session.getTransaction().commit();
			
			
		}
		finally
		{
			factory.close();
		}

	}

}