package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.Applications;
import com.hostmdy.jobPortal.domain.JobPost;
import com.hostmdy.jobPortal.domain.User;
import com.hostmdy.jobPortal.repository.ApplicationsRepository;
import com.hostmdy.jobPortal.service.ApplicationsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationsService{

	private final ApplicationsRepository applicationsRepository;
	
	@Override
	public List<Applications> findApplications() {
		// TODO Auto-generated method stub
		return (List<Applications>) applicationsRepository.findAll();
	}

	@Override
	public Optional<Applications> findById(Long id) {
		// TODO Auto-generated method stub
		return applicationsRepository.findById(id);
	}

	@Override
	public Applications save(Applications applications) {
		// TODO Auto-generated method stub
		return applicationsRepository.save(applications);
	}

	@Override
	public void deleteAppById(Long id) {
		// TODO Auto-generated method stub
		applicationsRepository.deleteById(id);
	}

	@Override
	public Applications save(Applications application, User user, JobPost jobPost) {
		// TODO Auto-generated method stub
		
		application.setUser(user);
       
        application.setJobPost(jobPost);
       
        return applicationsRepository.save(application);
		
	}

}
