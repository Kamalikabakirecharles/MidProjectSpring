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
import com.auca.MidExamSpring.model.Semester;
import com.auca.MidExamSpring.service.SemesterService;

@RestController
@RequestMapping(value = "/semester", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class SemesterController {

	@Autowired
	private SemesterService semesterService;
	
	@PostMapping(value = "/saveSemester")
	public ResponseEntity<?> createSemester(@RequestBody Semester semester) {
		if (semester != null) {
			String message = semesterService.saveSemester(semester);
			if ("Semester Saved".equals(message)) {
				return new ResponseEntity<>("Semester Saved", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Failed to save Semester", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Invalid Semester Data", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getSemesters")
	public ResponseEntity<List<Semester>> getAllSemesters() {
	    List<Semester> semesters = semesterService.getAllSemesters();
	    if (!semesters.isEmpty()) {
	        return new ResponseEntity<>(semesters, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getSemester/{id}")
	public ResponseEntity<Semester> getSemesterById(@PathVariable Long id) {
	    Semester semester = semesterService.getSemesterById(id);
	    if (semester != null) {
	        return new ResponseEntity<>(semester, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/updateSemester/{id}")
	public ResponseEntity<String> updateSemester(@PathVariable Long id, @RequestBody Semester updatedSemester) {
	    String message = semesterService.updateSemester(id, updatedSemester);
	    if ("Semester Updated".equals(message)) {
	        return new ResponseEntity<>("Semester Updated", HttpStatus.OK);
	    } else if ("Semester not found".equals(message)) {
	        return new ResponseEntity<>("Semester not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/deleteSemester/{id}")
	public ResponseEntity<String> deleteSemester(@PathVariable Long id) {
	    String message = semesterService.deleteSemester(id);
	    if ("Semester Deleted".equals(message)) {
	        return new ResponseEntity<>("Semester Deleted", HttpStatus.OK);
	    } else if ("Semester not found".equals(message)) {
	        return new ResponseEntity<>("Semester not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
