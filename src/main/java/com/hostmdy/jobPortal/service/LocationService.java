package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.Location;

public interface LocationService {

	Optional<Location> findLocationId(Long id);

	List<Location> findAll();
	
	Location save(Location location);
	
	Location updateLocation (Long id,Location location);

	void deleteById(Long id);
	
}
