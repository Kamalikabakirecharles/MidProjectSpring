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

import com.auca.MidExamSpring.model.Course;
import com.auca.MidExamSpring.service.CourseService;

@RestController
@RequestMapping(value = "/course", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping(value = "/saveCourse")
	public ResponseEntity<?> createCourse(@RequestBody Course course) {
		if (course != null) {
			String message = courseService.saveCourse(course);
			if ("Course Saved".equals(message)) {
				return new ResponseEntity<>("Course Saved", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Save Failed", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Invalid Course Data", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getCourses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		if (!courses.isEmpty()) {
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getCourse/{code}")
	public ResponseEntity<Course> getCourseByCode(@PathVariable Integer code) {
		Course course = courseService.getCourseById(code);
		if (course != null) {
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateCourse/{code}")
	public ResponseEntity<String> updateCourse(@PathVariable Integer code, @RequestBody Course updatedCourse) {
		String message = courseService.updateCourse(code, updatedCourse);
		if ("Course Updated".equals(message)) {
			return new ResponseEntity<>("Course Updated", HttpStatus.OK);
		} else if ("Course not found".equals(message)) {
			return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteCourse/{code}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer code) {
		String message = courseService.deleteCourse(code);
		if ("Course Deleted".equals(message)) {
			return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
		} else if ("Course not found".equals(message)) {
			return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
