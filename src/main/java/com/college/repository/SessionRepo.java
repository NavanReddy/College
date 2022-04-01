package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Session;

public interface SessionRepo  extends JpaRepository<Session, Long>{

}
