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

import com.challenge.dto.request.SubmissionDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.service.SubmissionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/submissions")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SubmissionController {

SubmissionService submissionService;
	
	
	@PostMapping
	public MessageResponseDTO insert(@RequestBody SubmissionDTO submissionDTO) {
		return submissionService.insert(submissionDTO);
	}

	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody SubmissionDTO submissionDTO) {
		return submissionService.update(id, submissionDTO);
	}


	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		submissionService.delete(id);
	}

	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SubmissionDTO findById(@PathVariable Long id) {
		return submissionService.findById(id);
	}

	
	@GetMapping
	public List<SubmissionDTO> findAll() {
		return submissionService.findAll();
	}
	
}
