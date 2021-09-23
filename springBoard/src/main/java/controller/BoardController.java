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
	
	@RequestMapping(value="/index/{currentPage}") // 전체 게시글 최신순 정렬 조회
	public String listPage(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.articleCount();
		model.addAttribute("page",pageCalc.pageCalc(currentPage, articleCount));
		model.addAttribute("boardList", boardService.listPage(pageCalc.pageCalc(currentPage, articleCount)));
		return "/index";
	}
	@RequestMapping(value="/popular/{currentPage}") // 전체 게시글 조회순 정렬 조회
	public String popularListPage(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.articleCount();
		model.addAttribute("page",pageCalc.pageCalc(currentPage, articleCount));
		model.addAttribute("boardList", boardService.popularList(pageCalc.pageCalc(currentPage, articleCount)));
		return "/sort/popular";
	}
	
	@RequestMapping(value="/free/{currentPage}") // 자유 게시판 글 최신순 정렬 조회
	public String freeList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.freeArticleCount();
		model.addAttribute("page",pageCalc.pageCalc(currentPage, articleCount));
		model.addAttribute("boardList", boardService.freeList(pageCalc.pageCalc(currentPage, articleCount)));
		return "/freeList";
	}
	
	@RequestMapping(value="/freePopular/{currentPage}") // 자유 게시판 글 조회순 정렬 조회
	public String freePopularList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.freeArticleCount();
		model.addAttribute("page",pageCalc.pageCalc(currentPage, articleCount));
		model.addAttribute("boardList", boardService.freePopularList(pageCalc.pageCalc(currentPage, articleCount)));
		return "sort/freePopular";
	}
	
	@RequestMapping(value="/humor/{currentPage}") // 유머 게시판 글 최신순 정렬 조회
	public String humorList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.humorArticleCount();
		model.addAttribute("page",pageCalc.pageCalc(currentPage, articleCount));
		model.addAttribute("boardList", boardService.humorList(pageCalc.pageCalc(currentPage, articleCount)));
		return "/humorList";
	}
	
	@RequestMapping(value="/humorPopular/{currentPage}") // 유머 게시판 글 조회순 정렬 조회
	public String humorPopularList(Model model, @PathVariable int currentPage) {
		int articleCount = boardService.humorArticleCount();
		model.addAttribute("page",pageCalc.pageCalc(currentPage, articleCount));
		model.addAttribute("boardList", boardService.humorPopularList(pageCalc.pageCalc(currentPage, articleCount)));
		return "sort/humorPopular";
	}
	
	@RequestMapping(value="/read/{num}") // 게시글 상세 보기
	public String read(Model model, @PathVariable int num) {
		boardService.views(num);
		model.addAttribute("boardVO", boardService.read(num));
		return "/read";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET) // 글쓰기 페이지
	public String write() {
		return "/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST) // 글쓰기
	public String write(BoardVO boardVO) {
		boardService.write(boardVO);
		return "redirect:/index/1";
	}
	
	@RequestMapping(value="/delete/{num}") // 글 삭제하기
	public String delete( @PathVariable int num) {
		boardService.delete(num);
		return "redirect:/myPost/1";
	}
	
	@RequestMapping(value="/news") // 긴급 뉴스 페이지
	public String news() {
		return "/news";
	}
	
	@RequestMapping(value="/notice") // 공지사항 페이지
	public String notice() {
		return "/notice";
	}
	
	@RequestMapping(value="/myPost/{currentPage}") // 내 게시글 리스트
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
