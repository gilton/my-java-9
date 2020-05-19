package com.challenge.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.challenge.dto.request.ChallengeDTO;
import com.challenge.entity.Challenge;


@Mapper
public interface ChallengeMapper {
	
	ChallengeMapper INSTANCE = Mappers.getMapper(ChallengeMapper.class);
	
	@Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd/MM/yyyy")
	Challenge toModel(ChallengeDTO challengeDto);
	
	ChallengeDTO toDTO(Challenge challenge);

}
