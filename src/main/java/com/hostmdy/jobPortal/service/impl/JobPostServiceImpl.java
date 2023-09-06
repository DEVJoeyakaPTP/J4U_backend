package com.hostmdy.jobPortal.service.impl;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.Category;
import com.hostmdy.jobPortal.domain.Company;
import com.hostmdy.jobPortal.domain.JobPost;
import com.hostmdy.jobPortal.domain.JobTypes;
import com.hostmdy.jobPortal.domain.Location;
import com.hostmdy.jobPortal.repository.CategoryRepository;
import com.hostmdy.jobPortal.repository.CompanyRepsitory;
import com.hostmdy.jobPortal.repository.JobPostRepository;
import com.hostmdy.jobPortal.repository.JobTypesRepsitory;
import com.hostmdy.jobPortal.repository.LocationRepository;
import com.hostmdy.jobPortal.service.JobPostService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPostServiceImpl implements JobPostService {

	private final JobPostRepository jobPostRepository;
	private final CompanyRepsitory companyRepsitory;
	private final JobTypesRepsitory jobTypesRepsitory;
	private final CategoryRepository categoryRepository;
	private final LocationRepository locationRepository;

	@Override
	public JobPost save(JobPost jobPost) {
		// TODO Auto-generated method stub
		return jobPostRepository.save(jobPost);
	}

	@Override
	public JobPost save(JobPost jobPost, Long companyId, Long jobTypeId, Long categoryId, Long locationId) {
		// TODO Auto-generated method stub
		Company company = companyRepsitory.findById(companyId).get();
		JobTypes jobTypes = jobTypesRepsitory.findById(jobTypeId).get();
		Category category = categoryRepository.findById(categoryId).get();
		Location location = locationRepository.findById(locationId).get();
		jobPost.setCompany(company);
		jobPost.setJobTypes(jobTypes);
		jobPost.setCategory(category);
		jobPost.setLocation(location);
		return jobPostRepository.save(jobPost);
	}

	@Override
	public Optional<JobPost> findById(Long id) {
		// TODO Auto-generated method stub
		return jobPostRepository.findById(id);
	}

	@Override
	public List<JobPost> findAll() {
		// TODO Auto-generated method stub
		return (List<JobPost>) jobPostRepository.findAll();
	}

	@Override
	public void deleteJobPostById(Long id) {
	Optional<JobPost> jobPostOpt = jobPostRepository.findById(id);
		
		if(jobPostOpt.isPresent()) {
			JobPost jobPost = jobPostOpt.get();
			jobPost.setCompany(null);
			jobPost.setJobTypes(null);
			jobPost.setCategory(null);
			jobPost.setLocation(null);
			
			
			JobPost updatedJobPost =jobPostRepository.save(jobPost);
			System.out.println("Deleted"+updatedJobPost);
			
			jobPostRepository.deleteById(updatedJobPost.getId());
		}else 
			System.out.println("$$$$$cannot be deletected by entity");
		
		jobPostRepository.deleteById(id);
	}

	


	@Override
	public JobPost updateJobPost(JobPost jobPost, Long companyId, Long jobTypeId, Long categoryId, Long locationId) {
		// TODO Auto-generated method stub
		JobPost existingJobPost = jobPostRepository.findById(jobPost.getId()).orElse(null);
		Company company = companyRepsitory.findById(companyId).get();
		JobTypes jobTypes = jobTypesRepsitory.findById(jobTypeId).get();
		Category category = categoryRepository.findById(categoryId).get();
		Location location = locationRepository.findById(locationId).get();
		existingJobPost.setTitle(jobPost.getTitle());
		existingJobPost.setDescriptions(jobPost.getDescriptions());
		existingJobPost.setRequirement(jobPost.getRequirement());
		existingJobPost.setSalary(jobPost.getSalary());
		existingJobPost.setDeadLine(jobPost.getDeadLine());
		existingJobPost.setPublishedOn(jobPost.getPublishedOn());
		existingJobPost.setJobTypes(jobTypes);
		existingJobPost.setCategory(category);
		existingJobPost.setLocation(location);
		existingJobPost.setCompany(company);
		existingJobPost.setSkills(jobPost.getSkills());

		return jobPostRepository.save(existingJobPost);

	}



}
