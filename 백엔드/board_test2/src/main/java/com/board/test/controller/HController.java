package com.board.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.board.test.mapper.BoardMapper;
import com.board.test.service.Service;

@ComponentScan(basePackages = "com.board.test.controller")
@Controller
public class HController {
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	Service service;
	
	Board board;
	
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
		System.out.println("�ۼ�������");
		return "boardForm";
	}
	
	
	@PostMapping("/writeAction.do")
	public String writeAction( 
			@RequestParam("b_title")String b_title, 
			@RequestParam("b_content") String b_content) {
		
		service.writeAction(b_title, b_content);
		
		System.out.println("�׼�");

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
	
	
	
	
	
	
}
