package model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("sqlsession 실행 dao실행");
		sqlSessionTemplate.insert("join", memberVO);
	}
	
	public void login(LoginCommand loginCommand) {
		
	}
}
