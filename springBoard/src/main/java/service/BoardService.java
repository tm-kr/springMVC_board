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
		System.out.println("service 작동");
		System.out.println(boardVO.getContent());
		System.out.println(boardVO.getCategory());
		boardDAO.write(boardVO);
	}
	
	public List<BoardVO> list() {
		return boardDAO.list();
	}
	
	public BoardVO read(int num) {
		return boardDAO.read(num);
	}
	

}
