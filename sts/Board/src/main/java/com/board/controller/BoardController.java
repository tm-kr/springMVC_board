package com.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.dao.PageCalc;
import com.board.dto.BoardVO;
import com.board.dto.PageVO;
import com.board.service.BoardService;

@Controller
public class BoardController {
   
   private BoardService boardService;
   private PageCalc pageCalc;
   private PageVO pageVO;
   
   @Autowired
   public BoardController(BoardService boardService, PageCalc pageCalc, PageVO pageVO) {
      this.boardService = boardService;
      this.pageCalc = pageCalc;
      this.pageVO = pageVO;
   }

   
   @RequestMapping(value="/", method = RequestMethod.GET)
   public String home(Model model) {
      return "index";
   }
   
   @RequestMapping(value="/index")
   public String index(Model model,String pageNum, String search, String sort) {
      int currentPage = 1;
      int articleCount = 0;
      if (pageNum != null) {
         currentPage = Integer.parseInt(pageNum);
      }
      if(search != null) {
         articleCount = boardService.searchArticleCount(search);
      }else {
         search = "";
         articleCount = boardService.articleCount();
      }
      pageVO = pageCalc.pageCalc(currentPage, articleCount);
      pageVO.setSearch(search);
      
      model.addAttribute("search", search);
      model.addAttribute("page",pageVO);
      if(sort != null && sort.equals("popular")) {
         model.addAttribute("boardList", boardService.popularList(pageVO));
         model.addAttribute("sort", sort);
      }else {
         model.addAttribute("boardList", boardService.listPage(pageVO));
      }
      
      return "index";
   }
   
   @RequestMapping(value="/free")
   public String free(Model model,String pageNum, String search, String sort) {
      int currentPage = 1;
      int articleCount = 0;
      if (pageNum != null) {
         currentPage = Integer.parseInt(pageNum);
      }
      if(search != null ) {
         articleCount = boardService.freeSearchArticleCount(search);
      }else {
         search = "";
         articleCount = boardService.freeArticleCount();
      }
      pageVO = pageCalc.pageCalc(currentPage, articleCount);
      pageVO.setSearch(search);
      
      model.addAttribute("search", search);
      model.addAttribute("page",pageVO);
      if(sort != null && sort.equals("popular")) {
         model.addAttribute("boardList", boardService.freePopularList(pageVO));
         model.addAttribute("sort", sort);
      }else {
         model.addAttribute("boardList", boardService.freeList(pageVO));
      }
      
      return "freeList";
   }
   
   @RequestMapping(value="/humor", method = RequestMethod.GET)
   public String humor(Model model,String pageNum, String search, String sort) {
      int currentPage = 1;
      int articleCount = 0;
      if (pageNum != null) {
         currentPage = Integer.parseInt(pageNum);
      }
      if(search != null) {
         articleCount = boardService.humorSearchArticleCount(search);
      }else {
         search = "";
         articleCount = boardService.humorArticleCount();
      }
      pageVO = pageCalc.pageCalc(currentPage, articleCount);
      pageVO.setSearch(search);
      
      model.addAttribute("search", search);
      model.addAttribute("page",pageVO);
      if(sort != null && sort.equals("popular")) {
         model.addAttribute("boardList", boardService.humorPopularList(pageVO));
         model.addAttribute("sort", sort);
      }else {
         model.addAttribute("boardList", boardService.humorList(pageVO));
      }
      
      return "humorList";
   }
   
   	  // 게시글 상세 보기
      @RequestMapping(value="/read/{num}") 
      public String read(Model model, @PathVariable int num) throws Exception {
         boardService.views(num);
         
         // 업로드 파일 조회하기
         List<Map<String, Object>> fileList = boardService.selectFileList(num);
 		 model.addAttribute("file", fileList);
         model.addAttribute("boardVO", boardService.read(num));
         return "/read";
      }
      // 글쓰기 페이지
      @RequestMapping(value="/write", method=RequestMethod.GET) 
      public String write() {
         return "/write";
      }
      // 글쓰기 (파일 업로드)
      @RequestMapping(value="/write", method=RequestMethod.POST) 
      public String write(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
         boardService.write(boardVO, mpRequest);
         return "redirect:/index";
      }
      // 파일 다운로드
	  	@RequestMapping(value="/fileDown")
	  	public void fileDown(int fileNum, HttpServletResponse response) throws Exception{
	  		Map<String, Object> resultMap = boardService.selectFileInfo(fileNum);
	  		String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
	  		String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
	  		System.out.println(originalFileName +", " + storedFileName);
	  		
	  		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
	  		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\mp\\file\\"+storedFileName));
	  		
	  		response.setContentType("application/octet-stream");
	  		response.setContentLength(fileByte.length);
	  		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
	  		response.getOutputStream().write(fileByte);
	  		response.getOutputStream().flush();
	  		response.getOutputStream().close();
	  		
	  	}
      // 글 삭제하기
      @RequestMapping(value="/delete/{num}") 
      public String delete( @PathVariable int num) {
         boardService.delete(num);
         return "redirect:/myPost";
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
      // 내 게시글 리스트
      @RequestMapping(value="/myPost") 
      public String myPost(Model model, HttpSession session, String pageNum) {
         int currentPage = 1;
         if(pageNum != null) {
            currentPage = Integer.parseInt(pageNum);
         }
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