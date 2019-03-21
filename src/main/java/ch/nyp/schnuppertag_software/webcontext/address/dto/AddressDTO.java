package ch.nyp.schnuppertag_software.webcontext.address.dto;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-21
 *
 */

public class AddressDTO {
	
private String name;
	
	private String streetName;
	
	private String streetNumber;
	
	private String zipCode;

	private String city;
	
	private String country;
	
	public AddressDTO() {
		super();
	}

	public AddressDTO(String name, String streetName, String streetNumber, String zipCode, String city,
			String country) {
		super();
		this.name = name;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
