package ch.nyp.schnuppertag_software.webcontext.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-20
 *
 */

@Entity 
@Table(name = "tbl_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "street_number")
	private String streetNumber;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	// Constructor - empty
	public Address() {
		super();
	}

	// Constructor - With id
	public Address(Long id, String name, String streetName, String streetNumber, String zipCode, String city,
			String country) {
		super();
		this.id = id;
		this.name = name;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}
	
	// Constructor - Without id
	public Address(String name, String streetName, String streetNumber, String zipCode, String city, String country) {
		super();
		this.name = name;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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
