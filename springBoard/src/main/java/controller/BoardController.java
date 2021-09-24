package controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.BoardVO;
import paging.PageCalc;
import paging.PageVO;
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
	
	// 전체 게시글 최신순 정렬 조회
	@RequestMapping(value="/index/{currentPage}") 
	public String listPage(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.articleCount();
		PageVO page = pageCalc.pageCalc(currentPage, articleCount);
		model.addAttribute("page",page);
		model.addAttribute("boardList", boardService.listPage(page));
		return "/index";
	}
	// 전체 게시글 조회순 정렬 조회
	@RequestMapping(value="/popular/{currentPage}")
	public String popularListPage(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.articleCount();
		PageVO page = pageCalc.pageCalc(currentPage, articleCount);
		model.addAttribute("page",page);
		model.addAttribute("boardList", boardService.popularList(page));
		return "/sort/popular";
	}
	// 자유 게시판 글 최신순 정렬 조회
	@RequestMapping(value="/free/{currentPage}") 
	public String freeList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.freeArticleCount();
		PageVO page = pageCalc.pageCalc(currentPage, articleCount);
		model.addAttribute("page",page);
		model.addAttribute("boardList", boardService.freeList(page));
		return "/freeList";
	}
	// 자유 게시판 글 조회순 정렬 조회
	@RequestMapping(value="/freePopular/{currentPage}") 
	public String freePopularList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.freeArticleCount();
		PageVO page = pageCalc.pageCalc(currentPage, articleCount);
		model.addAttribute("page",page);
		model.addAttribute("boardList", boardService.freePopularList(page));
		return "sort/freePopular";
	}
	// 유머 게시판 글 최신순 정렬 조회
	@RequestMapping(value="/humor/{currentPage}") 
	public String humorList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.humorArticleCount();
		PageVO page = pageCalc.pageCalc(currentPage, articleCount);
		model.addAttribute("page",page);
		model.addAttribute("boardList", boardService.humorList(page));
		return "/humorList";
	}
	// 유머 게시판 글 조회순 정렬 조회
	@RequestMapping(value="/humorPopular/{currentPage}") 
	public String humorPopularList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.humorArticleCount();
		PageVO page = pageCalc.pageCalc(currentPage, articleCount);
		model.addAttribute("page",page);
		model.addAttribute("boardList", boardService.humorPopularList(page));
		return "sort/humorPopular";
	}
	// 게시글 상세 보기
	@RequestMapping(value="/read/{num}") 
	public String read(Model model, @PathVariable int num) {
		boardService.views(num);
		model.addAttribute("boardVO", boardService.read(num));
		return "/read";
	}
	// 글쓰기 페이지
	@RequestMapping(value="/write", method=RequestMethod.GET) 
	public String write() {
		return "/write";
	}
	// 글쓰기
	@RequestMapping(value="/write", method=RequestMethod.POST) 
	public String write(BoardVO boardVO) {
		boardService.write(boardVO);
		return "redirect:/index/1";
	}
	// 글 삭제하기
	@RequestMapping(value="/delete/{num}") 
	public String delete( @PathVariable int num) {
		boardService.delete(num);
		return "redirect:/myPost/1";
	}
	//  글 수정 페이지
	@RequestMapping(value="/edit/{num}", method=RequestMethod.GET) 
	public String edit(Model model, @PathVariable int num) {
		model.addAttribute("boardVO", boardService.read(num));
		return "/edit";
	}
	// 글 수정하기
	@RequestMapping(value="/edit/{num}", method=RequestMethod.POST) 
	public String edit(BoardVO boardVO) {
		boardService.edit(boardVO);
		return "redirect:/read/{num}";
	}
	// 긴급 뉴스 페이지
	@RequestMapping(value="/news") 
	public String news() {
		return "/news";
	}
	// 공지사항 페이지
	@RequestMapping(value="/notice") 
	public String notice() {
		return "/notice";
	}
	// 마이 페이지
	@RequestMapping(value="/setting") 
	public String setting() {
		return "/setting";
	}
	// 내 게시글 리스트
	@RequestMapping(value="/myPost/{currentPage}") 
	public String myPost(Model model, HttpSession session, @PathVariable int currentPage) {
		String id = (String) session.getAttribute("id");
		int articleCount = boardService.myPostArticleCount(id);
		PageVO page = pageCalc.pageCalc(currentPage, articleCount);
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("first", page.getFirst());
		hm.put("second", page.getSecond());
		hm.put("id", id);
		model.addAttribute("page", page);
		model.addAttribute("boardList", boardService.myPostList(hm));
		return "/myPost";
	}
	
}
