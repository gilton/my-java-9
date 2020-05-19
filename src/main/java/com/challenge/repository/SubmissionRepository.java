package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

}
