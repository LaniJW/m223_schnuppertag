package ch.nyp.schnuppertag_software.webcontext.role.dto;

/**
 *
 * @author Lani Wagner
 * @since 2019-04-03
 *
 */

public class RoleDTO
{
	private String name;

	public RoleDTO()
	{
	}

	public RoleDTO(String name)
	{
		this.name = name;
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
