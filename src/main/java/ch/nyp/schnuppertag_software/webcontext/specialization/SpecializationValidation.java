package ch.nyp.schnuppertag_software.webcontext.specialization;

import ch.nyp.schnuppertag_software.webcontext.location.Location;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Lani Wagner
 * @since 2019-03-27
 *
 */

@Component
public class SpecializationValidation implements Validator
{
	public boolean supports(Class clazz) {
		return Location.class.equals(clazz);
	}

	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "title", "empty_title");
		ValidationUtils.rejectIfEmpty(e, "description", "empty_desc");
	}
}