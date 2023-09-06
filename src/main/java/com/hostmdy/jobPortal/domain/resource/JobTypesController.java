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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.jobPortal.domain.JobTypes;
import com.hostmdy.jobPortal.service.JobTypeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobTypes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class JobTypesController {

	
	private final JobTypeService jobTypesService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody JobTypes jobTypes){
		JobTypes savedJobTypes = jobTypesService.save(jobTypes);
		
		return new ResponseEntity<JobTypes>(savedJobTypes,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findJobTypesById(@PathVariable Long id){
		Optional<JobTypes> jobTypesOpt = jobTypesService.findById(id);
		
		if(jobTypesOpt.isEmpty())
			return new ResponseEntity<String>("JobTypes not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<JobTypes>(jobTypesOpt.get(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateJobType(@PathVariable Long id,@RequestBody JobTypes jobTypes){
	     JobTypes updatedJobTypes = jobTypesService.updateJobTypes(id, jobTypes);
	        if (updatedJobTypes != null) {
	            return ResponseEntity.ok(updatedJobTypes);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllJobTypes(){
		List<JobTypes> jobTypesList = jobTypesService.findAll();
		
		if(jobTypesList.isEmpty())
			return new ResponseEntity<String>("no jobTypes found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<JobTypes>>(jobTypesList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		
		jobTypesService.deleteById(id);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}
	
}
