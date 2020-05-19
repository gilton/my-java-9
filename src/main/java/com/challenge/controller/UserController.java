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

import com.challenge.dto.request.UserDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
	
	UserService userService;
	
	
	@PostMapping
	public MessageResponseDTO insert(@RequestBody UserDTO userDTO) {
		return userService.insert(userDTO);
	}

	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return userService.update(id, userDTO);
	}


	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}

	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	
	@GetMapping
	public List<UserDTO> findAll() {
		return userService.findAll();
	}
}