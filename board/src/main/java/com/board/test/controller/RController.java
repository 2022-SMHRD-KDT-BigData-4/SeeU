package com.board.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.test.domain.Board;
import com.board.test.domain.Comment;
import com.board.test.mapper.CommentMapper;
import com.board.test.service.Service;

@RestController
public class RController {
	@Autowired
	private Service service;
	@Autowired
	CommentMapper cmapper;
	
	
	
	@RequestMapping(value = "/board", method = {RequestMethod.GET})
	public List<Board> userDataFindAll() {
		List<Board> list = service.findAll();
		return list;
	}
	
	
	@RequestMapping(value = "/boarda", method = {RequestMethod.GET})
	public List<Board> boardList(Board board){
		List<Board> list = service.boardList(board);
		return list;
	}
	@RequestMapping(value = "/commenta", method = {RequestMethod.GET})
	public List<Comment> userCommentFindAll() {
		List<Comment> list = service.findcommentAll();
		return list;
	}
	@RequestMapping(value = "/comment", method = {RequestMethod.GET})
	public List<Comment> commentList(Comment comment){
		List<Comment> list = service.commentList(comment);
		return list;
	}
	
	
	
	
	
	
	
}
