package ch.nyp.schnuppertag_software.webcontext.trialday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.nyp.schnuppertag_software.webcontext.trainee.TraineeValidation;
import ch.nyp.schnuppertag_software.webcontext.trainer.TrainerValidation;

/**
 * @author Alexandra Girsberger
 * @since 2019-02-27
 */

@Component
public class TrialDayValidation implements Validator {
	
	SpecializationValidation specializationValidation;
	TraineeValidation traineeValidation;
	TrainerValidation trainerValidation;
	
	@Autowired
	public TrialDayValidation(SpecializationValidation specializationValidation, TraineeValidation traineeValidation, TrainerValidation trainerValidation)
	{
		this.specializationValidation = specializationValidation;
		this.traineeValidation = traineeValidation;
		this.trainerValidation = trainerValidation;
	}

	public boolean supports(Class<?> clazz) {
		return TrialDay.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "specialization", "empty_specialization");
		ValidationUtils.rejectIfEmpty(e, "trainees", "empty_trainees");
		ValidationUtils.rejectIfEmpty(e, "trainers", "empty_trainers");
		
		TrialDay trialDay = (TrialDay) target;

		e.pushNestedPath("specialization");
		specializationValidation.validate(trialDay.getSpecialization(), e);
		e.pushNestedPath("trainees");
		traineeValidation.validate(trialDay.getTrainees(), e);
		e.pushNestedPath("trainers");
		trainerValidation.validate(trialDay.getTrainers(), e);
	}
}
