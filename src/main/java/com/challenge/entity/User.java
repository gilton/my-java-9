package com.challenge.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "full_name", length = 100, nullable = false)
	private String fullname;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false, length = 50)
	private String nickname;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(nullable = false, name = "created_at")
	@Builder.Default
	private LocalDate createdAt = LocalDate.now();

		
}