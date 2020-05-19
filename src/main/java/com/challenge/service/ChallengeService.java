package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.dto.mapper.ChallengeMapper;
import com.challenge.dto.request.ChallengeDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;

import lombok.AllArgsConstructor;



@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChallengeService {
	
	private final ChallengeRepository challengeRepository;
	private final ChallengeMapper challengeMapper = ChallengeMapper.INSTANCE;
	
		
	public MessageResponseDTO insert(ChallengeDTO challengeDTO) {
		
		Challenge challengeModel = challengeMapper.toModel(challengeDTO);
		
		Challenge challenge2Save = challengeRepository.save(challengeModel);
		MessageResponseDTO message = setMessageResponse("Challenger created with ID: ", challenge2Save.getId());
		return message;
	}
	
	
	public MessageResponseDTO update(Long id, ChallengeDTO challengeDTO) {
		
		challengeRepository.findById(id).orElseThrow(RuntimeException::new);
		
		if( challengeDTO.getId() == null ) { challengeDTO.setId(id); }
		
		Challenge challengeUpdate = challengeMapper.toModel(challengeDTO);
		Challenge challengeSaved = challengeRepository.save(challengeUpdate);
		
		MessageResponseDTO message = setMessageResponse("Challenge is successfully updated with ID ", challengeSaved.getId());
		return message;
	}

	public void delete(Long id) {
		challengeRepository.deleteById(id);;
	}
	

	public Challenge findById(Long id) {
		return challengeRepository.findById(id).get();
	}
	
	public List<Challenge> findAll() {
		return challengeRepository.findAll();
	}
	
	
	private MessageResponseDTO setMessageResponse(String message, Long id) {
		return MessageResponseDTO.builder()
				.message(message + id )
				.build();
	}
}