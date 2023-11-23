package com.auca.MidExamSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {

	@Id
	@Column(name="code", length=50)
	private String code;
	
	@Column(name="names", length=100)
	private String names;
	
	@Enumerated(EnumType.STRING)
	@Column(name="qualification", length=50)
	private Equalification qualification;

	public Teacher() {
		super();
	}

	
	public Teacher(String code, String names, Equalification qualification) {
		super();
		this.code = code;
		this.names = names;
		this.qualification = qualification;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}


	public Equalification getQualification() {
		return qualification;
	}


	public void setQualification(Equalification qualification) {
		this.qualification = qualification;
	}

	
	
}
