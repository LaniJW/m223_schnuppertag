package ch.nyp.schnuppertag_software.webcontext.specialization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-20
 *
 */

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
	
}
