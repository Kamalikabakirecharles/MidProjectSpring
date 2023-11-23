package com.auca.MidExamSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coursedefinition")
public class CourseDefinition {

	@Id
	@Column(name="code", length=50)
	private String code;
	
	@Column(name="name", length=50)
	private String name;
	
	@Column(name="description", length=100)
	private String description;

	public CourseDefinition() {
		super();
	}

	public CourseDefinition(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
