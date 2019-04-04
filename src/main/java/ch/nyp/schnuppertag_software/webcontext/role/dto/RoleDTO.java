package ch.nyp.schnuppertag_software.webcontext.role.dto;

import java.util.List;

import ch.nyp.schnuppertag_software.webcontext.authorization.Authorization;

/**
 *
 * @author Lani Wagner
 * @since 2019-04-03
 *
 */

public class RoleDTO
{
	private String name;
	private List<Authorization> authorizations;

	public RoleDTO()
	{
	}

	public RoleDTO(String name, List<Authorization> authorizations)
	{
		this.name = name;
		this.authorizations = authorizations;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Authorization> getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(List<Authorization> authorizations) {
		this.authorizations = authorizations;
	}
	
}
