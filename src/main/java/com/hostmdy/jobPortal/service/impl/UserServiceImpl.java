package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.User;
import com.hostmdy.jobPortal.domain.security.UserRoles;
import com.hostmdy.jobPortal.exception.UsernameAlreadyExistsException;
import com.hostmdy.jobPortal.repository.RoleRepository;
import com.hostmdy.jobPortal.repository.UserRepository;
import com.hostmdy.jobPortal.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public User createUser(User user,Set<UserRoles> userRoles) throws UsernameAlreadyExistsException{
		// TODO Auto-generated method stub
		
		Optional< User> userOpt = findByUsername(user.getUsername());
		
		if(userOpt.isPresent()) {
			throw new UsernameAlreadyExistsException("Username Already Exists!");
		}
		
	    userRoles.forEach(ur -> roleRepository.save(ur.getRole()));
		
		user.getUserRoles().addAll(userRoles); //user and userRoles association
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return saveUser(user);
	}

	@Override
	public Optional<User> findbyId(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		 Optional<User> userOpt = userRepository.findById(id);
			
			if(userOpt.isPresent()) {
				User user = userOpt.get();
	
				
				User updatedUser =userRepository.save(user);
				
				userRepository.deleteById(updatedUser.getId());
			}else 
				System.out.println("$$$$$cannot be deletected by entity");
		userRepository.deleteById(id);
	}

}
