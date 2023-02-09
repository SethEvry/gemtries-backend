package com.huoji.gemtries.repositories;

import com.huoji.gemtries.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

	List<Character> findAllByUserUsername(String username);

}
