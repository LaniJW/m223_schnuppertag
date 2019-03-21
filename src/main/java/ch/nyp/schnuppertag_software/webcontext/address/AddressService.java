package ch.nyp.schnuppertag_software.webcontext.address;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * 2since 2019-03-21
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

	public void save(Address address) {
		addressRepository.save(address);
	}

	public List<Address> getAll() {
		List<Address> addresses = addressRepository.findAll();
		return addresses;
	}
}
