package ch.nyp.schnuppertag_software.webcontext.address.dto;

/**
 *
 * @author Lani Wagner
 * @since 2019-03-27
 *
 */

public class AddressWIDDTO
{
	private Long id;
	private String name;
	private String streetName;
	private String streetNumber;
	private String zipCode;
	private String city;
	private String country;

	public AddressWIDDTO()
	{
		super();
	}

	public AddressWIDDTO(Long id, String name, String streetName, String streetNumber, String zipCode, String city, String country)
	{
		this.id = id;
		this.name = name;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getStreetName()
	{
		return streetName;
	}

	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}

	public String getStreetNumber()
	{
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber)
	{
		this.streetNumber = streetNumber;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}
}
