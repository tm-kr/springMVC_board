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
	
	public void join(MemberVO memberVO) {
		memberDAO.join(memberVO);
	}
	
	public LoginCommand login(LoginCommand loginCommand) {
		System.out.println("service작동");
		return memberDAO.login(loginCommand);
		
	}
	
}
