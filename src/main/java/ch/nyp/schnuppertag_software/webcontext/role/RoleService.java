package ch.nyp.schnuppertag_software.webcontext.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lani Wagner
 * @since 2019-04-03
 *
 */
@Service
public class RoleService
{
	RoleRepository roleRepository;

	@Autowired
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public Optional<Role> getById(Long id) {
		Optional<Role> role = roleRepository.findById(id);
		return role;
	}

	public void save(Role role) {
		roleRepository.save(role);
	}

	public List<Role> getAll() {
		List<Role> rolees = roleRepository.findAll();
		return rolees;
	}

	public void updateById(Role role, Long id) {
		Optional<Role> currentRole = roleRepository.findById(id);
		if (currentRole.isPresent()) {
			role.setId(id);
			this.save(role);
		}
	}

	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}
}
