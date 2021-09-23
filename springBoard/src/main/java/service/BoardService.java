package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import model.BoardDAO;
import model.BoardVO;
import paging.PageVO;

@Service
public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardDAO getBoardDAO() {
		return boardDAO;
	}
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	// 전체 글 갯수 조회
	public int articleCount() {
		return boardDAO.articleCount();
	}
	// 전체 글 최신순 정렬
	public List<BoardVO> listPage(PageVO pageVO){
		return boardDAO.listPage(pageVO);
	}
	// 전체 글 조회순 정렬
	public List<BoardVO> popularList(PageVO pageVO) {
		return boardDAO.popularList(pageVO);
	}
	// 자유 게시판 글 갯수 조회
	public int freeArticleCount() {
		return boardDAO.freeArticleCount();
	}
	// 자유 게시판 최신순 정렬
	public List<BoardVO> freeList(PageVO pageVO) {
		return boardDAO.freeList(pageVO);
	}
	// 자유 게시판 조회순 정렬
	public List<BoardVO> freePopularList(PageVO pageVO) {
		return boardDAO.freePopularList(pageVO);
	}
	// 유머 게시판 글 갯수 조회
	public int humorArticleCount() {
		return boardDAO.humorArticleCount();
	}
	// 유머 게시판 최신순 정렬
	public List<BoardVO> humorList(PageVO pageVO) {
		return boardDAO.humorList(pageVO);
	}
	// 유머 게시판 조회순 정렬
	public List<BoardVO> humorPopularList(PageVO pageVO) {
		return boardDAO.humorPopularList(pageVO);
	}
	// 내 글 갯수 조회
	public int myPostArticleCount(String id) {
		return boardDAO.myPostArticleCount(id);
	}
	// 내 글 리스트 가져오기
	public List<BoardVO> myPostList(HashMap<String, Object> hm) {
		return boardDAO.myPostList(hm);
	}
	
	
	// 게시글 작성 
	public void write(BoardVO boardVO) {
		boardDAO.write(boardVO);
	}
	// 게시글 삭제
	public void delete(int num) {
		boardDAO.delete(num);
	}
	// 클릭한 게시물 정보 불러오기
	public BoardVO read(int num) {
		return boardDAO.read(num);
	}
	// 조회수 + 1
	public void views(int num) {
		boardDAO.views(num);
	}
}
