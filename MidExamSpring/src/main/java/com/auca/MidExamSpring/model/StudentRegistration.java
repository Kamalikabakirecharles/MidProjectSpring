package com.auca.MidExamSpring.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentregistration")
public class StudentRegistration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="regno")
	private Student regno;
	
	@Column(name="registrationdate")
	private Date RegistrationDate;
	
	@OneToOne
	@JoinColumn(name="academicunit_code")
	private AcademicUnit academicunit;
	
	@ManyToOne
	@JoinColumn(name="semester_id")
	private Semester semester;

	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Eregistration Status;
	
	@OneToMany(mappedBy = "studentregistration")
	private List<StudentCourse> studentCourses;

	
	public StudentRegistration() {
		super();
	}	

	public StudentRegistration(Integer id, Student regno, Date registrationDate, AcademicUnit academicunit,
			Semester semester) {
		super();
		this.id = id;
		this.regno = regno;
		RegistrationDate = registrationDate;
		this.academicunit = academicunit;
		this.semester = semester;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Student getRegno() {
		return regno;
	}

	public void setRegno(Student regno) {
		this.regno = regno;
	}

	public Date getRegistrationDate() {
		return RegistrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		RegistrationDate = registrationDate;
	}

	public AcademicUnit getAcademicunit() {
		return academicunit;
	}

	public void setAcademicunit(AcademicUnit academicunit) {
		this.academicunit = academicunit;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Eregistration getStatus() {
		return Status;
	}

	public void setStatus(Eregistration status) {
		Status = status;
	}
	
	
}
