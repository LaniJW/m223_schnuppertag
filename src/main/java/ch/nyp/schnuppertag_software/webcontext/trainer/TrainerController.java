package ch.nyp.schnuppertag_software.webcontext.trainer;

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

/**
 * 
 * @author Lani Wagner, Alexandra Girsberger
 * @since 2019-03-21
 * 
 */

@RestController
@RequestMapping("/trainers")
public class TrainerController {
	TrainerService trainerService;

	@Autowired
	public TrainerController(TrainerService trainerService) {
		this.trainerService = trainerService;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Trainer> getById(@PathVariable Long id){
		Optional<Trainer> trainer = trainerService.getById(id);
		
		if(trainer.isPresent()) {
			return new ResponseEntity<>(trainer.get(), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<Trainer> create(@RequestBody Trainer trainer) {
		trainerService.save(trainer);
		
		return new ResponseEntity<>(trainer, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Trainer> update(@RequestBody Trainer trainer, @PathVariable Long id) {
		trainerService.updateById(trainer, id);
		
		return new ResponseEntity<>(trainer, HttpStatus.CREATED);
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<Trainer>> getAll(){
		List<Trainer> trainers = trainerService.getAll();
		
		return new ResponseEntity<>(trainers, HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Trainer> deleteById(@PathVariable Long id) {
		Optional<Trainer> trainer = trainerService.getById(id);
		
		if(trainer.isPresent()) {
			trainerService.deleteById(id);
			return new ResponseEntity<>(trainer.get(), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
