package com.board.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.MemberDAO;
import com.board.dto.LoginCommand;
import com.board.dto.MemberVO;

@Service
public class MemberService {
	private MemberDAO memberDAO;

	@Autowired
	public MemberService(MemberDAO memberDAO) {
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
