package ch.nyp.schnuppertag_software.webcontext.authorization.dto;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

public class AuthorizationWIDDTO {

	private Long id;
	private String access;
	
	public AuthorizationWIDDTO() {
		super();
	}

	public AuthorizationWIDDTO(Long id, String access) {
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

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
}
