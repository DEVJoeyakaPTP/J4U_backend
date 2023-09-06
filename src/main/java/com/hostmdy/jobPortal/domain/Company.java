package com.hostmdy.jobPortal.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class Company {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(columnDefinition = "Text")
	private String name;
	
	@Lob
	@Column(columnDefinition = "Text")
	private String logo;
	
	private String email;
	
	@Lob
	@Column(columnDefinition = "Text")
	private String address;
	
	@Lob
	@Column(columnDefinition = "Text")
	private String phone;
	
	
	private Long jobOpening;
	
	@Lob
	@Column(columnDefinition = "Text")
	private String description;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<JobPost> jobPosts= new ArrayList<>();

	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = "location_id")
	private Location location;

	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	public void forEach(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}
