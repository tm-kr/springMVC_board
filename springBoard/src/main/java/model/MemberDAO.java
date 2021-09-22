package model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import controller.LoginCommand;
@Repository
public class MemberDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 회원가입 기능
	public void join(MemberVO memberVO) {
		sqlSessionTemplate.insert("join", memberVO);
	}
	// 로그인 기능
	public LoginCommand login(LoginCommand loginCommand) {
		LoginCommand lm = (LoginCommand)sqlSessionTemplate.selectOne("login", loginCommand);
		return lm;
	}
}
