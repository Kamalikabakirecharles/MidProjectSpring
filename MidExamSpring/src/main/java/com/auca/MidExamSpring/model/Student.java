package com.auca.MidExamSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@Column(name="regno", length=50)
	private String regno;
	
	@Column(name="fullname", length=50)
	private String fullname;
	
	@Column(name="dateofbirth", length=50)
	private String dateofbirth;

	public Student() {
		super();
	}

	public Student(String regno, String fullname, String dateofbirth) {
		super();
		this.regno = regno;
		this.fullname = fullname;
		this.dateofbirth = dateofbirth;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	
	
}
