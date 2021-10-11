package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	// ��ü �� ���� ��ȸ
	public int articleCount() {
		return sqlSessionTemplate.selectOne("articleCount");
	}
	// ��ü �� �ֽż� ����
	public List<BoardVO> listPage(PageVO pageVO) {
		return sqlSessionTemplate.selectList("listPage", pageVO);
	}
	// ��ü �� ��ȸ�� ����
	public List<BoardVO> popularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("popularList", pageVO);
	}
	// ���� �Խ��� �� ���� ��ȸ
	public int freeArticleCount() {
		return sqlSessionTemplate.selectOne("freeArticleCount");
	}
	// ���� �Խ��� �ֽż� ����
	public List<BoardVO> freeList(PageVO pageVO){
		return sqlSessionTemplate.selectList("freeList", pageVO);
	}
	// ���� �Խ��� ��ȸ�� ����
	public List<BoardVO> freePopularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("freePopularList", pageVO);
	}
	// ���� �Խ��� �� ���� ��ȸ
	public int humorArticleCount() {
		return sqlSessionTemplate.selectOne("humorArticleCount");
	}
	// ���� �Խ��� �ֽż� ����
	public List<BoardVO> humorList(PageVO pageVO){
		return sqlSessionTemplate.selectList("humorList", pageVO);
	}
	// ���� �Խ��� ��ȸ�� ����
	public List<BoardVO> humorPopularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("humorPopularList", pageVO);
	}
	//	�� �� ���� ��ȸ
	public int myPostArticleCount(String id) {
		return sqlSessionTemplate.selectOne("myPostArticleCount", id);
	}
	// ���� ����Ʈ ��������
	public List<BoardVO> myPostList(HashMap<String, Object> hm){
		return sqlSessionTemplate.selectList("myPostList", hm);
	}
	// �˻� �� ���� ��ȸ
	public int searchArticleCount(String search) {
		return sqlSessionTemplate.selectOne("searchArticleCount", search);
	}
	// ���� �Խ��� �˻� �� ���� ��ȸ
	public int freeSearchArticleCount(String search) {
		return sqlSessionTemplate.selectOne("freeSearchArticleCount", search);
	}
	// ���� �Խ��� �˻� �� ���� ��ȸ
	public int humorSearchArticleCount(String search) {
		return sqlSessionTemplate.selectOne("humorSearchArticleCount", search);
	}
	
	
	
	//÷������ ���ε�
	public void insertFile(Map<String, Object> map) throws Exception {
		System.out.println("insertFile dao ����");
		sqlSessionTemplate.insert("insertFile", map);
	}
	// �� �ۼ�
	public void write(BoardVO boardVO) {
		System.out.println("write dao ����");
		sqlSessionTemplate.insert("write", boardVO);
	}
	// �� ����
	public void edit(BoardVO boardVO) {
		sqlSessionTemplate.update("edit", boardVO);
	}
	// �� ����
	public void delete(int num) {
		sqlSessionTemplate.delete("delete", num);
	}
	// Ŭ���� �Խù� ���� �ҷ�����
	public BoardVO read(int num) {
		return sqlSessionTemplate.selectOne("read", num);
	}
	// ��ȸ�� + 1
	public void views(int num) {
		sqlSessionTemplate.selectOne("views",num);
	}
}
