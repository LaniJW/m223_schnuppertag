package ch.nyp.schnuppertag_software.webcontext.user;

import ch.nyp.schnuppertag_software.webcontext.authorization.Authorization;

import ch.nyp.schnuppertag_software.webcontext.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-04-03
 *
 */

public class UserDetailsImpl implements UserDetails{
	
	private User user;

	public UserDetailsImpl() {
		super();
	}

	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			for (Authorization authorization : role.getAuthorizations()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authorization.getName()));
			}
		}
		return grantedAuthorities;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		// TODO implement account expired check
		return true;
	}
	
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}

	public boolean isCredentialsNonExpired() {
		// TODO implement credentials expired check
		return true;
	}

	public boolean isEnabled() {
		return user.isEnabled();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
