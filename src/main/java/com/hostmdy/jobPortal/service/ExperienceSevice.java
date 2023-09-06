package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.Experiences;

public interface ExperienceSevice {

	List<Experiences> findAll();
	
	Optional<Experiences> findById(Long id);
	
	Experiences save(Experiences experiences);
	
	void saveExp(Experiences experiences);
	
	void deleteById(Long  id);
	
}
