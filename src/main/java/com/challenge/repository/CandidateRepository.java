package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
