package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.BoardVO;
import paging.PageCalc;
import service.BoardService;

@Controller
public class BoardController {
	
	private BoardService boardService;
	private PageCalc pageCalc;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	public void setPageCalc(PageCalc pageCalc) {
		this.pageCalc = pageCalc;
	}
	

	@RequestMapping(value="/index")
	public String list(Model model) {
		int articleCount = boardService.articleCount();
		model.addAttribute("page",pageCalc.pageCalc(1, articleCount));
		model.addAttribute("boardList", boardService.list());
		return "/index";
	}
	
	@RequestMapping(value="/index/{currentPage}")
	public String listPage(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.articleCount();
		model.addAttribute("page",pageCalc.pageCalc(currentPage, articleCount));
		model.addAttribute("boardList", boardService.listPage(pageCalc.pageCalc(currentPage, articleCount)));
		return "/index";
	}
	
	@RequestMapping(value="/read/{num}")
	public String read(Model model, @PathVariable int num) {
		model.addAttribute("boardVO", boardService.read(num));
		return "/read";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVO boardVO) {
		boardService.write(boardVO);
		return "redirect:/index";
	}
	
	
}
