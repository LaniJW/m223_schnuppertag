package ch.nyp.schnuppertag_software.webcontext.trainee;

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

import ch.nyp.schnuppertag_software.webcontext.trainee.dto.TraineeDTO;
import ch.nyp.schnuppertag_software.webcontext.trainee.dto.TraineeMapper;

/**
 * 
 * @author Lani Wagner, Alexandra Girsberger
 * @since 2019-03-22
 *
 */

@RestController
@RequestMapping("/trainees")
public class TraineeController {
	TraineeService traineeService;
	TraineeMapper traineeMapper;
	
	@Autowired
	public TraineeController(TraineeService traineeService, TraineeMapper trainerMapper) {
		this.traineeService = traineeService;
		this.traineeMapper = trainerMapper;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<TraineeDTO> getById(@PathVariable Long id){
		Optional<Trainee> trainee = traineeService.getById(id);
		
		if(trainee.isPresent()) {
			return new ResponseEntity<>(traineeMapper.toDTO(trainee.get()), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<Trainee> create(@RequestBody Trainee trainee) {
		traineeService.save(trainee);
		
		return new ResponseEntity<>(trainee, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Trainee> update(@RequestBody Trainee trainee, @PathVariable Long id) {
		traineeService.updateById(trainee, id);
		
		return new ResponseEntity<>(trainee, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Trainee> deleteById(@PathVariable Long id) {
		Optional<Trainee> trainee = traineeService.getById(id);
		
		if(trainee.isPresent()) {
			traineeService.deleteById(id);
			return new ResponseEntity<>(trainee.get(), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<Trainee>> getAll(){
		List<Trainee> trainees = traineeService.getAll();
		
		return new ResponseEntity<>(trainees, HttpStatus.OK);	
	
	}
}
