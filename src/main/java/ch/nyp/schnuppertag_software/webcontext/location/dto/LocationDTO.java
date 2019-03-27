package ch.nyp.schnuppertag_software.webcontext.location.dto;

import java.util.List;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.trialday.TrialDay;

/**
 * 
 * @author Alexandra Girsberger
 * @author 2019-03-21
 *
 */

public class LocationDTO {

	private Address address;
	private List<TrialDay> trialDays;

	public LocationDTO() {
		super();
	}

	public LocationDTO(Address address, List<TrialDay> trialDays) {
		super();
		this.address = address;
		this.trialDays = trialDays;
	}

	public Address getAddress() {
		return address;
	}

	public List<TrialDay> getTrialDays() {
		return trialDays;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setTrialDays(List<TrialDay> trialDays) {
		this.trialDays = trialDays;
	}

}
