package ch.nyp.schnuppertag_software.webcontext.role;

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
	private Authorization authorization;

	public Role(){}

	public Role(Long id, String name, Authorization authorization)
	{
		this.id = id;
		this.name = name;
		this.authorization = authorization;
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

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	
}
