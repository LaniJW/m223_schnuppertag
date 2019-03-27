package ch.nyp.schnuppertag_software.webcontext.specialization.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;

/**
 *
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpecializationMapper {
	SpecializationDTO toDTO(Specialization specialization);
	List<SpecializationDTO> toDTOs(List<Specialization> specialization);

	Specialization fromDTO(SpecializationDTO specializationDto);
	List<Specialization> fromDTOs(List<SpecializationDTO> specializationDto);
	
	SpecializationWIDDTO toDTOwId(Specialization specialization);
	SpecializationWIDDTO toDTOwId(SpecializationDTO specializationDto);
	List<SpecializationWIDDTO> toDTOwIds(List<Specialization> specialization);

	Specialization fromDTOwId(SpecializationWIDDTO specializationwIdDto);
	List<Specialization> fromDTOwIds(List<SpecializationWIDDTO> specializationwIdDto);
}