package ch.nyp.schnuppertag_software.webcontext.location;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-21
 *
 */

@RestController
@RequestMapping("/location")
public class LocationController {
	
	LocationService locationService;
	
	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Location> getById(@PathVariable Long id){
		Optional<Location> location = locationService.getById(id);
		
		if(location.isPresent()) {
			return new ResponseEntity<>(location.get(), HttpStatus.OK);	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<Location> create(@RequestBody Location location) {
		locationService.save(location);
		
		return new ResponseEntity<>(location, HttpStatus.CREATED);
	}
}
