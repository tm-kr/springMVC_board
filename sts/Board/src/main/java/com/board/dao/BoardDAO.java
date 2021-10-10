package com.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.dto.BoardVO;
import com.board.dto.PageVO;

@Repository
public class BoardDAO {
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public BoardDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	// 전체 글 갯수 조회
	public int articleCount() {
		return sqlSessionTemplate.selectOne("articleCount");
	}
	// 전체 글 최신순 정렬
	public List<BoardVO> listPage(PageVO pageVO) {
		return sqlSessionTemplate.selectList("listPage", pageVO);
	}
	// 전체 글 조회순 정렬
	public List<BoardVO> popularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("popularList", pageVO);
	}
	// 자유 게시판 글 갯수 조회
	public int freeArticleCount() {
		return sqlSessionTemplate.selectOne("freeArticleCount");
	}
	// 자유 게시판 최신순 정렬
	public List<BoardVO> freeList(PageVO pageVO){
		return sqlSessionTemplate.selectList("freeList", pageVO);
	}
	// 자유 게시판 조회순 정렬
	public List<BoardVO> freePopularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("freePopularList", pageVO);
	}
	// 유머 게시판 글 갯수 조회
	public int humorArticleCount() {
		return sqlSessionTemplate.selectOne("humorArticleCount");
	}
	// 유머 게시판 최신순 정렬
	public List<BoardVO> humorList(PageVO pageVO){
		return sqlSessionTemplate.selectList("humorList", pageVO);
	}
	// 유머 게시판 조회순 정렬
	public List<BoardVO> humorPopularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("humorPopularList", pageVO);
	}
	//	내 글 갯수 조회
	public int myPostArticleCount(String id) {
		return sqlSessionTemplate.selectOne("myPostArticleCount", id);
	}
	// 내글 리스트 가져오기
	public List<BoardVO> myPostList(HashMap<String, Object> hm){
		return sqlSessionTemplate.selectList("myPostList", hm);
	}
	// 검색 글 갯수 조회
	public int searchArticleCount(String search) {
		return sqlSessionTemplate.selectOne("searchArticleCount", search);
	}
	// 자유 게시판 검색 글 갯수 조회
	public int freeSearchArticleCount(String search) {
		return sqlSessionTemplate.selectOne("freeSearchArticleCount", search);
	}
	// 자유 게시판 검색 글 갯수 조회
	public int humorSearchArticleCount(String search) {
		return sqlSessionTemplate.selectOne("humorSearchArticleCount", search);
	}
	
	
	
	
	// 글 작성
	public void write(BoardVO boardVO) {
		sqlSessionTemplate.insert("write", boardVO);
	}
	// 글 수정
	public void edit(BoardVO boardVO) {
		sqlSessionTemplate.update("edit", boardVO);
	}
	// 글 삭제
	public void delete(int num) {
		sqlSessionTemplate.delete("delete", num);
	}
	// 클릭한 게시물 정보 불러오기
	public BoardVO read(int num) {
		return sqlSessionTemplate.selectOne("read", num);
	}
	// 조회수 + 1
	public void views(int num) {
		sqlSessionTemplate.selectOne("views",num);
	}
}
