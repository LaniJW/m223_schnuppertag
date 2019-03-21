package ch.nyp.schnuppertag_software.webcontext.trainee.dto;

import ch.nyp.schnuppertag_software.webcontext.address.Address;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-21
 *
 */

public class TraineeDTO {

	private Address address;
	
	private Integer age;

	private String phoneNumber;

	private String email;

	public TraineeDTO() {
		super();
	}

	public TraineeDTO(Address address, Integer age, String phoneNumber, String email) {
		super();
		this.address = address;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public Integer getAge() {
		return age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
