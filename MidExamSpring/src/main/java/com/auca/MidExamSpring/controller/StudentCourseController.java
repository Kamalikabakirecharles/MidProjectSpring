package com.auca.MidExamSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auca.MidExamSpring.model.StudentCourse;
import com.auca.MidExamSpring.service.StudentCourseService;

@RestController
@RequestMapping(value = "/studentcourse", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class StudentCourseController {

	@Autowired
	private StudentCourseService studentCourseService;
	
	@PostMapping(value = "/saveStudentCourse")
	public ResponseEntity<?> createStudentCourse(@RequestBody StudentCourse studentCourse) {
		if (studentCourse != null) {
			String message = studentCourseService.saveStudentCourse(studentCourse);
			if ("Student Course Saved".equals(message)) {
				return new ResponseEntity<>("Student Course Saved", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Failed to save Student Course", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Invalid Student Course Data", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getStudentCourses")
	public ResponseEntity<List<StudentCourse>> getAllStudentCourses() {
	    List<StudentCourse> studentCourses = studentCourseService.getAllStudentCourses();
	    if (!studentCourses.isEmpty()) {
	        return new ResponseEntity<>(studentCourses, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getStudentCourse/{id}")
	public ResponseEntity<StudentCourse> getStudentCourseById(@PathVariable Integer id) {
	    StudentCourse studentCourse = studentCourseService.getStudentCourseById(id);
	    if (studentCourse != null) {
	        return new ResponseEntity<>(studentCourse, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/updateStudentCourse/{id}")
	public ResponseEntity<String> updateStudentCourse(@PathVariable Integer id, @RequestBody StudentCourse updatedStudentCourse) {
	    String message = studentCourseService.updateStudentCourse(id, updatedStudentCourse);
	    if ("Student Course Updated".equals(message)) {
	        return new ResponseEntity<>("Student Course Updated", HttpStatus.OK);
	    } else if ("Student Course not found".equals(message)) {
	        return new ResponseEntity<>("Student Course not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/deleteStudentCourse/{id}")
	public ResponseEntity<String> deleteStudentCourse(@PathVariable Integer id) {
	    String message = studentCourseService.deleteStudentCourse(id);
	    if ("Student Course Deleted".equals(message)) {
	        return new ResponseEntity<>("Student Course Deleted", HttpStatus.OK);
	    } else if ("Student Course not found".equals(message)) {
	        return new ResponseEntity<>("Student Course not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
