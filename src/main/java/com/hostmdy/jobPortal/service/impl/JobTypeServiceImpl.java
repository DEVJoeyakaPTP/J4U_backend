package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.JobTypes;
import com.hostmdy.jobPortal.domain.Location;
import com.hostmdy.jobPortal.repository.JobTypesRepsitory;
import com.hostmdy.jobPortal.service.JobTypeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobTypeServiceImpl implements JobTypeService{

	private final JobTypesRepsitory jobTypesRepsitory;
	
	@Override
	public Optional<JobTypes> findById(Long id) {
		// TODO Auto-generated method stub
		return jobTypesRepsitory.findById(id);
	}

	@Override
	public List<JobTypes> findAll() {
		// TODO Auto-generated method stub
		return (List<JobTypes>) jobTypesRepsitory.findAll();
	}

	@Override
	public JobTypes save(JobTypes jobTypes) {
		// TODO Auto-generated method stub
		return jobTypesRepsitory.save(jobTypes);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<JobTypes> jobTypeOpt = jobTypesRepsitory.findById(id);
		
		if(jobTypeOpt.isPresent()) {
			JobTypes jobType = jobTypeOpt.get();
			jobType.setJobPosts(null);
			
			JobTypes updatedJobType =jobTypesRepsitory.save(jobType);
			
			jobTypesRepsitory.deleteById(updatedJobType.getId());
		}else 
			System.out.println("$$$$$cannot be deletected by entity");

		jobTypesRepsitory.deleteById(id);
	}

	@Override
	public JobTypes updateJobTypes(Long id, JobTypes jobTypes) {
		// TODO Auto-generated method stub
		JobTypes existingJobType = jobTypesRepsitory.findById(id).orElse(null);
        if (existingJobType != null) {
            // Perform any necessary validation or business logic
            // Update the existing user entity
            existingJobType.setType(jobTypes.getType());
           
            return jobTypesRepsitory.save(existingJobType);
        } else {
            return null;
        }
	}

}
