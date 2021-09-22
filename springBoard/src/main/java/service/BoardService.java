package service;

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

	public void write(BoardVO boardVO) {
		boardDAO.write(boardVO);
	}
	
	public List<BoardVO> list() {
		return boardDAO.list();
	}
	public List<BoardVO> listPage(PageVO pageVO){
		return boardDAO.listPage(pageVO);
	}
	
	public BoardVO read(int num) {
		return boardDAO.read(num);
	}
	
	public int articleCount() {
		return boardDAO.articleCount();
	}
	
	public void views(int num) {
		boardDAO.views(num);
	}

	public List<BoardVO> popularList(PageVO pageVO) {
		return boardDAO.popularList(pageVO);
	}
	
	public int freeArticleCount() {
		return boardDAO.freeArticleCount();
	}
	
	public List<BoardVO> freeList(PageVO pageVO) {
		return boardDAO.freeList(pageVO);
	}
	
	public List<BoardVO> freePopularList(PageVO pageVO) {
		return boardDAO.freePopularList(pageVO);
	}
	
	public int humorArticleCount() {
		return boardDAO.humorArticleCount();
	}
	public List<BoardVO> humorList(PageVO pageVO) {
		return boardDAO.humorList(pageVO);
	}
	
	public List<BoardVO> humorPopularList(PageVO pageVO) {
		return boardDAO.humorPopularList(pageVO);
	}
}
