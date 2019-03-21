package ch.nyp.schnuppertag_software.webcontext.location;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-20
 *
 */

@Service
public class LocationService {
	
	LocationRepository locationRepository;
	
	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	public Optional<Location> getById(Long id) {
		Optional<Location> location = locationRepository.findById(id);
		return location;
	}
}
