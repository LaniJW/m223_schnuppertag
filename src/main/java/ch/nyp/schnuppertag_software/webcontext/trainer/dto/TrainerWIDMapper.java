package ch.nyp.schnuppertag_software.webcontext.trainer.dto;

import java.util.List;

import ch.nyp.schnuppertag_software.webcontext.trainer.Trainer;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainerWIDMapper {
	TrainerWIDDTO toDTO(Trainer trainer);
	List<TrainerWIDDTO> toDTOs(List<Trainer> trainer);

	Trainer fromDTO(TrainerWIDDTO trainerwIdDto);
	List<Trainer> fromDTO(List<TrainerWIDDTO> trainerwIdDto);
}