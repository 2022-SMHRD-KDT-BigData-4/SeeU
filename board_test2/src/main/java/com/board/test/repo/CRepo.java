package com.board.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.board.test.domain.Comment;

@Repository
public interface CRepo extends JpaRepository<Comment, String> {
	
}

