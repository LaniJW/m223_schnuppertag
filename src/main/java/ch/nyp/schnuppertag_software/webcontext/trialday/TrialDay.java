package ch.nyp.schnuppertag_software.webcontext.trialday;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;
import ch.nyp.schnuppertag_software.webcontext.trainee.Trainee;
import ch.nyp.schnuppertag_software.webcontext.trainer.Trainer;

/**
 * @author Alexandra Girsberger
 * @since 2019-02-20
 */

@Entity
@Table(name = "tbl_trialday")
public class TrialDay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "specialization_fk")
	private Specialization specialization;
	
	@OneToMany
	@JoinColumn(name = "trainee_fk")
	private List<Trainee> trainees;
	
	@OneToMany
	@JoinColumn(name = "trainer_fk")
	private List<Trainer> trainers;

	public TrialDay() {
		super();
	}

	public TrialDay(Long id, Specialization specialization, List<Trainee> trainees, List<Trainer> trainers) {
		super();
		this.id = id;
		this.specialization = specialization;
		this.trainees = trainees;
		this.trainers = trainers;
	}

	public TrialDay(Specialization specialization, List<Trainee> trainees, List<Trainer> trainers) {
		super();
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
