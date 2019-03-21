package ch.nyp.schnuppertag_software.webcontext.trainee;

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
public class TraineeService {
	TraineeRepository traineeRepository;
	
	@Autowired
	public TraineeService(TraineeRepository traineeRepository) {
		this.traineeRepository = traineeRepository;
	}

	public Optional<Trainee> getById(Long id) {
		Optional<Trainee> trainee = traineeRepository.findById(id);
		return trainee;
	}
	
	public void save(Trainee trainee) {
		traineeRepository.save(trainee);
	}
}
