package com.huoji.gemtries.repositories;

import com.huoji.gemtries.models.Gemtry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GemtryRepository extends JpaRepository<Gemtry, Integer> {
	List<Gemtry> findAllByUserUsername(String username);

	List<Gemtry> findAllByUserUsernameAndLocalDate(String username, LocalDate localDate);
}
