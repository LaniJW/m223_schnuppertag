package ch.nyp.schnuppertag_software.webcontext.trialday.dto;

import java.util.List;
import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;
import ch.nyp.schnuppertag_software.webcontext.trainee.Trainee;
import ch.nyp.schnuppertag_software.webcontext.trainer.Trainer;

/**
 * @author Alexandra Girsberger
 * @since 2019-02-27
 */

public class TrialDayWIDDTO {
	
	private Long id;
	
	private Specialization specialization;
	
	private List<Trainee> trainees;

	private List<Trainer> trainers;

	public TrialDayWIDDTO() {
		super();
	}

	public TrialDayWIDDTO(Long id, Specialization specialization, List<Trainee> trainees, List<Trainer> trainers) {
		super();
		this.id = id;
		this.specialization = specialization;
		this.trainees = trainees;
		this.trainers = trainers;
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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
