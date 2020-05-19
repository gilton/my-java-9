package com.challenge.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.challenge.dto.request.UserDTO;
import com.challenge.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd/MM/yyyy")
	User toModel(UserDTO userDTO);
	
	UserDTO toDTO(User user);
	
}
