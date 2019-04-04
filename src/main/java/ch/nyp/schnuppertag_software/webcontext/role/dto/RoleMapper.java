package ch.nyp.schnuppertag_software.webcontext.role.dto;

import ch.nyp.schnuppertag_software.webcontext.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 *
 * @author Lani Wagner
 * @since 2019-04-03
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper
{
	RoleDTO toDTO(Role role);
	List<RoleDTO> toDTOs(List<Role> role);

	Role fromDTO(RoleDTO roleDto);
	List<Role> fromDTOs(List<RoleDTO> roleDto);

	RoleWIDDTO toDTOwId(Role role);
	RoleWIDDTO toDTOwId(RoleDTO roleDto);
	List<RoleWIDDTO> toDTOwIds(List<Role> role);

	Role fromDTOwId(RoleWIDDTO RolewIdDto);
	List<Role> fromDTOwIds(List<RoleWIDDTO> RolewIdDto);
}
