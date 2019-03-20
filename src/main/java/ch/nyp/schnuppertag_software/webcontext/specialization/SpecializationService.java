package ch.nyp.schnuppertag_software.webcontext.specialization;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-02-20
 *
 */

@Service
public class SpecializationService {

	SpecializationRepository specializationRepository;
	
	@Autowired
	public SpecializationService(SpecializationRepository specializationRepository) {
		this.specializationRepository = specializationRepository;
	}
	
	public Optional<Specialization> getById(Long id){
		Optional<Specialization> specialization = specializationRepository.findById(id);
		return specialization;
	}
}
