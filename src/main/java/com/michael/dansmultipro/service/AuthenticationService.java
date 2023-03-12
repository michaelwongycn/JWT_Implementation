package com.michael.dansmultipro.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.michael.dansmultipro.model.Role;
import com.michael.dansmultipro.model.User;
import com.michael.dansmultipro.model.request.LoginRequest;
import com.michael.dansmultipro.model.request.RegisterRequest;
import com.michael.dansmultipro.model.response.AuthenticationResponse;
import com.michael.dansmultipro.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;
	
	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder().username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
		repository.save(user);
		
		var jwtToken = jwtService.generateJwtToken(user);
		return AuthenticationResponse.builder().jwtToken(jwtToken).build();
	}

	public AuthenticationResponse login(LoginRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		var user = repository.findByUsername(request.getUsername()).orElseThrow();

		var jwtToken = jwtService.generateJwtToken(user);
		return AuthenticationResponse.builder().jwtToken(jwtToken).build();
	}

	

}
