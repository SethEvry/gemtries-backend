package com.huoji.gemtries.services;

import com.huoji.gemtries.models.Character;
import com.huoji.gemtries.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
	private final CharacterRepository characterRepository;

	public CharacterService(CharacterRepository characterRepository) {
		this.characterRepository = characterRepository;
	}

	public List<Character> findCharacters(String username){
		return characterRepository.findAllByUserUsername(username);
	}

	public Character upsertCharacter(Character character) {
		return characterRepository.save(character);
	}


	public void delete(int id) {
		characterRepository.deleteById(id);
	}
}
