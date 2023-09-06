package com.hostmdy.jobPortal.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hostmdy.jobPortal.domain.jobenum.JobStatus;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(columnDefinition = "Text")
	private String title;
	
	@Lob
	  @Column(columnDefinition = "Text")
	private String descriptions;
	
	@Enumerated(value = EnumType.STRING)
	private JobStatus jobStatus;
	
	@Lob
	  @Column(columnDefinition = "Text")
	private String requirement;
	
	@Lob
	  @Column(columnDefinition = "Text")
	private String skills;
	
	private String salary;
	private LocalDate publishedOn;
	private LocalDate deadLine;
	private Long vancy;
	
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = " category_id")
	private Category category;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = " job_types_id,")
	private JobTypes jobTypes;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = "location_id")
	private Location location;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="company_id")
	private Company company;

	@OneToOne(mappedBy = "jobPost")
	@JsonIgnore
	private Applications applications;
	
	
	
//	@OneToOne(mappedBy = "jobPost")
//	@JsonIgnore
//	private User user;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
}
