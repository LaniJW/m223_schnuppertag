package ch.nyp.schnuppertag_software.webcontext.location.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.location.Location;

/**
 *
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationMapper {
	LocationDTO toDTO(Location location);
	List<LocationDTO> toDTOs(List<Location> location);

	Location fromDTO(LocationDTO locationDto);
	List<Location> fromDTO(List<LocationDTO> locationDto);
}