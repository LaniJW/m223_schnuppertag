package ch.nyp.schnuppertag_software.webcontext.authorization.dto;

import ch.nyp.schnuppertag_software.webcontext.authorization.Access;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

public class AuthorizationWIDDTO {

	private Long id;
	private Access access;
	
	public AuthorizationWIDDTO() {
		super();
	}

	public AuthorizationWIDDTO(Long id, Access access) {
		super();
		this.id = id;
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
