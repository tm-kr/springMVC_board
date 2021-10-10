package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/free", method = RequestMethod.GET)
	public String free(Model model) {
		return "freeList";
	}
	
	@RequestMapping(value="/humor", method = RequestMethod.GET)
	public String humor(Model model) {
		return "humorList";
	}
	
	@RequestMapping(value="/news", method = RequestMethod.GET)
	public String news(Model model) {
		return "news";
	}
	
	@RequestMapping(value="/notice", method = RequestMethod.GET)
	public String notice(Model model) {
		return "notice";
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public String read(Model model) {
		return "read";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(Model model) {
		return "edit";
	}
	
	@RequestMapping(value="/myPost", method = RequestMethod.GET)
	public String myPost(Model model) {
		return "myPost";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String write(Model model) {
		return "write";
	}
}
