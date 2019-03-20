package ch.nyp.schnuppertag_software.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-20
 *
 */

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
