package com.auca.MidExamSpring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.auca.MidExamSpring.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
}
