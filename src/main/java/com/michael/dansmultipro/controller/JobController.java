package com.michael.dansmultipro.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.dansmultipro.model.response.JobResponse;
import com.michael.dansmultipro.service.JobService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class JobController {
	
	private final JobService service;

	@GetMapping("/job")
	public ResponseEntity<List<JobResponse>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/job/{id}")
	public ResponseEntity<JobResponse> getOne(@PathVariable String id){
		return ResponseEntity.ok(service.getOne(id));
	}
}
