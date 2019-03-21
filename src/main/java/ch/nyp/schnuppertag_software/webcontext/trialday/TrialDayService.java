package ch.nyp.schnuppertag_software.webcontext.trialday;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Alexandra Girsberger, Lani Wagner
 * @since 2019-03-21
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

	public void save(TrialDay trialDay) {
		trialDayRepository.save(trialDay);
	}
	
	public void updateById(TrialDay trialDay, Long id) {
		Optional<TrialDay> currentTrialDay = trialDayRepository.findById(id);
		if (currentTrialDay.isPresent()) {
			trialDay.setId(id);
			this.save(trialDay);
		}
	}
	
	public void deleteById(Long id) {
		trialDayRepository.deleteById(id);
	}
	
	public List<TrialDay> getAll() {
		List<TrialDay> trialDays = trialDayRepository.findAll();
		return trialDays;
	}
}
