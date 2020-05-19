package com.challenge.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.challenge.entity.Challenge;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccelerationDTO {
	
	private Long id;
	
	@NotBlank
	@Size(max = 100)
	private String name;
	
	@NotBlank
	@Size(max = 50)
	private String slug;
	
	@NotNull
	private String createdAt;
	
	@Valid
	@NotEmpty
	private Challenge challenge;
	
}
