package com.koushik.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String courseName;

	@Column(name = "course_duration")
	private int courseLength;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Teacher teachingAssistant;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseId",
			cascade = CascadeType.ALL)
	private List<Review> review;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> students;

	public Course(String courseName, int courseLength) {
		this.courseName = courseName;
		this.courseLength = courseLength;
	}

	public Course() {
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseLength() {
		return courseLength;
	}

	public void setCourseLength(int courseLength) {
		this.courseLength = courseLength;
	}

	public Teacher getTeachingAssistant() {
		return teachingAssistant;
	}

	public void setTeachingAssistant(Teacher teachingAssistant) {
		this.teachingAssistant = teachingAssistant;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void add(Review tempReview) {
		if(review == null) {
			review = new ArrayList<Review>();
		}
		review.add(tempReview);
		tempReview.setCourseId(this);
	}
	
	public void add(Student tempStudent) {
		if(students == null) {
			students = new ArrayList<Student>();
		}
		students.add(tempStudent);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseLength=" + courseLength
				+ "]";
	}

}
