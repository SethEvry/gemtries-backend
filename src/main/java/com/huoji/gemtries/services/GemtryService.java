package com.huoji.gemtries.services;

import com.huoji.gemtries.models.Gemtry;
import com.huoji.gemtries.repositories.GemtryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GemtryService {
	private final GemtryRepository gemtryRepository;

	public GemtryService(GemtryRepository gemtryRepository) {
		this.gemtryRepository = gemtryRepository;
	}

	public Gemtry upsertGemtry(Gemtry gemtry){
		if(gemtry.getLocalDate() == null) {
			gemtry.setLocalDate(LocalDate.now());
		}
		return gemtryRepository.save(gemtry);
	}

	public List<Gemtry> findGemtries(String username){
		return gemtryRepository.findAllByUserUsername(username);
	}

	public List<Gemtry> findDailies(String username, LocalDate localDate){
		return gemtryRepository.findAllByUserUsernameAndLocalDate(username, localDate);
	}


	public List<Gemtry> saveAll(List<Gemtry> gemtries) {
		return gemtryRepository.saveAll(gemtries);
	}
}
