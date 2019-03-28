package ch.nyp.schnuppertag_software.webcontext.address;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

	 @InjectMocks
	    private AddressService addressService;

	    @Mock
	    private AddressRepository addressRepository;

	    private DataHolder<Address> dataHolder;
	    
	    @Before
	    public void setup() {
	        this.dataHolder = DataGenerators.forClass(Address.class).generate();
	    }
	    
	    @Test
	    public void findById_idExists_returnsAddress() {
	        // setup mock
	        var address = dataHolder.first();
	        when(addressRepository.findById(address.getId()))
	                .thenReturn(Optional.of(address));

	        // test service
	        assertThat(addressService.findById(address.getId()))
	                .isPresent()
	                .contains(address);
	    }

	    @Test
	    public void findById_idDoesNotExist_returnsAddress() {
	        // no mock setup required

	        // test service
	        assertThat(addressService.getById(1312L))
	                .isEmpty();
	    }
}