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

import com.hostmdy.jobPortal.domain.Experiences;
import com.hostmdy.jobPortal.service.ExperienceSevice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ExperienceController {
	
	private final ExperienceSevice experienceSevice;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody Experiences experiences){
		Experiences savedExperience = experienceSevice.save(experiences);
		
		return new ResponseEntity<Experiences>(savedExperience,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findExperienceById(@PathVariable Long id){
		Optional<Experiences> experienceOpt = experienceSevice.findById(id);
		
		if(experienceOpt.isEmpty())
			return new ResponseEntity<String>("Experience not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Experiences>(experienceOpt.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getExperiences(){
		List<Experiences> experienceOpt = experienceSevice.findAll();
		
		if(experienceOpt.isEmpty())
			return new ResponseEntity<String>("no experience found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Experiences>>(experienceOpt,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteExperienceById(@PathVariable Long id) {
		
		experienceSevice.deleteById(id);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}

}
