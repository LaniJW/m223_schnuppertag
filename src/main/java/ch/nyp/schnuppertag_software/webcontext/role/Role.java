package ch.nyp.schnuppertag_software.webcontext.role;

import java.util.List;

import javax.persistence.*;

import ch.nyp.schnuppertag_software.webcontext.authorization.Authorization;

/**
 *
 * @author Lani Wagner
 * @since 2019-04-03
 *
 */

@Entity
@Table(name = "tbl_role")
public class Role
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name ="name")
	private String name;

	@ManyToMany(targetEntity = Authorization.class)
	@Column(name = "authorization_fk")
	private List<Authorization> authorizations;

	public Role(){}

	public Role(Long id, String name, List<Authorization> authorizations)
	{
		this.id = id;
		this.name = name;
		this.authorizations = authorizations;
	}

	public Role(String name)
	{
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

	public List<Authorization> getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(List<Authorization> authorizations) {
		this.authorizations = authorizations;
	}
	
}
