package ch.nyp.schnuppertag_software.webcontext.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService
{
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * @param repository
	 */
	@Autowired
	UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/**
	 * {@inheritDoc}
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = findByUsername(username);

		if (user == null)
		{
			throw new UsernameNotFoundException("User could not be found");
		}
		return new UserDetailsImpl(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public User findByUsername(String name)
	{
		User user = ((UserRepository) repository).findByUsername(name);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteByUsername(String name)
	{
		((UserRepository) repository).deleteByUsername(name);
	}
}