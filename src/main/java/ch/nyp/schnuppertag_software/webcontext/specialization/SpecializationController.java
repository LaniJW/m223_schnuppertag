package ch.nyp.schnuppertag_software.webcontext.specialization;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.address.AddressService;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-20
 *
 */
@RestController
@RequestMapping("/specialization")
public class SpecializationController {

	SpecializationService specializationService;
	
	@Autowired
	public SpecializationController(SpecializationService specializationService) {
		this.specializationService = specializationService;
	}
	
	/**
	 * This method returns the requested specialization
	 * 
	 * @param id
	 * @return ResponseEnitity with the specialization that was requested
	 */

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Specialization> getById(@PathVariable Long id){
		Optional<Specialization> specialization = specializationService.getById(id);
		
		if(specialization.isPresent()) {
			return new ResponseEntity<>(specialization.get(), HttpStatus.OK);	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
