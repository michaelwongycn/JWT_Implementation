package com.michael.dansmultipro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.dansmultipro.model.request.LoginRequest;
import com.michael.dansmultipro.model.request.RegisterRequest;
import com.michael.dansmultipro.model.response.AuthenticationResponse;
import com.michael.dansmultipro.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
		@RequestBody RegisterRequest request
	){
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(
		@RequestBody LoginRequest request
	){
		return ResponseEntity.ok(service.login(request));
	}
}
