package com.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.dao.BoardDAO;
import com.board.dto.BoardVO;
import com.board.dto.PageVO;
import com.board.util.FileUtils;

@Service
public class BoardService {
	
	private BoardDAO boardDAO;
	private FileUtils fileUtils;
	
	@Autowired
	public BoardService(BoardDAO boardDAO, FileUtils fileUtils) {
		this.boardDAO = boardDAO;
		this.fileUtils = fileUtils;
	}
	
	// ��ü �� ���� ��ȸ
	public int articleCount() {
		return boardDAO.articleCount();
	}
	// ��ü �� �ֽż� ����
	public List<BoardVO> listPage(PageVO pageVO){
		return boardDAO.listPage(pageVO);
	}
	// ��ü �� ��ȸ�� ����
	public List<BoardVO> popularList(PageVO pageVO) {
		return boardDAO.popularList(pageVO);
	}
	// ���� �Խ��� �� ���� ��ȸ
	public int freeArticleCount() {
		return boardDAO.freeArticleCount();
	}
	// ���� �Խ��� �ֽż� ����
	public List<BoardVO> freeList(PageVO pageVO) {
		return boardDAO.freeList(pageVO);
	}
	// ���� �Խ��� ��ȸ�� ����
	public List<BoardVO> freePopularList(PageVO pageVO) {
		return boardDAO.freePopularList(pageVO);
	}
	// ���� �Խ��� �� ���� ��ȸ
	public int humorArticleCount() {
		return boardDAO.humorArticleCount();
	}
	// ���� �Խ��� �ֽż� ����
	public List<BoardVO> humorList(PageVO pageVO) {
		return boardDAO.humorList(pageVO);
	}
	// ���� �Խ��� ��ȸ�� ����
	public List<BoardVO> humorPopularList(PageVO pageVO) {
		return boardDAO.humorPopularList(pageVO);
	}
	// �� �� ���� ��ȸ
	public int myPostArticleCount(String id) {
		return boardDAO.myPostArticleCount(id);
	}
	// �� �� ����Ʈ ��������
	public List<BoardVO> myPostList(HashMap<String, Object> hm) {
		return boardDAO.myPostList(hm);
	}
	// �˻� �� ���� ��ȸ
	public int searchArticleCount(String search) {
		return boardDAO.searchArticleCount(search);
	}
	// ���� �Խ��� �˻� �� ���� ��ȸ
	public int freeSearchArticleCount(String search) {
		return boardDAO.freeSearchArticleCount(search);
	}
	// ���� �Խ��� �˻� �� ���� ��ȸ
	public int humorSearchArticleCount(String search) {
		return boardDAO.humorSearchArticleCount(search);
	}
	
	// �Խñ� �ۼ� 
	public void write(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
		System.out.println("���� ����");
		boardDAO.write(boardVO);
		
		//���� ���ε�
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(boardVO, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			boardDAO.insertFile(list.get(i)); 
		}
	}
	// �Խñ� ����
	public void edit(BoardVO boardVO) {
		boardDAO.edit(boardVO);
	}
	// �Խñ� ����
	public void delete(int num) {
		boardDAO.delete(num);
	}
	// Ŭ���� �Խù� ���� �ҷ�����
	public BoardVO read(int num) {
		return boardDAO.read(num);
	}
	// ���ε� ���� ��ȸ
	public List<Map<String, Object>> selectFileList(int num) throws Exception {
		return boardDAO.selectFileList(num);
	}
	// ÷������ �ٿ�ε�
	public Map<String, Object> selectFileInfo(int fileNum) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectFileInfo(fileNum);
	}
	// ��ȸ�� + 1
	public void views(int num) {
		boardDAO.views(num);
	}
}
