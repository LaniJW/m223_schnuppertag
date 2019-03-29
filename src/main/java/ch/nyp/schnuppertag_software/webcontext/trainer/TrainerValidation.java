package ch.nyp.schnuppertag_software.webcontext.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.nyp.schnuppertag_software.webcontext.address.AddressValidation;
import ch.nyp.schnuppertag_software.webcontext.specialization.SpecializationValidation;

/**
 * @author Alexandra Girsberger
 * @since 2019-02-27
 */

@Component
public class TrainerValidation implements Validator {
	
	AddressValidation addressValidation;
	SpecializationValidation specializationValidation;
	
	@Autowired
	public TrainerValidation(AddressValidation addressValidation, SpecializationValidation specializationValidation)
	{
		this.addressValidation = addressValidation;
		this.specializationValidation = specializationValidation;
	}

	public boolean supports(Class<?> clazz) {
		return Trainer.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "specialization", "empty_specialization");
		ValidationUtils.rejectIfEmpty(e, "address", "empty_address");
		ValidationUtils.rejectIfEmpty(e, "phoneNumber", "empty_phoneNumber");
		ValidationUtils.rejectIfEmpty(e, "email", "empty_email");
		Trainer trainer = (Trainer) target;
		
		e.pushNestedPath("address");
		addressValidation.validate(trainer.getAddress(), e);
		e.pushNestedPath("trialDays");
		specializationValidation.validate(trainer.getSpecialization(), e);
		
		if(!trainer.getEmail().matches("(([a-zA-z0-9]+)\\.?)+@(\\.?([a-zA-z0-9]+)){2,}"))
			e.rejectValue("email", "incorrect_format");
		if(!trainer.getPhoneNumber().matches("\\\\d{9}"))
			e.rejectValue("phoneNumber", "incorrect_format");
	}
}
