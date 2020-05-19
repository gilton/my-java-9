package com.challenge.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.challenge.dto.request.CandidateDTO;
import com.challenge.entity.Candidate;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

	CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);
	
	@Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd/MM/yyyy")
	Candidate toModel(CandidateDTO candidateDTO);
	
	CandidateDTO toDTO(Candidate candidate);
}
