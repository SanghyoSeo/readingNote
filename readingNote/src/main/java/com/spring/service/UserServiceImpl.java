package com.spring.service;

import java.sql.SQLException;

import com.spring.dao.UserDAO;
import com.spring.dto.UserVO;

public class UserServiceImpl implements UserService {

	private UserDAO memberDAO;
	public void setMemberDAO(UserDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public UserVO detail(String id) throws SQLException {
		return memberDAO.selectMemberById(id);
	}

	@Override
	public void modifyPwd(UserVO member) throws SQLException {
		memberDAO.updatePwd(member);
		
	}

	@Override
	public void modifyName(UserVO member) throws SQLException {
		memberDAO.updateName(member);
		
	}

	@Override
	public void modifyEmail(UserVO member) throws SQLException {
		memberDAO.updateEmail(member);
		
	}

	@Override
	public void remove(String id) throws SQLException {
		memberDAO.deleteMember(id);
		
	}

}
