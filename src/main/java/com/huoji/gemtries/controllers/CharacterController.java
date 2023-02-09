package com.huoji.gemtries.controllers;

import com.huoji.gemtries.models.Character;
import com.huoji.gemtries.models.CharacterClass;
import com.huoji.gemtries.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

	@Autowired
	private CharacterService service;

	@GetMapping
	public List<Character> getCharacters(Principal principal){
		return service.findCharacters(principal.getName());
	}

	@PostMapping
	public Character upsertCharacter(@RequestBody Character character){
		System.out.println("new Character: " + character);
		return service.upsertCharacter(character);
	}

	@DeleteMapping("/{id}")
	public void deleteCharacter(@PathVariable int id){
		service.delete(id);
	}
}
