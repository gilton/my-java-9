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

import com.challenge.dto.request.CandidateDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.service.CandidateService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/candidates")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidateController {
	
	CandidateService candidateService;
	
	
	@PostMapping
	public MessageResponseDTO insert(@RequestBody CandidateDTO candidateDTO) {
		return candidateService.insert(candidateDTO);
	}

	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody CandidateDTO candidateDTO) {
		return candidateService.update(id, candidateDTO);
	}


	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		candidateService.delete(id);
	}

	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CandidateDTO findById(@PathVariable Long id) {
		return candidateService.findById(id);
	}

	
	@GetMapping
	public List<CandidateDTO> findAll() {
		return candidateService.findAll();
	}
}