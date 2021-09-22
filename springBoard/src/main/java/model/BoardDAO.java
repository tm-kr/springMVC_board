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
	
}
