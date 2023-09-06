package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.Education;
import com.hostmdy.jobPortal.domain.PersonalInfo;
import com.hostmdy.jobPortal.repository.EducationRepository;
import com.hostmdy.jobPortal.repository.PersonalInfoRepository;
import com.hostmdy.jobPortal.service.EducationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EducaitonServiceImpl implements EducationService{

	private final EducationRepository educationRepository;
	private final PersonalInfoRepository personalInfoRepository;
	
	@Override
	public List<Education> findAll() {
		// TODO Auto-generated method stub
		return (List<Education>) educationRepository.findAll();
	}

	@Override
	public Optional<Education> findById(Long id) {
		// TODO Auto-generated method stub
		return educationRepository.findById(id);
	}

	@Override
    public void save(Education education) {
        PersonalInfo personalInfo = education.getPersonalInfo();
        
        // Save the PersonalInfo entity first
        personalInfo = personalInfoRepository.save(personalInfo);
        
        // Set the updated PersonalInfo entity in the Education object
        education.setPersonalInfo(personalInfo);
        
        // Save the Education entity
        educationRepository.save(education);
    }

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		educationRepository.deleteById(id);
	}

	@Override
	public Education saveEducation(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

}
