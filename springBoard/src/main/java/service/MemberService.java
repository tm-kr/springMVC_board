package service;

import java.util.HashMap;

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
	
	public MemberVO info(String id) {
		return memberDAO.info(id);
	}
	
	public MemberVO getPass(String id) {
		return memberDAO.getPass(id);
	}
	
	public void updatePass(HashMap<String, Object> hm) {
		memberDAO.updatePass(hm);
	}
	
}
