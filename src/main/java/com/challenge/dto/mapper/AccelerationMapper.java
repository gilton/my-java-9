package com.challenge.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.challenge.dto.request.AccelerationDTO;
import com.challenge.entity.Acceleration;

@Mapper(componentModel = "spring")
public interface AccelerationMapper {
	
	AccelerationMapper INSTANCE = Mappers.getMapper(AccelerationMapper.class);
	
	@Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd/MM/yyyy")
	Acceleration toModel(AccelerationDTO AccelerationDTO);
	
	AccelerationDTO toDTO(Acceleration acceleration);
	
}
