package ch.nyp.schnuppertag_software.security;

import ch.nyp.schnuppertag_software.webcontext.authorization.Authorization;
import ch.nyp.schnuppertag_software.webcontext.authorization.AuthorizationRepository;
import ch.nyp.schnuppertag_software.webcontext.role.Role;
import ch.nyp.schnuppertag_software.webcontext.role.RoleRepository;
import ch.nyp.schnuppertag_software.webcontext.user.User;
import ch.nyp.schnuppertag_software.webcontext.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
public class PostgresLoader {

	@Autowired
	public PostgresLoader(UserRepository repository, BCryptPasswordEncoder pwEncoder, RoleRepository roleRepository, AuthorizationRepository authorizationRepository) {
		var auth = new Authorization("admin");
		authorizationRepository.save(auth);

		var role = new Role("admin", List.of(
				auth
		));
		roleRepository.save(role);

		var user = new User(
				"admin",
				pwEncoder.encode("admin"),
				Set.of(role),
				LocalDate.now().plusDays(5),
				LocalDate.now().plusDays(5),
				false,
				true
		);

		repository.save(user);
	}

}
