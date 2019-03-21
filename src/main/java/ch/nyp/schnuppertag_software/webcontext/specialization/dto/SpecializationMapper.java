package ch.nyp.schnuppertag_software.webcontext.specialization.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.specialization.Specialization;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-21
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpecializationMapper {
	SpecializationDTO toDTO(Specialization specialization);

	List<SpecializationDTO> toDTOs(List<Specialization> specialization);
}