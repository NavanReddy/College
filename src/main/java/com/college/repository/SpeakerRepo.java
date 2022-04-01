package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Speaker;

public interface SpeakerRepo extends JpaRepository<Speaker, Long> {

}
