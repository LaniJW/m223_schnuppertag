package ch.nyp.schnuppertag_software.webcontext.specialization;

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
@RequestMapping("/specialization")
public class SpecializationController {

	SpecializationService specializationService;
	
	@Autowired
	public SpecializationController(SpecializationService specializationService) {
		this.specializationService = specializationService;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Specialization> getById(@PathVariable Long id){
		Optional<Specialization> specialization = specializationService.getById(id);
		
		if(specialization.isPresent()) {
			return new ResponseEntity<>(specialization.get(), HttpStatus.OK);	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<Specialization> create(@RequestBody Specialization specialization) {
		specializationService.save(specialization);
		
		return new ResponseEntity<>(specialization, HttpStatus.CREATED);
	}
}
