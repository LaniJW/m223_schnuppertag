package ch.nyp.schnuppertag_software.webcontext.specialization;

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

import ch.nyp.schnuppertag_software.webcontext.specialization.dto.SpecializationDTO;
import ch.nyp.schnuppertag_software.webcontext.specialization.dto.SpecializationMapper;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-22
 *
 */

@RestController
@RequestMapping("/specializations")
public class SpecializationController {
	SpecializationService specializationService;
	SpecializationMapper specializationMapper;
	
	@Autowired
	public SpecializationController(SpecializationService specializationService, SpecializationMapper specializationMapper) {
		this.specializationService = specializationService;
		this.specializationMapper = specializationMapper;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<SpecializationDTO> getById(@PathVariable Long id){
		Optional<Specialization> specialization = specializationService.getById(id);
		
		if(specialization.isPresent()) {
			return new ResponseEntity<>(specializationMapper.toDTO(specialization.get()), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<Specialization> create(@RequestBody Specialization specialization) {
		specializationService.save(specialization);
		
		return new ResponseEntity<>(specialization, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Specialization> update(@RequestBody Specialization specialization, @PathVariable Long id) {
		specializationService.updateById(specialization, id);
		
		return new ResponseEntity<>(specialization, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Specialization> deleteById(@PathVariable Long id) {
		Optional<Specialization> specialization = specializationService.getById(id);
		
		if(specialization.isPresent()) {
			specializationService.deleteById(id);
			return new ResponseEntity<>(specialization.get(), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<Specialization>> getAll(){
		List<Specialization> specializations = specializationService.getAll();
		
		return new ResponseEntity<>(specializations, HttpStatus.OK);	
	
	}
}
