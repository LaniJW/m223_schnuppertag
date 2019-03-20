package ch.schnuppertag_software.webcontent.trialday;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-20
 *
 */

@Repository
public interface TrialDayRepository extends JpaRepository<TrialDay, Long> {

}
