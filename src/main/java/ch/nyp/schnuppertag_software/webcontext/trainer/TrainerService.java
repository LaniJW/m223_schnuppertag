package ch.nyp.schnuppertag_software.webcontext.trainer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Lani Wagner
 * @since 2019-03-20
 *
 */

@Service
public class TrainerService {
	TrainerRepository trainerRepository;
	
	@Autowired
	public TrainerService(TrainerRepository trainerRepository) {
		this.trainerRepository = trainerRepository;
	}
	
	/**
	 * This method returns the requested trainer
	 * 
	 * @param id
	 * @return ResponseEnitity with the information that was requested
	 */
	public Optional<Trainer> getById(Long id) {
		Optional<Trainer> trainer = trainerRepository.findById(id);
		return trainer;
	}
}
