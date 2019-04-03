package ch.nyp.schnuppertag_software.webcontext.authorization;

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

import ch.nyp.schnuppertag_software.webcontext.authorization.dto.AuthorizationDTO;
import ch.nyp.schnuppertag_software.webcontext.authorization.dto.AuthorizationMapper;
import ch.nyp.schnuppertag_software.webcontext.authorization.dto.AuthorizationWIDDTO;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

@RestController
@RequestMapping("/authorizations")
public class AuthorizationController {
	AuthorizationService authorizationService;
	AuthorizationMapper authorizationMapper;
	
	@Autowired
	public AuthorizationController(AuthorizationService authorizationService, AuthorizationMapper authorizationMapper) {
		this.authorizationService = authorizationService;
		this.authorizationMapper = authorizationMapper;
	}

	@ApiOperation(
			value = "This endpoint returns the Authorization with the given id.",
			response = AuthorizationWIDDTO.class
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorizationWIDDTO> getById(@PathVariable Long id){
		Optional<Authorization> authorization = authorizationService.getById(id);
		
		if(authorization.isPresent())
			return new ResponseEntity<>(authorizationMapper.toDTOwId(authorization.get()), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(
			value = "This endpoint returns all Authorizations without the id.",
			response = AuthorizationDTO.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<AuthorizationDTO>> getAll(){
		List<Authorization> authorizations = authorizationService.getAll();
		return new ResponseEntity<>(authorizationMapper.toDTOs(authorizations), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint returns all Authorizations without the id.",
			response = AuthorizationDTO.class
	)
	@GetMapping("/all")
	public @ResponseBody ResponseEntity<List<AuthorizationWIDDTO>> getAllwId(){
		List<Authorization> authorizations = authorizationService.getAll();
		return new ResponseEntity<>(authorizationMapper.toDTOwIds(authorizations), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a new Authorization with the request body and returns the created Authorization.",
			response = AuthorizationDTO.class
	)
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<AuthorizationDTO> create(@RequestBody AuthorizationDTO authorization) {
		authorizationService.save(authorizationMapper.fromDTO(authorization));
		return new ResponseEntity<>(authorization, HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint updates an existing Authorization with the request body and returns the updated Authorization.",
			response = AuthorizationWIDDTO.class
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorizationWIDDTO> update(@RequestBody AuthorizationDTO authorization, @PathVariable Long id) {
		authorizationService.updateById(authorizationMapper.fromDTO(authorization), id);
		return new ResponseEntity<>(authorizationMapper.toDTOwId(authorization), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint deletes an existing Authorization returns the deleted Authorization.",
			response = AuthorizationWIDDTO.class
	)
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorizationWIDDTO> deleteById(@PathVariable Long id) {
		Optional<Authorization> authorization = authorizationService.getById(id);
		
		if(authorization.isPresent()) {
			authorizationService.deleteById(id);
			return new ResponseEntity<>(authorizationMapper.toDTOwId(authorization.get()), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
