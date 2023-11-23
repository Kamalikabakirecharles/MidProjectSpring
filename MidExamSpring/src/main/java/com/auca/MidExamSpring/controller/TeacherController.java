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
import com.auca.MidExamSpring.model.Teacher;
import com.auca.MidExamSpring.service.TeacherService;

@RestController
@RequestMapping(value = "/teacher", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@PostMapping(value = "/saveTeacher")
	public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher) {
		if (teacher != null) {
			String message = teacherService.SaveTeacher(teacher);
			if ("Teacher Saved".equals(message)) {
				return new ResponseEntity<>("Teacher Saved", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Failed to save Teacher", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Invalid Teacher Data", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getTeachers")
	public ResponseEntity<List<Teacher>> getAllTeacher() {
	    List<Teacher> teachers = teacherService.getAllTeacher();
	    if (!teachers.isEmpty()) {
	        return new ResponseEntity<>(teachers, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getTeacher/{code}")
	public ResponseEntity<Teacher> getTeacherByCode(@PathVariable String code) {
	    Teacher teacher = teacherService.getTeacherById(code);
	    if (teacher != null) {
	        return new ResponseEntity<>(teacher, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/updateTeacher/{code}")
	public ResponseEntity<String> updateTeacher(@PathVariable String code, @RequestBody Teacher updatedTeacher) {
	    String message = teacherService.updateTeacher(code, updatedTeacher);
	    if ("Teacher Updated".equals(message)) {
	        return new ResponseEntity<>("Teacher Updated", HttpStatus.OK);
	    } else if ("Teacher not found".equals(message)) {
	        return new ResponseEntity<>("Teacher not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/deleteTeacher/{code}")
	public ResponseEntity<String> deleteTeacher(@PathVariable String code) {
	    String message = teacherService.deleteTeacher(code);
	    if ("Teacher Deleted".equals(message)) {
	        return new ResponseEntity<>("Teacher Deleted", HttpStatus.OK);
	    } else if ("Teacher not found".equals(message)) {
	        return new ResponseEntity<>("Teacher not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
