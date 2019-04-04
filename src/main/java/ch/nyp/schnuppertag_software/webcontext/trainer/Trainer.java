package ch.nyp.schnuppertag_software.webcontext.trainer;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;
import ch.nyp.schnuppertag_software.webcontext.user.User;

/**
 * 
 * @author Lani Wagner
 * @since 2019-04-04
 *
 */

@Entity
@Table(name = "tbl_trainer")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "specialization_fk")
	private Specialization specialization;
	
	@ManyToOne
	@JoinColumn(name = "address_fk")
	private Address address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User user;

	public Trainer(Long id, Specialization specialization, Address address, String phoneNumber, String email, User user) {
		super();
		this.id = id;
		this.specialization = specialization;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user = user;
	}

	public Trainer(Specialization specialization, Address address, String phoneNumber, String email, User user) {
		super();
		this.specialization = specialization;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user = user;
	}

	public Trainer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
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
