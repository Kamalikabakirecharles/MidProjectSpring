package com.auca.MidExamSpring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="academicunit")
public class AcademicUnit {

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="academicname")
	private String name;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "academic_type")
    private Eacademicunit academicType;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="parentcode", nullable = true)
	private AcademicUnit parentAcademic;

	public AcademicUnit() {
		super();
	}

	
	public AcademicUnit(String code, String name, Eacademicunit academicType, AcademicUnit parentAcademic) {
		super();
		this.code = code;
		this.name = name;
		this.academicType = academicType;
		this.parentAcademic = parentAcademic;
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

	

	public Eacademicunit getAcademicType() {
		return academicType;
	}


	public void setAcademicType(Eacademicunit academicType) {
		this.academicType = academicType;
	}


	public AcademicUnit getParentAcademic() {
		return parentAcademic;
	}

	public void setParentAcademic(AcademicUnit parentAcademic) {
		this.parentAcademic = parentAcademic;
	}

	
	
}
