package ch.nyp.schnuppertag_software.webcontext.authorization.dto;

import ch.nyp.schnuppertag_software.webcontext.authorization.Access;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

public class AuthorizationDTO {
	
	private Access access;

	public AuthorizationDTO() {
		super();
	}

	public AuthorizationDTO(Access access) {
		super();
		this.access = access;
	}

	public Access getAccess() {
		return access;
	}
	
	public void setAccess(Access access) {
		this.access = access;
	}

}
