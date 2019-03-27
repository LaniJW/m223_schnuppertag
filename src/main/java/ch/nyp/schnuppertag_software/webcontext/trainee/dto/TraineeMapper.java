package ch.nyp.schnuppertag_software.webcontext.trainee.dto;

import java.util.List;

import ch.nyp.schnuppertag_software.webcontext.trainee.Trainee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraineeMapper {
	TraineeDTO toDTO(Trainee trainee);
	List<TraineeDTO> toDTOs(List<Trainee> trainee);

	Trainee fromDTO(TraineeDTO traineeDto);
	List<Trainee> fromDTO(List<TraineeDTO> traineeDto);
}