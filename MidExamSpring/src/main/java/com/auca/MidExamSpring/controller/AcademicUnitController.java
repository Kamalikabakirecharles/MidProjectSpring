package com.auca.MidExamSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auca.MidExamSpring.model.AcademicUnit;
import com.auca.MidExamSpring.service.AcademicUnitService;

@RestController
@RequestMapping(value = "/academicunit", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class AcademicUnitController {

	@Autowired
	private AcademicUnitService academicUnitService;
	
	@PostMapping(value = "/saveAcademicUnit")
	public ResponseEntity<?> createAcademicUnit(@RequestBody AcademicUnit academicUnit) {
		if (academicUnit != null) {
			String message = academicUnitService.saveAcademicUnit(academicUnit);
			if ("Academic Unit Saved".equals(message)) {
				return new ResponseEntity<>("Academic Unit Saved", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Failed to save Academic Unit", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Invalid Academic Unit Data", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAcademicUnits")
	public ResponseEntity<List<AcademicUnit>> getAllAcademicUnits() {
	    List<AcademicUnit> academicUnits = academicUnitService.getAllAcademicUnits();
	    if (!academicUnits.isEmpty()) {
	        return new ResponseEntity<>(academicUnits, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getAcademicUnit/{code}")
	public ResponseEntity<AcademicUnit> getAcademicUnitByCode(@PathVariable String code) {
	    AcademicUnit academicUnit = academicUnitService.getAcademicUnitByCode(code);
	    if (academicUnit != null) {
	        return new ResponseEntity<>(academicUnit, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/updateAcademicUnit/{code}")
	public ResponseEntity<String> updateAcademicUnit(@PathVariable String code, @RequestBody AcademicUnit updatedAcademicUnit) {
	    String message = academicUnitService.updateAcademicUnit(code, updatedAcademicUnit);
	    if ("Academic Unit Updated".equals(message)) {
	        return new ResponseEntity<>("Academic Unit Updated", HttpStatus.OK);
	    } else if ("Academic Unit not found".equals(message)) {
	        return new ResponseEntity<>("Academic Unit not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/deleteAcademicUnit/{code}")
	public ResponseEntity<String> deleteAcademicUnit(@PathVariable String code) {
	    String message = academicUnitService.deleteAcademicUnit(code);
	    if ("Academic Unit Deleted".equals(message)) {
	        return new ResponseEntity<>("Academic Unit Deleted", HttpStatus.OK);
	    } else if ("Academic Unit not found".equals(message)) {
	        return new ResponseEntity<>("Academic Unit not found", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
