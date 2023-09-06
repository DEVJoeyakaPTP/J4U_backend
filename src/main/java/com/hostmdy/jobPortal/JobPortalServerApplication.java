package com.hostmdy.jobPortal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hostmdy.jobPortal.domain.Category;
import com.hostmdy.jobPortal.domain.Company;
import com.hostmdy.jobPortal.domain.JobPost;
import com.hostmdy.jobPortal.domain.JobTypes;
import com.hostmdy.jobPortal.domain.Location;
import com.hostmdy.jobPortal.domain.User;
import com.hostmdy.jobPortal.domain.jobenum.JobStatus;
import com.hostmdy.jobPortal.domain.security.Role;
import com.hostmdy.jobPortal.domain.security.UserRoles;
import com.hostmdy.jobPortal.service.CategorySevice;
import com.hostmdy.jobPortal.service.CompanyService;
import com.hostmdy.jobPortal.service.JobPostService;
import com.hostmdy.jobPortal.service.JobTypeService;
import com.hostmdy.jobPortal.service.LocationService;
import com.hostmdy.jobPortal.service.RoleService;
import com.hostmdy.jobPortal.service.UserService;

@SpringBootApplication
public class JobPortalServerApplication implements CommandLineRunner{

	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	JobTypeService jobTypesService;
	
	@Autowired
	CategorySevice categorySevice;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	JobPostService jobPostService;
	
	public static void main(String[] args) {
		SpringApplication.run(JobPortalServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		

//		Role role1 = new Role();
//		role1.setId(1L);
//		role1.setName("ROLE_USER");
//		
//		User user1 = new User();
//		user1.setFirstname("Mg");
//		user1.setLastname("Htun");
//		user1.setFullname("Mg Htun 007");
//		user1.setUsername("htun007@gmail.com");
//		user1.setPassword(passwordEncoder.encode("1234"));
//		user1.setPhone("090909090");
//		user1.setAddress("Mandalay,Myanmar");
//		
//		Set<UserRoles> userRoles1 =new HashSet<>();
//		userRoles1.add(new UserRoles(user1,role1));
//		userService.createUser(user1,userRoles1);
//		
//		Role role2 = new Role();
//		role2.setId(2L);
//		role2.setName("ROLE_ADMIN");
//		
//		User user2 = new User();
//		user2.setFirstname("Htun");
//		user2.setLastname("Yar Zar");
//		user2.setFullname("Htun Yar Zar 80");
//		user2.setUsername("hyz@gmail.com");
//		user2.setPassword(passwordEncoder.encode("admin1234"));
//		user2.setPhone("0987878721");
//		user2.setAddress("Mandalay,Myanmar");
//		
//		Set<UserRoles> userRoles2 =new HashSet<>();
//		userRoles2.add(new UserRoles(user2,role2));
//		userService.createUser(user2,userRoles2);
//		
//	
		

//		
//		JobTypes jobTypes1 = new JobTypes();
//		jobTypes1.setType("Part Time");
//		jobTypesService.save(jobTypes1);
//		
//		JobTypes jobTypes2 = new JobTypes();
//		jobTypes2.setType("Full Time");
//		jobTypesService.save(jobTypes2);
//		
//		JobTypes jobTypes3 = new JobTypes();
//		jobTypes3.setType("Remote");
//		jobTypesService.save(jobTypes3);
//		
//		Category category1 = new Category();
//		category1.setName("CustomerService");
//		categorySevice.save(category1);
//		
//		Category category3 = new Category();
//		category3.setName("Office Staff");
//		categorySevice.save(category3);
//		
//		Category category2 = new Category();
//		category2.setName("Human Resource");
//		categorySevice.save(category2);
//		
//		Category category4 = new Category();
//		category4.setName("Chef");
//		categorySevice.save(category4);
//		
//		Location location1 = new Location();
//		location1.setName("Mandalay");
//		locationService.save(location1);
//		
//		Location location2 = new Location();
//		location2.setName("Yangon");
//		locationService.save(location2);
//		
//		Location location3 = new Location();
//		location3.setName("Bagan");
//		locationService.save(location3);
//		
//		Location location4 = new Location();
//	
//		location4.setName("Pyay");
//		locationService.save(location4);
//		
//		Location location5 = new Location();
//		location5.setName("Taunggyi");
//		locationService.save(location5);
//		
//		Company company1 = new Company();
//		company1.setName("AnyCall");
//		company1.setLocation(location1);
//		company1.setEmail("anycall@gmail.com");
//		company1.setAddress("Mandalay");
//		company1.setPhone("0909090909");
//		company1.setDescription("This is description");
//		company1.setLogo("data:image/png;base64,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");
//		company1.setJobOpening(567L);
//        companyService.save(company1);
//        
//        Company company2 = new Company();
//        company2.setName("Isure");
//        company2.setEmail("isure@gmail.com");
//        company2.setAddress("Mandalay");
//        company2.setPhone("0909090909");
//        company2.setLocation(location2);
//        company2.setDescription("This is description");
//        company2.setLogo("data:image/png;base64,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");
//        company2.setJobOpening(222L);
//        companyService.save(company2);
//        
//        Company company3 = new Company();
//        company3.setName("Atom Myanmar");
//        company3.setEmail("atom@gmail.com");
//        company3.setAddress("Yangon");
//        company3.setLocation(location3);
//        company3.setPhone("0945665445");
//        company3.setDescription("This is description");
//        company3.setLogo("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABMlBMVEX///8NIaEAyP8Aqv8tMfqQlc0TJqMAAJsACJwAyv8HHqAAw/8AHKAAp/8AAJgAxf+an9AlL6M0Qar19/yprtjDyOYAsf8ArP8AsP8AEp3n6fZIUbGpqtEAEJ4AtP8AF58vJfoAuf8AAPkAv//l5v5Dzf/w/P8wH/kuK/rq6/VNU66f5P+9vf16fPuur/wME/lp1P9FSPo5PPrj9v8Ln/4dePwqQ/olWvve3+/T8f+BhsQrNqbJy+R1er5/g8KipdFgZ7dWXrViZPrGx/102P/Pz/2JivtzdPqhovxsbfuTlPxYWvrc3P4kXPvE7v8hZfsfb/wbgfwXjP2cnfwSlP3F7/+n4//U1f0mLeMoT/oiK9UcKMUXJbUMPq4LSrQKVbsJZ8gHfNgGit4KZcUIeNVrcr14CyXGAAAMcUlEQVR4nO2da2PTRhaGLd9GKEaxowSQHSEvGxI70IbSAiZXpwnQLlC6227b7KXtdjf//y+sFN+kOWdGR/YwHrV+P4ZBnkczmst7zkil0kfRzuun1S8vssu9vLx16/Llx6nDR9Wrg2612nvwOqvco7VypLVHOuqkVBcH1RsdfCIvNwIsl9eLhvj4QbVKQbwcA0ateKmrbkr06RQwQnwjLne5Xp5qvUiIXx1UEzr4WlQuCVgoxL+kAKvVvbd4uScpwAIhvuYAq9XuZx5SjgeMEJ9or+w8goAxYhuUg4AFQfwEAYwQn/KIGGAhEN+ggNHc3+unyj1EASPEh0uqOFUiwAixuzMrtlsWAMaIu8urfra+FgLGrThF3L0lBIwQbxmM+OWeGDBC3Bsj7orxRjIV0bvqygAjxIN3cbnPJQ1oNGL7swzAGPEVCbBc/nzZNIjazzMBIx1c7FIAy+vmIfZ7PQJgtft87RaF0DzEnT0a4NX923+iIa6Zte3fIbbg+zuVChVx/ZtlUyW00yUB7sWAdMQ1cxB3DmiAH+5XbnT7PhHxh2WTjfVKspBJdtFvx4A5EM0wby5ogHvP7lQqhUR8PAdghHinMIifEgH/mgKMEO8VBPEr4jPIAxYG8TtiC/4NAEa6S0Rcpj9FBryHAJIRl2jB8a6hqIt+jwNGiGUS49LMm4UBIxmNiLmGGOAXEsBKZZ2GuAx/CncNgXpyQIMRxaYaB3hXDli5TUTU7U89fpBNF3fRZ9g0wSHS9sTrZb2EbyiWRfwQZjUhHbFcxoIfH01vSfulavc2gbBy+8/EiVFnR30tdUZnhN9TCOmIGs2bHeJA8+J+Np+hiMRNE2WoyYWo0Z96RbQuviUiUs2bv+tD/JFmICpH1OhPvSN6pB/UIup0GYkmYvc9EZFq3mhE7BMRrxQjanQZ21Ui4j3avPgHQKRacBoRvaekFWrvORHRQH/Kyw6MjhDvkhArVESN5o33lrRG7T0nrcLJiDr9KSriUyIi1YLTad7IkkwSiD0iItWf0uls0EybXjXLtJm0ooGINOONjGiiP6XGW/w9IO7J/OGEqBacTkQVFnhSRAtOZ6Lfd0SHURCnAa1oICIxmCgKRc2JqNW8mTcgLEIssD+lGLGs0Z+6oD2Le88Uu4waEX9ckgWnEZHoT6lGXNfoMr4jPosfiB2ViqixFYlpbl2q42+gBUfNxXyh2J/SiUj0p1Qj6rTgiK14dWflT+VENNC8eV75/ftTREQTU8SIiFViR6UONzpz/GkJG70qJWEjQjSwEfs/UYMaFMIviPsMjTZq/8j5idKGV8RuSmxDfTNGOwitejZi90rt+nRN23Z4EDYsy6r/IwvwRVEDxCPATMTue6JnYx4gGwFGiP+UASreQumbKgauY1nZiMXdIx6zGWAkEaLyfb4+QDcFKGrFPcUZYfq66BYHGCH+SwOgPtd007WAEETlnqk2wCYCiCCSrX3jAGsoYKQ04oHq2IW28MyhCNCyGskuWtgo4iETAiYRe9QYonGApzJAy3ImLVjYUPeJHDBSPkDjMjKyAWNE6pbewINt1wTAGLGwgOckwEZdberXmjZAr2NTAMMWMUPROO+wvxGQAP+tOAVTmyfTP/JVApoXpvCskAaoOA6jLdTU9xvZeJbl/6w4IqoP0KEB/lJUU43agr8UNaY9M9XUABp3+umYCPirYlNNG+CWSwJ0fy3qET3oOeGA/yvqMctNGqD9n6Kaamdix+JjAi7bVINd9DfFgNo8JzKgWlNN32sHiIC+WkCNjsUxDbDxX+I8aJznVDoh7Qctn2hZmAdY6pBmesuneRYGApZOiW34G4HQPM8pFvE5DAnPoZmAOcbSrNnwLgVvKa80UzThG5hzOBVx0SZFNM9zSgkL9iKSrEuNfwMmdW8h2jwZD5hjf4iOqIV4TeuxPf8evxCAcfITzaeB8yLZsVj265LbtFYEXpt5pppQfZ9k6XOGsHmek0R9WtTC//lOfkCdx7Uk6oe0wMwsbmGe55Qhr06MPY2PORn5FkG5vFwBUvM8J4KIQe5GjFhIwAhxn4bYoptqZgFGGpJyMfz6QxKekZ9EouTThFZ/V/S1rhSgmZ+1ys6JigBLJQKioYDZiH59ZFhnIRr8eTl5bmJwNHHk8e/mFQBQnl9qd2Yhh0vZd9fM/pKlMAk6BShDNBxQbMGxYbqcCNF4QJEFx675cjhiAQBxC46dwHKzjx3PVJDPHkN/ip1i5R4BxKV/VIYq7mCXABAiFgYwTpRKIrJDUbkfUohL95zyKHn+0K2Jy32TQDTAc8qjWbqbDDCJaNjXALM1aNw4G457Ji/3cjxpGOI55dGgzsKG7W5mlXu5HjGuFxAw0tl5pwY/xw20++jJk0eG7pZWWmmllVZaaaWVVlpppZVWWmmllVZaaaWVmjVenLN7BgqQJD48OBhsRddsbh4PZAcM4RWh47wFCyFXcm1OLEwX2GB8CYpc3CBub+8f2S6LLsmYy+obh8ciwgD8LIgabIK62za80DZMqWDpXyWeXePkI4TedstlYeJyTiNg7HSAEtbh2QC3yQEivwsvtA/zRYN0nFoVoVez0XcWBO4QY0QI04jbaBYBuE7bhxdyWqnnQxHhpsVEJzZ89xo+kRhhMn6HA0LCTSzvx011UyWE/X0hX6zA3yIRzqLoolQXQIh00qh2qXwRFYTHbkbytOPyCQA44SSXRZiuxAO28YIs2WkUEFLOvrENEuEoH0n8zkaesIknp7nJPrM4oTg/LKlgI/Uwiggtdu5JMiN5wiO89uG5SkLiAU3LTyEKCa0wlCTTc4AD0W+7id9alHCLCGhZdvLGigml4jupKCedJVZICxIOpINoWslkDjWEwquE+8oIO6QjKGO5g+y6yZUGPBY/sHZbEaFgLBOo0VJLeCh+YtmZGkKP/BDyv6uC0BOMpLES3XQhQuILGaZyLE8hofRlCbPdTyd0eCE149QI2tImRC8Sa9qIKgilLy2xp8PaeQsI/vgRX6TeFj+FIbNbrQazMQbHUkfoiW7jjRpH03K84CTT2EBKxdpAenjDHW4NPK99fOhgk9Vk2a+AMGMmdvGN6U3LIISoBkgT2kfTC3unSBWCmjLCa/mLSG1xKiWZEOmk9jBZANm8TSYMBYQZ47jTWJwQ3sSQK3kGEUdjlALCraypmAlNIjIhfAwZ3/fhXDT+3cUJz7NWU4EgKZ1O6IGb6A/5MnDKYltqCPuIQcNV+0hkZ5IJYe1hvwj5eowHgIUJUYMmLVfUTamE0EGw4QB9zfelsdW3MCHopA7otQFy+iUXIdh+Ok4fFDrlR6OxSwQJG3zJsAHvwvS6fdCEAfCGnVDQTecmtELoE59QCdkmd/446CCj5ayS/L81OiWwGHOBxZePsE95DsF4GxyKCNNHrO19bNEyvS4YpKMVL9hMwZEvHyEcaewmXwa5C2dCwuQR6whQRohct40M3O6ChBZfSzg+18DaVDQf3jgr15M6snh7JyGEdexEfw3Qi85PWBqC0YtxjYgYtuNFAU5YGi9lR6c4JYT4fwf3M2nXzEOImAjpZ9uDqx7HkVVxbL6ODzmKCeEgd2Mfwj8HcHTPQ4jtsZNHawYbcPU/8WpFhLGBPgkBiAlhY41GaDj+oN2UTNjHpm12Ph5QvRpDVo5sO4OwtD01HcWEwKAJh3Gwu7kP/o52UzIhvkMLXfuk2axtuKjHMDGjxYSl6cJISIi4iOFNiBjuyBkWrKYTCvxKx7ftADe4/MlCSkI4lZAwhwHGj305CUWBEbGm1sIihB7iJIl0M4ssQEgPWow0W2QsQkh85epIWE5FDsLSPumjLTOM6TO2CCFYzcsE11n5CDEzSgI4Oym9CGGujjOZgOclzBW4mFmYCxFmGjRpIfvgXISlIXlcc5KPxAKEcLEoVQCP2OcjLLWIP+ikbub8hB7pTV2J2h+BC+ck9IiI6SXr/IRImpdccNeakzBCJHRUh9tvz0+Y6SLygnZNXsKSt595W33eSZ2bMNtF5MUlgc1DGO955Isbts/Pu3MTQhfRZ2mBNgZ2zRyEpeOWJGPBd+GsOzch6KTByXZaYKz1+W46D2G0r8NTE6NluDtEtqHzEkKDBkTR4H6At2vmIyx5Z9GGia93yBrXaBxvXkIwkiKVA7FZxnVTaEWSCCMdn7RcZoc3sdk4fdZlw03URpifsGPV0wq2wf+rhVyZxnm6QDPgClhUwkj9zeZ1p1WvtzbOa2eSTO86X1MbIWR1Xv8H7ljYylm+hUMAAAAASUVORK5CYII=");
//        company3.setJobOpening(20L);
//        companyService.save(company3);
//        
//        Company company4 = new Company();
//        company4.setName("Golden Duck");
//        company4.setEmail("gd@gmail.com");
//        company4.setAddress("Yangon");
//       company4.setLocation(location5);
//        company4.setPhone("0945665445");
//        company4.setDescription("This is description");
//        company4.setLogo("data:image/png;base64,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");
//        company4.setJobOpening(50L);
//        companyService.save(company4);
//		
//		JobPost jobPost1 = new JobPost();
//		jobPost1.setTitle("GM");
//		jobPost1.setDescriptions("This is Description");
//		jobPost1.setRequirement("This is Requirements");
//		jobPost1.setJobStatus(JobStatus.ACTIVE);;
//		jobPost1.setCompany(company1);
//		jobPost1.setJobTypes(jobTypes1);
//		jobPost1.setCategory(category1);
//		jobPost1.setLocation(location1);
//		jobPost1.setPublishedOn(LocalDate.now());
//		jobPost1.setDeadLine(LocalDate.MAX);
//		jobPost1.setVancy(123L);
//		jobPost1.setSalary("123321-123321 Kyats");
//		jobPost1.setSkills("BLa Bla");
//		jobPostService.save(jobPost1);	
//		
//		JobPost jobPost2 = new JobPost();
//		jobPost2.setTitle("Manager");
//		jobPost2.setDescriptions("This is Description");
//		jobPost2.setRequirement("This is Requirements");
//		jobPost2.setJobStatus(JobStatus.ACTIVE);;
//		jobPost2.setCompany(company2);
//		jobPost2.setJobTypes(jobTypes2);
//		jobPost2.setCategory(category2);
//		jobPost2.setLocation(location2);
//		jobPost2.setPublishedOn(LocalDate.now());
//		jobPost2.setDeadLine(LocalDate.now());
//		jobPost2.setVancy(123L);
//		jobPost2.setSalary("8000000 Kyats");
//		jobPost2.setSkills("Skills are bla");
//		jobPostService.save(jobPost2);	
//
//		JobPost jobPost3 = new JobPost();
//		jobPost3.setTitle("Office Staff");
//		jobPost3.setDescriptions("This is Description");
//		jobPost3.setRequirement("This is Requirements");
//		jobPost3.setJobStatus(JobStatus.ACTIVE);;
//		jobPost3.setCompany(company3);
//		jobPost3.setJobTypes(jobTypes3);
//		jobPost3.setCategory(category2);
//		jobPost3.setLocation(location4);
//		jobPost3.setPublishedOn(LocalDate.now());
//		jobPost3.setDeadLine(LocalDate.MAX);
//		jobPost3.setVancy(13L);
//		jobPost3.setSalary("700000 Kyats");
//		jobPost3.setSkills("Skill is Bla");
//		jobPostService.save(jobPost3);
//		
//		JobPost jobPost4 = new JobPost();
//		jobPost4.setTitle("HR");
//		jobPost4.setDescriptions("This is Description");
//		jobPost4.setRequirement("This is Requirements");
//		jobPost4.setJobStatus(JobStatus.ACTIVE);;
//		jobPost4.setCompany(company4);
//		jobPost4.setJobTypes(jobTypes3);
//		jobPost4.setCategory(category2);
//		jobPost4.setLocation(location4);
//		jobPost4.setPublishedOn(LocalDate.now());
//		jobPost4.setDeadLine(LocalDate.MAX);
//		jobPost4.setVancy(3L);
//		jobPost4.setSalary("400000 Kyats");
//		jobPost4.setSkills("Skill is Bla");
//		jobPostService.save(jobPost4);
//		
		
	}

}
