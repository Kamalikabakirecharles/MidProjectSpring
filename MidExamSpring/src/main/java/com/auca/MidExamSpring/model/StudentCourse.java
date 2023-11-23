package com.auca.MidExamSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentcourse")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="credits")
	private Integer credits;
	
	@Column(name="results")
	private String results;
	
	@ManyToOne
	@JoinColumn(name="studentregistration", nullable = true)
	private StudentRegistration studentregistration;
	
	@ManyToOne
	@JoinColumn(name = "course_code", nullable = true)
	private Course course;

	public StudentCourse() {
		super();
	}

	public StudentCourse(int id, Integer credits, String results, StudentRegistration studentregistration,
			Course course) {
		super();
		this.id = id;
		this.credits = credits;
		this.results = results;
		this.studentregistration = studentregistration;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public StudentRegistration getStudentregistration() {
		return studentregistration;
	}

	public void setStudentregistration(StudentRegistration studentregistration) {
		this.studentregistration = studentregistration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
