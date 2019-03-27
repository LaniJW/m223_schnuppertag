package ch.nyp.schnuppertag_software.webcontext.address.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.address.Address;

/**
 *
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
	AddressDTO toDTO(Address address);
	List<AddressDTO> toDTOs(List<Address> address);

	Address fromDTO(AddressDTO addressDto);
	List<Address> fromDTO(List<AddressDTO> addressDto);
}