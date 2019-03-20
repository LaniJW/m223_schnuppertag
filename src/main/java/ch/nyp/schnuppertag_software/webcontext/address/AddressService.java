package ch.nyp.schnuppertag_software.webcontext.address;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
