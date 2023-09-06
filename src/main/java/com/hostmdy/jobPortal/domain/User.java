package com.hostmdy.jobPortal.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hostmdy.jobPortal.domain.security.Authority;
import com.hostmdy.jobPortal.domain.security.UserRoles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 369500436365348573L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message ="firstname is required")
	private String firstname;
	
	@NotBlank(message ="lastname is required")
	private String lastname;
	
	@NotBlank(message ="fullname is required")
	private String fullname;
	
	@NotBlank(message ="username is required")
	@Column(updatable = false,nullable = false)
	private String username;
	
	@NotBlank(message ="password is required")
	private String password;
	
	@NotBlank(message ="phone is required")
	private String phone;
	
	private String address;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRoles> userRoles = new HashSet<>();
	
	
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JsonIgnore
//	private JobPost jobPost;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Applications applications;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private PersonalInfo personalInfo;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities = new HashSet<>();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
