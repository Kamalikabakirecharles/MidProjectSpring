package com.auca.MidExamSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auca.MidExamSpring.model.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {

}
