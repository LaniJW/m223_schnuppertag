package ch.nyp.schnuppertag_software.webcontext.role;

import javax.persistence.*;

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

	//TODO: Add reference to Authorization and its setters and getters.

	public Role(){}

	public Role(Long id, String name)
	{
		this.id = id;
		this.name = name;
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
}
