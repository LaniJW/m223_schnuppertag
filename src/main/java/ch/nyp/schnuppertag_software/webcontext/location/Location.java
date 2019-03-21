package ch.nyp.schnuppertag_software.webcontext.location;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.trialday.TrialDay;

/**
 * 
 * @author Alexandra Girsberger
 * @author 2019-03-20
 *
 */

@Entity
@Table(name = "tbl_location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(targetEntity = Address.class)
	@JoinColumn(name = "address_fk")
	private Address address;
	
	@OneToMany(targetEntity = TrialDay.class)
	@JoinColumn(name = "trialday_fk")
	private List<TrialDay> trialDays;

	public Location() {
		super();
	}

	public Location(Long id, Address address, List<TrialDay> trialDays) {
		super();
		this.id = id;
		this.address = address;
		this.trialDays = trialDays;
	}

	public Location(Address address, List<TrialDay> trialDays) {
		super();
		this.address = address;
		this.trialDays = trialDays;
	}

	public Long getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public List<TrialDay> getTrialDays() {
		return trialDays;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setTrialDays(List<TrialDay> trialDays) {
		this.trialDays = trialDays;
	}	

}
