package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.hostmdy.jobPortal.domain.User;
import com.hostmdy.jobPortal.domain.security.UserRoles;

public interface UserService {

	Optional<User> findByUsername(String username);

	User saveUser(User user);

	User createUser(User user,Set<UserRoles> userRoles);

	Optional<User> findbyId(Long id);
	
	List<User> findAll();
	
	void deleteById(Long id);


}
