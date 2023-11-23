package com.auca.MidExamSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auca.MidExamSpring.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
