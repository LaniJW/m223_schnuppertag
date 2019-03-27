package ch.nyp.schnuppertag_software.webcontext.address;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Lani Wagner
 * @since 2019-03-27
 *
 */

public class AddressValidation implements Validator
{
	public boolean supports(Class clazz) {
		return Address.class.equals(clazz);
	}

	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "empty_name");
		ValidationUtils.rejectIfEmpty(e, "streetName", "empty_streetname");
		ValidationUtils.rejectIfEmpty(e, "streetNumber", "empty_streetnumber");
		ValidationUtils.rejectIfEmpty(e, "zip_code", "empty_zip_code");
		ValidationUtils.rejectIfEmpty(e, "city", "empty_city");
		ValidationUtils.rejectIfEmpty(e, "country", "empty_country");
	}
}
