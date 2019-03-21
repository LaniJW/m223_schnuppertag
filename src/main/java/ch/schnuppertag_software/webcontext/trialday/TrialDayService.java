package ch.schnuppertag_software.webcontext.trialday;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Alexandra Girsberger
 * @since 2019-03-20
 *
 */

@Service
public class TrialDayService {
	
	TrialDayRepository trialDayRepository;
	
	@Autowired
	public TrialDayService(TrialDayRepository trialDayRepository) {
		this.trialDayRepository = trialDayRepository;
	}
	public Optional<TrialDay> getById(Long id) {
		Optional<TrialDay> trialDay = trialDayRepository.findById(id);
		return trialDay;
	}

}
