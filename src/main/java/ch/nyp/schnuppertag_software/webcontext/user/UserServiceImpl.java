package ch.nyp.schnuppertag_software.webcontext.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl extends UserService {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		super(userRepository);
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = findByUsername(username);

		if (user == null)
		{
			throw new UsernameNotFoundException("User could not be found");
		}
		return new UserDetailsImpl(user);
	}

	public User findByUsername(String name)
	{
		User user = ((UserRepository) userRepository).findByUsername(name);
		return user;
	}

	public void deleteByUsername(String name)
	{
		((UserRepository) userRepository).deleteByUsername(name);
	}
}