package ch.nyp.schnuppertag_software.webcontext.specialization;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.nyp.schnuppertag_software.data.DataGenerators;
import ch.nyp.schnuppertag_software.data.DataHolder;
import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.address.AddressController;
import ch.nyp.schnuppertag_software.webcontext.address.AddressService;
import ch.nyp.schnuppertag_software.webcontext.address.AddressValidation;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressMapper;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AddressController.class, includeFilters = {
        @Filter(classes = {AddressValidation.class, AddressMapper.class},
                type = FilterType.ASSIGNABLE_TYPE)
})
public class SpecializationControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService specializationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SpecializationMapper specializationMapper;

    private DataHolder<Specialization> dataHolder;

    @Before
    public void setup() {
        this.dataHolder = DataGenerators.forClass(Specialization.class).generate();
    }

    @Test
    public void test() throws Exception {
        // setup mock
        when(specializationService.getAll()).thenReturn(dataHolder.asList());

        // create request
        var expectedJson = objectMapper.writeValueAsString(
                specializationMapper.toDTOs(dataHolder.asList())
        );

        mockMvc.perform(get("/", ""))
                // .andDo(print()) prints out request/response info
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
