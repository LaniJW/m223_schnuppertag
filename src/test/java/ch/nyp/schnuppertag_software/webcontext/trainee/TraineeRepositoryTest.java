package ch.nyp.schnuppertag_software.webcontext.trainee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.address.AddressRepository;
import ch.nyp.schnuppertag_software.webcontext.address.DataHolder;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@DataJpaTest
public class TraineeRepositoryTest {
	
	@Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private TestEntityManager entityManager;

    private DataHolder<Trainee> dataHolder;
    
    @Before
    public void setup() {
    		   
    }

    @Test
    public void findAll_returnsAll() {
       assertThat(traineeRepository.findAll()).containsExactlyElementsOf(dataHolder.asList());
    }  

}
