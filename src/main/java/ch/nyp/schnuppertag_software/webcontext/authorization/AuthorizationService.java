package ch.nyp.schnuppertag_software.webcontext.authorization;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-04-03
 *
 */
@Service
public class AuthorizationService {
	
	AuthorizationRepository authorizationRepository;
	
	@Autowired
	public AuthorizationService(AuthorizationRepository authorizationRepository) {
		this.authorizationRepository = authorizationRepository;
	}
	
	public Optional<Authorization> getById(Long id){
		Optional<Authorization> authorization = authorizationRepository.findById(id);
		return authorization;
	}
	
	public void save(Authorization authorization) {
		authorizationRepository.save(authorization);
	}
	
	public void updateById(Authorization authorization, Long id) {
		Optional<Authorization> currentAuthorization = authorizationRepository.findById(id);
		if(currentAuthorization.isPresent()) {
			authorization.setId(id);
			this.save(authorization);
		}
	}
	
	public void deleteById(Long id) {
		authorizationRepository.deleteById(id);
	}
	
	public List<Authorization> getAll() {
		List<Authorization> authorizations = authorizationRepository.findAll();
		return authorizations;
	}
	

}
