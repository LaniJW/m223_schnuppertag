package ch.nyp.schnuppertag_software.webcontext.trainee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

}
