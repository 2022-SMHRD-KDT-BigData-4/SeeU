package com.board.test.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.board.test.domain.Board;
import com.board.test.domain.Comment;
import com.board.test.domain.Senior;
import com.board.test.mapper.BoardMapper;
import com.board.test.mapper.CommentMapper;
import com.board.test.mapper.SeniorMapper;
import com.board.test.repo.CRepo;
import com.board.test.repo.Repo;
import com.board.test.repo.SRepo;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	Repo repo;
	@Autowired
	CRepo crepo;
	@Autowired
	SRepo srepo;
	
	@Autowired
	BoardMapper mapper;
	@Autowired
	CommentMapper cmapper;
	@Autowired
	SeniorMapper smapper;
	
	public List<Board> findAll(){
		return repo.findAll();
	}
	
	
	public int insertBoard(Board board) {
		return mapper.insertBoard(board);
	}
	
	public Board  boardContent(int b_num) {
		return mapper.boardContent(b_num);
	}
	
	
	public int seniorinsert(MultipartFile photo,HttpServletRequest request,Senior vo) throws Exception{
		
		
		System.out.println("성공");		
		return smapper.SeniorwriteAction(vo);
		
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
	public List<Senior> SeniorList(Senior senior){
		return SeniorList(senior);
	}
	public List<Senior> findSeinorAll(){
		return srepo.findAll();
	}
	
	

}

