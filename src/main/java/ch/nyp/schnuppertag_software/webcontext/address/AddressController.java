package ch.nyp.schnuppertag_software.webcontext.address;

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
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-21
 *
 */

@RestController
@RequestMapping("/address")
public class AddressController {

	AddressService addressService;
	
	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Address> getById(@PathVariable Long id){
		Optional<Address> address = addressService.getById(id);
		
		if(address.isPresent()) {
			return new ResponseEntity<>(address.get(), HttpStatus.OK);	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public @ResponseBody ResponseEntity<Address> create(@RequestBody Address address) {
		addressService.save(address);
		
		return new ResponseEntity<>(address, HttpStatus.CREATED);
	}
}
