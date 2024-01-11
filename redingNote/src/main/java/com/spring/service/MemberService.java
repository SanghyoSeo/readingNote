package com.spring.service;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberService {
	
	MemberVO detail(String id) throws SQLException;
	void modifyPwd(MemberVO member) throws SQLException;
	void modifyName(MemberVO member) throws SQLException;
	void modifyEmail(MemberVO member) throws SQLException;
	void remove(String id) throws SQLException;
}
