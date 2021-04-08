package com.koushik.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.koushik.entity.Course;
import com.koushik.entity.Review;
import com.koushik.entity.Teacher;
import com.koushik.entity.TeacherDetails;

public class AddReview {
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
			Course java = session.get(Course.class, 10);
			Review good = new Review("The course is very good for the beginners!");
			Review outstanding = new Review("This is an outstanding course for the beginners "
					+ "This will teach you a great deal about core java");
			Review bad = new Review("If you know basic java and a little about programming "
					+ "then this course is just a waste of time");
			java.add(good);
			java.add(bad);
			java.add(outstanding);
			session.save(java);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}
}
