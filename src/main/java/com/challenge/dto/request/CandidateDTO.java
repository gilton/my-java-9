package com.challenge.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO {
	
	private Long id;
	
	@NotNull
	private int status;
	
	@NotNull	
	private String createdAt;
	
	@NotNull
	@Valid
	private UserDTO userDTO;
	
	@NotNull
	@Valid
	private AccelerationDTO accelerationDTO;
	
	@NotNull
	@Valid
	private CompanyDTO companyDTO;
}
