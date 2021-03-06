package ch.nyp.schnuppertag_software.webcontext.authorization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

@Entity
@Table(name = "tbl_authorization")
public class Authorization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	public Authorization() {
		super();
	}

	public Authorization(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Authorization(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
