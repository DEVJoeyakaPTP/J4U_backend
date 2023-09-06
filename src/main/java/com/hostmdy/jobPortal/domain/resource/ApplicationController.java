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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.jobPortal.domain.ApplicationRequest;
import com.hostmdy.jobPortal.domain.Applications;
import com.hostmdy.jobPortal.domain.Education;
import com.hostmdy.jobPortal.domain.Experiences;
import com.hostmdy.jobPortal.domain.JobPost;
import com.hostmdy.jobPortal.domain.PersonalInfo;
import com.hostmdy.jobPortal.domain.User;
import com.hostmdy.jobPortal.domain.jobenum.JobStatus;
import com.hostmdy.jobPortal.service.ApplicationsService;
import com.hostmdy.jobPortal.service.EducationService;
import com.hostmdy.jobPortal.service.ExperienceSevice;
import com.hostmdy.jobPortal.service.JobPostService;
import com.hostmdy.jobPortal.service.PersonalInfoService;
import com.hostmdy.jobPortal.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {
	
	private final ApplicationsService applicationsService;
	private final PersonalInfoService personalInfoService;
	private final EducationService educationService;
	private final ExperienceSevice experienceSevice;
	private final JobPostService jobPostService;
	private final UserService userService;
	
	
//    @PostMapping("/submit")
//    public ResponseEntity<String> submitApplication(@RequestBody ApplicationRequest applicationRequest) {
//        try {
//            PersonalInfo personalInfo = applicationRequest.getPersonalInfo();
//            List<Education> educationList = applicationRequest.getEducationLst();
//            List<Experiences> experienceList = applicationRequest.getExperiencesLst();
//            User user = applicationRequest.getUser();
//            Long jobPostId = applicationRequest.getJobPostId();
//            
//            for (Education education : educationList) {
//                education.setPersonalInfo(personalInfo);
//                personalInfo.getEducations().add(education);
//                educationService.saveEducation(education);
//            }
//            
//            for (Experiences experience : experienceList) {
//                experience.setPersonalInfo(personalInfo);
//                personalInfo.getExperiences().add(experience);
//                experienceSevice.save(experience);
//            }
//            
//            JobPost jobPost = jobPostService.findById(jobPostId).get();
//            
//            Applications application = new Applications();
//            application.setStatus(JobStatus.ACTIVE);
//            application.setUser(user);
//            user.setApplications(application);
//            application.setJobPost(jobPost);
//            jobPost.setApplications(application);
//            applicationsService.save(application);
//            
//            PersonalInfo savedPersonalInfo = personalInfoService.save(personalInfo, user);
//            
//            return ResponseEntity.ok("Application submitted successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit application.");
//        }
//    }
//	
	
	@PostMapping("/submit")
	public ResponseEntity<String> submitApplication(@RequestBody ApplicationRequest applicationRequest) {
	    try {
	        PersonalInfo personalInfo = applicationRequest.getPersonalInfo();
	        System.out.println("Person Info"+personalInfo.toString());
	        List<Education> educationList = applicationRequest.getEducationLst();
	        System.out.println("Educaiton list size is "+educationList.size());
	        List<Experiences> experienceList = applicationRequest.getExperiencesLst();
	        System.out.println("experiecne list size is "+experienceList.size());
	        User user= applicationRequest.getUser();
	        Long jobPostId=applicationRequest.getJobPostId();
	        
	        System.out.println(educationList.size());
	        System.out.println("USER ID IS"+user.getId());
	        System.out.println("jobPost id is"+jobPostId);
	        
	        //save the personal Info
	        PersonalInfo savedPersonalInfo= personalInfoService.save(personalInfo,user);
	        System.out.println("Finished save personal Info");
	        System.out.println("new id of personal info is"+savedPersonalInfo.getId());
	        

	         
	        // Save the education entities
	        for (Education education : educationList) {
	        	System.out.println("in the for each loop for education");
	        	education.setPersonalInfo(personalInfo);
	        	personalInfo.getEducations().add(education);
	            educationService.saveEducation(education);
	        }

	        // Save the experience entities
	        for (Experiences experience : experienceList) {
	        	System.out.println("in the for each loop for experiences");
	        	experience.setPersonalInfo(personalInfo);
	        	personalInfo.getExperiences().add(experience);
	        	experienceSevice.save(experience);
	        }

	        //save Application
	        JobPost jobPost= jobPostService.findById(jobPostId).get();
	        System.out.println("jobpost"+jobPost);
	        Applications application=new Applications();
	        application.setStatus(JobStatus.ACTIVE);
	        Applications savedApplications=applicationsService.save(application);
	        System.out.println("successfully save new applications in db");
	        System.out.println("saved application id is "+savedApplications.getId());
	        applicationsService.save(savedApplications,user,jobPost);
	        
// Save the personal info entity
	        
	        
	        
	        
	        return ResponseEntity.ok("Application submitted successfully!");
	    } catch (Exception e) {
	    	System.out.println("In the catch");
	    	e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit application.");
	    }
	}

	

	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findAppicationById(@PathVariable Long id){
		Optional<Applications> applicationOpt = applicationsService.findById(id);
		
		if(applicationOpt.isEmpty())
			return new ResponseEntity<String>("Application not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Applications>(applicationOpt.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllApplications(){
		List<Applications> applicationList = applicationsService.findApplications();
		
		if(applicationList.isEmpty())
			return new ResponseEntity<String>("no application found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Applications>>(applicationList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteApplicationById(@PathVariable Long id) {
		
		applicationsService.deleteAppById(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}

}
