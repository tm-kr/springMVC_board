package com.board.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.dto.LoginCommand;
import com.board.dto.MemberVO;

@Repository
public class MemberDAO {
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public MemberDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// ȸ������ ���
	public void join(MemberVO memberVO) {
		sqlSessionTemplate.insert("join", memberVO);
	}
	// �α��� ���
	public LoginCommand login(LoginCommand loginCommand) {
		LoginCommand lm = (LoginCommand)sqlSessionTemplate.selectOne("login", loginCommand);
		return lm;
	}
	
	public MemberVO info(String id) {
		return sqlSessionTemplate.selectOne("info", id);
	}
	
	public MemberVO getPass(String id) {
		return sqlSessionTemplate.selectOne("getPass", id);
	}
	
	public void updatePass(HashMap<String, Object> hm) {
		sqlSessionTemplate.update("updatePass", hm);
	}
}
