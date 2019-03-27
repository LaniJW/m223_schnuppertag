package ch.nyp.schnuppertag_software.webcontext.location;

import ch.nyp.schnuppertag_software.webcontext.address.AddressValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Lani Wagner
 * @since 2019-03-27
 *
 */

public class LocationValidation implements Validator
{
	AddressValidation addressValidation;
	TrialDayValidation trialDayValidation;

	@Autowired
	public LocationValidation(AddressValidation addressValidation, TrialDayValidation trialDayValidation)
	{
		this.addressValidation = addressValidation;
		this.trialDayValidation = trialDayValidation;
	}

	public boolean supports(Class clazz) {
		return Location.class.equals(clazz);
	}

	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "address", "empty_address");
		ValidationUtils.rejectIfEmpty(e, "trialDays", "empty_triaday");

		Location location = (Location) target;

		e.pushNestedPath("address");
		addressValidation.validate(location.getAddress(), e);
		e.pushNestedPath("trialDays");
		trialDayValidation.validate(location.getTrialDays(), e);
	}
}
