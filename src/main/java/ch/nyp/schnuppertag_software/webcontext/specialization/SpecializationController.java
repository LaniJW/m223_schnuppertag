package ch.nyp.schnuppertag_software.webcontext.specialization;

import java.security.SecurityPermission;
import java.util.List;
import java.util.Optional;

import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressDTO;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressWIDDTO;
import ch.nyp.schnuppertag_software.webcontext.specialization.dto.SpecializationWIDDTO;
import ch.nyp.schnuppertag_software.webcontext.specialization.dto.SpecializationWIDDTOMapper;
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

import ch.nyp.schnuppertag_software.webcontext.specialization.dto.SpecializationDTO;
import ch.nyp.schnuppertag_software.webcontext.specialization.dto.SpecializationMapper;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@RestController
@RequestMapping("/specializations")
public class SpecializationController {
	SpecializationService specializationService;
	SpecializationMapper specializationMapper;
	SpecializationWIDDTOMapper specializationwIdDtoMapper;
	
	@Autowired
	public SpecializationController(SpecializationService specializationService, SpecializationMapper specializationMapper, SpecializationWIDDTOMapper specializationwIdDtoMapper) {
		this.specializationService = specializationService;
		this.specializationMapper = specializationMapper;
		this.specializationwIdDtoMapper = specializationwIdDtoMapper;
	}

	@ApiOperation(
			value = "This endpoint returns the specialization with the given id.",
			response = SpecializationWIDDTO.class
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<SpecializationWIDDTO> getById(@PathVariable Long id){
		Optional<Specialization> specialization = specializationService.getById(id);
		
		if(specialization.isPresent())
			return new ResponseEntity<>(specializationwIdDtoMapper.toDTO(specialization.get()), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(
			value = "This endpoint returns all specializations without the id.",
			response = SpecializationDTO.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<SpecializationDTO>> getAll(){
		List<Specialization> specializations = specializationService.getAll();
		return new ResponseEntity<>(specializationMapper.toDTOs(specializations), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint returns all specializations without the id.",
			response = SpecializationDTO.class
	)
	@GetMapping("/all")
	public @ResponseBody ResponseEntity<List<SpecializationWIDDTO>> getAllwId(){
		List<Specialization> specializations = specializationService.getAll();
		return new ResponseEntity<>(specializationwIdDtoMapper.toDTOs(specializations), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a new specialization with the request body and returns the created specialization.",
			response = SpecializationDTO.class
	)
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<SpecializationDTO> create(@RequestBody SpecializationDTO specialization) {
		specializationService.save(specializationMapper.fromDTO(specialization));
		return new ResponseEntity<>(specialization, HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint updates an existing specialization with the request body and returns the updated specialization.",
			response = SpecializationWIDDTO.class
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<SpecializationWIDDTO> update(@RequestBody SpecializationDTO specialization, @PathVariable Long id) {
		specializationService.updateById(specializationMapper.fromDTO(specialization), id);
		return new ResponseEntity<>(specializationwIdDtoMapper.toDTO(specialization), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint deletes an existing specialization returns the deleted specialization.",
			response = SpecializationWIDDTO.class
	)
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<SpecializationWIDDTO> deleteById(@PathVariable Long id) {
		Optional<Specialization> specialization = specializationService.getById(id);
		
		if(specialization.isPresent()) {
			specializationService.deleteById(id);
			return new ResponseEntity<>(specializationwIdDtoMapper.toDTO(specialization.get()), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
