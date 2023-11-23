package com.auca.MidExamSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auca.MidExamSpring.model.CourseDefinition;

@Repository
public interface CourseDefinitionRepository extends JpaRepository<CourseDefinition, String> {

}
