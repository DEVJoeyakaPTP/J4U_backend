package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hostmdy.jobPortal.domain.Company;
import com.hostmdy.jobPortal.domain.Location;
import com.hostmdy.jobPortal.repository.LocationRepository;
import com.hostmdy.jobPortal.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{

	private final LocationRepository locationRepository;
	
	@Override
	public Optional<Location> findLocationId(Long id) {
		// TODO Auto-generated method stub
		return locationRepository.findById(id);
	}

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return (List<Location>) locationRepository.findAll();
	}

	@Override
	public Location save(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Location> locationOpt = locationRepository.findById(id);
			
			if(locationOpt.isPresent()) {
				Location location = locationOpt.get();
				location.setJobPosts(null);
				
				Location updatedLocation =locationRepository.save(location);
				
				locationRepository.deleteById(updatedLocation.getId());
			}else 
				System.out.println("$$$$$cannot be deletected by entity");
		locationRepository.deleteById(id);
	}

	@Override
	public Location updateLocation(@PathVariable Long id,Location location) {
		// TODO Auto-generated method stub
		Location existingLocation = locationRepository.findById(id).orElse(null);
        if (existingLocation != null) {
            // Perform any necessary validation or business logic
            // Update the existing user entity
            existingLocation.setName(location.getName());
           
            return locationRepository.save(existingLocation);
        } else {
            return null;
        }
    }
	}


