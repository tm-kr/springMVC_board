package service;

import org.springframework.stereotype.Service;

import controller.LoginCommand;
import model.MemberDAO;
import model.MemberVO;

@Service
public class MemberService {
	
	private MemberDAO memberDAO;

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	// 회원가입
	public void join(MemberVO memberVO) {
		memberDAO.join(memberVO);
	}
	// 로그인
	public LoginCommand login(LoginCommand loginCommand) {
		return memberDAO.login(loginCommand);
		
	}
	
}
