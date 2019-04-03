package ch.nyp.schnuppertag_software.webcontext.user;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public LocalDate getAccountExpirationDate() {
		return accountExpirationDate;
	}

	public void setAccountExpirationDate(LocalDate accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	public LocalDate getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	public void setCredentialsExpirationDate(LocalDate credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
