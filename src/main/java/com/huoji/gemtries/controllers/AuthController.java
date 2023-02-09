package com.huoji.gemtries.controllers;

import com.huoji.gemtries.dto.LoginDto;
import com.huoji.gemtries.dto.TokenDto;
import com.huoji.gemtries.services.TokenService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthController {

	private final TokenService tokenService;
	private final AuthenticationManager authManager;


	public AuthController(TokenService tokenService, AuthenticationManager authManager) {
		this.tokenService = tokenService;
		this.authManager = authManager;
	}

	@PostMapping
	public TokenDto token(@RequestBody LoginDto loginDto, HttpServletResponse res) {
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password()));
		String token = tokenService.generateToken(authentication);
		return new TokenDto(token);
	}

}
