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
	
	@Column(name = "access")
	private Access access;
	
	public Authorization() {
		super();
	}

	public Authorization(Long id, Access access) {
		super();
		this.id = id;
		this.access = access;
	}

	public Authorization(Access access) {
		super();
		this.access = access;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}
	
}
