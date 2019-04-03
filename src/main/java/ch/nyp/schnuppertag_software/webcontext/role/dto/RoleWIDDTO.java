package ch.nyp.schnuppertag_software.webcontext.role.dto;

/**
 *
 * @author Lani Wagner
 * @since 2019-04-03
 *
 */

public class RoleWIDDTO
{
	private Long id;
	private String name;

	public RoleWIDDTO()
	{
	}

	public RoleWIDDTO(Long id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
