package service;

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
	

}
