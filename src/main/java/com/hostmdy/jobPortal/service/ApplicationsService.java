package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.Applications;
import com.hostmdy.jobPortal.domain.JobPost;
import com.hostmdy.jobPortal.domain.User;

public interface ApplicationsService {

	List<Applications> findApplications();
	
	Optional<Applications> findById(Long id);
	
	Applications save(Applications applications);
	
	void deleteAppById(Long id);

	Applications save(Applications application, User user, JobPost jobPost);
}
