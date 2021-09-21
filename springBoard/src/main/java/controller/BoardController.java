package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.BoardVO;
import service.BoardService;

@Controller
public class BoardController {
	
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value="/index")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.list());
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
		System.out.println(boardVO.getCategory());
		boardService.write(boardVO);
		return "redirect:/index";
	}
	
	
}
