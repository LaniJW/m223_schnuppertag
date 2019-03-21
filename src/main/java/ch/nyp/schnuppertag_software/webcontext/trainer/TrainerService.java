package ch.nyp.schnuppertag_software.webcontext.trainer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;

/**
 * 
 * @author Lani Wagner, Alexandra Girsberger
 * @since 2019-03-21
 *
 */

@Service
public class TrainerService {
	TrainerRepository trainerRepository;
	
	@Autowired
	public TrainerService(TrainerRepository trainerRepository) {
		this.trainerRepository = trainerRepository;
	}
	
	public Optional<Trainer> getById(Long id) {
		Optional<Trainer> trainer = trainerRepository.findById(id);
		return trainer;
	}
	
	public void save(Trainer trainer) {
		trainerRepository.save(trainer);
	}
}
