package com.koushik.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class TeacherDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "youtube_channel")
	private String channel;

	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "details", cascade = CascadeType.ALL)
	private Teacher teacher;

	public TeacherDetails() {

	}

	public TeacherDetails(String channel, String hobby) {
		this.channel = channel;
		this.hobby = hobby;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "TeacherDetails [ID=" + ID + ", channel=" + channel + ", hobby=" + hobby + ", teacher=" + teacher + "]";
	}

}
