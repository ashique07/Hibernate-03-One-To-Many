package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Course;
import com.luv2code.com.hibernate.demo.entity.Instructor;
import com.luv2code.com.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//Use session to save and retrieve objects
			
												
			//Start transaction
			session.beginTransaction();
												
			//Get Course
			Course tempCourse = session.get(Course.class, 13);
						
			//Delete the course but not the instructor
			session.delete(tempCourse);	
			
			//Commit transaction
			session.getTransaction().commit();
			
			
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}