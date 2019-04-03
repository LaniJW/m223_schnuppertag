package ch.nyp.schnuppertag_software.webcontext.authorization.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.nyp.schnuppertag_software.webcontext.authorization.Authorization;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorizationMapper {
	AuthorizationDTO toDTO(Authorization authorization);
	List<AuthorizationDTO> toDTOs(List<Authorization> authorization);
	
	Authorization fromDTO(AuthorizationDTO authorizationDto);
	List<Authorization> fromDTOs(List<AuthorizationDTO> authorizationDto);
	
	AuthorizationWIDDTO toDTOwId(Authorization authorization);
	AuthorizationWIDDTO toDTOwId(AuthorizationDTO authorizationDto);
	List<AuthorizationWIDDTO> toDTOwIds(List<Authorization> authorization);
	
	Authorization fromDTOwId(AuthorizationWIDDTO authorizationwIdDto);
	List<Authorization> fromDTOwIds(List<AuthorizationWIDDTO> authorizationwIdDto);

}
