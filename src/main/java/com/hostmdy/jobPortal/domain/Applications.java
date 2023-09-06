package com.hostmdy.jobPortal.domain;

import java.time.LocalDateTime;

import com.hostmdy.jobPortal.domain.jobenum.JobStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter @NoArgsConstructor
public class Applications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private JobStatus status;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private JobPost jobPost;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private User user;
	
	
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
}
