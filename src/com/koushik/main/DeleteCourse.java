package com.koushik.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.koushik.entity.Course;
import com.koushik.entity.Teacher;
import com.koushik.entity.TeacherDetails;

public class DeleteCourse {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Teacher.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(TeacherDetails.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Course tableTennis = session.get(Course.class, 12);
			System.out.println("Course: "+tableTennis);
			System.out.println("Deleting It");
			session.delete(tableTennis);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
