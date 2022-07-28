package com.board.test.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.board.test.domain.Board;
import com.board.test.domain.Comment;
import com.board.test.domain.Senior;
import com.board.test.mapper.BoardMapper;
import com.board.test.service.Service;

@RestController


public class RController {
	@Autowired
	private Service service;

	@Autowired
	BoardMapper mapper;
	

	
	@PostMapping("/api/board")
	public List<Board> board() {
		System.out.println("게시글 목록 페이지");
	//		Board board = new Board(1, "jj","gg","hh","2022.07.23");
		List<Board> board = mapper.boardList();
		return  board;
	}
	
	@PostMapping("/api/boardInsert")
	public int boardInsert(@RequestBody Board board) {
		System.out.println("게시글 작성완료");
		return service.insertBoard(board);
	}
	
	@PostMapping("/api/boardContent/{b_num}")
	public Board boardContent(@RequestBody int b_num) {
		System.out.println("상세 글 보기"+b_num);
		return service.boardContent(b_num);
	}
	
	@PostMapping("/api/seniorinsert")
	public Map<String, Object> seniorinsert (MultipartFile photo, HttpServletRequest request,Senior vo) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
			//파일 읽어오기
			String S_photoPath = System.getProperty("user.dir")+"\\src\\main\\webapp\\WEB-INF\\resource\\file";
			UUID uuid = UUID.randomUUID();
			String S_photoname = uuid + "_" + photo.getOriginalFilename();
			
			
			// 저장하기
			File saveFile = new File(S_photoPath,S_photoname);
			photo.transferTo(saveFile);
			
			
			
		
		
		return service.seniorinsert(photo, request, vo);
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
	@RequestMapping(value = "/Senior", method = {RequestMethod.GET})
	public List<Senior> useSeniorFindAll() {
		List<Senior> list = service.findSeinorAll();
		return list;
	}
	
	
	
	
	
	
}
