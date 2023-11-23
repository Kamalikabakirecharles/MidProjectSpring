package com.auca.MidExamSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auca.MidExamSpring.Repository.TeacherRepository;
import com.auca.MidExamSpring.model.Teacher;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public String SaveTeacher(Teacher teacher) {
		if(teacher != null) {
			teacherRepository.save(teacher);
			return "Teacher Saved ";
		}else {
			return null;
		}
	}
	
	public List<Teacher> getAllTeacher() {
	    return teacherRepository.findAll();
	}
	
	public Teacher getTeacherById(String code) {
	    return teacherRepository.findById(code).orElse(null);
	}

	public String updateTeacher(String code, Teacher updatedTeacher) {
	    Teacher teacher = teacherRepository.findById(code).orElse(null);
	    if (teacher != null) {
	    	teacher.setNames(updatedTeacher.getNames());
	    	teacher.setQualification(updatedTeacher.getQualification());
	        teacherRepository.save(teacher);
	        return "Teacher Updated";
	    } else {
	        return "Teacher not found";
	    }
	}

	public String deleteTeacher(String code) {
	    Teacher teacher = teacherRepository.findById(code).orElse(null);
	    if (teacher != null) {
	    	teacherRepository.delete(teacher); // Delete the student
	        return "Teacher Deleted";
	    } else {
	        return "Teacher not found";
	    }
	}


	
}
