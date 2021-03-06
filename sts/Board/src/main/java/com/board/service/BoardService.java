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
	// 검색 글 갯수 조회
	public int searchArticleCount(String search) {
		return boardDAO.searchArticleCount(search);
	}
	// 자유 게시판 검색 글 갯수 조회
	public int freeSearchArticleCount(String search) {
		return boardDAO.freeSearchArticleCount(search);
	}
	// 유머 게시판 검색 글 갯수 조회
	public int humorSearchArticleCount(String search) {
		return boardDAO.humorSearchArticleCount(search);
	}
	
	// 게시글 작성 
	public void write(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
		System.out.println("서비스 실행");
		boardDAO.write(boardVO);
		
		//파일 업로드
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(boardVO, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			boardDAO.insertFile(list.get(i)); 
		}
	}
	// 게시글 수정
	public void edit(BoardVO boardVO) {
		boardDAO.edit(boardVO);
	}
	// 게시글 삭제
	public void delete(int num) {
		boardDAO.delete(num);
	}
	// 클릭한 게시물 정보 불러오기
	public BoardVO read(int num) {
		return boardDAO.read(num);
	}
	// 업로드 파일 조회
	public List<Map<String, Object>> selectFileList(int num) throws Exception {
		return boardDAO.selectFileList(num);
	}
	// 첨부파일 다운로드
	public Map<String, Object> selectFileInfo(int fileNum) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectFileInfo(fileNum);
	}
	// 조회수 + 1
	public void views(int num) {
		boardDAO.views(num);
	}
}
