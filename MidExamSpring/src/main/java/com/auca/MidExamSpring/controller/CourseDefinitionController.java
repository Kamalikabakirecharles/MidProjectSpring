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
import com.auca.MidExamSpring.model.CourseDefinition;
import com.auca.MidExamSpring.service.CourseDefinitionService;

@RestController
@RequestMapping(value = "/coursedefinition", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class CourseDefinitionController {

	@Autowired
	private CourseDefinitionService courseDefinitionService;
	
	@PostMapping(value = "/saveCourseDefinition")
	public ResponseEntity<?> createCourseDefinition(@RequestBody CourseDefinition courseDefinition) {
		if (courseDefinition != null) {
			String message = courseDefinitionService.saveCourseDefinition(courseDefinition);
			if ("Course Definition Saved".equals(message)) {
				return new ResponseEntity<>("Course Definition Saved", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Failed to save Course Definition", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Invalid Course Definition Data", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getCourseDefinitions")
	public ResponseEntity<List<CourseDefinition>> getAllCourseDefinitions() {
	    List<CourseDefinition> courseDefinitions = courseDefinitionService.getAllCourseDefinitions();
	    if (!courseDefinitions.isEmpty()) {
	        return new ResponseEntity<>(courseDefinitions, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getCourseDefinition/{code}")
	public ResponseEntity<CourseDefinition> getCourseDefinitionByCode(@PathVariable String code) {
	    CourseDefinition courseDefinition = courseDefinitionService.getCourseDefinitionById(code);
	    if (courseDefinition != null) {
	        return new ResponseEntity<>(courseDefinition, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/updateCourseDefinition/{code}")
	public ResponseEntity<String> updateCourseDefinition(@PathVariable String code, @RequestBody CourseDefinition updatedCourseDefinition) {
	    String message = courseDefinitionService.updateCourseDefinition(code, updatedCourseDefinition);
	    if ("Course Definition Updated".equals(message)) {
	        return new ResponseEntity<>("Course Definition Updated", HttpStatus.OK);
	    } else if ("Course Definition not found".equals(message)) {
	        return new ResponseEntity<>("Course Definition not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/deleteCourseDefinition/{code}")
	public ResponseEntity<String> deleteCourseDefinition(@PathVariable String code) {
	    String message = courseDefinitionService.deleteCourseDefinition(code);
	    if ("Course Definition Deleted".equals(message)) {
	        return new ResponseEntity<>("Course Definition Deleted", HttpStatus.OK);
	    } else if ("Course Definition not found".equals(message)) {
	        return new ResponseEntity<>("Course Definition not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
