package ch.nyp.schnuppertag_software.webcontext.user;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Type;


import ch.nyp.schnuppertag_software.webcontext.role.Role;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

@Entity
@Table(name = "users")
public class User {

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_role",
		joinColumns = @JoinColumn(name = "users_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles;

	@Column(name = "account_expiration_date")
	private LocalDate accountExpirationDate;

	@Column(name = "credentials_expiration_date")
	private LocalDate credentialsExpirationDate;

	@Column(name = "locked")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean locked;

	@Column(name = "enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enabled;
}
