package ch.nyp.schnuppertag_software.webcontext.location;

import java.util.List;
import java.util.Optional;

import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressDTO;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressWIDDTO;
import ch.nyp.schnuppertag_software.webcontext.location.dto.LocationWIDDTO;
import ch.nyp.schnuppertag_software.webcontext.location.dto.LocationWIDDTOMapper;
import io.swagger.annotations.ApiOperation;
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
 * @since 2019-03-27
 *
 */

@RestController
@RequestMapping("/locations")
public class LocationController {
	LocationService locationService;
	LocationMapper locationMapper;
	LocationWIDDTOMapper locationwIdDtoMapper;
	
	@Autowired
	public LocationController(LocationService locationService, LocationMapper locationMapper, LocationWIDDTOMapper locationwIdDtoMapper) {
		this.locationService = locationService;
		this.locationMapper = locationMapper;
		this.locationwIdDtoMapper = locationwIdDtoMapper;
	}

	@ApiOperation(
			value = "This endpoint returns the location with the given id.",
			response = LocationWIDDTO.class
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<LocationWIDDTO> getById(@PathVariable Long id){
		Optional<Location> location = locationService.getById(id);
		
		if(location.isPresent())
			return new ResponseEntity<>(locationwIdDtoMapper.toDTO(location.get()), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(
			value = "This endpoint returns all locations without the id.",
			response = LocationDTO.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<LocationDTO>> getAll(){
		List<Location> locations = locationService.getAll();
		return new ResponseEntity<>(locationMapper.toDTOs(locations), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint returns all locations without the id.",
			response = LocationDTO.class
	)
	@GetMapping("/all")
	public @ResponseBody ResponseEntity<List<LocationWIDDTO>> getAllwId(){
		List<Location> locations = locationService.getAll();
		return new ResponseEntity<>(locationwIdDtoMapper.toDTOs(locations), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a new location with the request body and returns the location address.",
			response = LocationDTO.class
	)
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<LocationDTO> create(@RequestBody LocationDTO location) {
		locationService.save(locationMapper.fromDTO(location));
		return new ResponseEntity<>(location, HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint updates an existing location with the request body and returns the updated location.",
			response = LocationWIDDTO.class
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<LocationWIDDTO> updateById(@RequestBody LocationDTO location, @PathVariable Long id) {
		locationService.updateById(locationMapper.fromDTO(location), id);
		return new ResponseEntity<>(locationwIdDtoMapper.toDTO(location), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint deletes an existing location returns the deleted location.",
			response = LocationWIDDTO.class
	)
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<LocationWIDDTO> deleteById(@PathVariable Long id) {
		Optional<Location> location = locationService.getById(id);
		
		if(location.isPresent()) {
			locationService.deleteById(id);
			return new ResponseEntity<>(locationwIdDtoMapper.toDTO(location.get()), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
