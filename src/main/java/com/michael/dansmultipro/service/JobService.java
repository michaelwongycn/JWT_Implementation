package com.michael.dansmultipro.service;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.michael.dansmultipro.model.response.JobResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobService {

	public List<JobResponse> getAll() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<JobResponse>> response = restTemplate.exchange(
				"http://dev3.dansmultipro.co.id/api/recruitment/positions.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<JobResponse>>() {
				});
		List<JobResponse> jobs = response.getBody();
		
		return jobs;
	}

	public JobResponse getOne(String id) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<JobResponse> response = restTemplate.exchange(
				"http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<JobResponse>() {
				});
		JobResponse job = response.getBody();
		
		return job;

	}

}
