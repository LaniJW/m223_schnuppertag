package ch.nyp.schnuppertag_software.webcontext.trainee.dto;

import java.util.List;

import ch.nyp.schnuppertag_software.webcontext.trainee.Trainee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraineeWIDMapper {
	TraineeWIDDTO toDTO(Trainee trainee);
	List<TraineeWIDDTO> toDTOs(List<Trainee> trainee);

	Trainee fromDTO(TraineeWIDDTO traineewIdDto);
	List<Trainee> fromDTO(List<TraineeWIDDTO> traineewIdDto);
}