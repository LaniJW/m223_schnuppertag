package ch.nyp.schnuppertag_software.webcontext.trainer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Lani Wagner
 * @since 2019-03-20
 * 
 */

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	TrainerService trainerService;
	
	@Autowired
	public TrainerController(TrainerService trainerService) {
		this.trainerService = trainerService;
	}
	
	/**
	 * This method returns the requested trainer
	 * 
	 * @param id
	 * @return ResponseEnitity with the information that was requested
	 */
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Trainer> getById(@PathVariable Long id){
		Optional<Trainer> address = trainerService.getById(id);
		
		if(address.isPresent()) {
			return new ResponseEntity<>(address.get(), HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
