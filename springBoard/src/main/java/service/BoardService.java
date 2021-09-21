package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.BoardDAO;
import model.BoardVO;

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
	
	public BoardVO read(int num) {
		return boardDAO.read(num);
	}
	

}
