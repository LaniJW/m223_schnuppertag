package ch.nyp.schnuppertag_software.webcontext.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String name);
	
	void deleteByUsername(String name);
}