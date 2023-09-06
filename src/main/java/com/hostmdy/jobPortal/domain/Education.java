package com.hostmdy.jobPortal.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String highSchoolName;
	private String degreeName;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	  @ManyToOne
	    @JoinColumn(name = "personal_info_id")
	    private PersonalInfo personalInfo;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
}
