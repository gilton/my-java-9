package com.challenge.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.challenge.entity.Challenge;
import com.challenge.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionDTO {

	private Long id;
	
	@NotNull
	private Float score;
	
	@NotNull
	@Valid
	private User user;
	
	@NotNull
	@Valid
	private Challenge challenge;
	
	@NotNull
	private String createdAt;
}