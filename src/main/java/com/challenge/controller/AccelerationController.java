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

import com.challenge.dto.request.AccelerationDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.service.AccelerationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/accelerations")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccelerationController {
	
	AccelerationService accelerationService;
	
	
	@PostMapping
	public MessageResponseDTO insert(@RequestBody AccelerationDTO accelerationDTO) {
		return accelerationService.insert(accelerationDTO);
	}

	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody AccelerationDTO accelerationDTO) {
		return accelerationService.update(id, accelerationDTO);
	}


	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		accelerationService.delete(id);
	}

	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccelerationDTO findById(@PathVariable Long id) {
		return accelerationService.findById(id);
	}

	
	@GetMapping
	public List<AccelerationDTO> findAll() {
		return accelerationService.findAll();
	}
}