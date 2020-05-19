package com.challenge.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long id;
	
	@NotBlank
	@Size(max = 100)
	private String fullname;
	
	@NotBlank
	@Size(max = 100)
	private String email;
	
	@NotBlank
	@Size(max = 50)
	private String nickname;
	
	@NotBlank
	@Size(max = 255)
	private String password;
	
	@NotNull
	private String createdAt;
}