package ch.nyp.schnuppertag_software.webcontext.trainer.dto;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;
import ch.nyp.schnuppertag_software.webcontext.user.User;

/**
 *
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-04-04
 *
 */

public class TrainerWIDDTO {
	
	private Long id;
	
	private Address address;
	
	private Specialization specialization;
	
	private String phoneNumber;
	
	private String email;

	private User user;

	public TrainerWIDDTO() {
		super();
	}

	public TrainerWIDDTO(Long id, Address address, Specialization specialization, String phoneNumber, String email, User user) {
		super();
		this.id = id;
		this.address = address;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user = user;
	}
	
	public Long getId() {
		return id;
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
	
	public void setId(Long id) {
		this.id = id;
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

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
}
