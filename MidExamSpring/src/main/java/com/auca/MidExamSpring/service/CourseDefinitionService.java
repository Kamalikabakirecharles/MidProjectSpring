package com.auca.MidExamSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.MidExamSpring.Repository.CourseDefinitionRepository;
import com.auca.MidExamSpring.model.CourseDefinition;

@Service
public class CourseDefinitionService {

	@Autowired
    private CourseDefinitionRepository courseDefinitionRepository;

    public List<CourseDefinition> getAllCourseDefinitions() {
        return courseDefinitionRepository.findAll();
    }

    public CourseDefinition getCourseDefinitionById(String code) {
        return courseDefinitionRepository.findById(code).orElse(null);
    }

    public String saveCourseDefinition(CourseDefinition courseDefinition) {
        courseDefinitionRepository.save(courseDefinition);
        return "Course Definition Saved";
    }

    public String updateCourseDefinition(String code, CourseDefinition updatedCourseDefinition) {
        CourseDefinition courseDefinition = courseDefinitionRepository.findById(code).orElse(null);
        if (courseDefinition != null) {
            // Update properties as needed
            courseDefinition.setName(updatedCourseDefinition.getName());
            courseDefinition.setDescription(updatedCourseDefinition.getDescription());
            courseDefinitionRepository.save(courseDefinition);
            return "Course Definition Updated";
        } else {
            return "Course Definition not found";
        }
    }

    public String deleteCourseDefinition(String code) {
        CourseDefinition courseDefinition = courseDefinitionRepository.findById(code).orElse(null);
        if (courseDefinition != null) {
            courseDefinitionRepository.delete(courseDefinition);
            return "Course Definition Deleted";
        } else {
            return "Course Definition not found";
        }
    }
}
