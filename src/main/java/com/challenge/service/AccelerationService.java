package com.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.mapper.AccelerationMapper;
import com.challenge.dto.request.AccelerationDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccelerationService {
	
	private AccelerationRepository accelerationRepository;
	private AccelerationMapper accelerationMapper = AccelerationMapper.INSTANCE;
	
	public MessageResponseDTO insert(AccelerationDTO accelerationDTO) {
		Acceleration  accelerationModel = accelerationMapper.toModel(accelerationDTO);
		
		Acceleration Acceleration2Save = accelerationRepository.save(accelerationModel);
		return setMessageResponse("Accelerationr created with ID: ", Acceleration2Save.getId());
	}

	
	public MessageResponseDTO update(Long id, AccelerationDTO accelerationDTO) {
		
		accelerationRepository.findById(id).orElseThrow(RuntimeException::new);
		
		if( accelerationDTO.getId() == null ) { accelerationDTO.setId(id); }
		
		Acceleration AccelerationUpdate = accelerationMapper.toModel(accelerationDTO);
		Acceleration AccelerationSaved = accelerationRepository.save(AccelerationUpdate);
		
		return setMessageResponse("Acceleration is successfully updated with ID ", AccelerationSaved.getId());
	}

	
	public void delete(Long id) {
		accelerationRepository.deleteById(id);;
	}
	

	
	public AccelerationDTO findById(Long id) {
		Acceleration accelerationFound = accelerationRepository.findById(id)
				.orElseThrow(RuntimeException::new);
		return accelerationMapper.toDTO(accelerationFound);
	}
	
	
	public List<AccelerationDTO> findAll() {
		List<Acceleration> accelerations = accelerationRepository.findAll();
		return accelerations.stream()
				.map(accelerationMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	private MessageResponseDTO setMessageResponse(String message, Long id) {
		return MessageResponseDTO.builder()
				.message(message + id )
				.build();
	}

}