package ch.nyp.schnuppertag_software.webcontext.specialization.dto;

/**
 *
 * @author Lani Wagner
 * @since 2019-03-27
 *
 */

public class SpecializationWIDDTO {
	private Long id;
	private String title;
	private String description;

	public SpecializationWIDDTO()
	{
		super();
	}

	public SpecializationWIDDTO(Long id, String title, String description)
	{
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
