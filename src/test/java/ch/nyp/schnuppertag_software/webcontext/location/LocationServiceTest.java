package ch.nyp.schnuppertag_software.webcontext.location;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.address.AddressRepository;
import ch.nyp.schnuppertag_software.webcontext.address.AddressService;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

	@InjectMocks
	private LocationService locationService;

	@Mock
	private LocationRepository locationRepository;

	private DataHolder<Location> dataHolder;

	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Location.class).generate();
	}

	@Test
	public void findById_idExists_returnsAddress() {
		// setup mock
		var address = dataHolder.first();
		when(locationRepository.findById(address.getId())).thenReturn(Optional.of(location));

		// test service
		assertThat(locationService.findById(address.getId())).isPresent().contains(location);
	}

	@Test
	public void findById_idDoesNotExist_returnsLocation() {
		// no mock setup required

		// test service
		assertThat(locationService.getById(1312L)).isEmpty();
	}
}
