package com.koushik.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseLength=" + courseLength
				+ ", teachingAssistant=" + teachingAssistant + "]";
	}

}
