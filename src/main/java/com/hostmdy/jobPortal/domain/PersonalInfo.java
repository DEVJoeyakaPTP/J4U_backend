package com.hostmdy.jobPortal.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hostmdy.jobPortal.domain.jobenum.Gender;
import com.hostmdy.jobPortal.domain.jobenum.Race;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter  @RequiredArgsConstructor
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nrc;
    private String dateOfBirth;

    private String address;
    private String email;
    private String phone;

    private Race race;
    private Gender gender;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personalInfo")
    @JsonIgnore
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personalInfo")
    @JsonIgnore
    private List<Experiences> experiences = new ArrayList<>();

   

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
