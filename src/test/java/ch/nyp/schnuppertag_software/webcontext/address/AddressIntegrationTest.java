package ch.nyp.schnuppertag_software.webcontext.address;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.nyp.schnuppertag_software.data.DataGenerators;
import ch.nyp.schnuppertag_software.data.DataHolder;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
public class AddressIntegrationTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private EntityManager entityManager;

	    @Autowired
	    private ObjectMapper objectMapper;

	    @Autowired
	    private AddressMapper addressMapper;

	    private DataHolder<Address> dataHolder;

	    @Before
	    public void setup() {
	
	        dataHolder = DataGenerators.forClass(Address.class).generate();
	        dataHolder.asList().stream()
	                .peek(a -> a.setId(null))
	                .forEach(entityManager::persist);

	    }

	    @Test
	    public void test() throws Exception {
	        var expectedJson = objectMapper.writeValueAsString(
	                addressMapper.toDTOs(dataHolder.asList())
	        );

	        mockMvc.perform(get("/addresses"))
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().json(expectedJson));
	    }
}

