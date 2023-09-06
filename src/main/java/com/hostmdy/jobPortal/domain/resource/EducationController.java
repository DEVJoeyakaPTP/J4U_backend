package com.hostmdy.jobPortal.domain.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.jobPortal.domain.Education;
import com.hostmdy.jobPortal.service.EducationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class EducationController {

	private final EducationService educationService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody Education education){
		Education savedEducation = educationService.saveEducation(education);
		
		return new ResponseEntity<Education>(savedEducation,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findEducationById(@PathVariable Long id){
		Optional<Education> educationOpt = educationService.findById(id);
		
		if(educationOpt.isEmpty())
			return new ResponseEntity<String>("Education not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Education>(educationOpt.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		List<Education> educationList = educationService.findAll();
		
		if(educationList.isEmpty())
			return new ResponseEntity<String>("no education found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Education>>(educationList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEducationById(@PathVariable Long id) {
		
		educationService.deleteById(id);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}
	
}
