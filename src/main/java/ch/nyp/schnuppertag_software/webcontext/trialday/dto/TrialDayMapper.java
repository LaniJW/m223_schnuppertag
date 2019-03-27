package ch.nyp.schnuppertag_software.webcontext.trialday.dto;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.trialday.TrialDay;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-27
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrialDayMapper {
	TrialDayDTO toDTO(TrialDay trialDay);
	List<TrialDayDTO> toDTOs(List<TrialDay> trialDay);

	TrialDay fromDTO(TrialDayDTO trialDayDto);
	List<TrialDay> fromDTO(List<TrialDayDTO> trialDayDto);
}