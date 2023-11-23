package com.auca.MidExamSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auca.MidExamSpring.model.AcademicUnit;

@Repository
public interface AcademicUnitRepository extends JpaRepository<AcademicUnit, String>{

}
