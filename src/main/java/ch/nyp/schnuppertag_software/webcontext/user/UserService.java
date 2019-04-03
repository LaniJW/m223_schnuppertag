package ch.nyp.schnuppertag_software.webcontext.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

@Service
public class UserService {
	
	UserRepository userRepository;
	
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
}

