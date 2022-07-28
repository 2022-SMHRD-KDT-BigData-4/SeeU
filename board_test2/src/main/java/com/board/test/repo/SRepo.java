package com.board.test.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.test.domain.Senior;

@Repository
public interface SRepo extends JpaRepository<Senior, String> {
	
}

