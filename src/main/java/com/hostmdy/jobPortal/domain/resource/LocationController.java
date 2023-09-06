package com.hostmdy.jobPortal.domain.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.jobPortal.domain.Location;
import com.hostmdy.jobPortal.service.LocationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {
	
	private final LocationService locationService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody Location location){
		Location savedLocation = locationService.save(location);
		
		return new ResponseEntity<Location>(savedLocation,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findLocationById(@PathVariable Long id){
		Optional<Location> locationOpt = locationService.findLocationId(id);
		
		if(locationOpt.isEmpty())
			return new ResponseEntity<String>("Location not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Location>(locationOpt.get(),HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateLocation(@PathVariable Long id,@RequestBody Location location){
	     Location updatedLocation = locationService.updateLocation(id, location);
	        if (updatedLocation != null) {
	            return ResponseEntity.ok(updatedLocation);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllLocations(){
		List<Location> locationList = locationService.findAll();
		
		if(locationList.isEmpty())
			return new ResponseEntity<String>("no Location found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Location>>(locationList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLocationById(@PathVariable Long id) {
		
		locationService.deleteById(id);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}
	
}
