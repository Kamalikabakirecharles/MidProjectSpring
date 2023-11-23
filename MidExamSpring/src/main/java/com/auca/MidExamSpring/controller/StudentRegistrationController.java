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
import com.auca.MidExamSpring.model.StudentRegistration;
import com.auca.MidExamSpring.service.StudentRegistrationService;

@RestController
@RequestMapping(value = "/studentregistration", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class StudentRegistrationController {

	@Autowired
	private StudentRegistrationService studentRegistrationService;
	
	@PostMapping(value = "/saveStudentRegistration")
	public ResponseEntity<?> createStudentRegistration(@RequestBody StudentRegistration studentRegistration) {
		if (studentRegistration != null) {
			String message = studentRegistrationService.saveStudentRegistration(studentRegistration);
			if ("Student Registration Saved".equals(message)) {
				return new ResponseEntity<>("Student Registration Saved", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Failed to save Student Registration", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Invalid Student Registration Data", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getStudentRegistrations")
	public ResponseEntity<List<StudentRegistration>> getAllStudentRegistrations() {
	    List<StudentRegistration> studentRegistrations = studentRegistrationService.getAllStudentRegistrations();
	    if (!studentRegistrations.isEmpty()) {
	        return new ResponseEntity<>(studentRegistrations, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getStudentRegistration/{id}")
	public ResponseEntity<StudentRegistration> getStudentRegistrationById(@PathVariable Integer id) {
	    StudentRegistration studentRegistration = studentRegistrationService.getStudentRegistrationById(id);
	    if (studentRegistration != null) {
	        return new ResponseEntity<>(studentRegistration, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/updateStudentRegistration/{id}")
	public ResponseEntity<String> updateStudentRegistration(@PathVariable Integer id, @RequestBody StudentRegistration updatedStudentRegistration) {
	    String message = studentRegistrationService.updateStudentRegistration(id, updatedStudentRegistration);
	    if ("Student Registration Updated".equals(message)) {
	        return new ResponseEntity<>("Student Registration Updated", HttpStatus.OK);
	    } else if ("Student Registration not found".equals(message)) {
	        return new ResponseEntity<>("Student Registration not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/deleteStudentRegistration/{id}")
	public ResponseEntity<String> deleteStudentRegistration(@PathVariable Integer id) {
	    String message = studentRegistrationService.deleteStudentRegistration(id);
	    if ("Student Registration Deleted".equals(message)) {
	        return new ResponseEntity<>("Student Registration Deleted", HttpStatus.OK);
	    } else if ("Student Registration not found".equals(message)) {
	        return new ResponseEntity<>("Student Registration not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
