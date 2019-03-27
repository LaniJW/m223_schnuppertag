package ch.nyp.schnuppertag_software.webcontext.trainee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Alexandra Girsberger
 * @since 2019-02-27
 */

@Component
public class TraineeValidation implements Validator {
	
	AddressValidation addressValidation;
	
	@Autowired
	public TraineeValidation(AddressValidation addressValidation)
	{
		this.addressValidation = addressValidation;
	}

	public boolean supports(Class<?> clazz) {
		return Trainee.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "age", "empty_age");
		ValidationUtils.rejectIfEmpty(e, "address", "empty_address");
		ValidationUtils.rejectIfEmpty(e, "phoneNumber", "empty_phoneNumber");
		ValidationUtils.rejectIfEmpty(e, "email", "empty_email");
		Trainee trainee = (Trainee) target;
		
		e.pushNestedPath("address");
		addressValidation.validate(trainee.getAddress(), e);
		
		if(!trainee.getEmail().matches("(([a-zA-z0-9]+)\\.?)+@(\\.?([a-zA-z0-9]+)){2,}"))
			e.rejectValue("email", "incorrect_format");
		if(!trainee.getPhoneNumber().matches("\\d{9}"))
			e.rejectValue("phoneNumber", "incorrect_format");
	}
}


