package com.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.mapper.SubmissionMapper;
import com.challenge.dto.request.SubmissionDTO;
import com.challenge.dto.response.MessageResponseDTO;
import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SubmissionService {
	
	private SubmissionRepository SubmissionRepository;
	private SubmissionMapper submissionMapper = SubmissionMapper.INSTANCE;
	
	public MessageResponseDTO insert(SubmissionDTO submissionDTO) {
		Submission  submissionModel = submissionMapper.toModel(submissionDTO);
		
		Submission Submission2Save = SubmissionRepository.save(submissionModel);
		return setMessageResponse("Submissionr created with ID: ", Submission2Save.getId());
	}

	
	public MessageResponseDTO update(Long id, SubmissionDTO submissionDTO) {
		
		SubmissionRepository.findById(id).orElseThrow(RuntimeException::new);
		
		if( submissionDTO.getId() == null ) { submissionDTO.setId(id); }
		
		Submission SubmissionUpdate = submissionMapper.toModel(submissionDTO);
		Submission SubmissionSaved = SubmissionRepository.save(SubmissionUpdate);
		
		return setMessageResponse("Submission is successfully updated with ID ", SubmissionSaved.getId());
	}

	
	public void delete(Long id) {
		SubmissionRepository.deleteById(id);;
	}
	

	
	public SubmissionDTO findById(Long id) {
		Submission SubmissionFound = SubmissionRepository.findById(id)
				.orElseThrow(RuntimeException::new);
		return submissionMapper.toDTO(SubmissionFound);
	}
	
	
	public List<SubmissionDTO> findAll() {
		List<Submission> Submissions = SubmissionRepository.findAll();
		return Submissions.stream()
				.map(submissionMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	private MessageResponseDTO setMessageResponse(String message, Long id) {
		return MessageResponseDTO.builder()
				.message(message + id )
				.build();
	}

}