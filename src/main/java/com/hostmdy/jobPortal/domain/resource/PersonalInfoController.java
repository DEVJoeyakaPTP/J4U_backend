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

import com.hostmdy.jobPortal.domain.PersonalInfo;
import com.hostmdy.jobPortal.service.PersonalInfoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/info")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PersonalInfoController {
	
	private final PersonalInfoService infoService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody PersonalInfo perInfo){
		PersonalInfo savedPerInfo = infoService.save(perInfo);
		
		return new ResponseEntity<PersonalInfo>(savedPerInfo,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findPerInfoById(@PathVariable Long id){
		Optional<PersonalInfo> perInfoOpt = infoService.findPersonalInfoById(id);
		
		if(perInfoOpt.isEmpty())
			return new ResponseEntity<String>("PerInfo not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<PersonalInfo>(perInfoOpt.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPerInfos(){
		List<PersonalInfo> perInfoList = infoService.findPersonalInfo();
		
		if(perInfoList.isEmpty())
			return new ResponseEntity<String>("no perInfo found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<PersonalInfo>>(perInfoList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePerInfoById(@PathVariable Long id) {
		
		
		infoService.deletePersonalInfoById(id);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}
	
	
}
