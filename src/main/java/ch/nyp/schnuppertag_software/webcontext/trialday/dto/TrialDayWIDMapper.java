package ch.nyp.schnuppertag_software.webcontext.trialday.dto;

import java.util.List;

import ch.nyp.schnuppertag_software.webcontext.trialday.TrialDay;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrialDayWIDMapper {
	TrialDayWIDDTO toDTO(TrialDay trialDay);
	List<TrialDayWIDDTO> toDTOs(List<TrialDay> trialDay);

	TrialDay fromDTO(TrialDayWIDDTO trialDaywIdDto);
	List<TrialDay> fromDTO(List<TrialDayWIDDTO> trialDaywIdDto);
}