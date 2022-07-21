package com.board.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.test.domain.Board;
import com.board.test.domain.Comment;
import com.board.test.mapper.BoardMapper;
import com.board.test.mapper.CommentMapper;
import com.board.test.service.Service;

@ComponentScan(basePackages = "com.board.test.controller")
@Controller
public class HController {
	
	@Autowired
	BoardMapper mapper;
	@Autowired
	CommentMapper cmapper;
	
	@Autowired
	Service service;
	
	Board board;
	Comment comment;
	
	@RequestMapping(value="/boardList")
	//@GetMapping("/boardList.do")
	public String index(Model model) {
		List<Board> list = mapper.boardList();
		model.addAttribute("list",list);
		
		System.out.println(list);
		
		return "boardList";
	}
	
	@GetMapping("/boardInsert.do")
	public String boardForm() {
		System.out.println("ÀÛ¼ºÆäÀÌÁö");
		return "boardForm";
	}
	
	
	@PostMapping("/writeAction.do")
	public String writeAction( 
			@RequestParam("b_title")String b_title, 
			@RequestParam("b_content") String b_content) {
		
		service.writeAction(b_title, b_content);
		
		System.out.println("¾×¼Ç");

		return "redirect:/boardList";

	}
	@RequestMapping("boardContent.do/{b_num}")
	public String boardContent(Model model, @PathVariable int b_num) {
		
		Board vo = mapper.boardContent(b_num);
		
		System.out.println(vo.getB_title());
		
		model.addAttribute("board", vo);
		
		return "boardContent";
	}
	
	@RequestMapping("boardDelete.do")
	public String boardDelete(int b_num) {
		
		mapper.boardDelete(b_num);
		
		return "redirect:/boardList";
	}

	@RequestMapping("/boardGoUpdate.do")
	public String boardGoUpdate(int b_num, Model model) {
		
		Board vo = mapper.boardContent(b_num);
		
		model.addAttribute("board",vo);
		
		return "boardUpdate";
	}
	
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) {
		
		mapper.boardUpdate(vo);
		
		return "redirect:/boardList.do";
		
	}
	@RequestMapping(value="/commentList")
	public String commentList(Model model) {
		List<Comment> list = cmapper.CommentList();
		
		model.addAttribute("list",list);
		
		System.out.println(list);
		
		return "comment";
	}
	@GetMapping("/commentInsert.do")
	public String commentForm() {
		System.out.println("댓글작성");
		return "redirect:/boardInsert.do";
	}
	

	@PostMapping("/CommentwriteAction.do")
	public String CommentwriteAction( 
			@RequestParam("c_content")String c_content){
		
		service.CommentwriteAction(c_content);
		
		System.out.println("액션");

		return "redirect:/boardInsert.do";

	}
	@RequestMapping("CommentDelete.do")
	public String CommentDelete(int c_num) {
		
		service.CommentDelete(c_num);
		
		return "redirect:/boardInsert.do";
		
		
	}

}
