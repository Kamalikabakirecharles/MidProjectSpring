package com.auca.MidExamSpring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auca.MidExamSpring.model.AcademicUnit;
import com.auca.MidExamSpring.model.Course;
import com.auca.MidExamSpring.model.Semester;
import com.auca.MidExamSpring.model.StudentCourse;
import com.auca.MidExamSpring.model.StudentRegistration;
import com.auca.MidExamSpring.service.AcademicUnitService;
import com.auca.MidExamSpring.service.CourseService;
import com.auca.MidExamSpring.service.SemesterService;
import com.auca.MidExamSpring.service.StudentCourseService;
import com.auca.MidExamSpring.service.StudentRegistrationService;
import com.auca.MidExamSpring.service.StudentService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class ListController {

	@Autowired
	private SemesterService semesterService;
	
	@Autowired
	private StudentRegistrationService studentregistrationservice;
	
	@Autowired
	private AcademicUnitService academicunitservice;
	
	@Autowired
	private StudentCourseService studentcourseservice;
	
	@Autowired
	private CourseService courseservice;
	
//	--------------(List of Students per semester)---------------

	  @GetMapping("/StudentsPerSemester/{semesterId}")
	    public ResponseEntity<List<StudentRegistration>> listRegistrationsBySemester(

	            @PathVariable Long semesterId) {
	        Semester semester = semesterService.getSemesterById(semesterId);

	        if (semester != null) {
	            List<StudentRegistration> registrations = studentregistrationservice.getRegistrationsBySemester(semester);
	            return new ResponseEntity<>(registrations, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}

//	-------------(List of Students per department and Semester)-------------------

	@GetMapping("/StudentsPerdepartmentAndSemester/{departmentCode}/{semesterId}")
	    public ResponseEntity<List<StudentRegistration>> listRegistrationsByDepartmentAndSemester(
	            @PathVariable String departmentCode,
	            @PathVariable String semesterId) {

	        AcademicUnit department = academicunitservice.getAcademicUnitByCode(departmentCode);
	        Semester semester = semesterService.getSemesterById(semesterId);

	        if (department != null && semester != null) {
	            List<StudentRegistration> registrations = studentregistrationservice.getRegistrationsByDepartmentAndSemester(department, semester);
	            return new ResponseEntity<>(registrations, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

//	-----------------(List of Students per course and Semester)--------------

	   @GetMapping("/StudentsPerCourseAndSemester/{courseCode}/{semesterId}")
	    public ResponseEntity<List<StudentCourse>> listByCourseAndSemester(@PathVariable Integer courseCode, @PathVariable String semesterId) {
	        Course course = courseservice.getCourseById(courseCode);

	        if (course != null) {
	            List<StudentCourse> crs = studentcourseservice.getStudentByCourseAndSemester(course, semesterId);
	            return new ResponseEntity<>(crs, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

//	-------------(List of Courses per Department and Semester)-------------------

	@GetMapping("/CoursesPerDepartmentAndSemester/{departmentCode}/{semesterId}")
	    public ResponseEntity<List<StudentRegistration>> listRegistrationsByDepartmentAndSemester(
	            @PathVariable String departmentCode,
	            @PathVariable String semesterId) {

	        AcademicUnit department = academicunitservice.getAcademicUnitByCode(departmentCode);
	        Semester semester = semesterService.getSemesterById(semesterId);

	        if (department != null && semester != null) {
	            List<StudentRegistration> registrations = studentregistrationservice.getRegistrationsByDepartmentAndSemester(department, semester);
	            return new ResponseEntity<>(registrations, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

//	--------------------(List of Courses per Student)---------------------

	 @GetMapping("/CoursesPerStudent/{studentId}")
	    public ResponseEntity<List<StudentCourse>> listByCourse(@PathVariable String studentId){
	        StudentRegistration stud = studentregistrationservice.getRegistrationByStudentId(studentId);

	        if (stud != null) {
	            List<StudentCourse> crs = studentcourseservice.getCoursesByStudentId(studentId);
	            return new ResponseEntity<>(crs, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	
}
