package ch.nyp.schnuppertag_software.webcontext.trainer.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.trainer.Trainer;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-21
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainerMapper {
	TrainerDTO toDTO(Trainer trainer);
	List<TrainerDTO> toDTOs(List<Trainer> trainer);
}