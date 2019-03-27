package ch.nyp.schnuppertag_software.webcontext.address;

import java.util.List;
import java.util.Optional;

import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressWIDDTO;
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

import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressDTO;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressMapper;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@RestController
@RequestMapping("/addresses")
public class AddressController {
	AddressService addressService;
	AddressMapper addressMapper;
	
	@Autowired
	public AddressController(AddressService addressService, AddressMapper addressMapper) {
		this.addressService = addressService;
		this.addressMapper = addressMapper;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<AddressWIDDTO> getById(@PathVariable Long id){
		Optional<Address> address = addressService.getById(id);

		if(address.isPresent())
			return new ResponseEntity<>(addressMapper.toDTOwId(address.get()), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<AddressDTO>> getAll(){
		List<Address> addresses = addressService.getAll();
		return new ResponseEntity<>(addressMapper.toDTOs(addresses), HttpStatus.OK);
	}

	@GetMapping("/all")
	public @ResponseBody ResponseEntity<List<AddressWIDDTO>> getAllwId(){
		List<Address> addresses = addressService.getAll();
		return new ResponseEntity<>(addressMapper.toDTOwIds(addresses), HttpStatus.OK);
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<AddressDTO> create(@RequestBody AddressDTO address) {
		addressService.save(addressMapper.fromDTO(address));
		return new ResponseEntity<>(address, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<AddressWIDDTO> updateById(@RequestBody AddressDTO address, @PathVariable Long id) {
		addressService.updateById(addressMapper.fromDTO(address), id);
		return new ResponseEntity<>(addressMapper.toDTOwId(address), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<AddressWIDDTO> deleteById(@PathVariable Long id) {
		Optional<Address> address = addressService.getById(id);
		
		if(address.isPresent()) {
			addressService.deleteById(id);
			return new ResponseEntity<>(addressMapper.toDTOwId(address.get()), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
