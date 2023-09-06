package com.hostmdy.jobPortal.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.jobPortal.domain.JobPost;

public interface JobPostRepository extends CrudRepository<JobPost, Long>{

}
