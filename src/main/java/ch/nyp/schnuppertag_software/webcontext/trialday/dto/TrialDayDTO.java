package ch.nyp.schnuppertag_software.webcontext.trialday.dto;

import java.util.List;
import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;
import ch.nyp.schnuppertag_software.webcontext.trainee.Trainee;
import ch.nyp.schnuppertag_software.webcontext.trainer.Trainer;

/**
 * @author Alexandra Girsberger
 * @since 2019-02-21
 */

public class TrialDayDTO {
	
	private Specialization specialization;
	
	private List<Trainee> trainees;

	private List<Trainer> trainers;

	public TrialDayDTO() {
		super();
	}

	public TrialDayDTO(Specialization specialization, List<Trainee> trainees, List<Trainer> trainers) {
		super();
		this.specialization = specialization;
		this.trainees = trainees;
		this.trainers = trainers;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}
	
}
