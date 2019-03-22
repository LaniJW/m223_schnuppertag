package ch.nyp.schnuppertag_software.webcontext.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.nyp.schnuppertag_software.webcontext.location.dto.LocationDTO;
import ch.nyp.schnuppertag_software.webcontext.location.dto.LocationMapper;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-22
 *
 */

@RestController
@RequestMapping("/locations")
public class LocationController {
	LocationService locationService;
	LocationMapper locationMapper;
	
	@Autowired
	public LocationController(LocationService locationService, LocationMapper locationMapper) {
		this.locationService = locationService;
		this.locationMapper = locationMapper;
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<LocationDTO> getById(@PathVariable Long id){
		Optional<Location> location = locationService.getById(id);
		
		if(location.isPresent()) {
			return new ResponseEntity<>(locationMapper.toDTO(location.get()), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<Location> create(@RequestBody Location location) {
		locationService.save(location);
		
		return new ResponseEntity<>(location, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Location> update(@RequestBody Location location, @PathVariable Long id) {
		locationService.updateById(location, id);
		
		return new ResponseEntity<>(location, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Location> deleteById(@PathVariable Long id) {
		Optional<Location> location = locationService.getById(id);
		
		if(location.isPresent()) {
			locationService.deleteById(id);
			return new ResponseEntity<>(location.get(), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<Location>> getAll(){
		List<Location> locations = locationService.getAll();
		
		return new ResponseEntity<>(locations, HttpStatus.OK);	
	
	}
}
