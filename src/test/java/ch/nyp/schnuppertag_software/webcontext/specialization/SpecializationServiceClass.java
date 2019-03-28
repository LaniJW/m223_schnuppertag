package ch.nyp.schnuppertag_software.webcontext.specialization;

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
public class SpecializationServiceClass {

	@InjectMocks
	private SpecializationService specializationService;

	@Mock
	private SpecializationRepository specializationRepository;

	private DataHolder<Specialization> dataHolder;

	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Specialization.class).generate();
	}

	@Test
	public void findById_idExists_returnsSpecialization() {
		// setup mock
		var specialization = dataHolder.first();
		when(specializationRepository.findById(specialization.getId())).thenReturn(Optional.of(specialization));

		// test service
		assertThat(specializationService.findById(specialization.getId())).isPresent().contains(specialization);
	}

	@Test
	public void findById_idDoesNotExist_returnsAddress() {
		// no mock setup required

		// test service
		assertThat(specializationService.getById(1312L)).isEmpty();
	}
}
