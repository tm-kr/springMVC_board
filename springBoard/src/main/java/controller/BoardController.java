package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping(value="/index")
	public String list(Model model) {
		return "/index";
	}
	
	@RequestMapping(value="/join")
	public String join(Model model) {
		return "/join";
	}
	
	@RequestMapping(value="/login")
	public String login(Model model) {
		return "/login";
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
