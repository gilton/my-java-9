package com.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.mapper.CandidateMapper;
import com.challenge.dto.request.CandidateDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.entity.Candidate;
import com.challenge.repository.CandidateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidateService {
	
	private CandidateRepository CandidateRepository;
	private CandidateMapper candidateMapper = CandidateMapper.INSTANCE;
	
	public MessageResponseDTO insert(CandidateDTO candidateDTO) {
		Candidate  CandidateModel = candidateMapper.toModel(candidateDTO);
		
		Candidate Candidate2Save = CandidateRepository.save(CandidateModel);
		return setMessageResponse("Candidater created with ID: ", Candidate2Save.getId());
	}

	
	public MessageResponseDTO update(Long id, CandidateDTO candidateDTO) {
		
		CandidateRepository.findById(id).orElseThrow(RuntimeException::new);
		
		if( candidateDTO.getId() == null ) { candidateDTO.setId(id); }
		
		Candidate CandidateUpdate = candidateMapper.toModel(candidateDTO);
		Candidate CandidateSaved = CandidateRepository.save(CandidateUpdate);
		
		return setMessageResponse("Candidate is successfully updated with ID ", CandidateSaved.getId());
	}

	
	public void delete(Long id) {
		CandidateRepository.deleteById(id);;
	}
	

	
	public CandidateDTO findById(Long id) {
		Candidate CandidateFound = CandidateRepository.findById(id)
				.orElseThrow(RuntimeException::new);
		return candidateMapper.toDTO(CandidateFound);
	}
	
	
	public List<CandidateDTO> findAll() {
		List<Candidate> Candidates = CandidateRepository.findAll();
		return Candidates.stream()
				.map(candidateMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	private MessageResponseDTO setMessageResponse(String message, Long id) {
		return MessageResponseDTO.builder()
				.message(message + id )
				.build();
	}

}