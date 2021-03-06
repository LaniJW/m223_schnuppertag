package ch.nyp.schnuppertag_software.webcontext.trainee.dto;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.user.User;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-04-04
 *
 */

public class TraineeWIDDTO {

	private Long id;
	
	private Address address;
	
	private Integer age;

	private String phoneNumber;

	private String email;

	private User user;

	public TraineeWIDDTO() {
		super();
	}

	public TraineeWIDDTO(Long id, Address address, Integer age, String phoneNumber, String email, User user) {
		super();
		this.id = id;
		this.address = address;
		this.age = age;
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

	public Integer getAge() {
		return age;
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

	public void setAge(Integer age) {
		this.age = age;
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
