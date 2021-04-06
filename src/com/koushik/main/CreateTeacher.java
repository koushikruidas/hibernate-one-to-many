package com.koushik.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.koushik.entity.Course;
import com.koushik.entity.Teacher;
import com.koushik.entity.TeacherDetails;

public class CreateTeacher {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Teacher.class)
									.addAnnotatedClass(TeacherDetails.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Teacher javaTeacher = new Teacher("Tanmoy", "Mondal", "tanmoy.mondal@gmail.com");
			TeacherDetails details = new TeacherDetails("https://www.youtube.com/tanmoy_mondal", "Reading Books");
			javaTeacher.setDetails(details);
			session.beginTransaction();
			session.save(javaTeacher);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
