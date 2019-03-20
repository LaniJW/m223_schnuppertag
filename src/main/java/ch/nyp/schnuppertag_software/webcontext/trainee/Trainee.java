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

	public Trainee(Long id, String uuid, Integer age, Address address, String phoneNumber, String email) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Trainee(String uuid, Integer age, Address address, String phoneNumber, String email) {
		super();
		this.uuid = uuid;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
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
}
