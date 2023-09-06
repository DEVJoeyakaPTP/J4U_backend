package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.Education;

public interface EducationService {

	List<Education> findAll();
	
	Optional<Education> findById(Long id);
	
	Education saveEducation(Education education);
	
	void deleteById(Long id);
	
	void save(Education education);
	
	
}
