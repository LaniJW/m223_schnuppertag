package ch.nyp.schnuppertag_software.webcontext.trainee;

import java.util.List;
import java.util.Optional;

import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressDTO;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressWIDDTO;
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

import ch.nyp.schnuppertag_software.webcontext.trainee.dto.TraineeDTO;
import ch.nyp.schnuppertag_software.webcontext.trainee.dto.TraineeMapper;
import ch.nyp.schnuppertag_software.webcontext.trainee.dto.TraineeWIDDTO;
import ch.nyp.schnuppertag_software.webcontext.trainee.dto.TraineeWIDMapper;

/**
 * 
 * @author Lani Wagner, Alexandra Girsberger
 * @since 2019-03-27
 *
 */

@RestController
@RequestMapping("/trainees")
public class TraineeController {
	TraineeService traineeService;
	TraineeMapper traineeMapper;
	TraineeWIDMapper traineewIdMapper;
	
	@Autowired
	public TraineeController(TraineeService traineeService, TraineeMapper traineeMapper, TraineeWIDMapper traineewIdMapper) {
		this.traineeService = traineeService;
		this.traineeMapper = traineeMapper;
		this.traineewIdMapper = traineewIdMapper;
	}

	@ApiOperation(
			value = "This endpoint returns the trainee with the given id.",
			response = TraineeWIDDTO.class
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<TraineeWIDDTO> getById(@PathVariable Long id){
		Optional<Trainee> trainee = traineeService.getById(id);
		
		if(trainee.isPresent()) 
			return new ResponseEntity<>(traineewIdMapper.toDTO(trainee.get()), HttpStatus.OK);	
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(
			value = "This endpoint returns all trainees without the id.",
			response = TraineeDTO.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<TraineeDTO>> getAll(){
		List<Trainee> trainees = traineeService.getAll();
		
		return new ResponseEntity<>(traineeMapper.toDTOs(trainees), HttpStatus.OK);	
	
	}

	@ApiOperation(
			value = "This endpoint returns all trainees without the id.",
			response = TraineeDTO.class
	)
	@GetMapping({"/all"})
	public @ResponseBody ResponseEntity<List<TraineeWIDDTO>> getAllwId(){
		List<Trainee> trainees = traineeService.getAll();
		
		return new ResponseEntity<>(traineewIdMapper.toDTOs(trainees), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a new trainee with the request body and returns the created trainee.",
			response = TraineeDTO.class
	)
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<TraineeDTO> create(@RequestBody TraineeDTO trainee) {
		traineeService.save(traineeMapper.fromDTO(trainee));
		
		return new ResponseEntity<>(trainee, HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint updates an existing trainee with the request body and returns the updated trainee.",
			response = TraineeWIDDTO.class
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<TraineeWIDDTO> updateById(@RequestBody TraineeDTO trainee, @PathVariable Long id) {
		traineeService.updateById(traineeMapper.fromDTO(trainee), id);
		
		return new ResponseEntity<>(traineeMapper.toDTO(trainee), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint deletes an existing trainee returns the deleted trainee.",
			response = TraineeWIDDTO.class
	)
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<TraineeWIDDTO> deleteById(@PathVariable Long id) {
		Optional<Trainee> trainee = traineeService.getById(id);
		
		if(trainee.isPresent()) {
			traineeService.deleteById(id);
			return new ResponseEntity<>(traineewIdMapper.toDTO(trainee.get()), HttpStatus.OK);	
		}
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
}
