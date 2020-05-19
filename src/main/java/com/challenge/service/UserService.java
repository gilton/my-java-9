package com.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.mapper.UserMapper;
import com.challenge.dto.request.UserDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.entity.User;
import com.challenge.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
	
	private UserRepository userRepository;
	private UserMapper userMapper = UserMapper.INSTANCE;
	
	public MessageResponseDTO insert(UserDTO userDTO) {
		User  UserModel = userMapper.toModel(userDTO);
		
		User User2Save = userRepository.save(UserModel);
		return setMessageResponse("Userr created with ID: ", User2Save.getId());
	}

	
	public MessageResponseDTO update(Long id, UserDTO userDTO) {
		
		userRepository.findById(id).orElseThrow(RuntimeException::new);
		
		if( userDTO.getId() == null ) { userDTO.setId(id); }
		
		User UserUpdate = userMapper.toModel(userDTO);
		User UserSaved = userRepository.save(UserUpdate);
		
		return setMessageResponse("User is successfully updated with ID ", UserSaved.getId());
	}

	
	public void delete(Long id) {
		userRepository.deleteById(id);;
	}
	

	
	public UserDTO findById(Long id) {
		User UserFound = userRepository.findById(id)
				.orElseThrow(RuntimeException::new);
		return userMapper.toDTO(UserFound);
	}
	
	
	public List<UserDTO> findAll() {
		List<User> Users = userRepository.findAll();
		return Users.stream()
				.map(userMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	private MessageResponseDTO setMessageResponse(String message, Long id) {
		return MessageResponseDTO.builder()
				.message(message + id )
				.build();
	}

}