package com.auca.MidExamSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.MidExamSpring.Repository.StudentCourseRepository;
import com.auca.MidExamSpring.model.StudentCourse;

@Service
public class StudentCourseService {

	@Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

    public StudentCourse getStudentCourseById(Integer id) {
        return studentCourseRepository.findById(id).orElse(null);
    }

    public String saveStudentCourse(StudentCourse studentCourse) {
        studentCourseRepository.save(studentCourse);
        return "Student Course Saved";
    }

    public String updateStudentCourse(Integer id, StudentCourse updatedStudentCourse) {
        StudentCourse studentCourse = studentCourseRepository.findById(id).orElse(null);
        if (studentCourse != null) {
            // Update properties as needed
            studentCourse.setCredits(updatedStudentCourse.getCredits());
            studentCourse.setResults(updatedStudentCourse.getResults());
            studentCourseRepository.save(studentCourse);
            return "Student Course Updated";
        } else {
            return "Student Course not found";
        }
    }

    public String deleteStudentCourse(Integer id) {
        StudentCourse studentCourse = studentCourseRepository.findById(id).orElse(null);
        if (studentCourse != null) {
            studentCourseRepository.delete(studentCourse);
            return "Student Course Deleted";
        } else {
            return "Student Course not found";
        }
    }
	
}
