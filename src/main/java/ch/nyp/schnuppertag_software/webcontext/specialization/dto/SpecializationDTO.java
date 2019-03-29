package ch.nyp.schnuppertag_software.webcontext.specialization.dto;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-21
 *
 */

public class SpecializationDTO {

	private String title;
	private String description;
	
	public SpecializationDTO() {
		super();
	}

	public SpecializationDTO(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
