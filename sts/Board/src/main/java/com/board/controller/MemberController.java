package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="login", method= RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="join", method= RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="setting", method= RequestMethod.GET)
	public String setting() {
		return "setting";
	}
}
