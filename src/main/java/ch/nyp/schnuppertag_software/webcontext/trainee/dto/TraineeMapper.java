package ch.nyp.schnuppertag_software.webcontext.trainee.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.trainee.Trainee;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-21
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraineeMapper {
	TraineeDTO toDTO(Trainee trainee);

	List<TraineeDTO> toDTOs(List<Trainee> trainee);
}