package com.spring.service;

import java.sql.SQLException;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIdentityException;

public interface MemberService {
	
	void login(String id, String pwd) throws NotFoundIdentityException,
											 InvalidPasswordException,
											 SQLException;
	
	MemberVO detail(String id) throws SQLException;
	void modifyPwd(MemberVO member) throws SQLException;
	void modifyName(MemberVO member) throws SQLException;
	void modifyEmail(MemberVO member) throws SQLException;
	void remove(MemberVO member) throws SQLException;
	
}
