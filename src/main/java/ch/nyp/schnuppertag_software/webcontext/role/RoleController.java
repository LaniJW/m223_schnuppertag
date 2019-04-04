package ch.nyp.schnuppertag_software.webcontext.role;

import ch.nyp.schnuppertag_software.webcontext.role.dto.RoleDTO;
import ch.nyp.schnuppertag_software.webcontext.role.dto.RoleMapper;
import ch.nyp.schnuppertag_software.webcontext.role.dto.RoleWIDDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lani Wagner
 * @since 2019-04-03
 *
 */

@RestController
@RequestMapping("/rolees")
public class RoleController
{
	RoleService roleService;
	RoleMapper roleMapper;

	@Autowired
	public RoleController(RoleService roleService, RoleMapper roleMapper) {
		this.roleService = roleService;
		this.roleMapper = roleMapper;
	}

	@ApiOperation(
			value = "This endpoint returns the role with the given id.",
			response = RoleWIDDTO.class
	)
	@GetMapping("/{id}")
	public @ResponseBody
	ResponseEntity<RoleWIDDTO> getById(@PathVariable Long id){
		Optional<Role> role = roleService.getById(id);

		if(role.isPresent())
			return new ResponseEntity<>(roleMapper.toDTOwId(role.get()), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(
			value = "This endpoint returns all rolees without the id.",
			response = RoleDTO.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<RoleDTO>> getAll(){
		List<Role> rolees = roleService.getAll();
		return new ResponseEntity<>(roleMapper.toDTOs(rolees), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint returns all rolees with the id.",
			response = RoleWIDDTO.class
	)
	@GetMapping("/all")
	public @ResponseBody ResponseEntity<List<RoleWIDDTO>> getAllwId(){
		List<Role> rolees = roleService.getAll();
		return new ResponseEntity<>(roleMapper.toDTOwIds(rolees), HttpStatus.OK);
	}

	@ApiOperation(
			value = "This endpoint creates a new role with the request body and returns the created role.",
			response = RoleDTO.class
	)
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<RoleDTO> create(@RequestBody RoleDTO role) {
		roleService.save(roleMapper.fromDTO(role));
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint updates an existing role with the request body and returns the updated role.",
			response = RoleWIDDTO.class
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<RoleWIDDTO> updateById(@RequestBody RoleDTO role, @PathVariable Long id) {
		roleService.updateById(roleMapper.fromDTO(role), id);
		return new ResponseEntity<>(roleMapper.toDTOwId(role), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "This endpoint deletes an existing role returns the deleted role.",
			response = RoleWIDDTO.class
	)
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<RoleWIDDTO> deleteById(@PathVariable Long id) {
		Optional<Role> role = roleService.getById(id);

		if(role.isPresent()) {
			roleService.deleteById(id);
			return new ResponseEntity<>(roleMapper.toDTOwId(role.get()), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
