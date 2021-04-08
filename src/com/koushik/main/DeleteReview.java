package com.koushik.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.koushik.entity.Course;
import com.koushik.entity.Review;
import com.koushik.entity.Teacher;
import com.koushik.entity.TeacherDetails;

public class DeleteReview {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Teacher.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(TeacherDetails.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Review badReview = session.get(Review.class, 21);
			
			// Uni-directional delete
			session.delete(badReview);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}
}
