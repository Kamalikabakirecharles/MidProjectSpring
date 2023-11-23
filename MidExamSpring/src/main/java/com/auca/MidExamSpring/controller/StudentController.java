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
import com.auca.MidExamSpring.model.Student;
import com.auca.MidExamSpring.service.StudentService;

@RestController
@RequestMapping(value = "/student", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/saveStudent")
	public ResponseEntity<?> createStudent(@RequestBody Student student){
		
		if(student != null) {
			String message = studentService.SaveStudent(student);
			if (message != null) {
				return new ResponseEntity<>("Saved", HttpStatus.CREATED);
	        } else {
	        	return new ResponseEntity<>("Saved", HttpStatus.CREATED);
	        }
		}else {
			return new ResponseEntity<>("yikes", HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
	    List<Student> students = studentService.getAllStudents();
	    if (!students.isEmpty()) {
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getStudent/{regno}")
	public ResponseEntity<Student> getStudentById(@PathVariable String regno) {
	    Student student = studentService.getStudentById(regno);
	    if (student != null) {
	        return new ResponseEntity<>(student, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/updateStudent/{regno}")
	public ResponseEntity<String> updateStudent(@PathVariable String regno, @RequestBody Student updatedStudent) {
	    String message = studentService.updateStudent(regno, updatedStudent);
	    if ("Student Updated".equals(message)) {
	        return new ResponseEntity<>("Student Updated", HttpStatus.OK);
	    } else if ("Student not found".equals(message)) {
	        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/deleteStudent/{regno}")
	public ResponseEntity<String> deleteStudent(@PathVariable String regno) {
	    String message = studentService.deleteStudent(regno);
	    if ("Student Deleted".equals(message)) {
	        return new ResponseEntity<>("Student Deleted", HttpStatus.OK);
	    } else if ("Student not found".equals(message)) {
	        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
