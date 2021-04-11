package com.koushik.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.koushik.entity.Course;
import com.koushik.entity.Review;
import com.koushik.entity.Student;
import com.koushik.entity.Teacher;
import com.koushik.entity.TeacherDetails;

public class CreateCourseAndAddStudentsToTheCourse {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Teacher.class)
									.addAnnotatedClass(TeacherDetails.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Course reactjs = new Course("React JS", 40);
			session.save(reactjs);
			
			Teacher teacher = new Teacher("Subrata", "Maity", "subrata.maity@pwc.com");
			session.save(teacher);
			
			TeacherDetails det = new TeacherDetails("https://youtube.com/learReact","Reading Books");
			teacher.add(reactjs);
			teacher.setDetails(det);
			
			Review gd = new Review("This is a very good Course!");
			Review sugges = new Review("Good course to learn with lots of new oppertunities");
			
			session.save(gd);
			session.save(sugges);
			
			reactjs.add(gd);
			reactjs.add(sugges);
			
			Student sumit = new Student("Sumit", "Gorai", "sumit.gorai01@gmail.com");
			Student suman = new Student("Suman", "Sarkar", "sumansarkar007@gmail.com");
			Student ritu = new Student("Rituparna","Ghosh","ghoshritu@gmail.com");
			
			session.save(ritu);
			session.save(suman);
			session.save(sumit);
			
			reactjs.add(sumit);
			reactjs.add(suman);
			reactjs.add(ritu);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}
}
