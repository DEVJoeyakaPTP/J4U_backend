package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.JobTypes;

public interface JobTypeService {

	
	Optional<JobTypes> findById(Long id);

	List<JobTypes> findAll();
	
	JobTypes save(JobTypes jobTypes);
	
	JobTypes updateJobTypes(Long id,JobTypes jobTypes);

	void deleteById(Long id);

}
