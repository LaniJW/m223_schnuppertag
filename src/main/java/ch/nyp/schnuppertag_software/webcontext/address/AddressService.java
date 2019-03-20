package ch.nyp.schnuppertag_software.webcontext.address;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Alexandra Girsberger
 * 2since 2019-03-20
 *
 */

@Service
public class AddressService {

	AddressRepository addressRepository;
	
	@Autowired
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	public Optional<Address> getById(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		return address;
	}
	
}
