package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.PersonalInfo;
import com.hostmdy.jobPortal.domain.User;
import com.hostmdy.jobPortal.repository.PersonalInfoRepository;
import com.hostmdy.jobPortal.repository.UserRepository;
import com.hostmdy.jobPortal.service.PersonalInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements PersonalInfoService {

	private final PersonalInfoRepository infoRepository;
	private final UserRepository userRepository;
	
	@Override
	public List<PersonalInfo> findPersonalInfo() {
		// TODO Auto-generated method stub
		return (List<PersonalInfo>) infoRepository.findAll();
	}

	@Override
	public Optional<PersonalInfo> findPersonalInfoById(Long id) {
		// TODO Auto-generated method stub
		return infoRepository.findById(id);
	}

	@Override
	public PersonalInfo save(PersonalInfo personalInfo,User user) {
		// TODO Auto-generated method stub
		
		
		personalInfo.setUser(user);
		System.out.println(personalInfo.getUser().getId());
		
//		user.setPersonalInfo(personalInfo);
//		userRepository.save(user);
//		System.out.println("save personal info to user");
		
		
		return infoRepository.save(personalInfo);
	}

	@Override
	public void deletePersonalInfoById(Long id) {
		// TODO Auto-generated method stub
		infoRepository.deleteById(id);
	}

	@Override
	public PersonalInfo save(PersonalInfo personalInfo) {
		// TODO Auto-generated method stub
		return infoRepository.save(personalInfo);
	}

}
