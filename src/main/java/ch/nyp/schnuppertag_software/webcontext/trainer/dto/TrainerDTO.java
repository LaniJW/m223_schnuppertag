package ch.nyp.schnuppertag_software.webcontext.trainer.dto;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-21
 *
 */

public class TrainerDTO {
	
	private Address address;
	
	private Specialization specialization;
	
	private String phoneNumber;
	
	private String email;

	public TrainerDTO() {
		super();
	}

	public TrainerDTO(Address address, Specialization specialization, String phoneNumber, String email) {
		super();
		this.address = address;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public Specialization getSpecialization() {
		return specialization;
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

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
