package ch.nyp.schnuppertag_software.webcontext.authorization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

}
