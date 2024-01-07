package com.spring.service;

import java.sql.SQLException;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public MemberVO detail(String id) throws SQLException {
		return memberDAO.selectMemberById(id);
	}

	@Override
	public void modifyPwd(MemberVO member) throws SQLException {
		memberDAO.updatePwd(member);
		
	}

	@Override
	public void modifyName(MemberVO member) throws SQLException {
		memberDAO.updateName(member);
		
	}

	@Override
	public void modifyEmail(MemberVO member) throws SQLException {
		memberDAO.updateEmail(member);
		
	}

	@Override
	public void remove(MemberVO member) throws SQLException {
		memberDAO.deleteMember(member);
		
	}

}
