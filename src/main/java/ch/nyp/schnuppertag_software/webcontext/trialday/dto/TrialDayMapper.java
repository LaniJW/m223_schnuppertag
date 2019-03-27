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
	List<TrialDay> fromDTOs(List<TrialDayDTO> trialDayDto);
	
	TrialDayWIDDTO toDTOwId(TrialDay trialDay);
	TrialDayWIDDTO toDTOwId(TrialDayDTO trialDayDto);
	List<TrialDayWIDDTO> toDTOwIds(List<TrialDay> trialDay);

	TrialDay fromDTOwId(TrialDayWIDDTO trialDaywIdDto);
	List<TrialDay> fromDTOwIds(List<TrialDayWIDDTO> trialDaywIdDto);
}