package com.board.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.board.test.domain.Board;
import com.board.test.domain.Comment;
import com.board.test.domain.Senior;
import com.board.test.mapper.BoardMapper;
import com.board.test.mapper.CommentMapper;
import com.board.test.mapper.SeniorMapper;
import com.board.test.service.Service;

@ComponentScan(basePackages = "com.board.test.controller")
@Controller
public class HController extends HttpServlet{
	
	@Autowired
	BoardMapper mapper;
	@Autowired
	CommentMapper cmapper;
	@Autowired
	SeniorMapper smapper;
	@Autowired
	Service service;
	
	Board board;
	Comment comment;
	Senior senior;
	
	
	
	

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
	@GetMapping("/SeniorInsert.do")
	public String SeniorForm() {
		System.out.println("입력");
		return "SeniorForm";
	}
	@PostMapping("/SeniorwriteAction.do")
	public String SeniorwriteAction (MultipartFile photo,HttpServletRequest request) throws Exception{
		
		Senior vo = new Senior();
		
		String S_name = request.getParameter("S_name");
		System.out.println(S_name);
		String S_birth = request.getParameter("S_birth");
		System.out.println(S_birth);
		String S_phone = request.getParameter("S_phone");
		System.out.println(S_phone);
		String S_gender = request.getParameter("S_gender");
		System.out.println(S_gender);
		String S_address = request.getParameter("S_address");
		System.out.println(S_address);
		String S_care = request.getParameter("S_care");
		System.out.println(S_care);
		// 텍스트 받아옴
		// 쌤이 MultipartFile이랑 @RequestParam이 같이 안먹는다고 하셧음 왠지모름
		
		String S_photoPath = System.getProperty("user.dir")+"\\src\\main\\webapp\\WEB-INF\\resource\\file";//경로설정
		UUID uuid = UUID.randomUUID();//랜덤이름 생성
		String S_photoname = uuid + "_" + photo.getOriginalFilename();//PC에저장할 파일이름(랜덤이름 + 원래이름)
		File saveFile = new File(S_photoPath,S_photoname);//경로,파일이름 받아와서
		photo.transferTo(saveFile); // PC에 저장

		vo.setS_name(S_name);
		vo.setS_birth(S_birth);
		vo.setS_phone(S_phone);
		vo.setS_gender(S_gender);
		vo.setS_address(S_address);
		vo.setS_care(S_care);
		vo.setS_photoname(S_photoname);
		vo.setS_photopath(S_photoPath);
		
		
		System.out.println(S_photoname);
		System.out.println(S_photoPath);
		
		smapper.SeniorwriteAction(vo);
	
		

		return "redirect:/SeniorInsert.do";

	}
	
	
	
	
//	@RequestMapping("/SeniorwriteAction.do")
//	public String SeniorwriteAction(Senior senior, MultipartFile photo) throws Exception {
//		service.SeniorwriteAction(senior ,photo);
//		return "SeniorForm";
//	}
	

}
