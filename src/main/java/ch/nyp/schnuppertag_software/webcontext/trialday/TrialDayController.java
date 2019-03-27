package ch.nyp.schnuppertag_software.webcontext.trialday;

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

import ch.nyp.schnuppertag_software.webcontext.trialday.dto.TrialDayDTO;
import ch.nyp.schnuppertag_software.webcontext.trialday.dto.TrialDayMapper;
import ch.nyp.schnuppertag_software.webcontext.trialday.dto.TrialDayWIDDTO;
import ch.nyp.schnuppertag_software.webcontext.trialday.dto.TrialDayWIDMapper;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@RestController
@RequestMapping("/trialdays")
public class TrialDayController {
	
TrialDayService trialDayService;
TrialDayMapper trialDayMapper;
TrialDayWIDMapper trialDaywIdMapper;
	
	@Autowired
	public TrialDayController(TrialDayService trialDayService, TrialDayMapper trialDayMapper, TrialDayWIDMapper trialDaywIdMapper) {
		this.trialDayService = trialDayService;
		this.trialDayMapper = trialDayMapper;
		this.trialDaywIdMapper = trialDaywIdMapper;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<TrialDayWIDDTO> getById(@PathVariable Long id){
		Optional<TrialDay> trialDay = trialDayService.getById(id);
		
		if(trialDay.isPresent()) 
			return new ResponseEntity<>(trialDaywIdMapper.toDTO(trialDay.get()), HttpStatus.OK);	
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<TrialDayDTO>> getAll(){
		List<TrialDay> trialDays = trialDayService.getAll();
		
		return new ResponseEntity<>(trialDayMapper.toDTOs(trialDays), HttpStatus.OK);	
	
	}
	
	@GetMapping({"/all"})
	public @ResponseBody ResponseEntity<List<TrialDayWIDDTO>> getAllwId(){
		List<TrialDay> trialDays = trialDayService.getAll();
		
		return new ResponseEntity<>(trialDaywIdMapper.toDTOs(trialDays), HttpStatus.OK);
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<TrialDayDTO> create(@RequestBody TrialDayDTO trialDay) {
		trialDayService.save(trialDayMapper.fromDTO(trialDay));
		
		return new ResponseEntity<>(trialDay, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<TrialDayWIDDTO> updateById(@RequestBody TrialDayDTO trialDay, @PathVariable Long id) {
		trialDayService.updateById(trialDayMapper.fromDTO(trialDay), id);
		
		return new ResponseEntity<>(trialDayMapper.toDTO(trialDay), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<TrialDayWIDDTO> deleteById(@PathVariable Long id) {
		Optional<TrialDay> trialDay = trialDayService.getById(id);
		
		if(trialDay.isPresent()) {
			trialDayService.deleteById(id);
			return new ResponseEntity<>(trialDaywIdMapper.toDTO(trialDay.get()), HttpStatus.OK);	
		}
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
