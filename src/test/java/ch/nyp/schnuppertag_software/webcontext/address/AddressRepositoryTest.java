package ch.nyp.schnuppertag_software.webcontext.address;

import static org.assertj.core.api.Assertions.assertThat;

import ch.nyp.schnuppertag_software.data.DataGenerators;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ch.nyp.schnuppertag_software.data.DataHolder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@DataJpaTest
public class AddressRepositoryTest {

	@Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TestEntityManager entityManager;

    private DataHolder<Address> dataHolder;
    
    @Before
    public void setup() {
        dataHolder = DataGenerators.forClass(Address.class).generate();
        dataHolder.asList().stream()
                .peek(a -> a.setId(null))
                .forEach(entityManager::persist);
    }

    @Test
    public void findAll_returnsAll() {
       assertThat(addressRepository.findAll()).containsExactlyElementsOf(dataHolder.asList());
    }  
}
