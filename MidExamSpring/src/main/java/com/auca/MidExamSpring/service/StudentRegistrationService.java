package com.auca.MidExamSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auca.MidExamSpring.Repository.StudentRegistrationRepository;
import com.auca.MidExamSpring.model.StudentRegistration;

@Service
public class StudentRegistrationService {

	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;
	
	public List<StudentRegistration> getAllStudentRegistrations() {
        return studentRegistrationRepository.findAll();
    }

    public StudentRegistration getStudentRegistrationById(Integer id) {
        return studentRegistrationRepository.findById(id).orElse(null);
    }

    public String saveStudentRegistration(StudentRegistration studentRegistration) {
        studentRegistrationRepository.save(studentRegistration);
        return "Student Registration Saved";
    }

    public String updateStudentRegistration(Integer id, StudentRegistration updatedStudentRegistration) {
        StudentRegistration studentRegistration = studentRegistrationRepository.findById(id).orElse(null);
        if (studentRegistration != null) {
            // Update properties as needed
            studentRegistration.setRegistrationDate(updatedStudentRegistration.getRegistrationDate());
            studentRegistration.setAcademicunit(updatedStudentRegistration.getAcademicunit());
            studentRegistration.setSemester(updatedStudentRegistration.getSemester());
            studentRegistration.setStatus(updatedStudentRegistration.getStatus());
            studentRegistrationRepository.save(studentRegistration);
            return "Student Registration Updated";
        } else {
            return "Student Registration not found";
        }
    }

    public String deleteStudentRegistration(Integer id) {
        StudentRegistration studentRegistration = studentRegistrationRepository.findById(id).orElse(null);
        if (studentRegistration != null) {
            studentRegistrationRepository.delete(studentRegistration);
            return "Student Registration Deleted";
        } else {
            return "Student Registration not found";
        }
    }


	
}
