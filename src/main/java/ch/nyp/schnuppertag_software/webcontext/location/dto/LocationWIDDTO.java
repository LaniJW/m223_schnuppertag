package ch.nyp.schnuppertag_software.webcontext.location.dto;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.trialday.TrialDay;

import java.util.List;

/**
 *
 * @author Lani Wagner
 * @since 2019-03-27
 *
 */

public class LocationWIDDTO
{
	private Long id;
	private Address address;
	private List<TrialDay> trialDays;

	public LocationWIDDTO()
	{
		super();
	}

	public LocationWIDDTO(Long id, Address address, List<TrialDay> trialDays)
	{
		this.id = id;
		this.address = address;
		this.trialDays = trialDays;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public List<TrialDay> getTrialDays()
	{
		return trialDays;
	}

	public void setTrialDays(List<TrialDay> trialDays)
	{
		this.trialDays = trialDays;
	}
}
