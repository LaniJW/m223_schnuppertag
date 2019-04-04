package ch.nyp.schnuppertag_software.webcontext.user;

import java.util.List;
import java.util.Optional;

import ch.nyp.schnuppertag_software.webcontext.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-04-04
 *
 */

@Service
public class UserService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Optional<User> getById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	public void save(User user) {
		userRepository.save(user);
	}
	
	public void updateById(User user, Long id) {
		Optional<User> currentUser = userRepository.findById(id);
		if (currentUser.isPresent()) {
			user.setId(id);
			this.save(user);
		}
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	public List<User> getAll() {
		List<User> user = userRepository.findAll();
		return user;
	}

	@Override
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
		User user = userRepository.findByUsername(name);
		return user;
	}

	public void deleteByUsername(String name)
	{
		userRepository.deleteByUsername(name);
	}
}

