package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Course;
import com.luv2code.com.hibernate.demo.entity.Instructor;
import com.luv2code.com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			//Create a Objects
			
			Instructor tempInstructor = new Instructor("Shuvro","Dev","shuvro@gmail.com");
			//InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube/saha.com","Politics");
			Course tempCourse = new Course("Political Science");
			
			//Associate objects
			//tempInstructor.setInstructorDetail(tempInstructorDetail);
			tempInstructor.add(tempCourse);
			
			//Start transaction
			session.beginTransaction();
			
			//Save student
			//session.save(tempCourse);
			session.save(tempInstructor);
							
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