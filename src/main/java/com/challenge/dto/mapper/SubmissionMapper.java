
package com.challenge.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.challenge.dto.request.SubmissionDTO;
import com.challenge.entity.Submission;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {
	
	SubmissionMapper INSTANCE = Mappers.getMapper(SubmissionMapper.class);
	
	@Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd/MM/yyyy")
	Submission toModel( SubmissionDTO submissionDTO );
	SubmissionDTO toDTO( Submission submission  );
	
}
