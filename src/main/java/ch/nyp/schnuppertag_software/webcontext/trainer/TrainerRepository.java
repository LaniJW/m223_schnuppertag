package ch.nyp.schnuppertag_software.webcontext.trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Lani Wagner
 * @since 2019-03-20
 *
 */

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>{
	
}
