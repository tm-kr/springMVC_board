package model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import paging.PageVO;

@Repository
public class BoardDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public BoardDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void write(BoardVO boardVO) {
		sqlSessionTemplate.insert("write", boardVO);
	}
	
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("list");
	}
	
	public List<BoardVO> listPage(PageVO pageVO) {
		return sqlSessionTemplate.selectList("listPage", pageVO);
	}
	
	public BoardVO read(int num) {
		return sqlSessionTemplate.selectOne("read", num);
	}

	public int articleCount() {
		return sqlSessionTemplate.selectOne("articleCount");
	}
	
	public void views(int num) {
		sqlSessionTemplate.selectOne("views",num);
	}

	public List<BoardVO> popularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("popularList", pageVO);
	}
	
	public int freeArticleCount() {
		return sqlSessionTemplate.selectOne("freeArticleCount");
	}
	
	public List<BoardVO> freeList(PageVO pageVO){
		return sqlSessionTemplate.selectList("freeList", pageVO);
	}
	
	public List<BoardVO> freePopularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("freePopularList", pageVO);
	}
	
	public int humorArticleCount() {
		return sqlSessionTemplate.selectOne("humorArticleCount");
	}
	
	public List<BoardVO> humorList(PageVO pageVO){
		return sqlSessionTemplate.selectList("humorList", pageVO);
	}
	
	public List<BoardVO> humorPopularList(PageVO pageVO) {
		return sqlSessionTemplate.selectList("humorPopularList", pageVO);
	}
	
}
