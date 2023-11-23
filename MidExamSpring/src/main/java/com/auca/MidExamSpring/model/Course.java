package com.auca.MidExamSpring.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

    @ManyToOne
    @JoinColumn(name = "coursedefinition_code", nullable = true)
    private CourseDefinition cousedefinition;

    @ManyToOne
    @JoinColumn(name = "teacher_code", nullable = true)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = true)
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "academicunit_code", nullable = true)
    private AcademicUnit academicunit;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;
    
	public Course() {
		super();
	}

	public Course(Integer code, CourseDefinition cousedefinition, Teacher teacher, Semester semester,
			AcademicUnit academicunit) {
		super();
		this.code = code;
		this.cousedefinition = cousedefinition;
		this.teacher = teacher;
		this.semester = semester;
		this.academicunit = academicunit;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public CourseDefinition getCousedefinition() {
		return cousedefinition;
	}

	public void setCousedefinition(CourseDefinition cousedefinition) {
		this.cousedefinition = cousedefinition;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public AcademicUnit getAcademicunit() {
		return academicunit;
	}

	public void setAcademicunit(AcademicUnit academicunit) {
		this.academicunit = academicunit;
	}
	
	
	
}
