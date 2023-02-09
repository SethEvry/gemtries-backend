package com.huoji.gemtries.controllers;

import com.huoji.gemtries.models.Gemtry;
import com.huoji.gemtries.services.GemtryService;
import com.huoji.gemtries.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/gemtries")
public class GemtryController {

	@Autowired
	private GemtryService gemtryService;

	@Autowired
	private UserService userService;

	@GetMapping
	public List<Gemtry> getGemtries(Principal principal) {
		return gemtryService.findGemtries(principal.getName());
	}

	@GetMapping("/date")
	public List<Gemtry> getGemtriesByDate(@RequestParam int year, @RequestParam int month, @RequestParam int date,Principal principal){
		if(year > 0 && month > 0 && date > 0) {
			LocalDate localDate = LocalDate.of(year, month, date);
			System.out.println("Generated local date: " + localDate);
			return gemtryService.findDailies(principal.getName(), localDate);
		}
		return null;
	}

	@PostMapping
	public List<Gemtry> saveGemtries(@RequestBody List<Gemtry> gemtries) {
		userService.setHasSubmitted(gemtries.get(0).getUser());
		return gemtryService.saveAll(gemtries);
	}

}
