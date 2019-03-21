package ch.nyp.schnuppertag_software.webcontext.trainee;

import java.util.List;
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
 * @author Lani Wagner, Alexandra Girsberger
 * @since 2019-03-21
 *
 */

@RestController
@RequestMapping("/trainees")
public class TraineeController {
	TraineeService traineeService;
	
	@Autowired
	public TraineeController(TraineeService traineeService) {
		this.traineeService = traineeService;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Trainee> getById(@PathVariable Long id){
		Optional<Trainee> trainee = traineeService.getById(id);
		
		if(trainee.isPresent()) {
			return new ResponseEntity<>(trainee.get(), HttpStatus.OK);	
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
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<Trainee>> getAll(){
		List<Trainee> trainees = traineeService.getAll();
		
		return new ResponseEntity<>(trainees, HttpStatus.OK);	
	
	}
}
