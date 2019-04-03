package ch.nyp.schnuppertag_software.webcontext.user;

import ch.nyp.schnuppertag_software.webcontext.authorization.Authorization;
import ch.nyp.schnuppertag_software.webcontext.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl
{
	private User user;

	/**
	 *
	 */
	public UserDetailsImpl() {
		super();
	}

	/**
	 * @param user
	 */
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			for (Authorization authorization: role.getAuthorizations()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authorization.getAccess()));
			}
		}
		return grantedAuthorities;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPassword() {
		return user.getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUsername() {
		return user.getUsername();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAccountNonExpired() {
		// TODO implement account expired check
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isCredentialsNonExpired() {
		// TODO implement credentials expired check
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isEnabled() {
		return user.isEnabled();
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
