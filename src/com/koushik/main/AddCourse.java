package com.koushik.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.koushik.entity.Course;
import com.koushik.entity.Teacher;
import com.koushik.entity.TeacherDetails;

public class AddCourse {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Teacher.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(TeacherDetails.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Teacher koushik = session.get(Teacher.class, 1);
			Course TTCourse = new Course("Table Tennis", 99);
			Course springHibernate = new Course("Spring-Hibernate", 42);
			koushik.add(TTCourse);
			koushik.add(springHibernate);
			session.save(TTCourse);
			session.save(springHibernate);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
