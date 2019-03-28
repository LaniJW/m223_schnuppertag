package ch.nyp.schnuppertag_software.webcontext.location;

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
import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.address.AddressController;
import ch.nyp.schnuppertag_software.webcontext.address.AddressService;
import ch.nyp.schnuppertag_software.webcontext.address.AddressValidation;
import ch.nyp.schnuppertag_software.webcontext.address.DataHolder;
import ch.nyp.schnuppertag_software.webcontext.address.dto.AddressMapper;
import ch.nyp.schnuppertag_software.webcontext.location.dto.LocationMapper;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LocationController.class, includeFilters = {
        @Filter(classes = {LocationValidation.class, LocationMapper.class},
                type = FilterType.ASSIGNABLE_TYPE)
})
public class LocationControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LocationMapper locationMapper;

    private DataHolder<Location> dataHolder;

    @Before
    public void setup() {
        this.dataHolder = DataGenerators.forClass(Location.class).generate();
    }
    
    @Test
    public void test() throws Exception {
        // setup mock
        when(locationService.getAll()).thenReturn(dataHolder.asList());

        // create request
        var expectedJson = objectMapper.writeValueAsString(
        		locationMapper.toDTOs(dataHolder.asList())
        );

        mockMvc.perform(get("/", ""))
                // .andDo(print()) prints out request/response info
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
