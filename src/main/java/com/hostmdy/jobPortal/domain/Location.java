package com.hostmdy.jobPortal.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hostmdy.jobPortal.domain.jobenum.City;
import com.hostmdy.jobPortal.domain.jobenum.Country;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String  name;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
	@JsonIgnore
	List<JobPost> jobPosts = new ArrayList<>();

	@OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Company> Companies = new ArrayList<>();
	

	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
