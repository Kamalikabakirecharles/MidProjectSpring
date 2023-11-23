package com.auca.MidExamSpring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auca.MidExamSpring.Repository.CourseRepository;
import com.auca.MidExamSpring.model.Course;

@Service
public class CourseService {

	@Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer code) {
        return courseRepository.findById(code).orElse(null);
    }

    public String saveCourse(Course course) {
        courseRepository.save(course);
        return "Course Saved";
    }

    public String updateCourse(Integer code, Course updatedCourse) {
        Course course = courseRepository.findById(code).orElse(null);
        if (course != null) {
            // Update properties as needed
            course.setCousedefinition(updatedCourse.getCousedefinition());
            course.setTeacher(updatedCourse.getTeacher());
            course.setSemester(updatedCourse.getSemester());
            course.setAcademicunit(updatedCourse.getAcademicunit());
            courseRepository.save(course);
            return "Course Updated";
        } else {
            return "Course not found";
        }
    }

    public String deleteCourse(Integer code) {
        Course course = courseRepository.findById(code).orElse(null);
        if (course != null) {
            courseRepository.delete(course);
            return "Course Deleted";
        } else {
            return "Course not found";
        }
    }
}
