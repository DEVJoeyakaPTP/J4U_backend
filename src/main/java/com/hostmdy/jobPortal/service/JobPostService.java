package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.JobPost;

public interface JobPostService {
	
	JobPost save(JobPost jobPost);

	JobPost save(JobPost jobPost, Long companyId, Long jobTypeId, Long categoryId, Long locationId);
	
	Optional<JobPost> findById(Long id);
	
	List<JobPost> findAll();
	
	JobPost updateJobPost(JobPost jobPost, Long companyId, Long jobTypeId, Long categoryId, Long locationId);
	
	void deleteJobPostById(Long id);
	
//	JobPost updateJobPost (Long id, JobPost updatedJobPost);
	
}
