package ch.nyp.schnuppertag_software.webcontext.trialday;

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

import ch.nyp.schnuppertag_software.webcontext.trialday.TrialDay;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-21
 *
 */

@RestController
@RequestMapping("/trialdays")
public class TrialDayController {
	
TrialDayService trialDayService;
	
	@Autowired
	public TrialDayController(TrialDayService trialDayService) {
		this.trialDayService = trialDayService;
	}
	
	/**
	 * This method returns the requested trialday
	 * 
	 * @param id
	 * @return ResponseEntity with the trialday that was requested
	 */
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<TrialDay> getById(@PathVariable Long id){
		Optional<TrialDay> trialDay = trialDayService.getById(id);
		
		if(trialDay.isPresent()) {
			return new ResponseEntity<>(trialDay.get(), HttpStatus.OK);	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<TrialDay> create(@RequestBody TrialDay trialDay) {
		trialDayService.save(trialDay);
		
		return new ResponseEntity<>(trialDay, HttpStatus.CREATED);
	}
}
