package ch.nyp.schnuppertag_software.webcontext.trainee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.user.User;

/**
 * 
 * @author Lani Wagner
 * @since 2019-04-04
 *
 */

@Entity
@Table(name = "tbl_trainee")
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "age")
	private Integer age;

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

	public Trainee(Long id, String uuid, Integer age, Address address, String phoneNumber, String email, User user) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user = user;
	}

	public Trainee(String uuid, Integer age, Address address, String phoneNumber, String email, User user) {
		super();
		this.uuid = uuid;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user = user;
	}
	
	public Trainee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
