package ch.nyp.schnuppertag_software.webcontext.trainee;

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
public class TraineeService {
	TraineeRepository traineeRepository;
	
	@Autowired
	public TraineeService(TraineeRepository traineeRepository) {
		this.traineeRepository = traineeRepository;
	}
	
	/**
	 * This method returns the requested trainee
	 * 
	 * @param id
	 * @return ResponseEnitity with the information that was requested
	 */
	public Optional<Trainee> getById(Long id) {
		Optional<Trainee> trainee = traineeRepository.findById(id);
		return trainee;
	}
}
