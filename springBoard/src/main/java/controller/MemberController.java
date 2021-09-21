package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.MemberVO;
import service.MemberService;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberVO memberVO) {
		memberService.join(memberVO);
		return "/login";
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
	

	
	
}
