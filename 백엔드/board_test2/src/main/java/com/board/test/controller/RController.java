package com.board.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.test.domain.Board;
import com.board.test.domain.Comment;
import com.board.test.domain.Member;
import com.board.test.domain.Senior;
import com.board.test.mapper.BoardMapper;
import com.board.test.mapper.CommentMapper;
import com.board.test.mapper.SeniorMapper;
import com.board.test.service.Service;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class RController {
	
	private final Service service;
	
	@Autowired
	BoardMapper mapper;

	@Autowired
	CommentMapper cmapper;
	@Autowired
	SeniorMapper smapper;
	
	@PostMapping("/api/board")
	public List<Board> board() {
		System.out.println("�Խñ� ��� ������");
	//		Board board = new Board(1, "jj","gg","hh","2022.07.23");
		List<Board> board = mapper.boardList();
		return  board;
	}
	
	@PostMapping("/api/boardInsert")
	public int boardInsert(@RequestBody Board board) {
		System.out.println("�Խñ� �ۼ��Ϸ�");
		return service.insertBoard(board);
	}
	
	@PostMapping("/api/boardContent")
	public Board boardContent(@RequestBody int b_num ) {
		
		System.out.println("�� �� ����"+b_num);
		return service.boardContent(b_num);
	}
	
	@PostMapping("/api/boardDelete")
	public int boardDelete(@RequestBody int b_num) {
		System.out.println("�ۻ���");
		return service.boardDelete(b_num);
		
	}
	
	@PostMapping("/api/comment")
	public List<Comment> comment(@RequestBody int num){
		List<Comment> comment = cmapper.CommentList(num);
		System.out.println("��� ����");
		return comment;
	}
	
	@PostMapping("/api/commentInsert")
	public int commentInsert(@RequestBody Comment comment) {
		System.out.println("��� �ۼ�!");
		return service.insertComment(comment);
	}
	
	@PostMapping("/api/commentDelete")
	public int commentDelete(@RequestBody int num) {
		System.out.println("��� ����");
		return service.deleteComment(num);
	}
	
	@PostMapping("/api/memberInsert")
	   public int insertMember(@RequestBody Member mem) {
	      System.out.println(">>>> Member Request");
	      System.out.println(">>>> param : " + mem.toString());
	      return service.insertMember(mem);
	   }
	   
	   @GetMapping("/api/memberLogin")
	   public void selectOneMember(){}
	   
	   @PostMapping("/api/memberLogin")
	   public Member selectOneMember(@RequestBody Member mem){
//	      mem = service.selectOneMember(mem);
//	      if(mem != null) {
//	         session.setAttribute("mem", mem);
//	      }
	      System.out.println(">>>> Login");
	      System.out.println(">>>> param : " + mem.toLogin());
	      
	      Member vo = service.selectOneMember(mem);
	      
	      return vo;
	   }
	   
	   @PostMapping("/api/member")
	   public Member selectAllMember(@RequestBody Member mem) {
	      mem = service.selectAllMember(mem);
	      return mem;
	   }
	   @PostMapping("/api/seniorList")
	   public List<Senior> senior(@RequestBody String mem_id) {
	      System.out.println("���λ�");

	      List<Senior> senior = smapper.seniorList();
	      System.out.println(">>>> param : " + senior.toString());
	      return senior;
	   }
	
		@PostMapping("/api/seniorInsert")
		public int commentInsert(@RequestBody Senior senior) {
			System.out.println("�ôϾ� ���!");
			return service.seniorInsert(senior);
		}
}
