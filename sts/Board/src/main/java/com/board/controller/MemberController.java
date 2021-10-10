package com.board.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.LoginCommand;
import com.board.dto.MemberVO;
import com.board.service.MemberService;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberVO memberVO) {
		memberService.join(memberVO);
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "/login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginCommand loginCommand, HttpSession session) {
		LoginCommand lm = (LoginCommand) memberService.login(loginCommand);
		try {
			if(loginCommand.getPassword().equals(lm.getPassword())) {
				session.setAttribute("id", lm.getId());
				return "redirect:/index";
			}
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		return "/login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	// 마이 페이지
	@RequestMapping(value="/setting", method=RequestMethod.GET) 
	public String setting(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		model.addAttribute("member", memberService.info(id));
		return "/setting";
	}
	// 마이 페이지
	@RequestMapping(value="/setting", method=RequestMethod.POST) 
	public String setting(Model model, HttpSession session, String oldPass, String newPass) {
		String id = (String) session.getAttribute("id");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("newPass", newPass);
		hm.put("id", id);
		System.out.println(oldPass);
		System.out.println(memberService.getPass(id).getPassword());
		System.out.println(hm);
		try {
			if(oldPass.equals(memberService.getPass(id).getPassword())) {
				memberService.updatePass(hm);
				return "redirect:/index";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("member", memberService.info(id));
		return "/setting";
	}
}
