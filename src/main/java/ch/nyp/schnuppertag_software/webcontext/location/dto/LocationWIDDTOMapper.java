package ch.nyp.schnuppertag_software.webcontext.location.dto;

import ch.nyp.schnuppertag_software.webcontext.location.Location;
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
public interface LocationWIDDTOMapper {
	LocationWIDDTO toDTO(Location location);
	LocationWIDDTO toDTO(LocationDTO locationDto);
	List<LocationWIDDTO> toDTOs(List<Location> location);

	Location fromDTO(LocationWIDDTO locationDto);
	List<Location> fromDTO(List<LocationWIDDTO> locationDto);
}
