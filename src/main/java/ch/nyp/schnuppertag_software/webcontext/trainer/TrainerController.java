package ch.nyp.schnuppertag_software.webcontext.trainer;

import java.util.List;
import java.util.Optional;

import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressDTO;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressWIDDTO;
import ch.nyp.schnuppertag_software.webcontext.location.dto.LocationWIDDTO;
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

import ch.nyp.schnuppertag_software.webcontext.trainer.dto.TrainerDTO;
import ch.nyp.schnuppertag_software.webcontext.trainer.dto.TrainerMapper;
import ch.nyp.schnuppertag_software.webcontext.trainer.dto.TrainerWIDDTO;

/**
 * 
 * @author Lani Wagner, Alexandra Girsberger
 * @since 2019-03-27
 * 
 */

@RestController
@RequestMapping("/trainers")
public class TrainerController {
	TrainerService trainerService;
	TrainerMapper trainerMapper;

	@Autowired
	public TrainerController(TrainerService trainerService, TrainerMapper trainerMapper) {
		this.trainerService = trainerService;
		this.trainerMapper = trainerMapper;
	}

	@ApiOperation(
			value = "This endpoint returns the trainer with the given id.",
			response = TrainerWIDDTO.class
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<TrainerWIDDTO> getById(@PathVariable Long id){
		Optional<Trainer> trainer = trainerService.getById(id);
		
		if(trainer.isPresent()) 
			return new ResponseEntity<>(trainerMapper.toDTOwId(trainer.get()), HttpStatus.OK);	
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}

	@ApiOperation(
			value = "This endpoint returns all trainers without the id.",
			response = TrainerDTO.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<TrainerDTO>> getAll(){
		List<Trainer> trainers = trainerService.getAll();
		
		return new ResponseEntity<>(trainerMapper.toDTOs(trainers), HttpStatus.OK);	
	}

	@ApiOperation(
			value = "This endpoint returns all trainers without the id.",
			response = TrainerDTO.class
	)
	@GetMapping({"/all"})
	public @ResponseBody ResponseEntity<List<TrainerWIDDTO>> getAllwId(){
		List<Trainer> trainers = trainerService.getAll();
		
		return new ResponseEntity<>(trainerMapper.toDTOwIds(trainers), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a new trainer with the request body and returns the created trainer.",
			response = TrainerDTO.class
	)
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<TrainerDTO> create(@RequestBody Trainer trainer) {
		trainerService.save(trainer);
		
		return new ResponseEntity<>(trainerMapper.toDTO(trainer), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint updates an existing trainer with the request body and returns the updated trainer.",
			response = TrainerWIDDTO.class
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<TrainerWIDDTO> updateById(@RequestBody TrainerDTO trainer, @PathVariable Long id) {
		trainerService.updateById(trainerMapper.fromDTO(trainer), id);
		
		return new ResponseEntity<>(trainerMapper.toDTOwId(trainer), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint deletes an existing trainer returns the deleted trainer.",
			response = TrainerWIDDTO.class
	)
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<TrainerWIDDTO> deleteById(@PathVariable Long id) {
		Optional<Trainer> trainer = trainerService.getById(id);
		
		if(trainer.isPresent()) {
			trainerService.deleteById(id);
			return new ResponseEntity<>(trainerMapper.toDTOwId(trainer.get()), HttpStatus.OK);	
		}
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
