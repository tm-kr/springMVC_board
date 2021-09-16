package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.MemberVO;
import service.MemberService;

@Controller
public class BoardController {
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/index")
	public String list(Model model) {
		return "/index";
	}
	
	@RequestMapping(value="/read")
	public String read(Model model) {
		return "/read";
	}
	
	@RequestMapping(value="/write")
	public String write(Model model) {
		return "//write";
	}
	
	
}
