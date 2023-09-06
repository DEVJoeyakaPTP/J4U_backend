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


import com.hostmdy.jobPortal.domain.Company;
import com.hostmdy.jobPortal.service.CompanyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CompanyController {

	
	private final CompanyService companyService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody Company company){
		Company savedCompany = companyService.save(company);
		
		return new ResponseEntity<Company>(savedCompany,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findCompanyById(@PathVariable Long id){
		Optional<Company> companyOpt = companyService.findCompanyById(id);
		
		if(companyOpt.isEmpty())
			return new ResponseEntity<String>("Company not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Company>(companyOpt.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllProduct(){
		List<Company> companyList = companyService.findCompanies();
		
		if(companyList.isEmpty())
			return new ResponseEntity<String>("no company found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Company>>(companyList,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCompany(@RequestBody Company company){
		
	     Company updatedCompany = companyService.updateCompany(company);
	        if (updatedCompany != null) {
	            return ResponseEntity.ok(updatedCompany);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
		
		companyService.deleteCompanyById(id);
		 
		if(companyService.findCompanyById(id) != null)
			return new ResponseEntity<String>("Can't deleted",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
		
	}
}