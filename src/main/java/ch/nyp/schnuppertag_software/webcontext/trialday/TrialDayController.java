package ch.nyp.schnuppertag_software.webcontext.trialday;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-04-03
 *
 */

@RestController
@RequestMapping("/trialdays")
public class TrialDayController {
	
TrialDayService trialDayService;
TrialDayMapper trialDayMapper;
	
	@Autowired
	public TrialDayController(TrialDayService trialDayService, TrialDayMapper trialDayMapper) {
		this.trialDayService = trialDayService;
		this.trialDayMapper = trialDayMapper;
	}

	@ApiOperation(
			value = "This endpoint returns the trial day with the given id.",
			response = TrialDayWIDDTO.class
	)
	@PreAuthorize("hasAuthorization('admin')")
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<TrialDayWIDDTO> getById(@PathVariable Long id){
		Optional<TrialDay> trialDay = trialDayService.getById(id);
		
		if(trialDay.isPresent()) 
			return new ResponseEntity<>(trialDayMapper.toDTOwId(trialDay.get()), HttpStatus.OK);	
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(
			value = "This endpoint returns all trial days without the id.",
			response = TrialDayDTO.class
	)
	@PreAuthorize("hasAuthorization('guest')")
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<TrialDayDTO>> getAll(){
		List<TrialDay> trialDays = trialDayService.getAll();
		
		return new ResponseEntity<>(trialDayMapper.toDTOs(trialDays), HttpStatus.OK);	
	
	}

	@ApiOperation(
			value = "This endpoint returns all trial days without the id.",
			response = TrialDayDTO.class
	)
	@PreAuthorize("hasAuthorization('admin')")
	@GetMapping({"/all"})
	public @ResponseBody ResponseEntity<List<TrialDayWIDDTO>> getAllwId(){
		List<TrialDay> trialDays = trialDayService.getAll();
		
		return new ResponseEntity<>(trialDayMapper.toDTOwIds(trialDays), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a new trial day with the request body and returns the created trial day.",
			response = TrialDayDTO.class
	)
	@PreAuthorize("hasAuthorization('admin')")
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<TrialDayDTO> create(@RequestBody TrialDayDTO trialDay) {
		trialDayService.save(trialDayMapper.fromDTO(trialDay));
		
		return new ResponseEntity<>(trialDay, HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint updates an existing trial day with the request body and returns the updated trial day.",
			response = TrialDayWIDDTO.class
	)
	@PreAuthorize("hasAuthorization('admin')")
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<TrialDayWIDDTO> updateById(@RequestBody TrialDayDTO trialDay, @PathVariable Long id) {
		trialDayService.updateById(trialDayMapper.fromDTO(trialDay), id);
		
		return new ResponseEntity<>(trialDayMapper.toDTOwId(trialDay), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint deletes an existing trail day returns the deleted trial day.",
			response = TrialDayWIDDTO.class
	)
	@PreAuthorize("hasAuthorization('admin')")
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<TrialDayWIDDTO> deleteById(@PathVariable Long id) {
		Optional<TrialDay> trialDay = trialDayService.getById(id);
		
		if(trialDay.isPresent()) {
			trialDayService.deleteById(id);
			return new ResponseEntity<>(trialDayMapper.toDTOwId(trialDay.get()), HttpStatus.OK);	
		}
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
