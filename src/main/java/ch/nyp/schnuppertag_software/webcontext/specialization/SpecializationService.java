package ch.nyp.schnuppertag_software.webcontext.specialization;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-02-21
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

	public void save(Specialization specialization) {
		specializationRepository.save(specialization);
	}
	
	public void updateById(Specialization specialization, Long id) {
		Optional<Specialization> currentSpecialization = specializationRepository.findById(id);
		if (currentSpecialization.isPresent()) {
			specialization.setId(id);
			this.save(specialization);
		}
	}
	
	public void deleteById(Long id) {
		specializationRepository.deleteById(id);
	}
}
