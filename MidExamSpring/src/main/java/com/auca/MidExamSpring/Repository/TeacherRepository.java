package com.auca.MidExamSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auca.MidExamSpring.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
