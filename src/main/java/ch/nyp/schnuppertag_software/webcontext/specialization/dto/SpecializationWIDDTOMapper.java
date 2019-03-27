package ch.nyp.schnuppertag_software.webcontext.specialization.dto;
import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;
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
public interface SpecializationWIDDTOMapper {
	SpecializationWIDDTO toDTO(Specialization specialization);
	SpecializationWIDDTO toDTO(SpecializationDTO specializationDto);
	List<SpecializationWIDDTO> toDTOs(List<Specialization> specialization);

	Specialization fromDTO(SpecializationWIDDTO specializationDto);
	List<Specialization> fromDTO(List<SpecializationWIDDTO> specializationDto);
}
