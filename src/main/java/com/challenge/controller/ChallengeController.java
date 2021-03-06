package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.request.ChallengeDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.entity.Challenge;
import com.challenge.service.ChallengeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/challenges")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChallengeController {

	ChallengeService challengeService;
	
	public ChallengeController() { }

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO insert(@RequestBody ChallengeDTO challengeDTO) {
		return challengeService.insert(challengeDTO);
	}
	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody ChallengeDTO challengeDTO) {
		return challengeService.update(id, challengeDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		challengeService.delete(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Challenge findById(@PathVariable Long id) {
		return challengeService.findById(id);
	}
	
	@GetMapping
	public List<Challenge> findAll() {
		return challengeService.findAll();
	}
	
}
