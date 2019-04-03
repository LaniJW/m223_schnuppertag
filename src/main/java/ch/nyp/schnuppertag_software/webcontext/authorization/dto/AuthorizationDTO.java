package ch.nyp.schnuppertag_software.webcontext.authorization.dto;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

public class AuthorizationDTO {
	
	private String access;

	public AuthorizationDTO() {
		super();
	}

	public AuthorizationDTO(String access) {
		super();
		this.access = access;
	}

	public String getAccess() {
		return access;
	}
	
	public void setAccess(String access) {
		this.access = access;
	}

}
