package com.board.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.board.test.domain.Board;
import com.board.test.domain.Comment;
import com.board.test.mapper.BoardMapper;
import com.board.test.mapper.CommentMapper;
import com.board.test.repo.CRepo;
import com.board.test.repo.Repo;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	Repo repo;
	@Autowired
	CRepo crepo;
	
	@Autowired
	BoardMapper mapper;
	@Autowired
	CommentMapper cmapper;
	
	
	public List<Board> findAll(){
		return repo.findAll();
	}
	
	
	public List<Board> boardList(Board board){
		return boardList(board);
	}
	public int writeAction(String b_title, String b_content) {
		return mapper.writeAction(b_title, b_content);
	}
	public List<Comment> findcommentAll(){
		return crepo.findAll();
	}
	public List<Comment> commentList(Comment comment){
		return commentList(comment);
	}
	public int CommentwriteAction(String c_content) {
		return cmapper.CommentwriteAction(c_content);
	}
	public int CommentDelete(int c_num) {
		return cmapper.CommentDelete(c_num);
	}
	
}
