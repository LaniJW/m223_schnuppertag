package ch.nyp.schnuppertag_software.webcontext.trainer.dto;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.trainer.Trainer;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainerMapper {
	TrainerDTO toDTO(Trainer trainer);
	TrainerWIDDTO toDTO(TrainerDTO trainerDto);
	List<TrainerDTO> toDTOs(List<Trainer> trainer);

	Trainer fromDTO(TrainerDTO trainerDto);
	List<Trainer> fromDTOs(List<TrainerDTO> trainerDto);
	
	TrainerWIDDTO toDTOwId(Trainer trainer);
	TrainerWIDDTO toDTOwId(TrainerDTO trainerDto);
	List<TrainerWIDDTO> toDTOwIds(List<Trainer> trainer);

	Trainer fromDTOwId(TrainerWIDDTO trainerwIdDto);
	List<Trainer> fromDTOwIds(List<TrainerWIDDTO> trainerwIdDto);
}