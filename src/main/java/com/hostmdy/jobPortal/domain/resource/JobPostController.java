package com.hostmdy.jobPortal.domain.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.jobPortal.domain.JobPost;
import com.hostmdy.jobPortal.service.JobPostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobPost")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {

	private final JobPostService jobPostService;
	//${POSTS_URL}/${data.companyId}/${data.jobTypeId}/${data.categoryId}/${data.locationId}
	@PostMapping("/create/{companyId}/{jobTypeId}/{categoryId}/{locationId}")
	public ResponseEntity<?> create(@Valid @RequestBody JobPost jobPost, @PathVariable Long companyId,
			@PathVariable Long jobTypeId,@PathVariable Long categoryId,@PathVariable Long locationId){
		System.out.println("job Post is "+jobPost.getTitle());
		System.out.println("job Post is "+jobPost.getDescriptions());
		JobPost savedJobPost = jobPostService.save(jobPost,companyId,jobTypeId,categoryId,locationId);
		
		return new ResponseEntity<JobPost>(savedJobPost,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{companyId}/{jobTypeId}/{categoryId}/{locationId}")
	public ResponseEntity<?> updateJobPost(@Valid @RequestBody JobPost jobPost, @PathVariable Long companyId,
			@PathVariable Long jobTypeId,@PathVariable Long categoryId,@PathVariable Long locationId){
		
	     JobPost updatedJobPost = jobPostService.updateJobPost(jobPost,companyId,jobTypeId,categoryId,locationId);
	     System.out.println(updatedJobPost);
	        if (updatedJobPost != null) {
	            return ResponseEntity.ok(updatedJobPost);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findJobPostById(@PathVariable Long id){
		Optional<JobPost> jobPostOpt = jobPostService.findById(id);
		
		if(jobPostOpt.isEmpty())
			return new ResponseEntity<String>("JobPost not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<JobPost>(jobPostOpt.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllProduct(){
		List<JobPost> jobPostList = jobPostService.findAll();
		
		if(jobPostList.isEmpty())
			return new ResponseEntity<String>("no jobPost found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<JobPost>>(jobPostList,HttpStatus.OK);
	}
	
	
//	  @PutMapping("/update/{id}")
//	  public ResponseEntity<JobPost> updateJobPost(@PathVariable Long id, @RequestBody JobPost updatedJobPost) {
//	    JobPost updatedPost = jobPostService.updateJobPost(id, updatedJobPost);
//	    return ResponseEntity.ok(updatedPost);
//	  }

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteJobPostById(@PathVariable Long id) {
		
		jobPostService.deleteJobPostById(id);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}
}
