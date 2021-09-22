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

	public void join(MemberVO memberVO) {
		sqlSessionTemplate.insert("join", memberVO);
	}
	
	public LoginCommand login(LoginCommand loginCommand) {
		LoginCommand lm = (LoginCommand)sqlSessionTemplate.selectOne("login", loginCommand);
		return lm;
	}
}
