package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.Experiences;
import com.hostmdy.jobPortal.repository.ExperiencesRepository;
import com.hostmdy.jobPortal.service.ExperienceSevice;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceSevice {
	
	private final ExperiencesRepository experiencesRepository;
	
	@Override
	public List<Experiences> findAll() {
		// TODO Auto-generated method stub
		return (List<Experiences>) experiencesRepository.findAll();
	}

	@Override
	public Optional<Experiences> findById(Long id) {
		// TODO Auto-generated method stub
		return experiencesRepository.findById(id);
	}
  
	@Override
	public Experiences save(Experiences experiences) {
		// TODO Auto-generated method stub
		return experiencesRepository.save(experiences);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		experiencesRepository.deleteById(id);
	}

	@Override
	public void saveExp(Experiences experiences) {
		// TODO Auto-generated method stub
		
	}

}
