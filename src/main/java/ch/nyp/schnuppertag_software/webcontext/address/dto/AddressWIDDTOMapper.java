package ch.nyp.schnuppertag_software.webcontext.address.dto;

import ch.nyp.schnuppertag_software.webcontext.address.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 *
 * @author Lani Wagner
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressWIDDTOMapper {
	AddressWIDDTO toDTO(Address address);
	AddressWIDDTO toDTO(AddressDTO addressDto);
	List<AddressWIDDTO> toDTOs(List<Address> address);

	Address fromDTO(AddressWIDDTO AddresswIdDto);
	List<Address> fromDTO(List<AddressWIDDTO> AddresswIdDto);
}
