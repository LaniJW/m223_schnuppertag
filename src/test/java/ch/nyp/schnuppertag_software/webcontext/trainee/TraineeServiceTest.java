package ch.nyp.schnuppertag_software.webcontext.trainee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.nyp.schnuppertag_software.data.DataGenerators;
import ch.nyp.schnuppertag_software.webcontext.address.Address;
import ch.nyp.schnuppertag_software.webcontext.address.AddressRepository;
import ch.nyp.schnuppertag_software.webcontext.address.AddressService;
import ch.nyp.schnuppertag_software.webcontext.address.DataHolder;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-28
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTest {

	@InjectMocks
	private TraineeService traineeService;

	@Mock
	private AddressRepository traineeRepository;

	private DataHolder<Trainee> dataHolder;

	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Trainee.class).generate();
	}

	@Test
	public void findById_idExists_returnsTrainee() {
		// setup mock
		var trainee = dataHolder.first();
		when(traineeRepository.findById(trainee.getId())).thenReturn(Optional.of(trainee));

		// test service
		assertThat(traineeService.findById(trainee.getId())).isPresent().contains(trainee);
	}

	@Test
	public void findById_idDoesNotExist_returnsAddress() {
		// no mock setup required

		// test service
		assertThat(traineeService.getById(1312L)).isEmpty();
	}
}
